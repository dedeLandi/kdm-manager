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
package br.ufscar.kdm_manager.core.filters.validateFilter.impl.factory;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import br.ufscar.kdm_manager.core.filters.validateFilter.factory.ValidateFilterJavaFactory;
import br.ufscar.kdm_manager.core.filters.validateFilter.impl.filters.java.ValidateFilterNameKDMEntity;
import br.ufscar.kdm_manager.core.filters.validateFilter.impl.filters.java.ValidateFilterNameKDMFramework;
import br.ufscar.kdm_manager.core.filters.validateFilter.interfaces.ValidateFilter;

public class ValidateFilterJavaFactoryImpl implements ValidateFilterJavaFactory {

	public static ValidateFilterJavaFactory init() {
		try {
			ValidateFilterJavaFactory theRecoverHierarchyFactoryFactory = (ValidateFilterJavaFactory)EPackage.Registry.INSTANCE.getEFactory("br.ufscar.kdm_manager.core.filters.validateFilter.factory.ValidateFilterJavaFactory"); //$NON-NLS-1$ 
			if (theRecoverHierarchyFactoryFactory != null) {
				return theRecoverHierarchyFactoryFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ValidateFilterJavaFactoryImpl();
	}
	
	public ValidateFilterJavaFactoryImpl() {
		super();
	}
	
	@Override
	public ValidateFilter<?, String> createValidateFilterNameOfKDMEntity(String nameToSearch) {
		ValidateFilter<?, String> filter = new ValidateFilterNameKDMEntity();
		filter.setValue(nameToSearch);
		return filter;
	}

	@Override
	public ValidateFilter<?, String> createValidateFilterNameOfKDMFramework(String nameToSearch) {
		ValidateFilter<?, String> filter = new ValidateFilterNameKDMFramework();
		filter.setValue(nameToSearch);
		return filter;
	}

}
