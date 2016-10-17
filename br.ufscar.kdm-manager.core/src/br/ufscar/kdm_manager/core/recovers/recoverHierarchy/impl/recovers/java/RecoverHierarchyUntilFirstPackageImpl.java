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
package br.ufscar.kdm_manager.core.recovers.recoverHierarchy.impl.recovers.java;

import org.eclipse.gmt.modisco.omg.kdm.action.ActionElement;
import org.eclipse.gmt.modisco.omg.kdm.action.BlockUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.ClassUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.EnumeratedType;
import org.eclipse.gmt.modisco.omg.kdm.code.InterfaceUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.MethodUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.Package;
import org.eclipse.gmt.modisco.omg.kdm.code.ParameterUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.Signature;
import org.eclipse.gmt.modisco.omg.kdm.code.StorableUnit;

import br.ufscar.kdm_manager.core.recovers.recoverHierarchy.interfaces.RecoverGenericHierarchy;

public class RecoverHierarchyUntilFirstPackageImpl implements RecoverGenericHierarchy<String> {

	@Override
	public String getHierarchyOf(ClassUnit classToAvaliate) {
		String completePath = "";

		if(classToAvaliate.eContainer() instanceof Package){
			completePath = completePath.concat(this.getHierarchyOf((Package) classToAvaliate.eContainer()));
		}else if(classToAvaliate.eContainer() instanceof ClassUnit){
			completePath = completePath.concat(this.getHierarchyOf((ClassUnit) classToAvaliate.eContainer()));
		}else if(classToAvaliate.eContainer() instanceof InterfaceUnit){
			completePath = completePath.concat(this.getHierarchyOf((InterfaceUnit) classToAvaliate.eContainer()));
		}else if(classToAvaliate.eContainer() instanceof EnumeratedType){
			completePath = completePath.concat(this.getHierarchyOf((EnumeratedType) classToAvaliate.eContainer()));
		}

		String nameObject = classToAvaliate.getName() == null ? "anonymous" : classToAvaliate.getName();
		String nameThisObjectIteration = (SEPARATOR_CLASS_TYPE.replace("?", classToAvaliate.eClass().getName())).concat(nameObject);

		return (completePath.concat(SEPARATOR_TYPE)).concat(nameThisObjectIteration);
	}

	@Override
	public String getHierarchyOf(Package packageToAvaliate) {
		String completePath = "";

		String nameObject = packageToAvaliate.getName() == null ? "anonymous" : packageToAvaliate.getName();
		String nameThisObjectIteration = (SEPARATOR_CLASS_TYPE.replace("?", packageToAvaliate.eClass().getName())).concat(nameObject);

		return (completePath.concat(SEPARATOR_TYPE)).concat(nameThisObjectIteration);
	}

	@Override
	public String getHierarchyOf(BlockUnit blockToAvaliate) {
		String completePath = "";

		if(blockToAvaliate.eContainer() instanceof MethodUnit){
			completePath = completePath.concat(this.getHierarchyOf((MethodUnit) blockToAvaliate.eContainer()));
		}else if(blockToAvaliate.eContainer() instanceof ActionElement){
			completePath = completePath.concat(this.getHierarchyOf((ActionElement) blockToAvaliate.eContainer()));
		}

		String nameObject = blockToAvaliate.getName() == null ? "anonymous" : blockToAvaliate.getName();
		String nameThisObjectIteration = (SEPARATOR_CLASS_TYPE.replace("?", blockToAvaliate.eClass().getName())).concat(nameObject);

		return (completePath.concat(SEPARATOR_TYPE)).concat(nameThisObjectIteration);
	}

	@Override
	public String getHierarchyOf(ActionElement actionElementToAvaliate) {
		String completePath = "";

		if(actionElementToAvaliate.eContainer() instanceof BlockUnit){
			completePath = completePath.concat(this.getHierarchyOf((BlockUnit) actionElementToAvaliate.eContainer()));
		}else if(actionElementToAvaliate.eContainer() instanceof ActionElement){
			completePath = completePath.concat(this.getHierarchyOf((ActionElement) actionElementToAvaliate.eContainer()));
		}

		String nameObject = actionElementToAvaliate.getName() == null ? "anonymous" : actionElementToAvaliate.getName();
		String nameThisObjectIteration = (SEPARATOR_CLASS_TYPE.replace("?", actionElementToAvaliate.eClass().getName())).concat(nameObject);

		return (completePath.concat(SEPARATOR_TYPE)).concat(nameThisObjectIteration);
	}

	@Override
	public String getHierarchyOf(Signature signatureToAvaliate) {
		String completePath = "";

		if(signatureToAvaliate.eContainer() instanceof MethodUnit){
			completePath = completePath.concat(this.getHierarchyOf((MethodUnit) signatureToAvaliate.eContainer()));
		}

		String nameObject = signatureToAvaliate.getName() == null ? "anonymous" : signatureToAvaliate.getName();
		String nameThisObjectIteration = (SEPARATOR_CLASS_TYPE.replace("?", signatureToAvaliate.eClass().getName())).concat(nameObject);

		return (completePath.concat(SEPARATOR_TYPE)).concat(nameThisObjectIteration);
	}

	@Override
	public String getHierarchyOf(ParameterUnit parameterToAvaliate) {
		String completePath = "";

		if(parameterToAvaliate.eContainer() instanceof MethodUnit){
			completePath = completePath.concat(this.getHierarchyOf((MethodUnit) parameterToAvaliate.eContainer()));
		}else if(parameterToAvaliate.eContainer() instanceof Signature){
			completePath = completePath.concat(this.getHierarchyOf((Signature) parameterToAvaliate.eContainer()));
		}

		String nameObject = parameterToAvaliate.getName() == null ? "anonymous" : parameterToAvaliate.getName();
		String nameThisObjectIteration = (SEPARATOR_CLASS_TYPE.replace("?", parameterToAvaliate.eClass().getName())).concat(nameObject);

		return (completePath.concat(SEPARATOR_TYPE)).concat(nameThisObjectIteration);
	}

