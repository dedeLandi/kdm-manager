package br.ufscar.kdm_manager.core.complements.complementRelationship.impl.factory;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import br.ufscar.kdm_manager.core.complements.complementRelationship.factory.ComplementsRelationshipFactory;
import br.ufscar.kdm_manager.core.complements.complementRelationship.impl.complements.java.ComplementsRelationshipHasTypeImpl;
import br.ufscar.kdm_manager.core.complements.complementRelationship.interfaces.ComplementsGenericRelationship;

public class ComplementsRelationshipFactoryImpl extends EFactoryImpl implements ComplementsRelationshipFactory {

	
	public static ComplementsRelationshipFactory init() {
		try {
			ComplementsRelationshipFactory theComplementsRelationsFactoryFactory = (ComplementsRelationshipFactory)EPackage.Registry.INSTANCE.getEFactory("br.ufscar.KDM_MANAGEMENT.complements.complementRelations.factory.ComplementsRelationsFactory"); //$NON-NLS-1$ 
			if (theComplementsRelationsFactoryFactory != null) {
				return theComplementsRelationsFactoryFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ComplementsRelationshipFactoryImpl();
	}
	
	public ComplementsRelationshipFactoryImpl() {
		super();
	}

	@Override
	public ComplementsGenericRelationship createInstanceOfComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsGenericRelationship createParameterToComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsGenericRelationship createImplementsComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsGenericRelationship createImplementationOfComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsGenericRelationship createHasTypeComplements() {
		return new ComplementsRelationshipHasTypeImpl();
	}

	@Override
	public ComplementsGenericRelationship createHasValueComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsGenericRelationship createExtendsComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsGenericRelationship createGeneratedFromComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsGenericRelationship createIncludesComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsGenericRelationship createVariantToComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsGenericRelationship createRedefinesComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsGenericRelationship createVisibleInComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsGenericRelationship createImportsComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsGenericRelationship createControlFlowComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsGenericRelationship createEntryFlowComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsGenericRelationship createCallsComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsGenericRelationship createDispatchesComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsGenericRelationship createReadsComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsGenericRelationship createWritesComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsGenericRelationship createAddressesComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsGenericRelationship createCreatesComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsGenericRelationship createExitFlowComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsGenericRelationship createThrowsComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsGenericRelationship createUsesTypeComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
