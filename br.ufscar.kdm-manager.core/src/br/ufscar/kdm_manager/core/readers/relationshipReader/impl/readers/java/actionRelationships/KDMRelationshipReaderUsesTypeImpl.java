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
package br.ufscar.kdm_manager.core.readers.relationshipReader.impl.readers.java.actionRelationships;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.gmt.modisco.omg.kdm.action.ActionElement;
import org.eclipse.gmt.modisco.omg.kdm.action.BlockUnit;
import org.eclipse.gmt.modisco.omg.kdm.action.UsesType;
import org.eclipse.gmt.modisco.omg.kdm.code.AbstractCodeElement;
import org.eclipse.gmt.modisco.omg.kdm.code.AbstractCodeRelationship;
import org.eclipse.gmt.modisco.omg.kdm.code.ClassUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.CodeItem;
import org.eclipse.gmt.modisco.omg.kdm.code.CodeModel;
import org.eclipse.gmt.modisco.omg.kdm.code.EnumeratedType;
import org.eclipse.gmt.modisco.omg.kdm.code.InterfaceUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.MethodUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.Package;
import org.eclipse.gmt.modisco.omg.kdm.code.ParameterUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.Signature;
import org.eclipse.gmt.modisco.omg.kdm.code.StorableUnit;
import org.eclipse.gmt.modisco.omg.kdm.kdm.Segment;

import br.ufscar.kdm_manager.core.readers.modelReader.factory.KDMModelReaderJavaFactory;
import br.ufscar.kdm_manager.core.readers.relationshipReader.interfaces.KDMRelationshipGenericReader;

public class KDMRelationshipReaderUsesTypeImpl implements KDMRelationshipGenericReader<UsesType> {

	@Override
	public List<UsesType> getAllRelationshipOf(Segment segmentToAvaliate) {
		List<UsesType> usesTypeRecovered = new ArrayList<UsesType>();

		Map<String, List<CodeModel>> models = KDMModelReaderJavaFactory.eINSTANCE.createKDMCodeModelReader().getAllFromSegment(segmentToAvaliate);

		for (String nameCodeModel : models.keySet()) {

			for (CodeModel codeModel : models.get(nameCodeModel)) {

				usesTypeRecovered.addAll(this.getAllRelationshipOf(codeModel));
			}
		}

		return usesTypeRecovered;
	}

