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

import br.ufscar.kdm_manager.core.filters.validateFilter.interfaces.KDMValidateFilter;
import br.ufscar.kdm_manager.core.readers.codeReader.interfaces.KDMCodeGenericReader;
import br.ufscar.kdm_manager.core.readers.modelReader.factory.KDMModelReaderJavaFactory;

public class KDMSignatureReaderImpl implements KDMCodeGenericReader<Signature>{
	
	private boolean hasNoFilter = true;
	private boolean hasFilter = false;

	private KDMValidateFilter<Signature, ?> filter = null;

	public KDMSignatureReaderImpl() {
		super();
	}

	public KDMSignatureReaderImpl(KDMValidateFilter<Signature, ?> filter) {
		this.hasNoFilter = false;
		this.hasFilter  = true;
		this.filter = filter;
	}
	
	private boolean validateFilter(Signature elementToValidate) {
		if(this.hasNoFilter){
			return true;
		}else if(this.hasFilter){
			return this.filter.validateElement(elementToValidate);
		}
		return false;
	}	
	
	@Override
	public List<Signature> getAllFrom(Segment segmentToSearch) {
		List<Signature> signatureRecovered = new ArrayList<Signature>();

		Map<String, List<CodeModel>> models = KDMModelReaderJavaFactory.eINSTANCE.createKDMCodeModelReader().getAllFromSegment(segmentToSearch);

		for (String nameCodeModel : models.keySet()) {

			for (CodeModel codeModel : models.get(nameCodeModel)) {

				signatureRecovered.addAll(this.getAllSignaturesFrom(codeModel));
			}
		}
		
		return signatureRecovered;
	}

	@Override
	public List<Signature> getAllFrom(CodeModel codeModelToSearch) {
		return this.getAllSignaturesFrom(codeModelToSearch);
	}

	@Override
	public List<Signature> getAllFrom(Package packageToSearch) {
		return this.getAllSignaturesFrom(packageToSearch);
	}

	@Override
	public List<Signature> getAllFrom(ClassUnit classUnitToSearch) {
		return this.getAllSignaturesFrom(classUnitToSearch);
	}

	@Override
	public List<Signature> getAllFrom(InterfaceUnit interfaceUnitToSearch) {
		return this.getAllSignaturesFrom(interfaceUnitToSearch);
	}

	@Override
	public List<Signature> getAllFrom(EnumeratedType enumeratedTypeToSearch) {
		return this.getAllSignaturesFrom(enumeratedTypeToSearch);
	}

	@Override
	public List<Signature> getAllFrom(MethodUnit methodUnitToSearch) {
		return this.getAllSignaturesFrom(methodUnitToSearch);
	}
	
	@Override
	@Deprecated
	public List<Signature> getAllFrom(Signature signatureUnitToSearch) {
		return null;
	}

	@Override
	@Deprecated
	public List<Signature> getAllFrom(StorableUnit storableUnitToSearch) {
		return null;
	}

	@Override
	@Deprecated
	public List<Signature> getAllFrom(BlockUnit blockUnitToSearch) {
		return null;
	}

	@Override
	@Deprecated
	public List<Signature> getAllFrom(ActionElement actionElementToSearch) {
		return null;
	}

	@Override
	@Deprecated
	public List<Signature> getAllFrom(ParameterUnit parameterUnitUnitToSearch) {
		return null;
	}
	
	private List<Signature> getAllSignaturesFrom(CodeModel codeModelToSearch) {
		List<Signature> modelSignatures = new ArrayList<Signature>();

		for (AbstractCodeElement abstractCodeElement : codeModelToSearch.getCodeElement()) {

			if(abstractCodeElement instanceof ClassUnit){

				modelSignatures.addAll(this.getAllSignaturesFrom((ClassUnit)abstractCodeElement));

			}else if(abstractCodeElement instanceof InterfaceUnit){
				
				modelSignatures.addAll(this.getAllSignaturesFrom((InterfaceUnit)abstractCodeElement));
				
			}else if(abstractCodeElement instanceof EnumeratedType){
				
				modelSignatures.addAll(this.getAllSignaturesFrom((EnumeratedType)abstractCodeElement));
				
			}else if(abstractCodeElement instanceof Package){

				modelSignatures.addAll(this.getAllSignaturesFrom((Package)abstractCodeElement));

			}

		}

		return modelSignatures;
	}

