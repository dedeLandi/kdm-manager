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

import br.ufscar.kdm_manager.core.filters.validateFilter.interfaces.ValidateFilter;
import br.ufscar.kdm_manager.core.readers.codeReader.interfaces.KDMCodeGenericReader;
import br.ufscar.kdm_manager.core.readers.modelReader.factory.KDMModelReaderJavaFactory;

public class KDMStorableReaderImpl implements KDMCodeGenericReader<StorableUnit>{

	private boolean hasNoFilter = true;
	private boolean hasFilter = false;

	private ValidateFilter<StorableUnit,?> filter = null;

	public KDMStorableReaderImpl() {
		super();
	}

	public KDMStorableReaderImpl(ValidateFilter<StorableUnit,?> filter) {
		this.hasNoFilter = false;
		this.hasFilter  = true;
		this.filter = filter;
	}

	private boolean validateFilter(StorableUnit elementToValidate) {
		if(this.hasNoFilter){
			return true;
		}else if(this.hasFilter){
			return this.filter.validateElement(elementToValidate);
		}
		return false;
	}	
	
	@Override
	public List<StorableUnit> getAllFrom(Segment segmentToSearch) {

		List<StorableUnit> storableUnitRecovered = new ArrayList<StorableUnit>();

		Map<String, List<CodeModel>> models = KDMModelReaderJavaFactory.eINSTANCE.createKDMCodeModelReader().getAllFromSegment(segmentToSearch);

		for (String nameCodeModel : models.keySet()) {

			for (CodeModel codeModel : models.get(nameCodeModel)) {

				storableUnitRecovered.addAll(this.getAllStorablesFrom(codeModel));
			}
		}

		return storableUnitRecovered;
	}

	@Override
	public List<StorableUnit> getAllFrom(CodeModel codeModelToSearch) {
		return this.getAllStorablesFrom(codeModelToSearch);
	}

	@Override
	public List<StorableUnit> getAllFrom(Package packageToSearch) {
		return this.getAllStorablesFrom(packageToSearch);
	}

	@Override
	public List<StorableUnit> getAllFrom(ClassUnit classUnitToSearch) {
		return this.getAllStorablesFrom(classUnitToSearch);
	}

	@Override
	public List<StorableUnit> getAllFrom(InterfaceUnit interfaceUnitToSearch) {
		return this.getAllStorablesFrom(interfaceUnitToSearch);
	}

	@Override
	public List<StorableUnit> getAllFrom(EnumeratedType enumeratedTypeToSearch) {
		return this.getAllStorablesFrom(enumeratedTypeToSearch);
	}

	@Override
	public List<StorableUnit> getAllFrom(MethodUnit methodUnitToSearch) {
		return this.getAllStorablesFrom(methodUnitToSearch);
	}

	@Override
	public List<StorableUnit> getAllFrom(BlockUnit blockUnitToSearch) {
		return this.getAllStorablesFrom(blockUnitToSearch);
	}

	@Override
	public List<StorableUnit> getAllFrom(ActionElement actionElementToSearch) {
		return this.getAllStorablesFrom(actionElementToSearch);
	}

	@Override
	@Deprecated
	public List<StorableUnit> getAllFrom(StorableUnit storableUnitToSearch) {
		return null;
	}

	@Override
	@Deprecated
	public List<StorableUnit> getAllFrom(Signature signatureUnitToSearch) {
		return null;
	}

	@Override
	@Deprecated
	public List<StorableUnit> getAllFrom(ParameterUnit parameterUnitUnitToSearch) {
		return null;
	}

	//fazer as pesquisas	
	private List<StorableUnit> getAllStorablesFrom(CodeModel codeModelToSearch) {
		List<StorableUnit> modelStorables = new ArrayList<StorableUnit>();

		for (AbstractCodeElement abstractCodeElement : codeModelToSearch.getCodeElement()) {

			if(abstractCodeElement instanceof ClassUnit){

				modelStorables.addAll(this.getAllStorablesFrom((ClassUnit)abstractCodeElement));

			}else if(abstractCodeElement instanceof InterfaceUnit){

				modelStorables.addAll(this.getAllStorablesFrom((InterfaceUnit)abstractCodeElement));

			}else if(abstractCodeElement instanceof EnumeratedType){

				modelStorables.addAll(this.getAllStorablesFrom((EnumeratedType)abstractCodeElement));

			}else if(abstractCodeElement instanceof Package){

				modelStorables.addAll(this.getAllStorablesFrom((Package)abstractCodeElement));

			}

		}

		return modelStorables;
	}

	private List<StorableUnit> getAllStorablesFrom(Package packageToSearch) {
		List<StorableUnit> packageStorables = new ArrayList<StorableUnit>();

		for (AbstractCodeElement abstractCodeElement : packageToSearch.getCodeElement()) {

			if(abstractCodeElement instanceof ClassUnit){

				packageStorables.addAll(this.getAllStorablesFrom((ClassUnit)abstractCodeElement));

			}else if(abstractCodeElement instanceof InterfaceUnit){

				packageStorables.addAll(this.getAllStorablesFrom((InterfaceUnit)abstractCodeElement));

			}else if(abstractCodeElement instanceof EnumeratedType){

				packageStorables.addAll(this.getAllStorablesFrom((EnumeratedType)abstractCodeElement));

			}else if(abstractCodeElement instanceof Package){

				packageStorables.addAll(this.getAllStorablesFrom((Package)abstractCodeElement));

			}

		}

		return packageStorables;
	}

