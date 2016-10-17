package br.ufscar.kdm_manager.core.recovers.recoverHierarchy.impl.factory;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import br.ufscar.kdm_manager.core.recovers.recoverHierarchy.factory.RecoverHierarchyJavaFactory;
import br.ufscar.kdm_manager.core.recovers.recoverHierarchy.impl.recovers.java.RecoverHierarchyCompleteImpl;
import br.ufscar.kdm_manager.core.recovers.recoverHierarchy.impl.recovers.java.RecoverHierarchyCompleteArchitecturalImpl;
import br.ufscar.kdm_manager.core.recovers.recoverHierarchy.impl.recovers.java.RecoverHierarchyUntilFirstEntityImpl;
import br.ufscar.kdm_manager.core.recovers.recoverHierarchy.impl.recovers.java.RecoverHierarchyUntilFirstPackageImpl;
import br.ufscar.kdm_manager.core.recovers.recoverHierarchy.interfaces.RecoverGenericHierarchy;

public class RecoverHierarchyJavaFactoryImpl implements RecoverHierarchyJavaFactory{

	public static RecoverHierarchyJavaFactory init() {
		try {
			RecoverHierarchyJavaFactory theRecoverHierarchyFactoryFactory = (RecoverHierarchyJavaFactory)EPackage.Registry.INSTANCE.getEFactory("br.ufscar.kdm_manager.core.recovers.recoverHierarchy.factory.RecoverHierarchyJavaFactory"); //$NON-NLS-1$ 
			if (theRecoverHierarchyFactoryFactory != null) {
				return theRecoverHierarchyFactoryFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RecoverHierarchyJavaFactoryImpl();
	}
	
	public RecoverHierarchyJavaFactoryImpl() {
		super();
	}

	@Override
	public RecoverGenericHierarchy<String> createRecoverHierarchyComplete() {
		return new RecoverHierarchyCompleteImpl();
	}

	@Override
	public RecoverGenericHierarchy<String> createRecoverHierarchyUntilFirstEntity() {
		return new RecoverHierarchyUntilFirstEntityImpl();
	}

	@Override
	public RecoverGenericHierarchy<String> createRecoverHierarchyUntilFirstPackage() {
		return new RecoverHierarchyUntilFirstPackageImpl();
	}

	@Override
	public RecoverGenericHierarchy<String> createRecoverHierarchyCompleteArchitectural() {
		return new RecoverHierarchyCompleteArchitecturalImpl();
	}
	
}