	@Override
	public String getHierarchyOf(StorableUnit storableToAvaliate) {
		String completePath = "";

		if(storableToAvaliate.eContainer() instanceof MethodUnit){
			completePath = completePath.concat(this.getHierarchyOf((MethodUnit) storableToAvaliate.eContainer()));
		}else if(storableToAvaliate.eContainer() instanceof ClassUnit){
			completePath = completePath.concat(this.getHierarchyOf((ClassUnit) storableToAvaliate.eContainer()));
		}else if(storableToAvaliate.eContainer() instanceof InterfaceUnit){
			completePath = completePath.concat(this.getHierarchyOf((InterfaceUnit) storableToAvaliate.eContainer()));
		}else if(storableToAvaliate.eContainer() instanceof EnumeratedType){
			completePath = completePath.concat(this.getHierarchyOf((EnumeratedType) storableToAvaliate.eContainer()));
		}else if(storableToAvaliate.eContainer() instanceof BlockUnit){
			completePath = completePath.concat(this.getHierarchyOf((BlockUnit) storableToAvaliate.eContainer()));
		}else if(storableToAvaliate.eContainer() instanceof ActionElement){
			completePath = completePath.concat(this.getHierarchyOf((ActionElement) storableToAvaliate.eContainer()));
		}

		String nameObject = storableToAvaliate.getName() == null ? "anonymous" : storableToAvaliate.getName();
		String nameThisObjectIteration = (SEPARATOR_CLASS_TYPE.replace("?", storableToAvaliate.eClass().getName())).concat(nameObject);

		return (completePath.concat(SEPARATOR_TYPE)).concat(nameThisObjectIteration);
	}

	@Override
	public String getHierarchyOf(MethodUnit methodToAvaliate) {
		String completePath = "";

		if(methodToAvaliate.eContainer() instanceof ClassUnit){
			completePath = completePath.concat(this.getHierarchyOf((ClassUnit) methodToAvaliate.eContainer()));
		}else if(methodToAvaliate.eContainer() instanceof InterfaceUnit){
			completePath = completePath.concat(this.getHierarchyOf((InterfaceUnit) methodToAvaliate.eContainer()));
		}else if(methodToAvaliate.eContainer() instanceof EnumeratedType){
			completePath = completePath.concat(this.getHierarchyOf((EnumeratedType) methodToAvaliate.eContainer()));
		}

		String nameObject = methodToAvaliate.getName() == null ? "anonymous" : methodToAvaliate.getName();
		String nameThisObjectIteration = (SEPARATOR_CLASS_TYPE.replace("?", methodToAvaliate.eClass().getName())).concat(nameObject);

		return (completePath.concat(SEPARATOR_TYPE)).concat(nameThisObjectIteration);
	}

	@Override
	public String getHierarchyOf(InterfaceUnit interfaceToAvaliate) {
		String completePath = "";

		if(interfaceToAvaliate.eContainer() instanceof Package){
			completePath = completePath.concat(this.getHierarchyOf((Package) interfaceToAvaliate.eContainer()));
		}else if(interfaceToAvaliate.eContainer() instanceof ClassUnit){
			completePath = completePath.concat(this.getHierarchyOf((ClassUnit) interfaceToAvaliate.eContainer()));
		}else if(interfaceToAvaliate.eContainer() instanceof InterfaceUnit){
			completePath = completePath.concat(this.getHierarchyOf((InterfaceUnit) interfaceToAvaliate.eContainer()));
		}else if(interfaceToAvaliate.eContainer() instanceof EnumeratedType){
			completePath = completePath.concat(this.getHierarchyOf((EnumeratedType) interfaceToAvaliate.eContainer()));
		}

		String nameObject = interfaceToAvaliate.getName() == null ? "anonymous" : interfaceToAvaliate.getName();
		String nameThisObjectIteration = (SEPARATOR_CLASS_TYPE.replace("?", interfaceToAvaliate.eClass().getName())).concat(nameObject);

		return (completePath.concat(SEPARATOR_TYPE)).concat(nameThisObjectIteration);
	}

	@Override
	public String getHierarchyOf(EnumeratedType enumeratedTypeToAvaliate) {
		String completePath = "";

		if(enumeratedTypeToAvaliate.eContainer() instanceof ClassUnit){
			completePath = completePath.concat(this.getHierarchyOf((ClassUnit) enumeratedTypeToAvaliate.eContainer()));
		}else if(enumeratedTypeToAvaliate.eContainer() instanceof InterfaceUnit){
			completePath = completePath.concat(this.getHierarchyOf((InterfaceUnit) enumeratedTypeToAvaliate.eContainer()));
		}else if(enumeratedTypeToAvaliate.eContainer() instanceof EnumeratedType){
			completePath = completePath.concat(this.getHierarchyOf((EnumeratedType) enumeratedTypeToAvaliate.eContainer()));
		}else if(enumeratedTypeToAvaliate.eContainer() instanceof Package){
			completePath = completePath.concat(this.getHierarchyOf((Package) enumeratedTypeToAvaliate.eContainer()));
		}

		String nameObject = enumeratedTypeToAvaliate.getName() == null ? "anonymous" : enumeratedTypeToAvaliate.getName();
		String nameThisObjectIteration = (SEPARATOR_CLASS_TYPE.replace("?", enumeratedTypeToAvaliate.eClass().getName())).concat(nameObject);

		return (completePath.concat(SEPARATOR_TYPE)).concat(nameThisObjectIteration);
	}

}
