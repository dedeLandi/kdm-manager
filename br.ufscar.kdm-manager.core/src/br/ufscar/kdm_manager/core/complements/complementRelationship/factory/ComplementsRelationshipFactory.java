package br.ufscar.kdm_manager.core.complements.complementRelationship.factory;

import org.eclipse.emf.ecore.EFactory;

import br.ufscar.kdm_manager.core.complements.complementRelationship.interfaces.ComplementsGenericRelationship;


public interface ComplementsRelationshipFactory extends EFactory {

	ComplementsRelationshipFactory eINSTANCE = br.ufscar.kdm_manager.core.complements.complementRelationship.impl.factory.ComplementsRelationshipFactoryImpl.init();
	
	//CodeRelations
	ComplementsGenericRelationship createInstanceOfComplements();
	
	ComplementsGenericRelationship createParameterToComplements();
	
	ComplementsGenericRelationship createImplementsComplements();
	
	ComplementsGenericRelationship createImplementationOfComplements();
	
	ComplementsGenericRelationship createHasTypeComplements();
	
	ComplementsGenericRelationship createHasValueComplements();

	ComplementsGenericRelationship createExtendsComplements();
	
	ComplementsGenericRelationship createGeneratedFromComplements();
	
	ComplementsGenericRelationship createIncludesComplements();
	
	ComplementsGenericRelationship createVariantToComplements();
	
	ComplementsGenericRelationship createRedefinesComplements();

	ComplementsGenericRelationship createVisibleInComplements();
	
	ComplementsGenericRelationship createImportsComplements();
	
	//ActionRelations
	
	ComplementsGenericRelationship createControlFlowComplements();
	
	ComplementsGenericRelationship createEntryFlowComplements();
	
	ComplementsGenericRelationship createCallsComplements();
	
	ComplementsGenericRelationship createDispatchesComplements();
	
	ComplementsGenericRelationship createReadsComplements();
	
	ComplementsGenericRelationship createWritesComplements();
	
	ComplementsGenericRelationship createAddressesComplements();
	
	ComplementsGenericRelationship createCreatesComplements();
	
	ComplementsGenericRelationship createExitFlowComplements();
	
	ComplementsGenericRelationship createThrowsComplements();
	
	ComplementsGenericRelationship createUsesTypeComplements();
	
}
