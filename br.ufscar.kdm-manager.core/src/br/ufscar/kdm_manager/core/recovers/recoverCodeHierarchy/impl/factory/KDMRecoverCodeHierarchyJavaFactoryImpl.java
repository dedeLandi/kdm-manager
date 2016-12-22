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
package br.ufscar.kdm_manager.core.recovers.recoverCodeHierarchy.impl.factory;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.gmt.modisco.omg.kdm.structure.AbstractStructureElement;

import br.ufscar.kdm_manager.core.recovers.recoverCodeHierarchy.factory.KDMRecoverCodeHierarchyJavaFactory;
import br.ufscar.kdm_manager.core.recovers.recoverCodeHierarchy.impl.recovers.java.KDMRecoverCodeHierarchyCompleteImpl;
import br.ufscar.kdm_manager.core.recovers.recoverCodeHierarchy.impl.recovers.java.KDMRecoverCodeHierarchyFirstEntityImpl;
import br.ufscar.kdm_manager.core.recovers.recoverCodeHierarchy.impl.recovers.java.KDMRecoverCodeHierarchyFirstPackageImpl;
import br.ufscar.kdm_manager.core.recovers.recoverCodeHierarchy.impl.recovers.java.KDMRecoverCodeHierarchyModelImpl;
import br.ufscar.kdm_manager.core.recovers.recoverCodeHierarchy.impl.recovers.java.KDMRecoverCodeStructureHierarchyCompleteImpl;
import br.ufscar.kdm_manager.core.recovers.recoverCodeHierarchy.impl.recovers.java.KDMRecoverCodeStructureHierarchyFirstArchitecturalElementImpl;
import br.ufscar.kdm_manager.core.recovers.recoverCodeHierarchy.impl.recovers.java.KDMRecoverRelationshipHierarchyCompleteImpl;
import br.ufscar.kdm_manager.core.recovers.recoverCodeHierarchy.interfaces.KDMRecoverGenericCodeHierarchy;
import br.ufscar.kdm_manager.core.recovers.recoverCodeHierarchy.interfaces.KDMRecoverGenericRelationshipHierarchy;

public class KDMRecoverCodeHierarchyJavaFactoryImpl implements KDMRecoverCodeHierarchyJavaFactory{

	public static KDMRecoverCodeHierarchyJavaFactory init() {
		try {
			KDMRecoverCodeHierarchyJavaFactory theKDMRecoverCodeHierarchyJavaFactory = (KDMRecoverCodeHierarchyJavaFactory)EPackage.Registry.INSTANCE.getEFactory("br.ufscar.kdm_manager.core.recovers.recoverHierarchy.factory.RecoverHierarchyJavaFactory"); //$NON-NLS-1$ 
			if (theKDMRecoverCodeHierarchyJavaFactory != null) {
				return theKDMRecoverCodeHierarchyJavaFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new KDMRecoverCodeHierarchyJavaFactoryImpl();
	}
	
	public KDMRecoverCodeHierarchyJavaFactoryImpl() {
		super();
	}

	@Override
	public KDMRecoverGenericCodeHierarchy<String> createRecoverCodeHierarchyComplete(boolean withHashCode) {
		return new KDMRecoverCodeHierarchyCompleteImpl(withHashCode);
	}

	@Override
	public KDMRecoverGenericCodeHierarchy<String> createRecoverCodeHierarchyFirstEntity() {
		return new KDMRecoverCodeHierarchyFirstEntityImpl();
	}

	@Override
	public KDMRecoverGenericCodeHierarchy<String> createRecoverCodeHierarchyFirstPackage() {
		return new KDMRecoverCodeHierarchyFirstPackageImpl();
	}

	@Override
	public KDMRecoverGenericCodeHierarchy<String> createRecoverCodeStructureHierarchyComplete() {
		return new KDMRecoverCodeStructureHierarchyCompleteImpl();
	}

	@Override
	public KDMRecoverGenericCodeHierarchy<AbstractStructureElement> createRecoverCodeStructureHierarchyFirstArchitecturalElement() {
		return new KDMRecoverCodeStructureHierarchyFirstArchitecturalElementImpl();
	}
	
	@Override
	public KDMRecoverGenericCodeHierarchy<String> createRecoverCodeHierarchyModel() {
		return new KDMRecoverCodeHierarchyModelImpl();
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.recovers.recoverCodeHierarchy.factory.KDMRecoverCodeHierarchyJavaFactory#createRecoverRelationshipHierarchyComplete()
	 */
	@Override
	public KDMRecoverGenericRelationshipHierarchy<String> createRecoverRelationshipHierarchyComplete() {
		return new KDMRecoverRelationshipHierarchyCompleteImpl();

	}
	
	
	
}
