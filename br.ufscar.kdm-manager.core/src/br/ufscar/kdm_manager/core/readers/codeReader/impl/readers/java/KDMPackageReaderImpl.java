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


public class KDMPackageReaderImpl implements KDMCodeGenericReader<Package> {

	private boolean hasNoFilter = true;
	private boolean hasFilter = false;

	private ValidateFilter<Package, ?> filter = null;

	public KDMPackageReaderImpl() {
		super();
	}

	public KDMPackageReaderImpl(ValidateFilter<Package, ?> filter) {
		this.hasNoFilter = false;
		this.hasFilter  = true;
		this.filter = filter;
	}
	
	private boolean validateFilter(Package elementToValidate) {
		if(this.hasNoFilter){
			return true;
		}else if(this.hasFilter){
			return this.filter.validateElement(elementToValidate);
		}
		return false;
	}	

	@Override
	public List<Package> getAllFrom(Segment segmentToSearch) {
		List<Package> packagesRecovered = new ArrayList<Package>();

		Map<String, List<CodeModel>> models = KDMModelReaderJavaFactory.eINSTANCE.createKDMCodeModelReader().getAllFromSegment(segmentToSearch);

		for (String nameCodeModel : models.keySet()) {

			for (CodeModel codeModel : models.get(nameCodeModel)) {

				packagesRecovered.addAll(this.getAllPackagesFrom(codeModel));
			}
		}
		
		return packagesRecovered;
	}
	
	@Override
	public List<Package> getAllFrom(CodeModel codeModelToSearch) {
		return this.getAllPackagesFrom(codeModelToSearch);
	}

	@Override
	public List<Package> getAllFrom(Package packageToSearch) {
		return this.getAllPackagesFrom(packageToSearch);
	}
	
	@Override
	@Deprecated
	public List<Package> getAllFrom(ClassUnit classUnitToSearch) {
		return null;
	}

	@Override
	@Deprecated
	public List<Package> getAllFrom(InterfaceUnit interfaceUnitToSearch) {
		return null;
	}

	@Override
	@Deprecated
	public List<Package> getAllFrom(EnumeratedType enumeratedTypeToSearch) {
		return null;
	}

	@Override
	@Deprecated
	public List<Package> getAllFrom(MethodUnit methodUnitToSearch) {
		return null;
	}

	@Override
	@Deprecated
	public List<Package> getAllFrom(StorableUnit storableUnitToSearch) {
		return null;
	}

	@Override
	@Deprecated
	public List<Package> getAllFrom(BlockUnit blockUnitToSearch) {
		return null;
	}

	@Override
	@Deprecated
	public List<Package> getAllFrom(Signature signatureUnitToSearch) {
		return null;
	}

	@Override
	@Deprecated
	public List<Package> getAllFrom(ActionElement actionElementToSearch) {
		return null;
	}

	@Override
	@Deprecated
	public List<Package> getAllFrom(ParameterUnit parameterUnitUnitToSearch) {
		return null;
	}
	
	private List<Package> getAllPackagesFrom(CodeModel codeModelToSearch) {
		List<Package> allPackages = new ArrayList<Package>();

		for (AbstractCodeElement abstractCodeElement : codeModelToSearch.getCodeElement()) {
			
			if(abstractCodeElement instanceof Package){
				
				if(validateFilter((Package) abstractCodeElement)){
					allPackages.add((Package) abstractCodeElement);
				}
				allPackages.addAll(this.getAllPackagesFrom((Package)abstractCodeElement));
				
			}
			
		}
		
		return allPackages ;
	}

	private List<Package> getAllPackagesFrom(Package packageToSearch) {
		List<Package> allPackages = new ArrayList<Package>();

		for (AbstractCodeElement abstractCodeElement : packageToSearch.getCodeElement()) {
			
			if(abstractCodeElement instanceof Package){
				
				if(validateFilter((Package) abstractCodeElement)){
					allPackages.add((Package) abstractCodeElement);
				}
				allPackages.addAll(this.getAllPackagesFrom((Package)abstractCodeElement));
				
			}
			
		}
		
		return allPackages ;
	}
	
}
