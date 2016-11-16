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
package br.ufscar.kdm_manager.core.readers.codeReader.impl.factory;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.gmt.modisco.omg.kdm.action.ActionElement;
import org.eclipse.gmt.modisco.omg.kdm.action.BlockUnit;
import org.eclipse.gmt.modisco.omg.kdm.action.CatchUnit;
import org.eclipse.gmt.modisco.omg.kdm.action.TryUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.ClassUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.EnumeratedType;
import org.eclipse.gmt.modisco.omg.kdm.code.InterfaceUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.MethodUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.Package;
import org.eclipse.gmt.modisco.omg.kdm.code.ParameterUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.Signature;
import org.eclipse.gmt.modisco.omg.kdm.code.StorableUnit;

import br.ufscar.kdm_manager.core.filters.validateFilter.interfaces.ValidateFilter;
import br.ufscar.kdm_manager.core.readers.codeReader.enums.KDMActionElementsType;
import br.ufscar.kdm_manager.core.readers.codeReader.factory.KDMCodeReaderJavaFactory;
import br.ufscar.kdm_manager.core.readers.codeReader.impl.readers.java.KDMActionElementReaderImpl;
import br.ufscar.kdm_manager.core.readers.codeReader.impl.readers.java.KDMBlockReaderImpl;
import br.ufscar.kdm_manager.core.readers.codeReader.impl.readers.java.KDMCatchReaderImpl;
import br.ufscar.kdm_manager.core.readers.codeReader.impl.readers.java.KDMClassReaderImpl;
import br.ufscar.kdm_manager.core.readers.codeReader.impl.readers.java.KDMEnumeratedTypeReaderImpl;
import br.ufscar.kdm_manager.core.readers.codeReader.impl.readers.java.KDMInterfaceReaderImpl;
import br.ufscar.kdm_manager.core.readers.codeReader.impl.readers.java.KDMMethodReaderImpl;
import br.ufscar.kdm_manager.core.readers.codeReader.impl.readers.java.KDMPackageReaderImpl;
import br.ufscar.kdm_manager.core.readers.codeReader.impl.readers.java.KDMParameterReaderImpl;
import br.ufscar.kdm_manager.core.readers.codeReader.impl.readers.java.KDMSignatureReaderImpl;
import br.ufscar.kdm_manager.core.readers.codeReader.impl.readers.java.KDMStorableReaderImpl;
import br.ufscar.kdm_manager.core.readers.codeReader.impl.readers.java.KDMTryReaderImpl;
import br.ufscar.kdm_manager.core.readers.codeReader.interfaces.KDMCodeGenericReader;

public class KDMCodeReaderJavaFactoryImpl extends EFactoryImpl implements KDMCodeReaderJavaFactory {

	
	public static KDMCodeReaderJavaFactory init() {
		try {
			KDMCodeReaderJavaFactory theKDMCodeReaderFactory = (KDMCodeReaderJavaFactory)EPackage.Registry.INSTANCE.getEFactory("br.ufscar.kdm_manager.core.readers.codeReader.factory.KDMCodeReaderJavaFactory"); //$NON-NLS-1$ 
			if (theKDMCodeReaderFactory != null) {
				return theKDMCodeReaderFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new KDMCodeReaderJavaFactoryImpl();
	}
	
	public KDMCodeReaderJavaFactoryImpl() {
		super();
	}
	
	@Override
	public KDMCodeGenericReader<Package> createKDMPackageReader() {
		return new KDMPackageReaderImpl();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public KDMCodeGenericReader<Package> createKDMPackageReaderWithFilter(ValidateFilter filter) {
		return new KDMPackageReaderImpl(filter);
	}
	
	@Override
	public KDMCodeGenericReader<ClassUnit> createKDMClassReader() {
		return new KDMClassReaderImpl();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public KDMCodeGenericReader<ClassUnit> createKDMClassReaderWithFilter(ValidateFilter filter) {
		return new KDMClassReaderImpl(filter);
	}
	
	@Override
	public KDMCodeGenericReader<InterfaceUnit> createKDMInterfaceReader() {
		return new KDMInterfaceReaderImpl();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public KDMCodeGenericReader<InterfaceUnit> createKDMInterfaceReaderWithFilter(ValidateFilter filter) {
		return new KDMInterfaceReaderImpl(filter);
	}
	
	@Override
	public KDMCodeGenericReader<EnumeratedType> createKDMEnumeratedTypeReader() {
		return new KDMEnumeratedTypeReaderImpl();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public KDMCodeGenericReader<EnumeratedType> createKDMEnumeratedTypeReaderWithFilter(ValidateFilter filter) {
		return new KDMEnumeratedTypeReaderImpl(filter);
	}
	
	@Override
	public KDMCodeGenericReader<StorableUnit> createKDMStorableReader() {
		return new KDMStorableReaderImpl();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public KDMCodeGenericReader<StorableUnit> createKDMStorableReaderWithFilter(ValidateFilter filter) {
		return new KDMStorableReaderImpl(filter);
	}

	@Override
	public KDMCodeGenericReader<ActionElement> createKDMActionReader() {
		return new KDMActionElementReaderImpl();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public KDMCodeGenericReader<ActionElement> createKDMActionReaderWithFilter(ValidateFilter filter) {
		return new KDMActionElementReaderImpl(filter);
	}

	@Override
	public KDMCodeGenericReader<ActionElement> createKDMActionReaderWithFilter(KDMActionElementsType kdmActionElementsType) {
		return new KDMActionElementReaderImpl(kdmActionElementsType);
	}

	@Override
	public KDMCodeGenericReader<MethodUnit> createKDMMethodReader() {
		return new KDMMethodReaderImpl();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public KDMCodeGenericReader<MethodUnit> createKDMMethodReaderWithFilter(ValidateFilter filter) {
		return new KDMMethodReaderImpl(filter);
	}
	
	@Override
	public KDMCodeGenericReader<BlockUnit> createKDMBlockReader() {
		return new KDMBlockReaderImpl();
	}
	
	@Override
	public KDMCodeGenericReader<TryUnit> createKDMTryReader() {
		return new KDMTryReaderImpl();
	}

	@Override
	public KDMCodeGenericReader<CatchUnit> createKDMCatchReader() {
		return new KDMCatchReaderImpl();
	}

	@Override
	public KDMCodeGenericReader<Signature> createKDMSignatureReader() {
		return new KDMSignatureReaderImpl();
	}

	@Override
	public KDMCodeGenericReader<ParameterUnit> createKDMParameterReader() {
		return new KDMParameterReaderImpl();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public KDMCodeGenericReader<BlockUnit> createKDMBlockReaderWithFilter(ValidateFilter filter) {
		return new KDMBlockReaderImpl(filter);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public KDMCodeGenericReader<TryUnit> createKDMTryReaderWithFilter(ValidateFilter filter) {
		return new KDMTryReaderImpl(filter);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public KDMCodeGenericReader<CatchUnit> createKDMCatchReaderWithFilter(ValidateFilter filter) {
		return new KDMCatchReaderImpl(filter);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public KDMCodeGenericReader<Signature> createKDMSignatureReaderWithFilter(ValidateFilter filter) {
		return new KDMSignatureReaderImpl(filter);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public KDMCodeGenericReader<ParameterUnit> createKDMParameterReaderWithFilter(ValidateFilter filter) {
		return new KDMParameterReaderImpl(filter);
	}

}
