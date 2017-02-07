/********************************************************************************
 *																				*
 * Copyright (c) 2016, André de Souza Landi. All rights reserved.				*
 *																				*
 * This file is part of KDM-MANAGER software.									*
 *																				*
 * KDM-MANAGER is free software: you can redistribute it and/or modify			*
 * it under the terms of the GNU General Public License as published by			*
 * the Free Software Foundation, either version 3 of the License, or			*
 * (at your option) any later version.											*
 *																				*
 * KDM-MANAGER is distributed in the hope that it will be useful,				*
 * but WITHOUT ANY WARRANTY; without even the implied warranty of				*
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the				*
 * GNU General Public License for more details.									*
 *																				*
 * You should have received a copy of the GNU General Public License			*
 * along with KDM-MANAGER.  If not, see <http://www.gnu.org/licenses/>.			*
 *																				*
 *******************************************************************************/
package br.ufscar.kdm_manager.core.executionEngines.machineLearningEngine.clusteringWekaEngine.impl.clusteringEngine;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import br.ufscar.kdm_manager.core.executionEngines.machineLearningEngine.clusteringWekaEngine.interfaces.MLClusteringWekaEngine;
import weka.clusterers.ClusterEvaluation;
import weka.clusterers.DBSCAN;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.gui.explorer.ClustererPanel;
import weka.gui.visualize.PlotData2D;

/**
 * @author Landi
 *
 */
public class MLClusteringEngineWekaDBScan implements MLClusteringWekaEngine<Object> {

	private boolean canRun = false;
	private String arffPath = null;
	private Instances data = null;
	private String options = null;
	private DBSCAN cluster = null;
	private ClusterEvaluation eval;

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.executionEngines.machineLearningEngine.clusteringWekaEngine.interfaces.MLClusteringWekaEngine#setDataToClustering(java.lang.String)
	 */
	@Override
	public MLClusteringWekaEngine<Object> setDataToClustering(String arffPath) {
		canRun = false;
		this.arffPath  = arffPath;
		return this;
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.executionEngines.machineLearningEngine.clusteringWekaEngine.interfaces.MLClusteringWekaEngine#setDataToClustering(weka.core.Instances)
	 */
	@Override
	public MLClusteringWekaEngine<Object> setDataToClustering(Object data) {
		canRun = false;
		this.data  = (Instances) data;
		return this;
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.executionEngines.machineLearningEngine.clusteringWekaEngine.interfaces.MLClusteringWekaEngine#setAlgorithmOptions(java.lang.String)
	 */
	@Override
	public MLClusteringWekaEngine<Object> setAlgorithmOptions(String options) {
		canRun = false;
		this.options  = options;
		return this;
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.executionEngines.machineLearningEngine.clusteringWekaEngine.interfaces.MLClusteringWekaEngine#configureCluster()
	 */
	@Override
	public MLClusteringWekaEngine<Object> configureCluster() {
		canRun = false;
		try {

			if(allSetted()){
				cluster = new DBSCAN();
				if(options != null){
					String[] optionsVec = weka.core.Utils.splitOptions(options);
					cluster.setOptions(optionsVec);
				}
				if(arffPath != null){
					File arff = new File(arffPath);
					ArffLoader loader = new ArffLoader();
					loader.setFile(arff);
					data = loader.getDataSet();
				}
				cluster.buildClusterer(data);

				canRun = true;
			}
			return this;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.executionEngines.machineLearningEngine.clusteringWekaEngine.interfaces.MLClusteringWekaEngine#clusterizingData()
	 */
	@Override
	public ClusterEvaluation clusterizingData() {
		if(canRun){
			try {
				eval = new ClusterEvaluation();
				eval.setClusterer(cluster);
				eval.evaluateClusterer(data);
				return eval;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}else {
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.executionEngines.machineLearningEngine.clusteringWekaEngine.interfaces.MLClusteringWekaEngine#clusterResultsToString()
	 */
	@Override
	public Object clusterResultsToString() {
		return eval.clusterResultsToString();
	}
	
	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.executionEngines.machineLearningEngine.clusteringWekaEngine.interfaces.MLClusteringWekaEngine#clusterResultsToString()
	 */
	@Override
	public DBSCAN getCluster() {
		return cluster;
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.executionEngines.machineLearningEngine.clusteringWekaEngine.interfaces.MLClusteringWekaEngine#getClusterAssignments()
	 */
	@Override
	public Object getClusterAssignments() {
		return eval.getClusterAssignments();
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.executionEngines.machineLearningEngine.clusteringWekaEngine.interfaces.MLClusteringWekaEngine#saveResults(java.lang.String)
	 */
	@Override
	public boolean saveResults(String arffPath) {
		try {
			BufferedWriter writer;
			writer = new BufferedWriter(new FileWriter(arffPath));

			PlotData2D predData = ClustererPanel.setUpVisualizableInstances(data, eval);

			//save data
			writer.write(predData.getPlotInstances().toString());         
			writer.newLine();
			writer.flush();
			writer.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.executionEngines.machineLearningEngine.clusteringWekaEngine.interfaces.MLClusteringWekaEngine#saveResults(java.lang.String)
	 */
	@Override
	public boolean saveData(String arffPath) {
		try {
			BufferedWriter writer;
			writer = new BufferedWriter(new FileWriter(arffPath));

			//save data
			writer.write(data.toString());         
			writer.newLine();
			writer.flush();
			writer.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	/**
	 * @author Landi
	 * @return
	 */
	private boolean allSetted() {
		if(arffPath == null){
			if(data == null){
				launchException("Please, configure the data set to clusterizing.");
				return false;
			}
		}
		return true;
	}

	/**
	 * @author Landi
	 */
	private void launchException(String text) {
		try {
			throw new Exception(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
