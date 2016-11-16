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
import org.eclipse.gmt.modisco.omg.kdm.kdm.Segment;
import org.eclipse.gmt.modisco.omg.kdm.structure.AbstractStructureElement;
import org.eclipse.gmt.modisco.omg.kdm.structure.StructureModel;

import br.ufscar.kdm_manager.core.readers.modelReader.factory.KDMModelReaderJavaFactory;
import br.ufscar.kdm_manager.core.recovers.recoverHierarchy.interfaces.RecoverGenericHierarchy;

public class RecoverHierarchyFirstArchitecturalElementImpl implements RecoverGenericHierarchy<AbstractStructureElement> {

	private Segment segmentToAvaliate = null;
	private AbstractStructureElement architecturalElementIs = null;

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

	@Override
	public AbstractStructureElement getHierarchyOf(Package packageToAvaliate) {

		if(this.validateArchitecturalElement(packageToAvaliate)){
			return this.architecturalElementIs;
		}

		AbstractStructureElement value = null;
		if(packageToAvaliate.eContainer() instanceof Package){
			value = this.getHierarchyOf((Package) packageToAvaliate.eContainer());
		}
		return value;
	}

	@Override
	public AbstractStructureElement getHierarchyOf(ClassUnit classToAvaliate) {

		if(this.validateArchitecturalElement(classToAvaliate)){
			return this.architecturalElementIs;
		}

		AbstractStructureElement value = null;
		if(classToAvaliate.eContainer() instanceof Package){
			value = this.getHierarchyOf((Package) classToAvaliate.eContainer());
		}else if (classToAvaliate.eContainer() instanceof ClassUnit){
			value = this.getHierarchyOf((ClassUnit) classToAvaliate.eContainer());
		}else if (classToAvaliate.eContainer() instanceof InterfaceUnit){
			value = this.getHierarchyOf((InterfaceUnit) classToAvaliate.eContainer());
		}else if (classToAvaliate.eContainer() instanceof EnumeratedType){
			value = this.getHierarchyOf((EnumeratedType) classToAvaliate.eContainer());
		}
		return value;
	}

	@Override
	public AbstractStructureElement getHierarchyOf(InterfaceUnit interfaceToAvaliate) {

		if(this.validateArchitecturalElement(interfaceToAvaliate)){
			return this.architecturalElementIs;
		}

		AbstractStructureElement value = null;
		if(interfaceToAvaliate.eContainer() instanceof Package){
			value = this.getHierarchyOf((Package) interfaceToAvaliate.eContainer());
		}else if (interfaceToAvaliate.eContainer() instanceof ClassUnit){
			value = this.getHierarchyOf((ClassUnit) interfaceToAvaliate.eContainer());
		}else if (interfaceToAvaliate.eContainer() instanceof InterfaceUnit){
			value = this.getHierarchyOf((InterfaceUnit) interfaceToAvaliate.eContainer());
		}else if (interfaceToAvaliate.eContainer() instanceof EnumeratedType){
			value = this.getHierarchyOf((EnumeratedType) interfaceToAvaliate.eContainer());
		}
		return value;
	}

	@Override
	public AbstractStructureElement getHierarchyOf(EnumeratedType enumeratedTypeToAvaliate) {

		if(this.validateArchitecturalElement(enumeratedTypeToAvaliate)){
			return this.architecturalElementIs;
		}
		
		AbstractStructureElement value = null;
		if(enumeratedTypeToAvaliate.eContainer() instanceof Package){
			value = this.getHierarchyOf((Package) enumeratedTypeToAvaliate.eContainer());
		}else if (enumeratedTypeToAvaliate.eContainer() instanceof ClassUnit){
			value = this.getHierarchyOf((ClassUnit) enumeratedTypeToAvaliate.eContainer());
		}else if (enumeratedTypeToAvaliate.eContainer() instanceof InterfaceUnit){
			value = this.getHierarchyOf((InterfaceUnit) enumeratedTypeToAvaliate.eContainer());
		}else if (enumeratedTypeToAvaliate.eContainer() instanceof EnumeratedType){
			value = this.getHierarchyOf((EnumeratedType) enumeratedTypeToAvaliate.eContainer());
		}
		return value;
	}

