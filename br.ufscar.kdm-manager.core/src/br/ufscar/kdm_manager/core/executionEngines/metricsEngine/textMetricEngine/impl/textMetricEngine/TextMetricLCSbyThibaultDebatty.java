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
package br.ufscar.kdm_manager.core.executionEngines.metricsEngine.textMetricEngine.impl.textMetricEngine;

import br.ufscar.kdm_manager.core.executionEngines.metricsEngine.textMetricEngine.interfaces.TextMestricEngine;
import info.debatty.java.stringsimilarity.MetricLCS;

/**
 * @author Landi
 *
 */
public class TextMetricLCSbyThibaultDebatty implements TextMestricEngine<Object, Double>{

	private MetricLCS metricLCS = null;
	
	/**
	 * 
	 */
	public TextMetricLCSbyThibaultDebatty() {
		metricLCS = new MetricLCS();
	}
	
	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.executionEngines.metricsEngine.textMetricEngine.interfaces.TextMestricEngine#getMetricImplementation()
	 */
	@Override
	public MetricLCS getMetricImplementation() {
		return metricLCS;
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.executionEngines.metricsEngine.textMetricEngine.interfaces.TextMestricEngine#applyMetric(java.lang.String, java.lang.String)
	 */
	@Override
	public Double applyMetric(String source, String target) {
		return metricLCS.distance(source, target);
	}

}
