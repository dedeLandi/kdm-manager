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
package br.ufscar.kdm_manager.core.readers.codeReader.impl.readers.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.gmt.modisco.omg.kdm.action.ActionElement;
import org.eclipse.gmt.modisco.omg.kdm.action.BlockUnit;
import org.eclipse.gmt.modisco.omg.kdm.action.CatchUnit;
import org.eclipse.gmt.modisco.omg.kdm.action.TryUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.AbstractCodeElement;
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

import br.ufscar.kdm_manager.core.filters.validateFilter.interfaces.KDMValidateFilter;
import br.ufscar.kdm_manager.core.readers.codeReader.interfaces.KDMCodeGenericReader;
import br.ufscar.kdm_manager.core.readers.modelReader.factory.KDMModelReaderJavaFactory;

public class KDMTryReaderImpl implements KDMCodeGenericReader<TryUnit>{

	private boolean hasNoFilter = true;
	private boolean hasFilter = false;

	private KDMValidateFilter<TryUnit, ?> filter = null;

	public KDMTryReaderImpl() {
		super();
	}

	public KDMTryReaderImpl(KDMValidateFilter<TryUnit, ?> filter) {
		this.hasNoFilter = false;
		this.hasFilter  = true;
		this.filter = filter;
	}
	
	private boolean validateFilter(TryUnit elementToValidate) {
		if(this.hasNoFilter){
			return true;
		}else if(this.hasFilter){
			return this.filter.validateElement(elementToValidate);
		}
		return false;
	}	
	@Override
	public List<TryUnit> getAllFrom(Segment segmentToSearch) {
		List<TryUnit> tryUnitRecovered = new ArrayList<TryUnit>();

		Map<String, List<CodeModel>> models = KDMModelReaderJavaFactory.eINSTANCE.createKDMCodeModelReader().getAllFromSegment(segmentToSearch);

		for (String nameCodeModel : models.keySet()) {

			for (CodeModel codeModel : models.get(nameCodeModel)) {

				tryUnitRecovered.addAll(this.getAllTryFrom(codeModel));
			}
		}
		
		return tryUnitRecovered;
	}

	@Override
	public List<TryUnit> getAllFrom(CodeModel codeModelToSearch) {
		return this.getAllTryFrom(codeModelToSearch);
	}

	@Override
	public List<TryUnit> getAllFrom(Package packageToSearch) {
		return this.getAllTryFrom(packageToSearch);
	}

	@Override
	public List<TryUnit> getAllFrom(ClassUnit classUnitToSearch) {
		return this.getAllTryFrom(classUnitToSearch);
	}

	@Override
	public List<TryUnit> getAllFrom(InterfaceUnit interfaceUnitToSearch) {
		return this.getAllTryFrom(interfaceUnitToSearch);
	}

	@Override
	public List<TryUnit> getAllFrom(EnumeratedType enumeratedTypeToSearch) {
		return this.getAllTryFrom(enumeratedTypeToSearch);
	}

	@Override
	public List<TryUnit> getAllFrom(MethodUnit methodUnitToSearch) {
		return this.getAllTryFrom(methodUnitToSearch);
	}

	@Override
	public List<TryUnit> getAllFrom(BlockUnit blockUnitToSearch) {
		return this.getAllTryFrom(blockUnitToSearch);
	}

	@Override
	public List<TryUnit> getAllFrom(ActionElement actionElementToSearch) {
		return this.getAllTryFrom(actionElementToSearch);
	}
	
	@Override
	@Deprecated
	public List<TryUnit> getAllFrom(StorableUnit storableUnitToSearch) {
		return null;
	}
	
	@Override
	@Deprecated
	public List<TryUnit> getAllFrom(Signature signatureUnitToSearch) {
		return null;
	}

	@Override
	@Deprecated
	public List<TryUnit> getAllFrom(ParameterUnit parameterUnitUnitToSearch) {
		return null;
	}
	