	@Override
	public AbstractStructureElement getHierarchyOf(StorableUnit storableToAvaliate) {
		AbstractStructureElement value = null;
		if(storableToAvaliate.eContainer() instanceof MethodUnit){
			value = this.getHierarchyOf((MethodUnit) storableToAvaliate.eContainer());
		}else if (storableToAvaliate.eContainer() instanceof ClassUnit){
			value = this.getHierarchyOf((ClassUnit) storableToAvaliate.eContainer());
		}else if (storableToAvaliate.eContainer() instanceof InterfaceUnit){
			value = this.getHierarchyOf((InterfaceUnit) storableToAvaliate.eContainer());
		}else if (storableToAvaliate.eContainer() instanceof EnumeratedType){
			value = this.getHierarchyOf((EnumeratedType) storableToAvaliate.eContainer());
		}else if(storableToAvaliate.eContainer() instanceof BlockUnit){
			value = this.getHierarchyOf((BlockUnit) storableToAvaliate.eContainer());
		}else if(storableToAvaliate.eContainer() instanceof ActionElement){
			value = this.getHierarchyOf((ActionElement) storableToAvaliate.eContainer());
		}

		return value;
	}

	@Override
	public AbstractStructureElement getHierarchyOf(MethodUnit methodToAvaliate) {
		AbstractStructureElement value = null;
		if(methodToAvaliate.eContainer() instanceof ClassUnit){
			value = this.getHierarchyOf((ClassUnit) methodToAvaliate.eContainer());
		}else if (methodToAvaliate.eContainer() instanceof InterfaceUnit){
			value = this.getHierarchyOf((InterfaceUnit) methodToAvaliate.eContainer());
		}else if (methodToAvaliate.eContainer() instanceof EnumeratedType){
			value = this.getHierarchyOf((EnumeratedType) methodToAvaliate.eContainer());
		}

		return value;
	}

	@Override
	public AbstractStructureElement getHierarchyOf(Signature signatureToAvaliate) {
		AbstractStructureElement value = null;
		if(signatureToAvaliate.eContainer() instanceof MethodUnit){
			value = this.getHierarchyOf((MethodUnit) signatureToAvaliate.eContainer());
		}

		return value;
	}

	@Override
	public AbstractStructureElement getHierarchyOf(ParameterUnit parameterToAvaliate) {
		AbstractStructureElement value = null;
		if(parameterToAvaliate.eContainer() instanceof Signature){
			value = this.getHierarchyOf((Signature) parameterToAvaliate.eContainer());
		}

		return value;
	}

	@Override
	public AbstractStructureElement getHierarchyOf(BlockUnit blockToAvaliate) {
		AbstractStructureElement value = null;
		if(blockToAvaliate.eContainer() instanceof MethodUnit){
			value = this.getHierarchyOf((MethodUnit) blockToAvaliate.eContainer());
		}else if(blockToAvaliate.eContainer() instanceof ActionElement){
			value = this.getHierarchyOf((ActionElement) blockToAvaliate.eContainer());
		}

		return value;
	}

	@Override
	public AbstractStructureElement getHierarchyOf(ActionElement actionElementToAvaliate) {
		AbstractStructureElement value = null;
		if(actionElementToAvaliate.eContainer() instanceof BlockUnit){
			value = this.getHierarchyOf((BlockUnit) actionElementToAvaliate.eContainer());
		}else if(actionElementToAvaliate.eContainer() instanceof ActionElement){
			value = this.getHierarchyOf((ActionElement) actionElementToAvaliate.eContainer());
		}
		
		return value;
	}

}
