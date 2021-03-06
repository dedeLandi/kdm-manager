/********************************************************************************
 *																				*
 * Copyright (c) 2016, Andr� de Souza Landi. All rights reserved.				*
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

public class KDMBlockReaderImpl implements KDMCodeGenericReader<BlockUnit>{

	private boolean hasNoFilter = true;
	private boolean hasFilter = false;

	private KDMValidateFilter<BlockUnit, ?> filter = null;

	public KDMBlockReaderImpl() {
		super();
	}

	public KDMBlockReaderImpl(KDMValidateFilter<BlockUnit, ?> filter) {
		this.hasNoFilter = false;
		this.hasFilter  = true;
		this.filter = filter;
	}

	private boolean validateFilter(BlockUnit elementToValidate) {
		if(this.hasNoFilter){
			return true;
		}else if(this.hasFilter){
			return this.filter.validateElement(elementToValidate);
		}
		return false;
	}	
	@Override
	public List<BlockUnit> getAllFrom(Segment segmentToSearch) {
		List<BlockUnit> blockUnitRecovered = new ArrayList<BlockUnit>();

		Map<String, List<CodeModel>> models = KDMModelReaderJavaFactory.eINSTANCE.createKDMCodeModelReader().getAllFromSegment(segmentToSearch);

		for (String nameCodeModel : models.keySet()) {

			for (CodeModel codeModel : models.get(nameCodeModel)) {

				blockUnitRecovered.addAll(this.getAllBlocksFrom(codeModel));
			}
		}

		return blockUnitRecovered;
	}

	@Override
	public List<BlockUnit> getAllFrom(CodeModel codeModelToSearch) {
		return this.getAllBlocksFrom(codeModelToSearch);
	}

	@Override
	public List<BlockUnit> getAllFrom(Package packageToSearch) {
		return this.getAllBlocksFrom(packageToSearch);
	}

	@Override
	public List<BlockUnit> getAllFrom(ClassUnit classUnitToSearch) {
		return this.getAllBlocksFrom(classUnitToSearch);
	}

	@Override
	public List<BlockUnit> getAllFrom(InterfaceUnit interfaceUnitToSearch) {
		return this.getAllBlocksFrom(interfaceUnitToSearch);
	}

	@Override
	public List<BlockUnit> getAllFrom(EnumeratedType enumeratedTypeToSearch) {
		return this.getAllBlocksFrom(enumeratedTypeToSearch);
	}

	@Override
	public List<BlockUnit> getAllFrom(MethodUnit methodUnitToSearch) {
		return this.getAllBlocksFrom(methodUnitToSearch);
	}

	@Override
	public List<BlockUnit> getAllFrom(BlockUnit blockUnitToSearch) {
		return this.getAllBlocksFrom(blockUnitToSearch);
	}

	@Override
	public List<BlockUnit> getAllFrom(ActionElement actionElementToSearch) {
		return this.getAllBlocksFrom(actionElementToSearch);
	}

	@Override
	@Deprecated
	public List<BlockUnit> getAllFrom(StorableUnit storableUnitToSearch) {
		return null;
	}

	@Override
	@Deprecated
	public List<BlockUnit> getAllFrom(Signature signatureUnitToSearch) {
		return null;
	}

	@Override
	@Deprecated
	public List<BlockUnit> getAllFrom(ParameterUnit parameterUnitUnitToSearch) {
		return null;
	}

	private List<BlockUnit> getAllBlocksFrom(CodeModel codeModelToSearch) {
		List<BlockUnit> modelBlocks = new ArrayList<BlockUnit>();

		for (AbstractCodeElement abstractCodeElement : codeModelToSearch.getCodeElement()) {

			if(abstractCodeElement instanceof ClassUnit){

				modelBlocks.addAll(this.getAllBlocksFrom((ClassUnit)abstractCodeElement));

			}else if(abstractCodeElement instanceof InterfaceUnit){

				modelBlocks.addAll(this.getAllBlocksFrom((InterfaceUnit)abstractCodeElement));

			}else if(abstractCodeElement instanceof EnumeratedType){

				modelBlocks.addAll(this.getAllBlocksFrom((EnumeratedType)abstractCodeElement));

			}else if(abstractCodeElement instanceof Package){

				modelBlocks.addAll(this.getAllBlocksFrom((Package)abstractCodeElement));

			}

		}

		return modelBlocks;
	}

	private List<BlockUnit> getAllBlocksFrom(Package packageToSearch) {
		List<BlockUnit> packageBlocks = new ArrayList<BlockUnit>();

		for (AbstractCodeElement abstractCodeElement : packageToSearch.getCodeElement()) {

			if(abstractCodeElement instanceof ClassUnit){

				packageBlocks.addAll(this.getAllBlocksFrom((ClassUnit)abstractCodeElement));

			}else if(abstractCodeElement instanceof InterfaceUnit){

				packageBlocks.addAll(this.getAllBlocksFrom((InterfaceUnit)abstractCodeElement));

			}else if(abstractCodeElement instanceof EnumeratedType){

				packageBlocks.addAll(this.getAllBlocksFrom((EnumeratedType)abstractCodeElement));

			}else if(abstractCodeElement instanceof Package){

				packageBlocks.addAll(this.getAllBlocksFrom((Package)abstractCodeElement));

			}

		}

		return packageBlocks;
	}

	private List<BlockUnit> getAllBlocksFrom(ClassUnit classToSearch) {
		List<BlockUnit> classBlocks = new ArrayList<BlockUnit>();

		for (CodeItem codeItem : classToSearch.getCodeElement()) {

			if(codeItem instanceof ClassUnit){

				classBlocks.addAll(this.getAllBlocksFrom((ClassUnit)codeItem));

			}else if(codeItem instanceof InterfaceUnit){

				classBlocks.addAll(this.getAllBlocksFrom((InterfaceUnit)codeItem));

			}else if(codeItem instanceof EnumeratedType){

				classBlocks.addAll(this.getAllBlocksFrom((EnumeratedType)codeItem));

			}else if (codeItem instanceof MethodUnit){

				classBlocks.addAll(this.getAllBlocksFrom((MethodUnit)codeItem));

			}

		}

		return classBlocks;
	}

	private List<BlockUnit> getAllBlocksFrom(InterfaceUnit interfaceToSearch) {
		List<BlockUnit> interfaceBlocks = new ArrayList<BlockUnit>();

		for (CodeItem codeItem : interfaceToSearch.getCodeElement()) {

			if(codeItem instanceof ClassUnit){

				interfaceBlocks.addAll(this.getAllBlocksFrom((ClassUnit)codeItem));

			}else if(codeItem instanceof InterfaceUnit){

				interfaceBlocks.addAll(this.getAllBlocksFrom((InterfaceUnit)codeItem));

			}else if(codeItem instanceof EnumeratedType){

				interfaceBlocks.addAll(this.getAllBlocksFrom((EnumeratedType)codeItem));

			}else if (codeItem instanceof MethodUnit){

				interfaceBlocks.addAll(this.getAllBlocksFrom((MethodUnit)codeItem));

			}

		}

		return interfaceBlocks;
	}

	private List<BlockUnit> getAllBlocksFrom(EnumeratedType enumeratedTypeToSearch) {
		List<BlockUnit> enumeratedTypeBlocks = new ArrayList<BlockUnit>();

		for (CodeItem codeItem : enumeratedTypeToSearch.getCodeElement()) {

			if(codeItem instanceof ClassUnit){

				enumeratedTypeBlocks.addAll(this.getAllBlocksFrom((ClassUnit)codeItem));

			}else if(codeItem instanceof InterfaceUnit){

				enumeratedTypeBlocks.addAll(this.getAllBlocksFrom((InterfaceUnit)codeItem));

			}else if(codeItem instanceof EnumeratedType){

				enumeratedTypeBlocks.addAll(this.getAllBlocksFrom((EnumeratedType)codeItem));

			}else if (codeItem instanceof MethodUnit){

				enumeratedTypeBlocks.addAll(this.getAllBlocksFrom((MethodUnit)codeItem));

			}

		}

		return enumeratedTypeBlocks;
	}

	private List<BlockUnit> getAllBlocksFrom(MethodUnit methodToSearch) {
		List<BlockUnit> methodBlocks = new ArrayList<BlockUnit>();

		for (AbstractCodeElement abstractCodeElement : methodToSearch.getCodeElement()) {

			if(abstractCodeElement instanceof BlockUnit){

				if(validateFilter((BlockUnit) abstractCodeElement)){
					methodBlocks.add((BlockUnit) abstractCodeElement);
				}
				methodBlocks.addAll(this.getAllBlocksFrom((BlockUnit) abstractCodeElement));

			}else if(abstractCodeElement instanceof TryUnit){

				methodBlocks.addAll(this.getAllBlocksFrom((TryUnit) abstractCodeElement));

			}else if(abstractCodeElement instanceof CatchUnit){

				methodBlocks.addAll(this.getAllBlocksFrom((CatchUnit) abstractCodeElement));

			}
		}

		return methodBlocks;
	}

	private List<BlockUnit> getAllBlocksFrom(BlockUnit blockToSearch) {

		List<BlockUnit> blockBlocks = new ArrayList<BlockUnit>();

		for (AbstractCodeElement abstractCodeElement : blockToSearch.getCodeElement()) {

			if(abstractCodeElement instanceof ActionElement ){

				blockBlocks.addAll(this.getAllBlocksFrom((ActionElement)abstractCodeElement));

			}else if(abstractCodeElement instanceof TryUnit ){

				blockBlocks.addAll(this.getAllBlocksFrom((TryUnit)abstractCodeElement));

			}else if(abstractCodeElement instanceof CatchUnit ){

				blockBlocks.addAll(this.getAllBlocksFrom((CatchUnit)abstractCodeElement));

			}else if(abstractCodeElement instanceof BlockUnit ){

				if(validateFilter((BlockUnit) abstractCodeElement)){
					blockBlocks.add((BlockUnit) abstractCodeElement);
				}
				blockBlocks.addAll(this.getAllBlocksFrom((BlockUnit)abstractCodeElement));

			}

		}

		return blockBlocks;
	}

	private List<BlockUnit> getAllBlocksFrom(ActionElement actionToSearch) {
		List<BlockUnit> actionBlocks = new ArrayList<BlockUnit>();

		for (AbstractCodeElement abstractCodeElement : actionToSearch.getCodeElement()) {

			if(abstractCodeElement instanceof ActionElement ){

				actionBlocks.addAll(this.getAllBlocksFrom((ActionElement)abstractCodeElement));

			}else if(abstractCodeElement instanceof TryUnit ){

				actionBlocks.addAll(this.getAllBlocksFrom((TryUnit)abstractCodeElement));

			}else if(abstractCodeElement instanceof CatchUnit ){

				actionBlocks.addAll(this.getAllBlocksFrom((CatchUnit)abstractCodeElement));

			}else if(abstractCodeElement instanceof BlockUnit ){

				if(validateFilter((BlockUnit) abstractCodeElement)){
					actionBlocks.add((BlockUnit) abstractCodeElement);
				}
				actionBlocks.addAll(this.getAllBlocksFrom((BlockUnit)abstractCodeElement));

			}

		}

		return actionBlocks;
	}
}