	private List<TryUnit> getAllTryFrom(CodeModel codeModelToSearch) {
		List<TryUnit> modelBlocks = new ArrayList<TryUnit>();

		for (AbstractCodeElement abstractCodeElement : codeModelToSearch.getCodeElement()) {

			if(abstractCodeElement instanceof ClassUnit){

				modelBlocks.addAll(this.getAllTryFrom((ClassUnit)abstractCodeElement));
				
			}else if(abstractCodeElement instanceof InterfaceUnit){
				
				modelBlocks.addAll(this.getAllTryFrom((InterfaceUnit)abstractCodeElement));
				
			}else if(abstractCodeElement instanceof EnumeratedType){
				
				modelBlocks.addAll(this.getAllTryFrom((EnumeratedType)abstractCodeElement));

			}else if(abstractCodeElement instanceof Package){

				modelBlocks.addAll(this.getAllTryFrom((Package)abstractCodeElement));

			}

		}

		return modelBlocks;
	}

	private List<TryUnit> getAllTryFrom(Package packageToSearch) {
		List<TryUnit> packageBlocks = new ArrayList<TryUnit>();

		for (AbstractCodeElement abstractCodeElement : packageToSearch.getCodeElement()) {

			if(abstractCodeElement instanceof ClassUnit){

				packageBlocks.addAll(this.getAllTryFrom((ClassUnit)abstractCodeElement));

			}else if(abstractCodeElement instanceof InterfaceUnit){
				
				packageBlocks.addAll(this.getAllTryFrom((InterfaceUnit)abstractCodeElement));
				
			}else if(abstractCodeElement instanceof EnumeratedType){
				
				packageBlocks.addAll(this.getAllTryFrom((EnumeratedType)abstractCodeElement));

			}else if(abstractCodeElement instanceof Package){

				packageBlocks.addAll(this.getAllTryFrom((Package)abstractCodeElement));

			}

		}

		return packageBlocks;
	}

	private List<TryUnit> getAllTryFrom(ClassUnit classToSearch) {
		List<TryUnit> classBlocks = new ArrayList<TryUnit>();
		
		for (CodeItem codeItem : classToSearch.getCodeElement()) {
			
			if(codeItem instanceof ClassUnit){
				
				classBlocks.addAll(this.getAllTryFrom((ClassUnit)codeItem));
				
			}else if(codeItem instanceof InterfaceUnit){
				
				classBlocks.addAll(this.getAllTryFrom((InterfaceUnit)codeItem));
				
			}else if(codeItem instanceof EnumeratedType){
				
				classBlocks.addAll(this.getAllTryFrom((EnumeratedType)codeItem));
				
			}else if (codeItem instanceof MethodUnit){
				
				classBlocks.addAll(this.getAllTryFrom((MethodUnit)codeItem));
				
			}
			
		}
		
		return classBlocks;
	}
	
	private List<TryUnit> getAllTryFrom(InterfaceUnit interfaceToSearch) {
		List<TryUnit> interfaceBlocks = new ArrayList<TryUnit>();
		
		for (CodeItem codeItem : interfaceToSearch.getCodeElement()) {
			
			if(codeItem instanceof ClassUnit){
				
				interfaceBlocks.addAll(this.getAllTryFrom((ClassUnit)codeItem));
				
			}else if(codeItem instanceof InterfaceUnit){
				
				interfaceBlocks.addAll(this.getAllTryFrom((InterfaceUnit)codeItem));
				
			}else if(codeItem instanceof EnumeratedType){
				
				interfaceBlocks.addAll(this.getAllTryFrom((EnumeratedType)codeItem));
				
			}else if (codeItem instanceof MethodUnit){
				
				interfaceBlocks.addAll(this.getAllTryFrom((MethodUnit)codeItem));
				
			}
			
		}
		
		return interfaceBlocks;
	}
	
