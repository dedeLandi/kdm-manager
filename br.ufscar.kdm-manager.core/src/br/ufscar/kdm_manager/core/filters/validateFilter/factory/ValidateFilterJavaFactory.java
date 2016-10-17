package br.ufscar.kdm_manager.core.filters.validateFilter.factory;

import br.ufscar.kdm_manager.core.filters.validateFilter.interfaces.ValidateFilter;

public interface ValidateFilterJavaFactory {

	ValidateFilterJavaFactory eINSTANCE = br.ufscar.kdm_manager.core.filters.validateFilter.impl.factory.ValidateFilterJavaFactoryImpl.init();
	
	ValidateFilter<?, String> createValidateFilterNameOfKDMEntity(String nameToSearch);
	
	ValidateFilter<?, String> createValidateFilterNameOfKDMFramework(String nameToSearch);
	
}
