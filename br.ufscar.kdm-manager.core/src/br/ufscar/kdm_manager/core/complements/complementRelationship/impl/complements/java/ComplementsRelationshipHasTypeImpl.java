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
package br.ufscar.kdm_manager.core.complements.complementRelationship.impl.complements.java;

import org.eclipse.gmt.modisco.omg.kdm.action.ActionElement;
import org.eclipse.gmt.modisco.omg.kdm.action.BlockUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.AbstractCodeRelationship;
import org.eclipse.gmt.modisco.omg.kdm.code.ClassUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.CodeFactory;
import org.eclipse.gmt.modisco.omg.kdm.code.CodeModel;
import org.eclipse.gmt.modisco.omg.kdm.code.Datatype;
import org.eclipse.gmt.modisco.omg.kdm.code.EnumeratedType;
import org.eclipse.gmt.modisco.omg.kdm.code.HasType;
import org.eclipse.gmt.modisco.omg.kdm.code.InterfaceUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.MethodUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.Package;
import org.eclipse.gmt.modisco.omg.kdm.code.ParameterTo;
import org.eclipse.gmt.modisco.omg.kdm.code.ParameterUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.Signature;
import org.eclipse.gmt.modisco.omg.kdm.code.StorableUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.TemplateType;
import org.eclipse.gmt.modisco.omg.kdm.kdm.Segment;

import br.ufscar.kdm_manager.core.complements.complementRelationship.interfaces.ComplementsGenericRelationship;

public class ComplementsRelationshipHasTypeImpl implements ComplementsGenericRelationship{

	@Override
	public ClassUnit complementsRelationOf(ClassUnit classToUpdate) {
		
		for (int i = 0; i < classToUpdate.getCodeElement().size(); i++) {
			
			if(classToUpdate.getCodeElement().get(i) instanceof StorableUnit){

				classToUpdate.getCodeElement().set(i, this.complementsRelationOf((StorableUnit)classToUpdate.getCodeElement().get(i)));
				
			}else if(classToUpdate.getCodeElement().get(i) instanceof MethodUnit){
				
				classToUpdate.getCodeElement().set(i, this.complementsRelationOf((MethodUnit)classToUpdate.getCodeElement().get(i)));
				
			}
			
		}
		
		return classToUpdate;
	}

	@Override
	public Package complementsRelationOf(Package packageToUpdate) {
		
		for (int i = 0; i < packageToUpdate.getCodeElement().size(); i++) {
			
			if(packageToUpdate.getCodeElement().get(i) instanceof ClassUnit){

				packageToUpdate.getCodeElement().set(i, this.complementsRelationOf((ClassUnit)packageToUpdate.getCodeElement().get(i)));
				
			}else if(packageToUpdate.getCodeElement().get(i) instanceof InterfaceUnit){
				packageToUpdate.getCodeElement().set(i, (InterfaceUnit) packageToUpdate.getCodeElement().get(i));
			}else if(packageToUpdate.getCodeElement().get(i) instanceof Package){
				
				packageToUpdate.getCodeElement().set(i, this.complementsRelationOf((Package)packageToUpdate.getCodeElement().get(i)));
				
			}
			
		}
		
		return packageToUpdate;
	}

	@Override
	public BlockUnit complementsRelationOf(BlockUnit blockToUpdate) {

		for (int i = 0; i < blockToUpdate.getCodeElement().size(); i++) {
			
			if (blockToUpdate.getCodeElement().get(i) instanceof StorableUnit) {
				
				blockToUpdate.getCodeElement().set(i, this.complementsRelationOf((StorableUnit) blockToUpdate.getCodeElement().get(i)));
			
			}else if(blockToUpdate.getCodeElement().get(i) instanceof ActionElement ){
				
				blockToUpdate.getCodeElement().set(i, this.complementsRelationOf((ActionElement) blockToUpdate.getCodeElement().get(i)));
				
			}else if(blockToUpdate.getCodeElement().get(i) instanceof BlockUnit ){
				
				blockToUpdate.getCodeElement().set(i, this.complementsRelationOf((BlockUnit) blockToUpdate.getCodeElement().get(i)));
				
			}
			
			
		}
		
		return blockToUpdate;
	}

	@Override
	public ActionElement complementsRelationOf(ActionElement actionElementToUpdate) {

		for (int i = 0; i < actionElementToUpdate.getCodeElement().size(); i++) {
			
			if (actionElementToUpdate.getCodeElement().get(i) instanceof StorableUnit) {
				
				actionElementToUpdate.getCodeElement().set(i, this.complementsRelationOf((StorableUnit) actionElementToUpdate.getCodeElement().get(i)));
			
			}else if(actionElementToUpdate.getCodeElement().get(i) instanceof ActionElement ){
				
				actionElementToUpdate.getCodeElement().set(i, this.complementsRelationOf((ActionElement) actionElementToUpdate.getCodeElement().get(i)));
				
			}else if(actionElementToUpdate.getCodeElement().get(i) instanceof BlockUnit ){
				
				actionElementToUpdate.getCodeElement().set(i, this.complementsRelationOf((BlockUnit) actionElementToUpdate.getCodeElement().get(i)));
				
			}
			
		}
		
		return actionElementToUpdate;
	}

