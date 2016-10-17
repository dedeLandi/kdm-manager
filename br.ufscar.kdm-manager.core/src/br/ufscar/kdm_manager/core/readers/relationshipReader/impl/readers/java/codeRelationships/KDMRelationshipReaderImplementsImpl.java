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
import org.eclipse.gmt.modisco.omg.kdm.code.Implements;
import org.eclipse.gmt.modisco.omg.kdm.code.InterfaceUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.MethodUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.Package;
import org.eclipse.gmt.modisco.omg.kdm.code.ParameterUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.Signature;
import org.eclipse.gmt.modisco.omg.kdm.code.StorableUnit;
import org.eclipse.gmt.modisco.omg.kdm.kdm.Segment;

import br.ufscar.kdm_manager.core.readers.modelReader.factory.KDMModelReaderJavaFactory;
import br.ufscar.kdm_manager.core.readers.relationshipReader.interfaces.KDMRelationshipGenericReader;

public class KDMRelationshipReaderImplementsImpl implements KDMRelationshipGenericReader<Implements>{

	@Override
	public List<Implements> getAllRelationshipOf(Segment segmentToAvaliate) {
		List<Implements> implementsRecovered = new ArrayList<Implements>();

		Map<String, List<CodeModel>> models = KDMModelReaderJavaFactory.eINSTANCE.createKDMCodeModelReader().getAllFromSegment(segmentToAvaliate);

		for (String nameCodeModel : models.keySet()) {

			for (CodeModel codeModel : models.get(nameCodeModel)) {

				implementsRecovered.addAll(this.getAllRelationshipOf(codeModel));
			}
		}

		return implementsRecovered;
	}

	@Override
	public List<Implements> getAllRelationshipOf(CodeModel codeModelToAvaliate) {
		List<Implements> implementsRecovered = new ArrayList<Implements>();
		
		for (AbstractCodeElement abstractCodeElement : codeModelToAvaliate.getCodeElement()) {
			
			if(abstractCodeElement instanceof InterfaceUnit){
				implementsRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) abstractCodeElement));
			}else if(abstractCodeElement instanceof EnumeratedType){
				implementsRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) abstractCodeElement));
			}else if(abstractCodeElement instanceof ClassUnit){
				implementsRecovered.addAll(this.getAllRelationshipOf((ClassUnit) abstractCodeElement));
			}else if(abstractCodeElement instanceof Package){
				implementsRecovered.addAll(this.getAllRelationshipOf((Package) abstractCodeElement));
			}
		}
		
		return implementsRecovered;
	}
	
	@Override
	public List<Implements> getAllRelationshipOf(Package packageToAvaliate) {
		
		List<Implements> implementsRecovered = new ArrayList<Implements>();
		
		for (AbstractCodeElement abstractCodeElement : packageToAvaliate.getCodeElement()) {
			
			if(abstractCodeElement instanceof InterfaceUnit){
				implementsRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) abstractCodeElement));
			}else if(abstractCodeElement instanceof EnumeratedType){
				implementsRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) abstractCodeElement));
			}else if(abstractCodeElement instanceof ClassUnit){
				implementsRecovered.addAll(this.getAllRelationshipOf((ClassUnit) abstractCodeElement));
			}else if(abstractCodeElement instanceof Package){
				implementsRecovered.addAll(this.getAllRelationshipOf((Package) abstractCodeElement));
			}
		}
		
		return implementsRecovered;
	}

	@Override
	public List<Implements> getAllRelationshipOf(ClassUnit classToAvaliate) {
		List<Implements> implementsRecovered = new ArrayList<Implements>();
		
		for (AbstractCodeRelationship abstractCodeRelationship : classToAvaliate.getCodeRelation()) {
			if(abstractCodeRelationship instanceof Implements){
				implementsRecovered.add((Implements) abstractCodeRelationship);
			}
		}
		for (CodeItem codeItem : classToAvaliate.getCodeElement()) {
			
			if(codeItem instanceof InterfaceUnit){
				implementsRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) codeItem));
			}else if(codeItem instanceof EnumeratedType){
				implementsRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) codeItem));
			}else if(codeItem instanceof ClassUnit){
				implementsRecovered.addAll(this.getAllRelationshipOf((ClassUnit) codeItem));
			}
		}
		
		return implementsRecovered;
	}
	
	@Override
	public List<Implements> getAllRelationshipOf(InterfaceUnit interfaceToAvaliate) {
		
		List<Implements> implementsRecovered = new ArrayList<Implements>();
		
		for (AbstractCodeRelationship abstractCodeRelationship : interfaceToAvaliate.getCodeRelation()) {
			if(abstractCodeRelationship instanceof Implements){
				implementsRecovered.add((Implements) abstractCodeRelationship);
			}
		}
		for (CodeItem codeItem : interfaceToAvaliate.getCodeElement()) {
			
			if(codeItem instanceof InterfaceUnit){
				implementsRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) codeItem));
			}else if(codeItem instanceof EnumeratedType){
				implementsRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) codeItem));
			}else if(codeItem instanceof ClassUnit){
				implementsRecovered.addAll(this.getAllRelationshipOf((ClassUnit) codeItem));
			}
		}
		
		return implementsRecovered;
	}

	@Override
	public List<Implements> getAllRelationshipOf(EnumeratedType enumeratedTypeToAvaliate) {
		List<Implements> implementsRecovered = new ArrayList<Implements>();
		
		for (AbstractCodeRelationship abstractCodeRelationship : enumeratedTypeToAvaliate.getCodeRelation()) {
			if(abstractCodeRelationship instanceof Implements){
				implementsRecovered.add((Implements) abstractCodeRelationship);
			}
		}
		for (CodeItem codeItem : enumeratedTypeToAvaliate.getCodeElement()) {
			
			if(codeItem instanceof InterfaceUnit){
				implementsRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) codeItem));
			}else if(codeItem instanceof EnumeratedType){
				implementsRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) codeItem));
			}else if(codeItem instanceof ClassUnit){
				implementsRecovered.addAll(this.getAllRelationshipOf((ClassUnit) codeItem));
			}
		}
		
		return implementsRecovered;
	}

	@Override
	@Deprecated
	public List<Implements> getAllRelationshipOf(BlockUnit blockToAvaliate) {
		return null;
	}

	@Override
	@Deprecated
	public List<Implements> getAllRelationshipOf(StorableUnit storableToAvaliate) {
		return null;
	}

	@Override
	@Deprecated
	public List<Implements> getAllRelationshipOf(MethodUnit methodToAvaliate) {
		return null;
	}

	@Override
	@Deprecated
	public List<Implements> getAllRelationshipOf(ActionElement actionElementToAvaliate) {
		return null;
	}

	@Override
	@Deprecated
	public List<Implements> getAllRelationshipOf(Signature signatureToAvaliate) {
		return null;
	}

	@Override
	@Deprecated
	public List<Implements> getAllRelationshipOf(ParameterUnit parameterToAvaliate) {
		return null;
	}

}
