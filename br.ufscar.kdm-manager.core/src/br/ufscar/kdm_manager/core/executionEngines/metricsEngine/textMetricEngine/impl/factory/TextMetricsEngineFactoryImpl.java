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
package br.ufscar.kdm_manager.core.executionEngines.metricsEngine.textMetricEngine.impl.factory;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import br.ufscar.kdm_manager.core.executionEngines.metricsEngine.textMetricEngine.factory.TextMetricsEngineFactory;
import br.ufscar.kdm_manager.core.executionEngines.metricsEngine.textMetricEngine.impl.textMetricEngine.TextMetricLCSbyThibaultDebatty;
import br.ufscar.kdm_manager.core.executionEngines.metricsEngine.textMetricEngine.interfaces.TextMestricEngine;

/**
 * @author Landi
 *
 */
public class TextMetricsEngineFactoryImpl extends EFactoryImpl implements TextMetricsEngineFactory{

	public static TextMetricsEngineFactory init() {
		try {
			TextMetricsEngineFactory theTextMetricsEngineFactory = (TextMetricsEngineFactory)EPackage.Registry.INSTANCE.getEFactory("br.ufscar.kdm_manager.core.executionEngines.metricsEngine.textMetricEngine.factory.TextMetricsEngineFactory"); //$NON-NLS-1$ 
			if (theTextMetricsEngineFactory != null) {
				return theTextMetricsEngineFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TextMetricsEngineFactoryImpl();
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.executionEngines.metricsEngine.textMetricEngine.factory.TextMetricsEngineFactory#createTextMetricLongestCommonSubsequence()
	 */
	@Override
	public TextMestricEngine<?, ?> createTextMetricLongestCommonSubsequence() {
		TextMetricLCSbyThibaultDebatty metric = new TextMetricLCSbyThibaultDebatty();
		return metric;
	}

	
}
