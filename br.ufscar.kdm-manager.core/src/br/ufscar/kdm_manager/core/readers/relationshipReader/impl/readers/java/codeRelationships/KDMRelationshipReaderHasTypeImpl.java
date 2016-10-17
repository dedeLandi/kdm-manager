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
package br.ufscar.kdm_manager.core.readers.relationshipReader.impl.readers.java.codeRelationships;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.gmt.modisco.omg.kdm.action.ActionElement;
import org.eclipse.gmt.modisco.omg.kdm.action.BlockUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.AbstractCodeElement;
import org.eclipse.gmt.modisco.omg.kdm.code.AbstractCodeRelationship;
import org.eclipse.gmt.modisco.omg.kdm.code.ClassUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.CodeItem;
import org.eclipse.gmt.modisco.omg.kdm.code.CodeModel;
import org.eclipse.gmt.modisco.omg.kdm.code.EnumeratedType;
import org.eclipse.gmt.modisco.omg.kdm.code.HasType;
import org.eclipse.gmt.modisco.omg.kdm.code.InterfaceUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.MethodUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.Package;
import org.eclipse.gmt.modisco.omg.kdm.code.ParameterUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.Signature;
import org.eclipse.gmt.modisco.omg.kdm.code.StorableUnit;
import org.eclipse.gmt.modisco.omg.kdm.kdm.Segment;

import br.ufscar.kdm_manager.core.readers.modelReader.factory.KDMModelReaderJavaFactory;
import br.ufscar.kdm_manager.core.readers.relationshipReader.interfaces.KDMRelationshipGenericReader;

public class KDMRelationshipReaderHasTypeImpl implements KDMRelationshipGenericReader<HasType>{

	@Override
	public List<HasType> getAllRelationshipOf(Segment segmentToAvaliate) {
		List<HasType> hasTypeRecovered = new ArrayList<HasType>();

		Map<String, List<CodeModel>> models = KDMModelReaderJavaFactory.eINSTANCE.createKDMCodeModelReader().getAllFromSegment(segmentToAvaliate);

		for (String nameCodeModel : models.keySet()) {

			for (CodeModel codeModel : models.get(nameCodeModel)) {

				hasTypeRecovered.addAll(this.getAllRelationshipOf(codeModel));
			}
		}

		return hasTypeRecovered;
	}

