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

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.gmt.modisco.omg.kdm.core.KDMEntity;
import org.eclipse.gmt.modisco.omg.kdm.kdm.KDMModel;
import org.eclipse.gmt.modisco.omg.kdm.kdm.Segment;
import org.eclipse.gmt.modisco.omg.kdm.structure.AbstractStructureElement;
import org.eclipse.gmt.modisco.omg.kdm.structure.StructureModel;

import br.ufscar.kdm_manager.core.readers.modelReader.factory.KDMModelReaderJavaFactory;
import br.ufscar.kdm_manager.core.recovers.recoverHierarchy.interfaces.RecoverGenericHierarchy;

public class RecoverHierarchyCompleteArchitecturalImpl implements RecoverGenericHierarchy<String> {

	private Segment segmentToAvaliate = null;
	private AbstractStructureElement architecturalElementIs = null;

	private String getHierarchyOf(Segment segmentToAvaliate) {
		String nameObject = segmentToAvaliate.getName() == null ? "anonymous" : segmentToAvaliate.getName();
		return (SEPARATOR_CLASS_TYPE.replace("?", segmentToAvaliate.eClass().getName())).concat(nameObject);
	}

	private String getHierarchyOf(KDMModel modelToAvaliate) {
		String completePath = "";

		if(modelToAvaliate.eContainer() instanceof Segment){
			completePath = completePath.concat(this.getHierarchyOf((Segment) modelToAvaliate.eContainer()));
		}else if(modelToAvaliate.eContainer() instanceof KDMModel){
			completePath = completePath.concat(this.getHierarchyOf((KDMModel) modelToAvaliate.eContainer()));
		}

		String nameObject = modelToAvaliate.getName() == null ? "anonymous" : modelToAvaliate.getName();
		String nameThisObjectIteration = (SEPARATOR_CLASS_TYPE.replace("?", modelToAvaliate.eClass().getName())).concat(nameObject);

		return (completePath.concat(SEPARATOR_TYPE)).concat(nameThisObjectIteration);
	}

	private boolean validateArchitecturalElement(KDMEntity entityToAvaliate) {
		this.segmentToAvaliate = this.getSegmentFrom(entityToAvaliate);

		Map<String, List<StructureModel>> allFromSegment = KDMModelReaderJavaFactory.eINSTANCE.createKDMStructureModelReader().getAllFromSegment(this.segmentToAvaliate);

		for (String key : allFromSegment.keySet()) {
			for (StructureModel structureModel : allFromSegment.get(key)) {

				for (AbstractStructureElement abstractStructureElement : structureModel.getStructureElement()) {
					if(this.validateArchitecturalElement(abstractStructureElement, entityToAvaliate)){
						return true;
					}
				}
			}
		}

		return false;
	}

	private Segment getSegmentFrom(EObject entityToAvaliate) {

		if(entityToAvaliate instanceof Segment){
			return (Segment) entityToAvaliate;
		}else{
			return getSegmentFrom(entityToAvaliate.eContainer());
		}

	}

	private boolean validateArchitecturalElement(AbstractStructureElement abstractStructureElement,
			KDMEntity kdmEntityToAvaliate) {

		for (KDMEntity kdmEntity : abstractStructureElement.getImplementation()) {
			if(kdmEntity.equals(kdmEntityToAvaliate)){
				this.architecturalElementIs  = abstractStructureElement;
				return true;
			}
		}

		for (AbstractStructureElement abstractStructureElement2 : abstractStructureElement.getStructureElement()) {
			if(this.validateArchitecturalElement(abstractStructureElement2, kdmEntityToAvaliate)){
				return true;
			}
		}

		return false;
	}
	
	private String getArchitecturalHierarchyOf(KDMEntity entityToAvaliate) {
		String completePath = "";
		String architectureCompletePath = "";

		architectureCompletePath = architectureCompletePath.concat(this.getArchitecturalHierarchyOfArchitecturalElement(this.architecturalElementIs));
		
		String nameObject = entityToAvaliate.getName() == null ? "anonymous" : entityToAvaliate.getName();
		String nameThisObjectIteration = (SEPARATOR_CLASS_TYPE.replace("?", entityToAvaliate.eClass().getName())).concat(nameObject);
		
		return architectureCompletePath.concat(completePath.concat(SEPARATOR_TYPE).concat(nameThisObjectIteration));
	}
	
