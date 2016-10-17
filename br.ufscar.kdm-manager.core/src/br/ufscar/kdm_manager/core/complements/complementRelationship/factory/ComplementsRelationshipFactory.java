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