	@Override
	public List<HasType> getAllRelationshipOf(CodeModel codeModelToAvaliate) {
		List<HasType> hasTypeRecovered = new ArrayList<HasType>();

		for (AbstractCodeElement abstractCodeElement : codeModelToAvaliate.getCodeElement()) {

			if(abstractCodeElement instanceof InterfaceUnit){
				hasTypeRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) abstractCodeElement));
			}else if(abstractCodeElement instanceof EnumeratedType){
				hasTypeRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) abstractCodeElement));
			}else if(abstractCodeElement instanceof ClassUnit){
				hasTypeRecovered.addAll(this.getAllRelationshipOf((ClassUnit) abstractCodeElement));
			}else if(abstractCodeElement instanceof Package){
				hasTypeRecovered.addAll(this.getAllRelationshipOf((Package) abstractCodeElement));
			}
		}

		return hasTypeRecovered;
	}

	@Override
	public List<HasType> getAllRelationshipOf(Package packageToAvaliate) {

		List<HasType> hasTypeRecovered = new ArrayList<HasType>();

		for (AbstractCodeElement abstractCodeElement : packageToAvaliate.getCodeElement()) {

			if(abstractCodeElement instanceof InterfaceUnit){
				hasTypeRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) abstractCodeElement));
			}else if(abstractCodeElement instanceof EnumeratedType){
				hasTypeRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) abstractCodeElement));
			}else if(abstractCodeElement instanceof ClassUnit){
				hasTypeRecovered.addAll(this.getAllRelationshipOf((ClassUnit) abstractCodeElement));
			}else if(abstractCodeElement instanceof Package){
				hasTypeRecovered.addAll(this.getAllRelationshipOf((Package) abstractCodeElement));
			}
		}

		return hasTypeRecovered;
	}

	@Override
	public List<HasType> getAllRelationshipOf(ClassUnit classToAvaliate) {
		List<HasType> hasTypeRecovered = new ArrayList<HasType>();

		for (CodeItem codeItem : classToAvaliate.getCodeElement()) {

			if(codeItem instanceof InterfaceUnit){
				hasTypeRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) codeItem));
			}else if(codeItem instanceof EnumeratedType){
				hasTypeRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) codeItem));
			}else if(codeItem instanceof ClassUnit){
				hasTypeRecovered.addAll(this.getAllRelationshipOf((ClassUnit) codeItem));
			}
		}

		return hasTypeRecovered;
	}

	@Override
	public List<HasType> getAllRelationshipOf(InterfaceUnit interfaceToAvaliate) {

		List<HasType> hasTypeRecovered = new ArrayList<HasType>();

		for (CodeItem codeItem : interfaceToAvaliate.getCodeElement()) {

			if(codeItem instanceof InterfaceUnit){
				hasTypeRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) codeItem));
			}else if(codeItem instanceof EnumeratedType){
				hasTypeRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) codeItem));
			}else if(codeItem instanceof ClassUnit){
				hasTypeRecovered.addAll(this.getAllRelationshipOf((ClassUnit) codeItem));
			}
		}

		return hasTypeRecovered;
	}

	@Override
	public List<HasType> getAllRelationshipOf(EnumeratedType enumeratedTypeToAvaliate) {
		List<HasType> hasTypeRecovered = new ArrayList<HasType>();

		for (CodeItem codeItem : enumeratedTypeToAvaliate.getCodeElement()) {

			if(codeItem instanceof InterfaceUnit){
				hasTypeRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) codeItem));
			}else if(codeItem instanceof EnumeratedType){
				hasTypeRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) codeItem));
			}else if(codeItem instanceof ClassUnit){
				hasTypeRecovered.addAll(this.getAllRelationshipOf((ClassUnit) codeItem));
			}
		}

		return hasTypeRecovered;
	}

	@Override
	public List<HasType> getAllRelationshipOf(StorableUnit storableToAvaliate) {
		List<HasType> hasTypeRelations = new ArrayList<HasType>();

		for (AbstractCodeRelationship abstractCodeRelationship : storableToAvaliate.getCodeRelation()) {

			if(abstractCodeRelationship instanceof HasType){

				hasTypeRelations.add((HasType) abstractCodeRelationship);

			}

		}

		return hasTypeRelations;
	}

	@Override
	public List<HasType> getAllRelationshipOf(MethodUnit methodToAvaliate) {
		List<HasType> hasTypeRelations = new ArrayList<HasType>();

		for (AbstractCodeElement abstractCodeElement : methodToAvaliate.getCodeElement()) {

			if(abstractCodeElement instanceof Signature){
				hasTypeRelations.addAll(this.getAllRelationshipOf((Signature)abstractCodeElement));
			}else if(abstractCodeElement instanceof BlockUnit){
				hasTypeRelations.addAll(this.getAllRelationshipOf((BlockUnit)abstractCodeElement));
			}

		}

		return hasTypeRelations;
	}
	
	@Override
	public List<HasType> getAllRelationshipOf(Signature signatureToAvaliate) {
		List<HasType> hasTypeRelations = new ArrayList<HasType>();

		for (ParameterUnit parameterUnit : signatureToAvaliate.getParameterUnit()) {

			hasTypeRelations.addAll(this.getAllRelationshipOf(parameterUnit));

		}

		return hasTypeRelations;
	}

	@Override
	public List<HasType> getAllRelationshipOf(ParameterUnit parameterToAvaliate) {
		List<HasType> hasTypeRelations = new ArrayList<HasType>();

		for (AbstractCodeRelationship abstractCodeRelationship : parameterToAvaliate.getCodeRelation()) {

			if(abstractCodeRelationship instanceof HasType){

				hasTypeRelations.add((HasType) abstractCodeRelationship);

			}

		}

		return hasTypeRelations;
	}

	@Override
	public List<HasType> getAllRelationshipOf(BlockUnit blockToAvaliate) {
		List<HasType> hasTypeRelations = new ArrayList<HasType>();

		for (AbstractCodeElement abstractCodeElement : blockToAvaliate.getCodeElement()) {

			if(abstractCodeElement instanceof ActionElement){
				hasTypeRelations.addAll(this.getAllRelationshipOf((ActionElement)abstractCodeElement));
			}else if(abstractCodeElement instanceof StorableUnit){
				hasTypeRelations.addAll(this.getAllRelationshipOf((StorableUnit)abstractCodeElement));
			}else if(abstractCodeElement instanceof BlockUnit){
				hasTypeRelations.addAll(this.getAllRelationshipOf((BlockUnit)abstractCodeElement));
			}

		}

		return hasTypeRelations;
	}

	@Override
	public List<HasType> getAllRelationshipOf(ActionElement actionElementToAvaliate) {
		List<HasType> hasTypeRelations = new ArrayList<HasType>();

		for (AbstractCodeElement abstractCodeElement : actionElementToAvaliate.getCodeElement()) {

			if(abstractCodeElement instanceof ActionElement){
				hasTypeRelations.addAll(this.getAllRelationshipOf((ActionElement)abstractCodeElement));
			}else if(abstractCodeElement instanceof StorableUnit){
				hasTypeRelations.addAll(this.getAllRelationshipOf((StorableUnit)abstractCodeElement));
			}else if(abstractCodeElement instanceof BlockUnit){
				hasTypeRelations.addAll(this.getAllRelationshipOf((BlockUnit)abstractCodeElement));
			}

		}

		return hasTypeRelations;
	}

}
