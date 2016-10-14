package br.ufscar.kdm_manager.core.readers.codeReader.factory;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.gmt.modisco.omg.kdm.action.ActionElement;
import org.eclipse.gmt.modisco.omg.kdm.action.BlockUnit;
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
import br.ufscar.kdm_manager.core.readers.codeReader.interfaces.KDMCodeGenericReader;


public interface KDMCodeReaderJavaFactory extends EFactory {

	KDMCodeReaderJavaFactory eINSTANCE = br.ufscar.kdm_manager.core.readers.codeReader.impl.factory.KDMCodeReaderJavaFactoryImpl.init();
	
	KDMCodeGenericReader<Package> createKDMPackageReader();
	
	KDMCodeGenericReader<ClassUnit> createKDMClassReader();
	
	KDMCodeGenericReader<InterfaceUnit> createKDMInterfaceReader();
	
	KDMCodeGenericReader<EnumeratedType> createKDMEnumeratedTypeReader();
	
	KDMCodeGenericReader<MethodUnit> createKDMMethodReader();
	
	KDMCodeGenericReader<StorableUnit> createKDMStorableReader();
	
	KDMCodeGenericReader<ActionElement> createKDMActionReader();
	
	KDMCodeGenericReader<BlockUnit> createKDMBlockReader();
	
	KDMCodeGenericReader<Signature> createKDMSignatureReader();
	
	KDMCodeGenericReader<ParameterUnit> createKDMParameterReader();
	
	KDMCodeGenericReader<Package> createKDMPackageReaderWithFilter(ValidateFilter<?, ?> filter);
	
	KDMCodeGenericReader<ClassUnit> createKDMClassReaderWithFilter(ValidateFilter<?, ?> filter);
	
	KDMCodeGenericReader<InterfaceUnit> createKDMInterfaceReaderWithFilter(ValidateFilter<?, ?> filter);
	
	KDMCodeGenericReader<EnumeratedType> createKDMEnumeratedTypeReaderWithFilter(ValidateFilter<?, ?> filter);
	
	KDMCodeGenericReader<MethodUnit> createKDMMethodReaderWithFilter(ValidateFilter<?, ?> filter);
	
	KDMCodeGenericReader<StorableUnit> createKDMStorableReaderWithFilter(ValidateFilter<?, ?> filter);

	KDMCodeGenericReader<ActionElement> createKDMActionReaderWithFilter(ValidateFilter<?, ?> filter);

	KDMCodeGenericReader<BlockUnit> createKDMBlockReaderWithFilter(ValidateFilter<?, ?> filter);
	
	KDMCodeGenericReader<Signature> createKDMSignatureReaderWithFilter(ValidateFilter<?, ?> filter);
	
	KDMCodeGenericReader<ParameterUnit> createKDMParameterReaderWithFilter(ValidateFilter<?, ?> filter);

	KDMCodeGenericReader<ActionElement> createKDMActionReaderWithFilter(KDMActionElementsType kdmActionElementsType);
	
}
