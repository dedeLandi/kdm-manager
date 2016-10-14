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
	
	KDMCodeGenericReader<Package> createKDMPackageReaderWithFilter(String nameToSearch);
	
	KDMCodeGenericReader<ClassUnit> createKDMClassReaderWithFilter(String nameToSearch);
	
	KDMCodeGenericReader<InterfaceUnit> createKDMInterfaceReaderWithFilter(String nameToSearch);
	
	KDMCodeGenericReader<EnumeratedType> createKDMEnumeratedTypeReaderWithFilter(String nameToSearch);
	
	KDMCodeGenericReader<MethodUnit> createKDMMethodReaderWithFilter(String nameToSearch);
	
	KDMCodeGenericReader<StorableUnit> createKDMStorableReaderWithFilter(String nameToSearch);

	KDMCodeGenericReader<ActionElement> createKDMActionReaderWithFilter(String nameToSearch);

	KDMCodeGenericReader<BlockUnit> createKDMBlockReaderWithFilter(String nameToSearch);
	
	KDMCodeGenericReader<Signature> createKDMSignatureReaderWithFilter(String nameToSearch);
	
	KDMCodeGenericReader<ParameterUnit> createKDMParameterReaderWithFilter(String nameToSearch);

	KDMCodeGenericReader<ActionElement> createKDMActionReaderWithFilter(KDMActionElementsType kdmActionElementsType);
	
}
