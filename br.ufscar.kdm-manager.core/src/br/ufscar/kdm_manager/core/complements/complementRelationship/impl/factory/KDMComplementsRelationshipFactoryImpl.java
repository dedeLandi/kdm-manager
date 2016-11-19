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

import br.ufscar.kdm_manager.core.complements.complementRelationship.factory.KDMComplementsRelationshipFactory;
import br.ufscar.kdm_manager.core.complements.complementRelationship.impl.complements.java.KDMComplementsRelationshipHasTypeImpl;
import br.ufscar.kdm_manager.core.complements.complementRelationship.interfaces.KDMComplementsGenericRelationship;

public class KDMComplementsRelationshipFactoryImpl extends EFactoryImpl implements KDMComplementsRelationshipFactory {

	
	public static KDMComplementsRelationshipFactory init() {
		try {
			KDMComplementsRelationshipFactory theComplementsRelationsFactoryFactory = (KDMComplementsRelationshipFactory)EPackage.Registry.INSTANCE.getEFactory("br.ufscar.KDM_MANAGEMENT.complements.complementRelations.factory.ComplementsRelationsFactory"); //$NON-NLS-1$ 
			if (theComplementsRelationsFactoryFactory != null) {
				return theComplementsRelationsFactoryFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new KDMComplementsRelationshipFactoryImpl();
	}
	
	public KDMComplementsRelationshipFactoryImpl() {
		super();
	}

	@Override
	public KDMComplementsGenericRelationship createInstanceOfComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KDMComplementsGenericRelationship createParameterToComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KDMComplementsGenericRelationship createImplementsComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KDMComplementsGenericRelationship createImplementationOfComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KDMComplementsGenericRelationship createHasTypeComplements() {
		return new KDMComplementsRelationshipHasTypeImpl();
	}

	@Override
	public KDMComplementsGenericRelationship createHasValueComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KDMComplementsGenericRelationship createExtendsComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KDMComplementsGenericRelationship createGeneratedFromComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KDMComplementsGenericRelationship createIncludesComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KDMComplementsGenericRelationship createVariantToComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KDMComplementsGenericRelationship createRedefinesComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KDMComplementsGenericRelationship createVisibleInComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KDMComplementsGenericRelationship createImportsComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KDMComplementsGenericRelationship createControlFlowComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KDMComplementsGenericRelationship createEntryFlowComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KDMComplementsGenericRelationship createCallsComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KDMComplementsGenericRelationship createDispatchesComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KDMComplementsGenericRelationship createReadsComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KDMComplementsGenericRelationship createWritesComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KDMComplementsGenericRelationship createAddressesComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KDMComplementsGenericRelationship createCreatesComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KDMComplementsGenericRelationship createExitFlowComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KDMComplementsGenericRelationship createThrowsComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KDMComplementsGenericRelationship createUsesTypeComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