	@Override
	public StorableUnit complementsRelationOf(StorableUnit storableToUpdate) {
		
		HasType hasType = CodeFactory.eINSTANCE.createHasType();
		
		hasType.setFrom(storableToUpdate);
		
		Datatype dataType = storableToUpdate.getType();
		
		if (dataType instanceof TemplateType) {
			
			//desce na arvore do TemplateUnit
			TemplateType auxTemplateUnit = (TemplateType) dataType;
			for (AbstractCodeRelationship abstractCodeRelationship : auxTemplateUnit.getCodeRelation()) {
				if(abstractCodeRelationship instanceof ParameterTo){
					dataType = (Datatype) ( (ParameterTo)abstractCodeRelationship ).getTo();							
				}
			}
		} 
		
		hasType.setTo(dataType);
		
		storableToUpdate.getCodeRelation().add(hasType);
		
		return storableToUpdate;
	}

	@Override
	public MethodUnit complementsRelationOf(MethodUnit methodToUpdate) {
		
		for (int i = 0; i < methodToUpdate.getCodeElement().size(); i++) {
			
			if(methodToUpdate.getCodeElement().get(i) instanceof Signature){
				
				methodToUpdate.getCodeElement().set(i, this.complementsRelationOf((Signature) methodToUpdate.getCodeElement().get(i)));
			
			}else if(methodToUpdate.getCodeElement().get(i) instanceof BlockUnit){
				
				methodToUpdate.getCodeElement().set(i, this.complementsRelationOf((BlockUnit) methodToUpdate.getCodeElement().get(i)));
			
			}
			
		}
		
		return methodToUpdate;
	}

	@Override
	public ParameterUnit complementsRelationOf(ParameterUnit parameterToUpdate) {
		
		HasType hasType = CodeFactory.eINSTANCE.createHasType();
		
		hasType.setFrom(parameterToUpdate);					
		
		Datatype dataType = parameterToUpdate.getType();
		
		hasType.setTo(dataType);
		
		parameterToUpdate.getCodeRelation().add(hasType);
		
		return parameterToUpdate;
	}

	@Override
	public Signature complementsRelationOf(Signature signatureToUpdate) {
		
		for (int i = 0; i < signatureToUpdate.getParameterUnit().size(); i++) {
			
			ParameterUnit parameterUnit = signatureToUpdate.getParameterUnit().get(i);
			
			signatureToUpdate.getParameterUnit().set(i, this.complementsRelationOf(parameterUnit));
			
		}
		
		return signatureToUpdate;
	}

	@Override
	public InterfaceUnit complementsRelationOf(InterfaceUnit interfaceToUpdate) {
		
		for (int i = 0; i < interfaceToUpdate.getCodeElement().size(); i++) {
			
			if(interfaceToUpdate.getCodeElement().get(i) instanceof StorableUnit){

				interfaceToUpdate.getCodeElement().set(i, this.complementsRelationOf((StorableUnit)interfaceToUpdate.getCodeElement().get(i)));
				
			}else if(interfaceToUpdate.getCodeElement().get(i) instanceof MethodUnit){
				
				interfaceToUpdate.getCodeElement().set(i, this.complementsRelationOf((MethodUnit)interfaceToUpdate.getCodeElement().get(i)));
				
			}
			
		}
		
		return interfaceToUpdate;
	}

	@Override
	public Segment complementsRelationOf(Segment segmentToUpdate) {

		for (int i = 0; i < segmentToUpdate.getModel().size(); i++) {
			
			if(segmentToUpdate.getModel().get(i) instanceof CodeModel){

				segmentToUpdate.getModel().set(i, this.complementsRelationOf((CodeModel)segmentToUpdate.getModel().get(i)));
				
			}
			
		}
		
		return segmentToUpdate;
	}

	@Override
	public CodeModel complementsRelationOf(CodeModel codeModelToUpdate) {

		for (int i = 0; i < codeModelToUpdate.getCodeElement().size(); i++) {
			
			if(codeModelToUpdate.getCodeElement().get(i) instanceof ClassUnit){

				codeModelToUpdate.getCodeElement().set(i, this.complementsRelationOf((ClassUnit)codeModelToUpdate.getCodeElement().get(i)));
				
			}else if(codeModelToUpdate.getCodeElement().get(i) instanceof Package){
				
				codeModelToUpdate.getCodeElement().set(i, this.complementsRelationOf((Package)codeModelToUpdate.getCodeElement().get(i)));
				
			}
			
		}
		
		return codeModelToUpdate;
	}

	@Override
	public EnumeratedType complementsRelationOf(EnumeratedType enumeratedTypeToUpdate) {
		for (int i = 0; i < enumeratedTypeToUpdate.getCodeElement().size(); i++) {
			
			if(enumeratedTypeToUpdate.getCodeElement().get(i) instanceof StorableUnit){

				enumeratedTypeToUpdate.getCodeElement().set(i, this.complementsRelationOf((StorableUnit)enumeratedTypeToUpdate.getCodeElement().get(i)));
				
			}else if(enumeratedTypeToUpdate.getCodeElement().get(i) instanceof MethodUnit){
				
				enumeratedTypeToUpdate.getCodeElement().set(i, this.complementsRelationOf((MethodUnit)enumeratedTypeToUpdate.getCodeElement().get(i)));
				
			}
			
		}
		
		return enumeratedTypeToUpdate;
	}




}
