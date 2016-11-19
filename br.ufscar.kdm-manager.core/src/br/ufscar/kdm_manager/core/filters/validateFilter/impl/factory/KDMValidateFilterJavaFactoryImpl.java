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
import org.eclipse.gmt.modisco.omg.kdm.core.KDMEntity;

import br.ufscar.kdm_manager.core.filters.validateFilter.factory.KDMValidateFilterJavaFactory;
import br.ufscar.kdm_manager.core.filters.validateFilter.impl.filters.java.KDMValidateFilterFromAggregated;
import br.ufscar.kdm_manager.core.filters.validateFilter.impl.filters.java.KDMValidateFilterNameKDMEntity;
import br.ufscar.kdm_manager.core.filters.validateFilter.impl.filters.java.KDMValidateFilterNameKDMFramework;
import br.ufscar.kdm_manager.core.filters.validateFilter.impl.filters.java.KDMValidateFilterToAggregated;
import br.ufscar.kdm_manager.core.filters.validateFilter.impl.filters.java.KDMValidateFilterToFromAggregated;
import br.ufscar.kdm_manager.core.filters.validateFilter.interfaces.KDMValidateFilter;

public class KDMValidateFilterJavaFactoryImpl implements KDMValidateFilterJavaFactory {

	public static KDMValidateFilterJavaFactory init() {
		try {
			KDMValidateFilterJavaFactory theRecoverHierarchyFactoryFactory = (KDMValidateFilterJavaFactory)EPackage.Registry.INSTANCE.getEFactory("br.ufscar.kdm_manager.core.filters.validateFilter.factory.ValidateFilterJavaFactory"); //$NON-NLS-1$ 
			if (theRecoverHierarchyFactoryFactory != null) {
				return theRecoverHierarchyFactoryFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new KDMValidateFilterJavaFactoryImpl();
	}
	
	public KDMValidateFilterJavaFactoryImpl() {
		super();
	}
	
	@Override
	public KDMValidateFilter<?, String> createValidateFilterNameOfKDMEntity(String nameToSearch) {
		KDMValidateFilter<?, String> filter = new KDMValidateFilterNameKDMEntity();
		filter.setValue(nameToSearch);
		return filter;
	}

	@Override
	public KDMValidateFilter<?, String> createValidateFilterNameOfKDMFramework(String nameToSearch) {
		KDMValidateFilter<?, String> filter = new KDMValidateFilterNameKDMFramework();
		filter.setValue(nameToSearch);
		return filter;
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.filters.validateFilter.factory.ValidateFilterJavaFactory#createValidateFilterAggregatedRelationshipToOfKDMEntity(org.eclipse.gmt.modisco.omg.kdm.core.KDMEntity)
	 */
	@Override
	public KDMValidateFilter<?, KDMEntity> createValidateFilterAggregatedRelationshipToOfKDMEntity(
			KDMEntity elementToAvaliate) {
		KDMValidateFilter<?, KDMEntity> filter = new KDMValidateFilterToAggregated();
		filter.setValue(elementToAvaliate);
		return filter;
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.filters.validateFilter.factory.ValidateFilterJavaFactory#createValidateFilterAggregatedRelationshipFromOfKDMEntity(org.eclipse.gmt.modisco.omg.kdm.core.KDMEntity)
	 */
	@Override
	public KDMValidateFilter<?, KDMEntity> createValidateFilterAggregatedRelationshipFromOfKDMEntity(
			KDMEntity elementToAvaliate) {
		KDMValidateFilter<?, KDMEntity> filter = new KDMValidateFilterFromAggregated();
		filter.setValue(elementToAvaliate);
		return filter;
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.filters.validateFilter.factory.ValidateFilterJavaFactory#createValidateFilterAggregatedRelationshipToFromOfKDMEntity(org.eclipse.gmt.modisco.omg.kdm.core.KDMEntity[])
	 */
	@Override
	public KDMValidateFilter<?, KDMEntity[]> createValidateFilterAggregatedRelationshipToFromOfKDMEntity(
			KDMEntity[] elementToAvaliate) {
		KDMValidateFilter<?, KDMEntity[]> filter = new KDMValidateFilterToFromAggregated();
		filter.setValue(elementToAvaliate);
		return filter;
	}

}
