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
package br.ufscar.kdm_manager.core.executionEngines.metricsEngine.textMetricEngine.factory;

import org.eclipse.emf.ecore.EFactory;

import br.ufscar.kdm_manager.core.executionEngines.metricsEngine.textMetricEngine.interfaces.TextMestricEngine;
import info.debatty.java.stringsimilarity.MetricLCS;

/**
 * @author Landi
 *
 */
public interface TextMetricsEngineFactory extends EFactory {

	TextMetricsEngineFactory eINSTANCE = br.ufscar.kdm_manager.core.executionEngines.metricsEngine.textMetricEngine.impl.factory.TextMetricsEngineFactoryImpl.init();
		
	TextMestricEngine<MetricLCS, Double> createTextMetricLongestCommonSubsequence();
	
}