	private String getArchitecturalHierarchyOfArchitecturalElement(AbstractStructureElement elementToAvaliate) {
		String completePath = "";

		if(elementToAvaliate.eContainer() instanceof AbstractStructureElement){
			completePath = completePath.concat(this.getArchitecturalHierarchyOfArchitecturalElement((AbstractStructureElement) elementToAvaliate.eContainer()));
		}else if (elementToAvaliate.eContainer() instanceof KDMModel){
			completePath = completePath.concat(this.getHierarchyOf((KDMModel) elementToAvaliate.eContainer()));
		}

		String nameObject = elementToAvaliate.getName() == null ? "anonymous" : elementToAvaliate.getName();
		String nameThisObjectIteration = (SEPARATOR_CLASS_TYPE.replace("?", elementToAvaliate.eClass().getName())).concat(nameObject);

		return (completePath.concat(SEPARATOR_TYPE)).concat(nameThisObjectIteration);
	}

	@Override
	public String getHierarchyOf(Package packageToAvaliate) {
		String completePath = "";

		if(this.validateArchitecturalElement(packageToAvaliate)){
			return this.getArchitecturalHierarchyOf(packageToAvaliate);
		}

		if(packageToAvaliate.eContainer() instanceof Package){
			completePath = completePath.concat(this.getHierarchyOf((Package) packageToAvaliate.eContainer()));
		}else if(packageToAvaliate.eContainer() instanceof KDMModel){
			completePath = completePath.concat(this.getHierarchyOf((KDMModel) packageToAvaliate.eContainer()));
		}

		String nameObject = packageToAvaliate.getName() == null ? "anonymous" : packageToAvaliate.getName();
		String nameThisObjectIteration = (SEPARATOR_CLASS_TYPE.replace("?", packageToAvaliate.eClass().getName())).concat(nameObject);

		return (completePath.concat(SEPARATOR_TYPE)).concat(nameThisObjectIteration);
	}

	@Override
	public String getHierarchyOf(ClassUnit classToAvaliate) {
		String completePath = "";

		if(this.validateArchitecturalElement(classToAvaliate)){
			return this.getArchitecturalHierarchyOf(classToAvaliate);
		}
		
		if(classToAvaliate.eContainer() instanceof Package){
			completePath = completePath.concat(this.getHierarchyOf((Package) classToAvaliate.eContainer()));
		}else if (classToAvaliate.eContainer() instanceof ClassUnit){
			completePath = completePath.concat(this.getHierarchyOf((ClassUnit) classToAvaliate.eContainer()));
		}else if (classToAvaliate.eContainer() instanceof InterfaceUnit){
			completePath = completePath.concat(this.getHierarchyOf((InterfaceUnit) classToAvaliate.eContainer()));
		}else if (classToAvaliate.eContainer() instanceof EnumeratedType){
			completePath = completePath.concat(this.getHierarchyOf((EnumeratedType) classToAvaliate.eContainer()));
		}else if (classToAvaliate.eContainer() instanceof KDMModel){
			completePath = completePath.concat(this.getHierarchyOf((KDMModel) classToAvaliate.eContainer()));
		}

		String nameObject = classToAvaliate.getName() == null ? "anonymous" : classToAvaliate.getName();
		String nameThisObjectIteration = (SEPARATOR_CLASS_TYPE.replace("?", classToAvaliate.eClass().getName())).concat(nameObject);

		return (completePath.concat(SEPARATOR_TYPE)).concat(nameThisObjectIteration);
	}

	@Override
	public String getHierarchyOf(InterfaceUnit interfaceToAvaliate) {
		String completePath = "";

		if(this.validateArchitecturalElement(interfaceToAvaliate)){
			return this.getArchitecturalHierarchyOf(interfaceToAvaliate);
		}
		
		if(interfaceToAvaliate.eContainer() instanceof Package){
			completePath = completePath.concat(this.getHierarchyOf((Package) interfaceToAvaliate.eContainer()));
		}else if (interfaceToAvaliate.eContainer() instanceof ClassUnit){
			completePath = completePath.concat(this.getHierarchyOf((ClassUnit) interfaceToAvaliate.eContainer()));
		}else if (interfaceToAvaliate.eContainer() instanceof InterfaceUnit){
			completePath = completePath.concat(this.getHierarchyOf((InterfaceUnit) interfaceToAvaliate.eContainer()));
		}else if (interfaceToAvaliate.eContainer() instanceof EnumeratedType){
			completePath = completePath.concat(this.getHierarchyOf((EnumeratedType) interfaceToAvaliate.eContainer()));
		}else if (interfaceToAvaliate.eContainer() instanceof KDMModel){
			completePath = completePath.concat(this.getHierarchyOf((KDMModel) interfaceToAvaliate.eContainer()));
		}

		String nameObject = interfaceToAvaliate.getName() == null ? "anonymous" : interfaceToAvaliate.getName();
		String nameThisObjectIteration = (SEPARATOR_CLASS_TYPE.replace("?", interfaceToAvaliate.eClass().getName())).concat(nameObject);

		return (completePath.concat(SEPARATOR_TYPE)).concat(nameThisObjectIteration);
	}

