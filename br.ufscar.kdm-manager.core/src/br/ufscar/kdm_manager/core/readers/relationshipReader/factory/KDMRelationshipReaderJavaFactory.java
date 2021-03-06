/********************************************************************************
 *																				*
 * Copyright (c) 2016, Andr� de Souza Landi. All rights reserved.				*
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
package br.ufscar.kdm_manager.core.readers.relationshipReader.factory;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.gmt.modisco.omg.kdm.action.Calls;
import org.eclipse.gmt.modisco.omg.kdm.action.Creates;
import org.eclipse.gmt.modisco.omg.kdm.action.Reads;
import org.eclipse.gmt.modisco.omg.kdm.action.UsesType;
import org.eclipse.gmt.modisco.omg.kdm.action.Writes;
import org.eclipse.gmt.modisco.omg.kdm.code.Extends;
import org.eclipse.gmt.modisco.omg.kdm.code.HasType;
import org.eclipse.gmt.modisco.omg.kdm.code.HasValue;
import org.eclipse.gmt.modisco.omg.kdm.code.Implements;
import org.eclipse.gmt.modisco.omg.kdm.code.Imports;

import br.ufscar.kdm_manager.core.readers.relationshipReader.interfaces.KDMRelationshipGenericReader;


public interface KDMRelationshipReaderJavaFactory extends EFactory {

	KDMRelationshipReaderJavaFactory eINSTANCE = br.ufscar.kdm_manager.core.readers.relationshipReader.impl.factory.KDMRelationshipReaderJavaFactoryImpl.init();
	
	//CodeRelations
//	KDMRelationshipGenericReader<InstanceOf> createInstanceOfRecover();
	
//	KDMRelationshipGenericReader<ParameterTo> createParameterToRecover();
	
	KDMRelationshipGenericReader<Implements> createImplementsRecover();
	
//	KDMRelationshipGenericReader<ImplementationOf> createImplementationOfRecover();
	
	KDMRelationshipGenericReader<HasType> createHasTypeRecover();
	
	KDMRelationshipGenericReader<HasValue> createHasValueRecover();

	KDMRelationshipGenericReader<Extends> createExtendsRecover();
	
//	KDMRelationshipGenericReader<GeneratedFrom> createGeneratedFromRecover();
	
//	KDMRelationshipGenericReader<Includes> createIncludesRecover();
	
//	KDMRelationshipGenericReader<VariantTo> createVariantToRecover();
	
//	KDMRelationshipGenericReader<Redefines> createRedefinesRecover();

//	KDMRelationshipGenericReader<VisibleIn> createVisibleInRecover();
	
	KDMRelationshipGenericReader<Imports> createImportsRecover();
	
	//ActionRelations
//	KDMRelationshipGenericReader<ControlFlow> createControlFlowRecover();
	
//	KDMRelationshipGenericReader<EntryFlow> createEntryFlowRecover();
	
	KDMRelationshipGenericReader<Calls> createCallsRecover();
	
//	KDMRelationshipGenericReader<Dispatches> createDispatchesRecover();
	
	KDMRelationshipGenericReader<Reads> createReadsRecover();
	
	KDMRelationshipGenericReader<Writes> createWritesRecover();
	
//	KDMRelationshipGenericReader<Addresses> createAddressesRecover();
	
	KDMRelationshipGenericReader<Creates> createCreatesRecover();
	
//	KDMRelationshipGenericReader<ExitFlow> createExitFlowRecover();
	
//	KDMRelationshipGenericReader<Throws> createThrowsRecover();
	
	KDMRelationshipGenericReader<UsesType> createUsesTypeRecover();
	
}
