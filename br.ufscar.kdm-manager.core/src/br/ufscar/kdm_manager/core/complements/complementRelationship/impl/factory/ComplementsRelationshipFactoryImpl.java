package br.ufscar.kdm_manager.core.complements.complementRelationship.impl.factory;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import br.ufscar.kdm_manager.core.complements.complementRelationship.factory.ComplementsRelationshipFactory;
import br.ufscar.kdm_manager.core.complements.complementRelationship.impl.complements.ComplementsRelationshipHasTypeImpl;
import br.ufscar.kdm_manager.core.complements.complementRelationship.interfaces.ComplementsRelationship;

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
	public ComplementsRelationship createInstanceOfComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsRelationship createParameterToComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsRelationship createImplementsComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsRelationship createImplementationOfComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsRelationship createHasTypeComplements() {
		return new ComplementsRelationshipHasTypeImpl();
	}

	@Override
	public ComplementsRelationship createHasValueComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsRelationship createExtendsComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsRelationship createGeneratedFromComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsRelationship createIncludesComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsRelationship createVariantToComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsRelationship createRedefinesComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsRelationship createVisibleInComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsRelationship createImportsComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsRelationship createControlFlowComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsRelationship createEntryFlowComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsRelationship createCallsComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsRelationship createDispatchesComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsRelationship createReadsComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsRelationship createWritesComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsRelationship createAddressesComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsRelationship createCreatesComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsRelationship createExitFlowComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsRelationship createThrowsComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplementsRelationship createUsesTypeComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
