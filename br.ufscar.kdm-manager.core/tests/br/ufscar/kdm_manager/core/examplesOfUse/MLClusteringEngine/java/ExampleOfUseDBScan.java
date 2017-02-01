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
package br.ufscar.kdm_manager.core.examplesOfUse.MLClusteringEngine.java;

import br.ufscar.kdm_manager.core.executionEngines.machineLearningEngine.clusteringWekaEngine.factory.MLClusteringWekaEngineFactory;
import br.ufscar.kdm_manager.core.executionEngines.machineLearningEngine.clusteringWekaEngine.interfaces.MLClusteringWekaEngine;
import weka.clusterers.DBSCAN;

/**
 * @author Landi
 *
 */
public class ExampleOfUseDBScan {

	public static void main(String[] args) {
		
		MLClusteringWekaEngine<DBSCAN> dbscan = MLClusteringWekaEngineFactory.eINSTANCE.createMLClusteringEngineWekaDBScan();
		
		String arffPath = "C:\\Java\\workspaceMestradoMars64\\kdm-manager\\br.ufscar.kdm-manager.core\\tests\\br\\ufscar\\kdm_manager\\core\\examplesOfUse\\MLClusteringEngine\\inputs\\entradaWeka.arff";
		String options = "" 
				+ "-E 0.45 "
	    		+ "-M 0 ";
		
		dbscan.setDataToClustering(arffPath).setAlgorithmOptions(options).configureCluster();
		
		dbscan.clusterizingData();
		
		dbscan.saveResults(arffPath.replace(".arff", "_out.arff"));
		
	}
	
}
