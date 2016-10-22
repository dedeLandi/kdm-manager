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
package br.ufscar.kdm_manager.core.filters.validateFilter.factory;

import org.eclipse.gmt.modisco.omg.kdm.core.KDMEntity;

import br.ufscar.kdm_manager.core.filters.validateFilter.interfaces.ValidateFilter;

public interface ValidateFilterJavaFactory {

	ValidateFilterJavaFactory eINSTANCE = br.ufscar.kdm_manager.core.filters.validateFilter.impl.factory.ValidateFilterJavaFactoryImpl.init();
	
	ValidateFilter<?, String> createValidateFilterNameOfKDMEntity(String nameToSearch);
	
	ValidateFilter<?, String> createValidateFilterNameOfKDMFramework(String nameToSearch);
	
	ValidateFilter<?, KDMEntity> createValidateFilterAggregatedRelationshipToOfKDMEntity(KDMEntity elementToAvaliate);
	
	ValidateFilter<?, KDMEntity> createValidateFilterAggregatedRelationshipFromOfKDMEntity(KDMEntity elementToAvaliate);
	
	ValidateFilter<?, KDMEntity[]> createValidateFilterAggregatedRelationshipToFromOfKDMEntity(KDMEntity[] elementToAvaliate);
	
}