	private List<StorableUnit> getAllStorablesFrom(ClassUnit classToSearch) {
		List<StorableUnit> classStorables = new ArrayList<StorableUnit>();

		for (CodeItem codeItem : classToSearch.getCodeElement()) {

			if(codeItem instanceof StorableUnit){

				if(validateFilter((StorableUnit)codeItem)){
					classStorables.add((StorableUnit)codeItem);
				}

			}else if (codeItem instanceof ClassUnit){

				classStorables.addAll(this.getAllStorablesFrom((ClassUnit)codeItem));

			}else if (codeItem instanceof InterfaceUnit){

				classStorables.addAll(this.getAllStorablesFrom((InterfaceUnit)codeItem));

			}else if (codeItem instanceof EnumeratedType){

				classStorables.addAll(this.getAllStorablesFrom((EnumeratedType)codeItem));

			}else if (codeItem instanceof MethodUnit){

				classStorables.addAll(this.getAllStorablesFrom((MethodUnit)codeItem));

			}

		}

		return classStorables;
	}

	private List<StorableUnit> getAllStorablesFrom(InterfaceUnit interfaceToSearch) {
		List<StorableUnit> interfaceStorables = new ArrayList<StorableUnit>();

		for (CodeItem codeItem : interfaceToSearch.getCodeElement()) {

			if(codeItem instanceof StorableUnit){

				if(validateFilter((StorableUnit)codeItem)){
					interfaceStorables.add((StorableUnit)codeItem);
				}

			}else if (codeItem instanceof ClassUnit){

				interfaceStorables.addAll(this.getAllStorablesFrom((ClassUnit)codeItem));

			}else if (codeItem instanceof InterfaceUnit){

				interfaceStorables.addAll(this.getAllStorablesFrom((InterfaceUnit)codeItem));

			}else if (codeItem instanceof EnumeratedType){

				interfaceStorables.addAll(this.getAllStorablesFrom((EnumeratedType)codeItem));

			}else if (codeItem instanceof MethodUnit){

				interfaceStorables.addAll(this.getAllStorablesFrom((MethodUnit)codeItem));

			}

		}

		return interfaceStorables;
	}

	private List<StorableUnit> getAllStorablesFrom(EnumeratedType enumeratedTypeToSearch) {
		List<StorableUnit> enumeratedTypeStorables = new ArrayList<StorableUnit>();

		for (CodeItem codeItem : enumeratedTypeToSearch.getCodeElement()) {

			if(codeItem instanceof StorableUnit){

				if(validateFilter((StorableUnit)codeItem)){
					enumeratedTypeStorables.add((StorableUnit)codeItem);
				}

			}else if (codeItem instanceof ClassUnit){

				enumeratedTypeStorables.addAll(this.getAllStorablesFrom((ClassUnit)codeItem));

			}else if (codeItem instanceof InterfaceUnit){

				enumeratedTypeStorables.addAll(this.getAllStorablesFrom((InterfaceUnit)codeItem));

			}else if (codeItem instanceof EnumeratedType){

				enumeratedTypeStorables.addAll(this.getAllStorablesFrom((EnumeratedType)codeItem));

			}else if (codeItem instanceof MethodUnit){

				enumeratedTypeStorables.addAll(this.getAllStorablesFrom((MethodUnit)codeItem));

			}

		}

		return enumeratedTypeStorables;
	}

	private List<StorableUnit> getAllStorablesFrom(MethodUnit methodToSearch) {
		List<StorableUnit> methodStorables = new ArrayList<StorableUnit>();

		for (AbstractCodeElement abstractCodeElement : methodToSearch.getCodeElement()) {

			if(abstractCodeElement instanceof BlockUnit){

				methodStorables.addAll(getAllStorablesFrom((BlockUnit) abstractCodeElement));

			}
		}

		return methodStorables;
	}

	private List<StorableUnit> getAllStorablesFrom(BlockUnit blockToSearch) {

		List<StorableUnit> blockStorables = new ArrayList<StorableUnit>();

		for (AbstractCodeElement abstractCodeElement : blockToSearch.getCodeElement()) {

			if (abstractCodeElement instanceof StorableUnit) {

				if(validateFilter((StorableUnit)abstractCodeElement)){
					blockStorables.add((StorableUnit)abstractCodeElement);
				}

			}else if(abstractCodeElement instanceof ActionElement ){

				blockStorables.addAll(getAllStorablesFrom((ActionElement)abstractCodeElement));

			}else if(abstractCodeElement instanceof BlockUnit ){

				blockStorables.addAll(getAllStorablesFrom((BlockUnit)abstractCodeElement));

			}

		}

		return blockStorables;
	}

	private List<StorableUnit> getAllStorablesFrom(ActionElement actionToSearch) {
		List<StorableUnit> actionStorables = new ArrayList<StorableUnit>();

		for (AbstractCodeElement abstractCodeElement : actionToSearch.getCodeElement()) {

			if (abstractCodeElement instanceof StorableUnit) {

				if(validateFilter((StorableUnit)abstractCodeElement)){
					actionStorables.add((StorableUnit)abstractCodeElement);
				}

			}else if(abstractCodeElement instanceof ActionElement ){

				actionStorables.addAll(getAllStorablesFrom((ActionElement)abstractCodeElement));

			}else if(abstractCodeElement instanceof BlockUnit ){

				actionStorables.addAll(getAllStorablesFrom((BlockUnit)abstractCodeElement));

			}

		}

		return actionStorables;
	}


}
