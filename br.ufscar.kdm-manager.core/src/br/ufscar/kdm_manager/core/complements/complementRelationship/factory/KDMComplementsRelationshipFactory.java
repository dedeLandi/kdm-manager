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

import br.ufscar.kdm_manager.core.complements.complementRelationship.interfaces.KDMComplementsGenericRelationship;


public interface KDMComplementsRelationshipFactory extends EFactory {

	KDMComplementsRelationshipFactory eINSTANCE = br.ufscar.kdm_manager.core.complements.complementRelationship.impl.factory.KDMComplementsRelationshipFactoryImpl.init();
	
	//CodeRelations
	KDMComplementsGenericRelationship createInstanceOfComplements();
	
	KDMComplementsGenericRelationship createParameterToComplements();
	
	KDMComplementsGenericRelationship createImplementsComplements();
	
	KDMComplementsGenericRelationship createImplementationOfComplements();
	
	KDMComplementsGenericRelationship createHasTypeComplements();
	
	KDMComplementsGenericRelationship createHasValueComplements();

	KDMComplementsGenericRelationship createExtendsComplements();
	
	KDMComplementsGenericRelationship createGeneratedFromComplements();
	
	KDMComplementsGenericRelationship createIncludesComplements();
	
	KDMComplementsGenericRelationship createVariantToComplements();
	
	KDMComplementsGenericRelationship createRedefinesComplements();

	KDMComplementsGenericRelationship createVisibleInComplements();
	
	KDMComplementsGenericRelationship createImportsComplements();
	
	//ActionRelations
	
	KDMComplementsGenericRelationship createControlFlowComplements();
	
	KDMComplementsGenericRelationship createEntryFlowComplements();
	
	KDMComplementsGenericRelationship createCallsComplements();
	
	KDMComplementsGenericRelationship createDispatchesComplements();
	
	KDMComplementsGenericRelationship createReadsComplements();
	
	KDMComplementsGenericRelationship createWritesComplements();
	
	KDMComplementsGenericRelationship createAddressesComplements();
	
	KDMComplementsGenericRelationship createCreatesComplements();
	
	KDMComplementsGenericRelationship createExitFlowComplements();
	
	KDMComplementsGenericRelationship createThrowsComplements();
	
	KDMComplementsGenericRelationship createUsesTypeComplements();
	
}