	@Override
	public String getHierarchyOf(EnumeratedType enumeratedTypeToAvaliate) {
		String completePath = "";

		if(this.validateArchitecturalElement(enumeratedTypeToAvaliate)){
			return this.getArchitecturalHierarchyOf(enumeratedTypeToAvaliate);
		}
		
		if(enumeratedTypeToAvaliate.eContainer() instanceof Package){
			completePath = completePath.concat(this.getHierarchyOf((Package) enumeratedTypeToAvaliate.eContainer()));
		}else if (enumeratedTypeToAvaliate.eContainer() instanceof ClassUnit){
			completePath = completePath.concat(this.getHierarchyOf((ClassUnit) enumeratedTypeToAvaliate.eContainer()));
		}else if (enumeratedTypeToAvaliate.eContainer() instanceof InterfaceUnit){
			completePath = completePath.concat(this.getHierarchyOf((InterfaceUnit) enumeratedTypeToAvaliate.eContainer()));
		}else if (enumeratedTypeToAvaliate.eContainer() instanceof EnumeratedType){
			completePath = completePath.concat(this.getHierarchyOf((EnumeratedType) enumeratedTypeToAvaliate.eContainer()));
		}else if (enumeratedTypeToAvaliate.eContainer() instanceof KDMModel){
			completePath = completePath.concat(this.getHierarchyOf((KDMModel) enumeratedTypeToAvaliate.eContainer()));
		}

		String nameObject = enumeratedTypeToAvaliate.getName() == null ? "anonymous" : enumeratedTypeToAvaliate.getName();
		String nameThisObjectIteration = (SEPARATOR_CLASS_TYPE.replace("?", enumeratedTypeToAvaliate.eClass().getName())).concat(nameObject);

		return (completePath.concat(SEPARATOR_TYPE)).concat(nameThisObjectIteration);
	}

	@Override
	public String getHierarchyOf(StorableUnit storableToAvaliate) {
		String completePath = "";

		if(storableToAvaliate.eContainer() instanceof MethodUnit){
			completePath = completePath.concat(this.getHierarchyOf((MethodUnit) storableToAvaliate.eContainer()));
		}else if (storableToAvaliate.eContainer() instanceof ClassUnit){
			completePath = completePath.concat(this.getHierarchyOf((ClassUnit) storableToAvaliate.eContainer()));
		}else if (storableToAvaliate.eContainer() instanceof InterfaceUnit){
			completePath = completePath.concat(this.getHierarchyOf((InterfaceUnit) storableToAvaliate.eContainer()));
		}else if (storableToAvaliate.eContainer() instanceof EnumeratedType){
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
		}else if (methodToAvaliate.eContainer() instanceof InterfaceUnit){
			completePath = completePath.concat(this.getHierarchyOf((InterfaceUnit) methodToAvaliate.eContainer()));
		}else if (methodToAvaliate.eContainer() instanceof EnumeratedType){
			completePath = completePath.concat(this.getHierarchyOf((EnumeratedType) methodToAvaliate.eContainer()));
		}

		String nameObject = methodToAvaliate.getName() == null ? "anonymous" : methodToAvaliate.getName();
		String nameThisObjectIteration = (SEPARATOR_CLASS_TYPE.replace("?", methodToAvaliate.eClass().getName())).concat(nameObject);

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

		if(parameterToAvaliate.eContainer() instanceof Signature){
			completePath = completePath.concat(this.getHierarchyOf((Signature) parameterToAvaliate.eContainer()));
		}

		String nameObject = parameterToAvaliate.getName() == null ? "anonymous" : parameterToAvaliate.getName();
		String nameThisObjectIteration = (SEPARATOR_CLASS_TYPE.replace("?", parameterToAvaliate.eClass().getName())).concat(nameObject);

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

}
