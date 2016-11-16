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

import org.eclipse.gmt.modisco.omg.kdm.action.AbstractActionRelationship;
import org.eclipse.gmt.modisco.omg.kdm.action.ActionElement;
import org.eclipse.gmt.modisco.omg.kdm.action.BlockUnit;
import org.eclipse.gmt.modisco.omg.kdm.action.CatchUnit;
import org.eclipse.gmt.modisco.omg.kdm.action.Creates;
import org.eclipse.gmt.modisco.omg.kdm.action.TryUnit;
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

public class KDMRelationshipReaderCreatesImpl implements KDMRelationshipGenericReader<Creates> {

	@Override
	public List<Creates> getAllRelationshipOf(Segment segmentToAvaliate) {
		List<Creates> createsRecovered = new ArrayList<Creates>();

		Map<String, List<CodeModel>> models = KDMModelReaderJavaFactory.eINSTANCE.createKDMCodeModelReader().getAllFromSegment(segmentToAvaliate);

		for (String nameCodeModel : models.keySet()) {

			for (CodeModel codeModel : models.get(nameCodeModel)) {

				createsRecovered.addAll(this.getAllRelationshipOf(codeModel));
			}
		}

		return createsRecovered;
	}

	@Override
	public List<Creates> getAllRelationshipOf(CodeModel codeModelToAvaliate) {
		List<Creates> createsRecovered = new ArrayList<Creates>();

		for (AbstractCodeElement abstractCodeElement : codeModelToAvaliate.getCodeElement()) {

			if(abstractCodeElement instanceof InterfaceUnit){
				createsRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) abstractCodeElement));
			}else if(abstractCodeElement instanceof EnumeratedType){
				createsRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) abstractCodeElement));
			}else if(abstractCodeElement instanceof ClassUnit){
				createsRecovered.addAll(this.getAllRelationshipOf((ClassUnit) abstractCodeElement));
			}else if(abstractCodeElement instanceof Package){
				createsRecovered.addAll(this.getAllRelationshipOf((Package) abstractCodeElement));
			}
		}

		return createsRecovered;
	}

	@Override
	public List<Creates> getAllRelationshipOf(Package packageToAvaliate) {

		List<Creates> createsRecovered = new ArrayList<Creates>();

		for (AbstractCodeElement abstractCodeElement : packageToAvaliate.getCodeElement()) {

			if(abstractCodeElement instanceof ClassUnit){
				createsRecovered.addAll(this.getAllRelationshipOf((ClassUnit) abstractCodeElement));
			}else if(abstractCodeElement instanceof InterfaceUnit){
				createsRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) abstractCodeElement));
			}else if(abstractCodeElement instanceof EnumeratedType){
				createsRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) abstractCodeElement));
			}else if(abstractCodeElement instanceof Package){
				createsRecovered.addAll(this.getAllRelationshipOf((Package) abstractCodeElement));
			}

		}

		return createsRecovered;
	}

	@Override
	public List<Creates> getAllRelationshipOf(ClassUnit classToAvaliate) {

		List<Creates> createsRecovered = new ArrayList<Creates>();

		for (CodeItem codeItem : classToAvaliate.getCodeElement()) {

			if(codeItem instanceof MethodUnit){
				createsRecovered.addAll(this.getAllRelationshipOf((MethodUnit) codeItem));
			}else if(codeItem instanceof ClassUnit){
				createsRecovered.addAll(this.getAllRelationshipOf((ClassUnit) codeItem));
			}else if(codeItem instanceof InterfaceUnit){
				createsRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) codeItem));
			}else if(codeItem instanceof EnumeratedType){
				createsRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) codeItem));
			}

		}

		return createsRecovered;
	}

	@Override
	public List<Creates> getAllRelationshipOf(InterfaceUnit interfaceToAvaliate) {

		List<Creates> createsRecovered = new ArrayList<Creates>();

		for (CodeItem codeItem : interfaceToAvaliate.getCodeElement()) {

			if(codeItem instanceof MethodUnit){
				createsRecovered.addAll(this.getAllRelationshipOf((MethodUnit) codeItem));
			}else if(codeItem instanceof ClassUnit){
				createsRecovered.addAll(this.getAllRelationshipOf((ClassUnit) codeItem));
			}else if(codeItem instanceof InterfaceUnit){
				createsRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) codeItem));
			}else if(codeItem instanceof EnumeratedType){
				createsRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) codeItem));
			}

		}

		return createsRecovered;
	}

	@Override
	public List<Creates> getAllRelationshipOf(EnumeratedType enumeratedTypeToAvaliate) {
		List<Creates> createsRecovered = new ArrayList<Creates>();

		for (CodeItem codeItem : enumeratedTypeToAvaliate.getCodeElement()) {

			if(codeItem instanceof MethodUnit){
				createsRecovered.addAll(this.getAllRelationshipOf((MethodUnit) codeItem));
			}else if(codeItem instanceof ClassUnit){
				createsRecovered.addAll(this.getAllRelationshipOf((ClassUnit) codeItem));
			}else if(codeItem instanceof InterfaceUnit){
				createsRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) codeItem));
			}else if(codeItem instanceof EnumeratedType){
				createsRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) codeItem));
			}

		}

		return createsRecovered;
	}

	@Override
	@Deprecated
	public List<Creates> getAllRelationshipOf(StorableUnit storableToAvaliate) {
		return null;
	}

	@Override
	public List<Creates> getAllRelationshipOf(MethodUnit methodToAvaliate) {

		List<Creates> createsRecovered = new ArrayList<Creates>();

		for (AbstractCodeElement abstractCodeElement : methodToAvaliate.getCodeElement()) {

			if(abstractCodeElement instanceof BlockUnit){
				createsRecovered.addAll(this.getAllRelationshipOf((BlockUnit) abstractCodeElement));
			}

		}

		return createsRecovered;
	}

	@Override
	@Deprecated
	public List<Creates> getAllRelationshipOf(Signature signatureToAvaliate) {
		return null;
	}

	@Override
	@Deprecated
	public List<Creates> getAllRelationshipOf(ParameterUnit parameterToAvaliate) {
		return null;
	}

	@Override
	public List<Creates> getAllRelationshipOf(BlockUnit blockToAvaliate) {

		List<Creates> createsRecovered = new ArrayList<Creates>();

		for (AbstractCodeRelationship abstractCodeRelationship : blockToAvaliate.getCodeRelation()) {
			
			if(abstractCodeRelationship instanceof Creates){
				createsRecovered.add((Creates) abstractCodeRelationship);
			}
			
		}
		for (AbstractActionRelationship abstractActionRelationship : blockToAvaliate.getActionRelation()) {

			if(abstractActionRelationship instanceof Creates){
				createsRecovered.add((Creates) abstractActionRelationship);
			}

		}
		
		for (AbstractCodeElement abstractCodeElement : blockToAvaliate.getCodeElement()) {

			if(abstractCodeElement instanceof ActionElement){

				createsRecovered.addAll(this.getAllRelationshipOf((ActionElement) abstractCodeElement));
				
			}else if(abstractCodeElement instanceof TryUnit){
				
				createsRecovered.addAll(this.getAllRelationshipOf((TryUnit) abstractCodeElement));
				
			}else if(abstractCodeElement instanceof CatchUnit){
				
				createsRecovered.addAll(this.getAllRelationshipOf((CatchUnit) abstractCodeElement));

			}else if(abstractCodeElement instanceof BlockUnit){

				createsRecovered.addAll(this.getAllRelationshipOf((BlockUnit) abstractCodeElement));

			}

		}

		return createsRecovered;
	}

	@Override
	public List<Creates> getAllRelationshipOf(ActionElement actionElementToAvaliate) {

		List<Creates> createsRecovered = new ArrayList<Creates>();

		for (AbstractCodeRelationship abstractCodeRelationship : actionElementToAvaliate.getCodeRelation()) {
			
			if(abstractCodeRelationship instanceof Creates){
				createsRecovered.add((Creates) abstractCodeRelationship);
			}
			
		}
		for (AbstractActionRelationship abstractActionRelationship : actionElementToAvaliate.getActionRelation()) {

			if(abstractActionRelationship instanceof Creates){
				createsRecovered.add((Creates) abstractActionRelationship);
			}

		}

		for (AbstractCodeElement abstractCodeElement : actionElementToAvaliate.getCodeElement()) {

			if(abstractCodeElement instanceof ActionElement){

				createsRecovered.addAll(this.getAllRelationshipOf((ActionElement) abstractCodeElement));
				
			}else if(abstractCodeElement instanceof TryUnit){
				
				createsRecovered.addAll(this.getAllRelationshipOf((TryUnit) abstractCodeElement));
				
			}else if(abstractCodeElement instanceof CatchUnit){
				
				createsRecovered.addAll(this.getAllRelationshipOf((CatchUnit) abstractCodeElement));

			}else if(abstractCodeElement instanceof BlockUnit){

				createsRecovered.addAll(this.getAllRelationshipOf((BlockUnit) abstractCodeElement));

			}
		}

		return createsRecovered;
	}

}
