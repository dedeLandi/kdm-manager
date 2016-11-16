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
package br.ufscar.kdm_manager.core.recovers.recoverHierarchy.impl.factory;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.gmt.modisco.omg.kdm.structure.AbstractStructureElement;

import br.ufscar.kdm_manager.core.recovers.recoverHierarchy.factory.RecoverHierarchyJavaFactory;
import br.ufscar.kdm_manager.core.recovers.recoverHierarchy.impl.recovers.java.RecoverHierarchyCompleteImpl;
import br.ufscar.kdm_manager.core.recovers.recoverHierarchy.impl.recovers.java.RecoverHierarchyFirstArchitecturalElementImpl;
import br.ufscar.kdm_manager.core.recovers.recoverHierarchy.impl.recovers.java.RecoverHierarchyCompleteArchitecturalImpl;
import br.ufscar.kdm_manager.core.recovers.recoverHierarchy.impl.recovers.java.RecoverHierarchyUntilFirstEntityImpl;
import br.ufscar.kdm_manager.core.recovers.recoverHierarchy.impl.recovers.java.RecoverHierarchyUntilFirstPackageImpl;
import br.ufscar.kdm_manager.core.recovers.recoverHierarchy.interfaces.RecoverGenericHierarchy;

public class RecoverHierarchyJavaFactoryImpl implements RecoverHierarchyJavaFactory{

	public static RecoverHierarchyJavaFactory init() {
		try {
			RecoverHierarchyJavaFactory theRecoverHierarchyFactoryFactory = (RecoverHierarchyJavaFactory)EPackage.Registry.INSTANCE.getEFactory("br.ufscar.kdm_manager.core.recovers.recoverHierarchy.factory.RecoverHierarchyJavaFactory"); //$NON-NLS-1$ 
			if (theRecoverHierarchyFactoryFactory != null) {
				return theRecoverHierarchyFactoryFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RecoverHierarchyJavaFactoryImpl();
	}
	
	public RecoverHierarchyJavaFactoryImpl() {
		super();
	}

	@Override
	public RecoverGenericHierarchy<String> createRecoverHierarchyComplete() {
		return new RecoverHierarchyCompleteImpl();
	}

	@Override
	public RecoverGenericHierarchy<String> createRecoverHierarchyUntilFirstEntity() {
		return new RecoverHierarchyUntilFirstEntityImpl();
	}

	@Override
	public RecoverGenericHierarchy<String> createRecoverHierarchyUntilFirstPackage() {
		return new RecoverHierarchyUntilFirstPackageImpl();
	}

	@Override
	public RecoverGenericHierarchy<String> createRecoverHierarchyCompleteArchitectural() {
		return new RecoverHierarchyCompleteArchitecturalImpl();
	}

	@Override
	public RecoverGenericHierarchy<AbstractStructureElement> createRecoverHierarchyFirstArchitecturalElement() {
		return new RecoverHierarchyFirstArchitecturalElementImpl();
	}
	
}