	private List<Signature> getAllSignaturesFrom(Package packageToSearch) {
		List<Signature> packageSignatures = new ArrayList<Signature>();

		for (AbstractCodeElement abstractCodeElement : packageToSearch.getCodeElement()) {

			if(abstractCodeElement instanceof ClassUnit){

				packageSignatures.addAll(this.getAllSignaturesFrom((ClassUnit)abstractCodeElement));

			}else if(abstractCodeElement instanceof InterfaceUnit){
				
				packageSignatures.addAll(this.getAllSignaturesFrom((InterfaceUnit)abstractCodeElement));
				
			}else if(abstractCodeElement instanceof EnumeratedType){
				
				packageSignatures.addAll(this.getAllSignaturesFrom((EnumeratedType)abstractCodeElement));
				
			}else if(abstractCodeElement instanceof Package){

				packageSignatures.addAll(this.getAllSignaturesFrom((Package)abstractCodeElement));

			}

		}

		return packageSignatures;
	}

	private List<Signature> getAllSignaturesFrom(ClassUnit classToSearch) {
		List<Signature> classSignatures = new ArrayList<Signature>();

		for (CodeItem codeItem : classToSearch.getCodeElement()) {

			if(codeItem instanceof ClassUnit){

				classSignatures.addAll(this.getAllSignaturesFrom((ClassUnit)codeItem));

			}else if(codeItem instanceof InterfaceUnit){
				
				classSignatures.addAll(this.getAllSignaturesFrom((InterfaceUnit)codeItem));
				
			}else if(codeItem instanceof EnumeratedType){
				
				classSignatures.addAll(this.getAllSignaturesFrom((EnumeratedType)codeItem));
				
			}else if (codeItem instanceof MethodUnit){

				classSignatures.addAll(this.getAllSignaturesFrom((MethodUnit)codeItem));

			}

		}

		return classSignatures;
	}

	private List<Signature> getAllSignaturesFrom(InterfaceUnit interfaceToSearch) {
		List<Signature> interfaceSignatures = new ArrayList<Signature>();
		
		for (CodeItem codeItem : interfaceToSearch.getCodeElement()) {
			
			if(codeItem instanceof ClassUnit){
				
				interfaceSignatures.addAll(this.getAllSignaturesFrom((ClassUnit)codeItem));
				
			}else if(codeItem instanceof InterfaceUnit){
				
				interfaceSignatures.addAll(this.getAllSignaturesFrom((InterfaceUnit)codeItem));
				
			}else if(codeItem instanceof EnumeratedType){
				
				interfaceSignatures.addAll(this.getAllSignaturesFrom((EnumeratedType)codeItem));
				
			}else if (codeItem instanceof MethodUnit){
				
				interfaceSignatures.addAll(this.getAllSignaturesFrom((MethodUnit)codeItem));
				
			}
			
		}
		
		return interfaceSignatures;
	}
	
	private List<Signature> getAllSignaturesFrom(EnumeratedType enumeratedTypeToSearch) {
		List<Signature> enumeratedTypeSignatures = new ArrayList<Signature>();

		for (CodeItem codeItem : enumeratedTypeToSearch.getCodeElement()) {

			if(codeItem instanceof ClassUnit){

				enumeratedTypeSignatures.addAll(this.getAllSignaturesFrom((ClassUnit)codeItem));

			}else if(codeItem instanceof InterfaceUnit){
				
				enumeratedTypeSignatures.addAll(this.getAllSignaturesFrom((InterfaceUnit)codeItem));
				
			}else if(codeItem instanceof EnumeratedType){
				
				enumeratedTypeSignatures.addAll(this.getAllSignaturesFrom((EnumeratedType)codeItem));
				
			}else if (codeItem instanceof MethodUnit){

				enumeratedTypeSignatures.addAll(this.getAllSignaturesFrom((MethodUnit)codeItem));

			}

		}

		return enumeratedTypeSignatures;
	}

	private List<Signature> getAllSignaturesFrom(MethodUnit methodToSearch) {
		List<Signature> methodSignatures = new ArrayList<Signature>();

		for (AbstractCodeElement abstractCodeElement : methodToSearch.getCodeElement()) {

			if(abstractCodeElement instanceof Signature){

				if(validateFilter((Signature)abstractCodeElement)){
					methodSignatures.add(((Signature)abstractCodeElement));
				}

			}
		}

		return methodSignatures;
	}

}