	@Override
	public List<UsesType> getAllRelationshipOf(CodeModel codeModelToAvaliate) {
		List<UsesType> usesTypeRecovered = new ArrayList<UsesType>();
		
		for (AbstractCodeElement abstractCodeElement : codeModelToAvaliate.getCodeElement()) {
			
			if(abstractCodeElement instanceof InterfaceUnit){
				usesTypeRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) abstractCodeElement));
			}else if(abstractCodeElement instanceof EnumeratedType){
				usesTypeRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) abstractCodeElement));
			}else if(abstractCodeElement instanceof ClassUnit){
				usesTypeRecovered.addAll(this.getAllRelationshipOf((ClassUnit) abstractCodeElement));
			}else if(abstractCodeElement instanceof Package){
				usesTypeRecovered.addAll(this.getAllRelationshipOf((Package) abstractCodeElement));
			}
		}
		
		return usesTypeRecovered;
	}
	
	@Override
	public List<UsesType> getAllRelationshipOf(Package packageToAvaliate) {

		List<UsesType> usesTypeRecovered = new ArrayList<UsesType>();
		
		for (AbstractCodeElement abstractCodeElement : packageToAvaliate.getCodeElement()) {
			
			if(abstractCodeElement instanceof ClassUnit){
				usesTypeRecovered.addAll(this.getAllRelationshipOf((ClassUnit) abstractCodeElement));
			}else if(abstractCodeElement instanceof InterfaceUnit){
				usesTypeRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) abstractCodeElement));
			}else if(abstractCodeElement instanceof EnumeratedType){
				usesTypeRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) abstractCodeElement));
			}else if(abstractCodeElement instanceof Package){
				usesTypeRecovered.addAll(this.getAllRelationshipOf((Package) abstractCodeElement));
			}
			
		}
		
		return usesTypeRecovered;
	}
	
	@Override
	public List<UsesType> getAllRelationshipOf(ClassUnit classToAvaliate) {

		List<UsesType> usesTypeRecovered = new ArrayList<UsesType>();
		
		for (CodeItem codeItem : classToAvaliate.getCodeElement()) {
			
			if(codeItem instanceof MethodUnit){
				usesTypeRecovered.addAll(this.getAllRelationshipOf((MethodUnit) codeItem));
			}else if(codeItem instanceof ClassUnit){
				usesTypeRecovered.addAll(this.getAllRelationshipOf((ClassUnit) codeItem));
			}else if(codeItem instanceof InterfaceUnit){
				usesTypeRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) codeItem));
			}else if(codeItem instanceof EnumeratedType){
				usesTypeRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) codeItem));
			}
			
		}
		
		return usesTypeRecovered;
	}
	
	@Override
	public List<UsesType> getAllRelationshipOf(InterfaceUnit interfaceToAvaliate) {

		List<UsesType> usesTypeRecovered = new ArrayList<UsesType>();
		
		for (CodeItem codeItem : interfaceToAvaliate.getCodeElement()) {
			
			if(codeItem instanceof MethodUnit){
				usesTypeRecovered.addAll(this.getAllRelationshipOf((MethodUnit) codeItem));
			}else if(codeItem instanceof ClassUnit){
				usesTypeRecovered.addAll(this.getAllRelationshipOf((ClassUnit) codeItem));
			}else if(codeItem instanceof InterfaceUnit){
				usesTypeRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) codeItem));
			}else if(codeItem instanceof EnumeratedType){
				usesTypeRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) codeItem));
			}
			
		}
		
		return usesTypeRecovered;
	}

	@Override
	public List<UsesType> getAllRelationshipOf(EnumeratedType enumeratedTypeToAvaliate) {
		List<UsesType> usesTypeRecovered = new ArrayList<UsesType>();
		
		for (CodeItem codeItem : enumeratedTypeToAvaliate.getCodeElement()) {
			
			if(codeItem instanceof MethodUnit){
				usesTypeRecovered.addAll(this.getAllRelationshipOf((MethodUnit) codeItem));
			}else if(codeItem instanceof ClassUnit){
				usesTypeRecovered.addAll(this.getAllRelationshipOf((ClassUnit) codeItem));
			}else if(codeItem instanceof InterfaceUnit){
				usesTypeRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) codeItem));
			}else if(codeItem instanceof EnumeratedType){
				usesTypeRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) codeItem));
			}
			
		}
		
		return usesTypeRecovered;
	}

	@Override
	@Deprecated
	public List<UsesType> getAllRelationshipOf(StorableUnit storableToAvaliate) {
		return null;
	}

	@Override
	public List<UsesType> getAllRelationshipOf(MethodUnit methodToAvaliate) {

		List<UsesType> usesTypeRecovered = new ArrayList<UsesType>();
		
		for (AbstractCodeElement abstractCodeElement : methodToAvaliate.getCodeElement()) {
			
			if(abstractCodeElement instanceof BlockUnit){
				usesTypeRecovered.addAll(this.getAllRelationshipOf((BlockUnit) abstractCodeElement));
			}
			
		}
		
		return usesTypeRecovered;
	}

	@Override
	@Deprecated
	public List<UsesType> getAllRelationshipOf(Signature signatureToAvaliate) {
		return null;
	}

	@Override
	@Deprecated
	public List<UsesType> getAllRelationshipOf(ParameterUnit parameterToAvaliate) {
		return null;
	}
	
	@Override
	public List<UsesType> getAllRelationshipOf(BlockUnit blockToAvaliate) {
		
		List<UsesType> usesTypeRecovered = new ArrayList<UsesType>();

		for (AbstractCodeElement abstractCodeElement : blockToAvaliate.getCodeElement()) {

			if(abstractCodeElement instanceof ActionElement){

				usesTypeRecovered.addAll(this.getAllRelationshipOf((ActionElement) abstractCodeElement));

			}else if(abstractCodeElement instanceof BlockUnit){

				usesTypeRecovered.addAll(this.getAllRelationshipOf((BlockUnit) abstractCodeElement));

			}

		}

		return usesTypeRecovered;
	}

	@Override
	public List<UsesType> getAllRelationshipOf(ActionElement actionElementToAvaliate) {
		
		List<UsesType> usesTypeRecovered = new ArrayList<UsesType>();

		for (AbstractCodeRelationship abstractCodeRelationship : actionElementToAvaliate.getCodeRelation()) {
			
			if(abstractCodeRelationship instanceof UsesType){
				usesTypeRecovered.add((UsesType) abstractCodeRelationship);
			}
			
		}
		
		for (AbstractCodeElement abstractCodeElement : actionElementToAvaliate.getCodeElement()) {

			if(abstractCodeElement instanceof ActionElement){

				usesTypeRecovered.addAll(this.getAllRelationshipOf((ActionElement) abstractCodeElement));

			}else if(abstractCodeElement instanceof BlockUnit){

				usesTypeRecovered.addAll(this.getAllRelationshipOf((BlockUnit) abstractCodeElement));

			}
		}
		
		return usesTypeRecovered;
	}

}
