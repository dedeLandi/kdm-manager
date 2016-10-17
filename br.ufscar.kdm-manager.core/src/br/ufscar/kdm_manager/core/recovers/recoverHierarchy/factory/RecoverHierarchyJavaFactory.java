package br.ufscar.kdm_manager.core.recovers.recoverHierarchy.factory;

import br.ufscar.kdm_manager.core.recovers.recoverHierarchy.interfaces.RecoverGenericHierarchy;

public interface RecoverHierarchyJavaFactory {

	RecoverHierarchyJavaFactory eINSTANCE = br.ufscar.kdm_manager.core.recovers.recoverHierarchy.impl.factory.RecoverHierarchyJavaFactoryImpl.init();
	
	RecoverGenericHierarchy<String> createRecoverHierarchyComplete();
	
	RecoverGenericHierarchy<String> createRecoverHierarchyUntilFirstEntity();
	
	RecoverGenericHierarchy<String> createRecoverHierarchyUntilFirstPackage();
	
	RecoverGenericHierarchy<String> createRecoverHierarchyCompleteArchitectural();
	
	
	
}
