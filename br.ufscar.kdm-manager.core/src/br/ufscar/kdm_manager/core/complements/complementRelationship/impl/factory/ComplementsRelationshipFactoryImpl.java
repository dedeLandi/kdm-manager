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