	private List<TryUnit> getAllTryFrom(EnumeratedType enumeratedTypeToSearch) {
		List<TryUnit> enumeratedTypeBlocks = new ArrayList<TryUnit>();

		for (CodeItem codeItem : enumeratedTypeToSearch.getCodeElement()) {

			if(codeItem instanceof ClassUnit){

				enumeratedTypeBlocks.addAll(this.getAllTryFrom((ClassUnit)codeItem));

			}else if(codeItem instanceof InterfaceUnit){
				
				enumeratedTypeBlocks.addAll(this.getAllTryFrom((InterfaceUnit)codeItem));
				
			}else if(codeItem instanceof EnumeratedType){
				
				enumeratedTypeBlocks.addAll(this.getAllTryFrom((EnumeratedType)codeItem));

			}else if (codeItem instanceof MethodUnit){

				enumeratedTypeBlocks.addAll(this.getAllTryFrom((MethodUnit)codeItem));

			}

		}

		return enumeratedTypeBlocks;
	}

	private List<TryUnit> getAllTryFrom(MethodUnit methodToSearch) {
		List<TryUnit> methodBlocks = new ArrayList<TryUnit>();

		for (AbstractCodeElement abstractCodeElement : methodToSearch.getCodeElement()) {

			if(abstractCodeElement instanceof TryUnit){
				
				if(validateFilter((TryUnit) abstractCodeElement)){
					methodBlocks.add((TryUnit) abstractCodeElement);
				}
				methodBlocks.addAll(this.getAllTryFrom((TryUnit) abstractCodeElement));
			
			}else if(abstractCodeElement instanceof CatchUnit){
				
				methodBlocks.addAll(this.getAllTryFrom((CatchUnit) abstractCodeElement));
			
			}else if(abstractCodeElement instanceof BlockUnit){

				methodBlocks.addAll(this.getAllTryFrom((BlockUnit) abstractCodeElement));

			}
		}

		return methodBlocks;
	}

	private List<TryUnit> getAllTryFrom(BlockUnit blockToSearch) {

		List<TryUnit> blockBlocks = new ArrayList<TryUnit>();

		for (AbstractCodeElement abstractCodeElement : blockToSearch.getCodeElement()) {

			if(abstractCodeElement instanceof ActionElement ){
				
				blockBlocks.addAll(this.getAllTryFrom((ActionElement)abstractCodeElement));
				
			}else if(abstractCodeElement instanceof CatchUnit ){
				
				blockBlocks.addAll(this.getAllTryFrom((CatchUnit)abstractCodeElement));
				
			}else if(abstractCodeElement instanceof BlockUnit ){

				blockBlocks.addAll(this.getAllTryFrom((BlockUnit)abstractCodeElement));

			}else if(abstractCodeElement instanceof TryUnit ){

				if(validateFilter((TryUnit) abstractCodeElement)){
					blockBlocks.add((TryUnit) abstractCodeElement);
				}
				blockBlocks.addAll(this.getAllTryFrom((TryUnit)abstractCodeElement));

			}

		}

		return blockBlocks;
	}

	private List<TryUnit> getAllTryFrom(ActionElement actionToSearch) {
		List<TryUnit> actionBlocks = new ArrayList<TryUnit>();

		for (AbstractCodeElement abstractCodeElement : actionToSearch.getCodeElement()) {

			if(abstractCodeElement instanceof ActionElement ){
				
				actionBlocks.addAll(this.getAllTryFrom((ActionElement)abstractCodeElement));
				
			}else if(abstractCodeElement instanceof CatchUnit ){
				
				actionBlocks.addAll(this.getAllTryFrom((CatchUnit)abstractCodeElement));
				
			}else if(abstractCodeElement instanceof BlockUnit ){

				actionBlocks.addAll(this.getAllTryFrom((BlockUnit)abstractCodeElement));

			}else if(abstractCodeElement instanceof TryUnit ){

				if(validateFilter((TryUnit) abstractCodeElement)){
					actionBlocks.add((TryUnit) abstractCodeElement);
				}
				actionBlocks.addAll(this.getAllTryFrom((TryUnit)abstractCodeElement));

			}

		}

		return actionBlocks;
	}
}
