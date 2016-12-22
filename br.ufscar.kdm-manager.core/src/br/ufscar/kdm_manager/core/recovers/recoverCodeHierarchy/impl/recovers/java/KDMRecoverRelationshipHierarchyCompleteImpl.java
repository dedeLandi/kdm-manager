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
package br.ufscar.kdm_manager.core.recovers.recoverCodeHierarchy.impl.recovers.java;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmt.modisco.omg.kdm.action.ActionElement;
import org.eclipse.gmt.modisco.omg.kdm.action.BlockUnit;
import org.eclipse.gmt.modisco.omg.kdm.action.CatchUnit;
import org.eclipse.gmt.modisco.omg.kdm.action.TryUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.ClassUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.EnumeratedType;
import org.eclipse.gmt.modisco.omg.kdm.code.InterfaceUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.MethodUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.Package;
import org.eclipse.gmt.modisco.omg.kdm.code.ParameterUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.Signature;
import org.eclipse.gmt.modisco.omg.kdm.code.StorableUnit;
import org.eclipse.gmt.modisco.omg.kdm.core.KDMRelationship;

import br.ufscar.kdm_manager.core.recovers.recoverCodeHierarchy.factory.KDMRecoverCodeHierarchyJavaFactory;
import br.ufscar.kdm_manager.core.recovers.recoverCodeHierarchy.interfaces.KDMRecoverGenericRelationshipHierarchy;

/**
 * @author André
 *
 */
public class KDMRecoverRelationshipHierarchyCompleteImpl implements KDMRecoverGenericRelationshipHierarchy<String>{

	
	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.recovers.recoverCodeHierarchy.interfaces.KDMRecoverGenericRelationshipHierarchy#getHierarchyOf(org.eclipse.gmt.modisco.omg.kdm.core.KDMRelationship)
	 */
	@Override
	public String getHierarchyOf(KDMRelationship relationship) {
		
		EObject parent = relationship.eContainer();
		String completePath = "";
		
		if(parent instanceof ActionElement){
			completePath = KDMRecoverCodeHierarchyJavaFactory.eINSTANCE.createRecoverCodeHierarchyComplete(true).getHierarchyOf((ActionElement)parent);
		}else if(parent instanceof BlockUnit){
			completePath = KDMRecoverCodeHierarchyJavaFactory.eINSTANCE.createRecoverCodeHierarchyComplete(true).getHierarchyOf((BlockUnit)parent);
		}else if(parent instanceof TryUnit){
			completePath = KDMRecoverCodeHierarchyJavaFactory.eINSTANCE.createRecoverCodeHierarchyComplete(true).getHierarchyOf((TryUnit)parent);
		}else if(parent instanceof CatchUnit){
			completePath = KDMRecoverCodeHierarchyJavaFactory.eINSTANCE.createRecoverCodeHierarchyComplete(true).getHierarchyOf((CatchUnit)parent);
		}else if(parent instanceof MethodUnit){
			completePath = KDMRecoverCodeHierarchyJavaFactory.eINSTANCE.createRecoverCodeHierarchyComplete(true).getHierarchyOf((MethodUnit)parent);
		}else if(parent instanceof Signature){
			completePath = KDMRecoverCodeHierarchyJavaFactory.eINSTANCE.createRecoverCodeHierarchyComplete(true).getHierarchyOf((Signature)parent);
		}else if(parent instanceof ParameterUnit){
			completePath = KDMRecoverCodeHierarchyJavaFactory.eINSTANCE.createRecoverCodeHierarchyComplete(true).getHierarchyOf((ParameterUnit)parent);
		}else if(parent instanceof StorableUnit){
			completePath = KDMRecoverCodeHierarchyJavaFactory.eINSTANCE.createRecoverCodeHierarchyComplete(true).getHierarchyOf((StorableUnit)parent);
		}else if(parent instanceof ClassUnit){
			completePath = KDMRecoverCodeHierarchyJavaFactory.eINSTANCE.createRecoverCodeHierarchyComplete(true).getHierarchyOf((ClassUnit)parent);
		}else if(parent instanceof InterfaceUnit){
			completePath = KDMRecoverCodeHierarchyJavaFactory.eINSTANCE.createRecoverCodeHierarchyComplete(true).getHierarchyOf((InterfaceUnit)parent);
		}else if(parent instanceof EnumeratedType){
			completePath = KDMRecoverCodeHierarchyJavaFactory.eINSTANCE.createRecoverCodeHierarchyComplete(true).getHierarchyOf((EnumeratedType)parent);
		}else if(parent instanceof Package){
			completePath = KDMRecoverCodeHierarchyJavaFactory.eINSTANCE.createRecoverCodeHierarchyComplete(true).getHierarchyOf((Package)parent);
		}
		
		String nameObject = "anonymous";
		String nameThisObjectIteration = (SEPARATOR_CLASS_TYPE.replace("?", relationship.eClass().getName())).concat(nameObject);

		return (completePath.concat(SEPARATOR_TYPE)).concat(nameThisObjectIteration);
	}
}
