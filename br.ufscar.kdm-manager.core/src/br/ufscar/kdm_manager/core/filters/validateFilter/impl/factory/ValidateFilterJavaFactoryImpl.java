package br.ufscar.kdm_manager.core.filters.validateFilter.impl.factory;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import br.ufscar.kdm_manager.core.filters.validateFilter.factory.ValidateFilterJavaFactory;
import br.ufscar.kdm_manager.core.filters.validateFilter.impl.filters.ValidateFilterNameKDMEntity;
import br.ufscar.kdm_manager.core.filters.validateFilter.impl.filters.ValidateFilterNameKDMFramework;
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
