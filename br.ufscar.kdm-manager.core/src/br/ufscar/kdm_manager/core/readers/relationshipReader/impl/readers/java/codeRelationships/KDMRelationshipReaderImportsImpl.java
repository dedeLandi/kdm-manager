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
import org.eclipse.gmt.modisco.omg.kdm.code.Imports;
import org.eclipse.gmt.modisco.omg.kdm.code.InterfaceUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.MethodUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.Package;
import org.eclipse.gmt.modisco.omg.kdm.code.ParameterUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.Signature;
import org.eclipse.gmt.modisco.omg.kdm.code.StorableUnit;
import org.eclipse.gmt.modisco.omg.kdm.kdm.Segment;

import br.ufscar.kdm_manager.core.readers.modelReader.factory.KDMModelReaderJavaFactory;
import br.ufscar.kdm_manager.core.readers.relationshipReader.interfaces.KDMRelationshipGenericReader;

public class KDMRelationshipReaderImportsImpl implements KDMRelationshipGenericReader<Imports>{

	@Override
	public List<Imports> getAllRelationshipOf(Segment segmentToAvaliate) {
		List<Imports> importsRecovered = new ArrayList<Imports>();

		Map<String, List<CodeModel>> models = KDMModelReaderJavaFactory.eINSTANCE.createKDMCodeModelReader().getAllFromSegment(segmentToAvaliate);

		for (String nameCodeModel : models.keySet()) {

			for (CodeModel codeModel : models.get(nameCodeModel)) {

				importsRecovered.addAll(this.getAllRelationshipOf(codeModel));
			}
		}

		return importsRecovered;
	}

	@Override
	public List<Imports> getAllRelationshipOf(CodeModel codeModelToAvaliate) {
		List<Imports> importsRecovered = new ArrayList<Imports>();
		
		for (AbstractCodeElement abstractCodeElement : codeModelToAvaliate.getCodeElement()) {
			
			if(abstractCodeElement instanceof InterfaceUnit){
				importsRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) abstractCodeElement));
			}else if(abstractCodeElement instanceof EnumeratedType){
				importsRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) abstractCodeElement));
			}else if(abstractCodeElement instanceof ClassUnit){
				importsRecovered.addAll(this.getAllRelationshipOf((ClassUnit) abstractCodeElement));
			}else if(abstractCodeElement instanceof Package){
				importsRecovered.addAll(this.getAllRelationshipOf((Package) abstractCodeElement));
			}
		}
		
		return importsRecovered;
	}
	
	@Override
	public List<Imports> getAllRelationshipOf(Package packageToAvaliate) {
		
		List<Imports> importsRecovered = new ArrayList<Imports>();
		
		for (AbstractCodeRelationship abstractCodeRelationship : packageToAvaliate.getCodeRelation()) {
			
			if(abstractCodeRelationship instanceof Imports){
				importsRecovered.add((Imports) abstractCodeRelationship);
			}
			
		}
		
		for (AbstractCodeElement abstractCodeElement : packageToAvaliate.getCodeElement()) {
			
			if(abstractCodeElement instanceof InterfaceUnit){
				importsRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) abstractCodeElement));
			}else if(abstractCodeElement instanceof EnumeratedType){
				importsRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) abstractCodeElement));
			}else if(abstractCodeElement instanceof ClassUnit){
				importsRecovered.addAll(this.getAllRelationshipOf((ClassUnit) abstractCodeElement));
			}else if(abstractCodeElement instanceof Package){
				importsRecovered.addAll(this.getAllRelationshipOf((Package) abstractCodeElement));
			}
		}
		
		return importsRecovered;
	}

	@Override
	public List<Imports> getAllRelationshipOf(ClassUnit classToAvaliate) {
		List<Imports> importsRecovered = new ArrayList<Imports>();
		
		for (AbstractCodeRelationship abstractCodeRelationship : classToAvaliate.getCodeRelation()) {
			if(abstractCodeRelationship instanceof Imports){
				importsRecovered.add((Imports) abstractCodeRelationship);
			}
		}
		for (CodeItem codeItem : classToAvaliate.getCodeElement()) {
			
			if(codeItem instanceof InterfaceUnit){
				importsRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) codeItem));
			}else if(codeItem instanceof EnumeratedType){
				importsRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) codeItem));
			}else if(codeItem instanceof ClassUnit){
				importsRecovered.addAll(this.getAllRelationshipOf((ClassUnit) codeItem));
			}
		}
		
		return importsRecovered;
	}
	
	@Override
	public List<Imports> getAllRelationshipOf(InterfaceUnit interfaceToAvaliate) {
		
		List<Imports> importsRecovered = new ArrayList<Imports>();
		
		for (AbstractCodeRelationship abstractCodeRelationship : interfaceToAvaliate.getCodeRelation()) {
			if(abstractCodeRelationship instanceof Imports){
				importsRecovered.add((Imports) abstractCodeRelationship);
			}
		}
		for (CodeItem codeItem : interfaceToAvaliate.getCodeElement()) {
			
			if(codeItem instanceof InterfaceUnit){
				importsRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) codeItem));
			}else if(codeItem instanceof EnumeratedType){
				importsRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) codeItem));
			}else if(codeItem instanceof ClassUnit){
				importsRecovered.addAll(this.getAllRelationshipOf((ClassUnit) codeItem));
			}
		}
		
		return importsRecovered;
	}

	@Override
	public List<Imports> getAllRelationshipOf(EnumeratedType enumeratedTypeToAvaliate) {
		List<Imports> importsRecovered = new ArrayList<Imports>();
		
		for (AbstractCodeRelationship abstractCodeRelationship : enumeratedTypeToAvaliate.getCodeRelation()) {
			if(abstractCodeRelationship instanceof Imports){
				importsRecovered.add((Imports) abstractCodeRelationship);
			}
		}
		for (CodeItem codeItem : enumeratedTypeToAvaliate.getCodeElement()) {
			
			if(codeItem instanceof InterfaceUnit){
				importsRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) codeItem));
			}else if(codeItem instanceof EnumeratedType){
				importsRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) codeItem));
			}else if(codeItem instanceof ClassUnit){
				importsRecovered.addAll(this.getAllRelationshipOf((ClassUnit) codeItem));
			}
		}
		
		return importsRecovered;
	}

	@Override
	@Deprecated
	public List<Imports> getAllRelationshipOf(BlockUnit blockToAvaliate) {
		return null;
	}

	@Override
	@Deprecated
	public List<Imports> getAllRelationshipOf(StorableUnit storableToAvaliate) {
		return null;
	}

	@Override
	@Deprecated
	public List<Imports> getAllRelationshipOf(MethodUnit methodToAvaliate) {
		return null;
	}

	@Override
	@Deprecated
	public List<Imports> getAllRelationshipOf(ActionElement actionElementToAvaliate) {
		return null;
	}

	@Override
	@Deprecated
	public List<Imports> getAllRelationshipOf(Signature signatureToAvaliate) {
		return null;
	}

	@Override
	@Deprecated
	public List<Imports> getAllRelationshipOf(ParameterUnit parameterToAvaliate) {
		return null;
	}

}
