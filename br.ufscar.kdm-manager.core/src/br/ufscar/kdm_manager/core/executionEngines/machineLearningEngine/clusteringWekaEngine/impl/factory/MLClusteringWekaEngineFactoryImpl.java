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
package br.ufscar.kdm_manager.core.executionEngines.machineLearningEngine.clusteringWekaEngine.impl.factory;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import br.ufscar.kdm_manager.core.executionEngines.machineLearningEngine.clusteringWekaEngine.factory.MLClusteringWekaEngineFactory;
import br.ufscar.kdm_manager.core.executionEngines.machineLearningEngine.clusteringWekaEngine.impl.clusteringEngine.MLClusteringEngineWekaDBScan;
import br.ufscar.kdm_manager.core.executionEngines.machineLearningEngine.clusteringWekaEngine.interfaces.MLClusteringWekaEngine;
import weka.clusterers.DBSCAN;

/**
 * @author Landi
 *
 */
public class MLClusteringWekaEngineFactoryImpl extends EFactoryImpl implements MLClusteringWekaEngineFactory {

	public static MLClusteringWekaEngineFactory init() {
		try {
			MLClusteringWekaEngineFactory theMLClusteringWekaEngineFactory = (MLClusteringWekaEngineFactory)EPackage.Registry.INSTANCE.getEFactory("br.ufscar.kdm_manager.core.executionEngines.machineLearningEngine.clusteringWekaEngine.factory.MLClusteringWekaEngineFactory"); //$NON-NLS-1$ 
			if (theMLClusteringWekaEngineFactory != null) {
				return theMLClusteringWekaEngineFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MLClusteringWekaEngineFactoryImpl();
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.executionEngines.machineLearningEngine.clusteringWekaEngine.factory.MLClusteringWekaEngineFactory#createMLClusteringEngineWekaDBScan()
	 */
	@Override
	public MLClusteringWekaEngine<DBSCAN> createMLClusteringEngineWekaDBScan() {
		MLClusteringEngineWekaDBScan dbscan = new MLClusteringEngineWekaDBScan();
		return dbscan;
	}

}
