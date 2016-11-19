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

public class KDMCatchReaderImpl implements KDMCodeGenericReader<CatchUnit>{

	private boolean hasNoFilter = true;
	private boolean hasFilter = false;

	private KDMValidateFilter<CatchUnit, ?> filter = null;

	public KDMCatchReaderImpl() {
		super();
	}

	public KDMCatchReaderImpl(KDMValidateFilter<CatchUnit, ?> filter) {
		this.hasNoFilter = false;
		this.hasFilter  = true;
		this.filter = filter;
	}
	
	private boolean validateFilter(CatchUnit elementToValidate) {
		if(this.hasNoFilter){
			return true;
		}else if(this.hasFilter){
			return this.filter.validateElement(elementToValidate);
		}
		return false;
	}	
	@Override
	public List<CatchUnit> getAllFrom(Segment segmentToSearch) {
		List<CatchUnit> blockUnitRecovered = new ArrayList<CatchUnit>();

		Map<String, List<CodeModel>> models = KDMModelReaderJavaFactory.eINSTANCE.createKDMCodeModelReader().getAllFromSegment(segmentToSearch);

		for (String nameCodeModel : models.keySet()) {

			for (CodeModel codeModel : models.get(nameCodeModel)) {

				blockUnitRecovered.addAll(this.getAllCatchsFrom(codeModel));
			}
		}
		
		return blockUnitRecovered;
	}

	@Override
	public List<CatchUnit> getAllFrom(CodeModel codeModelToSearch) {
		return this.getAllCatchsFrom(codeModelToSearch);
	}

	@Override
	public List<CatchUnit> getAllFrom(Package packageToSearch) {
		return this.getAllCatchsFrom(packageToSearch);
	}

	@Override
	public List<CatchUnit> getAllFrom(ClassUnit classUnitToSearch) {
		return this.getAllCatchsFrom(classUnitToSearch);
	}

	@Override
	public List<CatchUnit> getAllFrom(InterfaceUnit interfaceUnitToSearch) {
		return this.getAllCatchsFrom(interfaceUnitToSearch);
	}

	@Override
	public List<CatchUnit> getAllFrom(EnumeratedType enumeratedTypeToSearch) {
		return this.getAllCatchsFrom(enumeratedTypeToSearch);
	}

	@Override
	public List<CatchUnit> getAllFrom(MethodUnit methodUnitToSearch) {
		return this.getAllCatchsFrom(methodUnitToSearch);
	}

	@Override
	public List<CatchUnit> getAllFrom(BlockUnit blockUnitToSearch) {
		return this.getAllCatchsFrom(blockUnitToSearch);
	}

	@Override
	public List<CatchUnit> getAllFrom(ActionElement actionElementToSearch) {
		return this.getAllCatchsFrom(actionElementToSearch);
	}
	
	@Override
	@Deprecated
	public List<CatchUnit> getAllFrom(StorableUnit storableUnitToSearch) {
		return null;
	}
	
	@Override
	@Deprecated
	public List<CatchUnit> getAllFrom(Signature signatureUnitToSearch) {
		return null;
	}

	@Override
	@Deprecated
	public List<CatchUnit> getAllFrom(ParameterUnit parameterUnitUnitToSearch) {
		return null;
	}
	
	private List<CatchUnit> getAllCatchsFrom(CodeModel codeModelToSearch) {
		List<CatchUnit> modelBlocks = new ArrayList<CatchUnit>();

		for (AbstractCodeElement abstractCodeElement : codeModelToSearch.getCodeElement()) {

			if(abstractCodeElement instanceof ClassUnit){

				modelBlocks.addAll(this.getAllCatchsFrom((ClassUnit)abstractCodeElement));
				
			}else if(abstractCodeElement instanceof InterfaceUnit){
				
				modelBlocks.addAll(this.getAllCatchsFrom((InterfaceUnit)abstractCodeElement));
				
			}else if(abstractCodeElement instanceof EnumeratedType){
				
				modelBlocks.addAll(this.getAllCatchsFrom((EnumeratedType)abstractCodeElement));

			}else if(abstractCodeElement instanceof Package){

				modelBlocks.addAll(this.getAllCatchsFrom((Package)abstractCodeElement));

			}

		}

		return modelBlocks;
	}

	private List<CatchUnit> getAllCatchsFrom(Package packageToSearch) {
		List<CatchUnit> packageBlocks = new ArrayList<CatchUnit>();

		for (AbstractCodeElement abstractCodeElement : packageToSearch.getCodeElement()) {

			if(abstractCodeElement instanceof ClassUnit){

				packageBlocks.addAll(this.getAllCatchsFrom((ClassUnit)abstractCodeElement));

			}else if(abstractCodeElement instanceof InterfaceUnit){
				
				packageBlocks.addAll(this.getAllCatchsFrom((InterfaceUnit)abstractCodeElement));
				
			}else if(abstractCodeElement instanceof EnumeratedType){
				
				packageBlocks.addAll(this.getAllCatchsFrom((EnumeratedType)abstractCodeElement));

			}else if(abstractCodeElement instanceof Package){

				packageBlocks.addAll(this.getAllCatchsFrom((Package)abstractCodeElement));

			}

		}

		return packageBlocks;
	}

	private List<CatchUnit> getAllCatchsFrom(ClassUnit classToSearch) {
		List<CatchUnit> classBlocks = new ArrayList<CatchUnit>();
		
		for (CodeItem codeItem : classToSearch.getCodeElement()) {
			
			if(codeItem instanceof ClassUnit){
				
				classBlocks.addAll(this.getAllCatchsFrom((ClassUnit)codeItem));
				
			}else if(codeItem instanceof InterfaceUnit){
				
				classBlocks.addAll(this.getAllCatchsFrom((InterfaceUnit)codeItem));
				
			}else if(codeItem instanceof EnumeratedType){
				
				classBlocks.addAll(this.getAllCatchsFrom((EnumeratedType)codeItem));
				
			}else if (codeItem instanceof MethodUnit){
				
				classBlocks.addAll(this.getAllCatchsFrom((MethodUnit)codeItem));
				
			}
			
		}
		
		return classBlocks;
	}
	
