package br.ufscar.kdm_manager.core.complements.complementRelationship.factory;

import org.eclipse.emf.ecore.EFactory;

import br.ufscar.kdm_manager.core.complements.complementRelationship.interfaces.ComplementsRelationship;


public interface ComplementsRelationshipFactory extends EFactory {

	ComplementsRelationshipFactory eINSTANCE = br.ufscar.kdm_manager.core.complements.complementRelationship.impl.factory.ComplementsRelationshipFactoryImpl.init();
	
	//CodeRelations
	ComplementsRelationship createInstanceOfComplements();
	
	ComplementsRelationship createParameterToComplements();
	
	ComplementsRelationship createImplementsComplements();
	
	ComplementsRelationship createImplementationOfComplements();
	
	ComplementsRelationship createHasTypeComplements();
	
	ComplementsRelationship createHasValueComplements();

	ComplementsRelationship createExtendsComplements();
	
	ComplementsRelationship createGeneratedFromComplements();
	
	ComplementsRelationship createIncludesComplements();
	
	ComplementsRelationship createVariantToComplements();
	
	ComplementsRelationship createRedefinesComplements();

	ComplementsRelationship createVisibleInComplements();
	
	ComplementsRelationship createImportsComplements();
	
	//ActionRelations
	
	ComplementsRelationship createControlFlowComplements();
	
	ComplementsRelationship createEntryFlowComplements();
	
	ComplementsRelationship createCallsComplements();
	
	ComplementsRelationship createDispatchesComplements();
	
	ComplementsRelationship createReadsComplements();
	
	ComplementsRelationship createWritesComplements();
	
	ComplementsRelationship createAddressesComplements();
	
	ComplementsRelationship createCreatesComplements();
	
	ComplementsRelationship createExitFlowComplements();
	
	ComplementsRelationship createThrowsComplements();
	
	ComplementsRelationship createUsesTypeComplements();
	
}
