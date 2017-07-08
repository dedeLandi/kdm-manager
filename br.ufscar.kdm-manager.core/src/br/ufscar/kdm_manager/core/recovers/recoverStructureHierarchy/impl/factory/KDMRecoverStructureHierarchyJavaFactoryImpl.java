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
package br.ufscar.kdm_manager.core.recovers.recoverStructureHierarchy.impl.factory;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import br.ufscar.kdm_manager.core.recovers.recoverStructureHierarchy.factory.KDMRecoverStructureHierarchyJavaFactory;
import br.ufscar.kdm_manager.core.recovers.recoverStructureHierarchy.impl.recovers.java.KDMRecoverStructureHierarchyCompleteImpl;
import br.ufscar.kdm_manager.core.recovers.recoverStructureHierarchy.impl.recovers.java.KDMRecoverStructureHierarchyModelImpl;
import br.ufscar.kdm_manager.core.recovers.recoverStructureHierarchy.interfaces.KDMRecoverGenericStructureHierarchy;

public class KDMRecoverStructureHierarchyJavaFactoryImpl extends EFactoryImpl implements KDMRecoverStructureHierarchyJavaFactory{

	public static KDMRecoverStructureHierarchyJavaFactory init() {
		try {
			KDMRecoverStructureHierarchyJavaFactory theKDMRecoverStructureHierarchyJavaFactory = (KDMRecoverStructureHierarchyJavaFactory)EPackage.Registry.INSTANCE.getEFactory("br.ufscar.kdm_manager.core.recovers.recoverHierarchy.factory.RecoverHierarchyJavaFactory"); //$NON-NLS-1$ 
			if (theKDMRecoverStructureHierarchyJavaFactory != null) {
				return theKDMRecoverStructureHierarchyJavaFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new KDMRecoverStructureHierarchyJavaFactoryImpl();
	}
	
	public KDMRecoverStructureHierarchyJavaFactoryImpl() {
		super();
	}

	@Override
	public KDMRecoverGenericStructureHierarchy<String> createRecoverStructureHierarchyComplete() {
		return new KDMRecoverStructureHierarchyCompleteImpl();
	}

	@Override
	public KDMRecoverGenericStructureHierarchy<String> createRecoverStructureHierarchyModel() {
		return new KDMRecoverStructureHierarchyModelImpl();
	}
	
	
	
}