	private List<CatchUnit> getAllCatchsFrom(InterfaceUnit interfaceToSearch) {
		List<CatchUnit> interfaceBlocks = new ArrayList<CatchUnit>();
		
		for (CodeItem codeItem : interfaceToSearch.getCodeElement()) {
			
			if(codeItem instanceof ClassUnit){
				
				interfaceBlocks.addAll(this.getAllCatchsFrom((ClassUnit)codeItem));
				
			}else if(codeItem instanceof InterfaceUnit){
				
				interfaceBlocks.addAll(this.getAllCatchsFrom((InterfaceUnit)codeItem));
				
			}else if(codeItem instanceof EnumeratedType){
				
				interfaceBlocks.addAll(this.getAllCatchsFrom((EnumeratedType)codeItem));
				
			}else if (codeItem instanceof MethodUnit){
				
				interfaceBlocks.addAll(this.getAllCatchsFrom((MethodUnit)codeItem));
				
			}
			
		}
		
		return interfaceBlocks;
	}
	
	private List<CatchUnit> getAllCatchsFrom(EnumeratedType enumeratedTypeToSearch) {
		List<CatchUnit> enumeratedTypeBlocks = new ArrayList<CatchUnit>();

		for (CodeItem codeItem : enumeratedTypeToSearch.getCodeElement()) {

			if(codeItem instanceof ClassUnit){

				enumeratedTypeBlocks.addAll(this.getAllCatchsFrom((ClassUnit)codeItem));

			}else if(codeItem instanceof InterfaceUnit){
				
				enumeratedTypeBlocks.addAll(this.getAllCatchsFrom((InterfaceUnit)codeItem));
				
			}else if(codeItem instanceof EnumeratedType){
				
				enumeratedTypeBlocks.addAll(this.getAllCatchsFrom((EnumeratedType)codeItem));

			}else if (codeItem instanceof MethodUnit){

				enumeratedTypeBlocks.addAll(this.getAllCatchsFrom((MethodUnit)codeItem));

			}

		}

		return enumeratedTypeBlocks;
	}

	private List<CatchUnit> getAllCatchsFrom(MethodUnit methodToSearch) {
		List<CatchUnit> methodBlocks = new ArrayList<CatchUnit>();

		for (AbstractCodeElement abstractCodeElement : methodToSearch.getCodeElement()) {

			if(abstractCodeElement instanceof CatchUnit){
				
				if(validateFilter((CatchUnit) abstractCodeElement)){
					methodBlocks.add((CatchUnit) abstractCodeElement);
				}
				methodBlocks.addAll(this.getAllCatchsFrom((CatchUnit) abstractCodeElement));
			
			}else if(abstractCodeElement instanceof TryUnit){
				
				methodBlocks.addAll(this.getAllCatchsFrom((TryUnit) abstractCodeElement));
			
			}else if(abstractCodeElement instanceof BlockUnit){

				methodBlocks.addAll(this.getAllCatchsFrom((BlockUnit) abstractCodeElement));

			}
		}

		return methodBlocks;
	}

	private List<CatchUnit> getAllCatchsFrom(BlockUnit blockToSearch) {

		List<CatchUnit> blockBlocks = new ArrayList<CatchUnit>();

		for (AbstractCodeElement abstractCodeElement : blockToSearch.getCodeElement()) {

			if(abstractCodeElement instanceof ActionElement ){
				
				blockBlocks.addAll(this.getAllCatchsFrom((ActionElement)abstractCodeElement));
				
			}else if(abstractCodeElement instanceof TryUnit ){
				
				blockBlocks.addAll(this.getAllCatchsFrom((TryUnit)abstractCodeElement));
				
			}else if(abstractCodeElement instanceof BlockUnit ){

				blockBlocks.addAll(this.getAllCatchsFrom((BlockUnit)abstractCodeElement));

			}else if(abstractCodeElement instanceof CatchUnit ){

				if(validateFilter((CatchUnit) abstractCodeElement)){
					blockBlocks.add((CatchUnit) abstractCodeElement);
				}
				blockBlocks.addAll(this.getAllCatchsFrom((CatchUnit)abstractCodeElement));

			}

		}

		return blockBlocks;
	}

	private List<CatchUnit> getAllCatchsFrom(ActionElement actionToSearch) {
		List<CatchUnit> actionBlocks = new ArrayList<CatchUnit>();

		for (AbstractCodeElement abstractCodeElement : actionToSearch.getCodeElement()) {

			if(abstractCodeElement instanceof ActionElement ){
				
				actionBlocks.addAll(this.getAllCatchsFrom((ActionElement)abstractCodeElement));
				
			}else if(abstractCodeElement instanceof TryUnit ){
				
				actionBlocks.addAll(this.getAllCatchsFrom((TryUnit)abstractCodeElement));
				
			}else if(abstractCodeElement instanceof BlockUnit ){

				actionBlocks.addAll(this.getAllCatchsFrom((BlockUnit)abstractCodeElement));

			}else if(abstractCodeElement instanceof CatchUnit ){

				if(validateFilter((CatchUnit) abstractCodeElement)){
					actionBlocks.add((CatchUnit) abstractCodeElement);
				}
				actionBlocks.addAll(this.getAllCatchsFrom((CatchUnit)abstractCodeElement));

			}

		}

		return actionBlocks;
	}
}
