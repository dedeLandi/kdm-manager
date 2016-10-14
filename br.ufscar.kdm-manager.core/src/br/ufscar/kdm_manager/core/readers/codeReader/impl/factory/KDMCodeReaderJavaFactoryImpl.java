package br.ufscar.kdm_manager.core.readers.codeReader.impl.factory;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
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
import br.ufscar.kdm_manager.core.readers.codeReader.factory.KDMCodeReaderJavaFactory;
import br.ufscar.kdm_manager.core.readers.codeReader.impl.readers.java.KDMActionElementReaderImpl;
import br.ufscar.kdm_manager.core.readers.codeReader.impl.readers.java.KDMBlockReaderImpl;
import br.ufscar.kdm_manager.core.readers.codeReader.impl.readers.java.KDMClassReaderImpl;
import br.ufscar.kdm_manager.core.readers.codeReader.impl.readers.java.KDMEnumeratedTypeReaderImpl;
import br.ufscar.kdm_manager.core.readers.codeReader.impl.readers.java.KDMInterfaceReaderImpl;
import br.ufscar.kdm_manager.core.readers.codeReader.impl.readers.java.KDMMethodReaderImpl;
import br.ufscar.kdm_manager.core.readers.codeReader.impl.readers.java.KDMPackageReaderImpl;
import br.ufscar.kdm_manager.core.readers.codeReader.impl.readers.java.KDMParameterReaderImpl;
import br.ufscar.kdm_manager.core.readers.codeReader.impl.readers.java.KDMSignatureReaderImpl;
import br.ufscar.kdm_manager.core.readers.codeReader.impl.readers.java.KDMStorableReaderImpl;
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

	@Override
	public KDMCodeGenericReader<Package> createKDMPackageReaderWithFilter(String nameToSearch) {
		return new KDMPackageReaderImpl(nameToSearch);
	}
	
	@Override
	public KDMCodeGenericReader<ClassUnit> createKDMClassReader() {
		return new KDMClassReaderImpl();
	}

	@Override
	public KDMCodeGenericReader<ClassUnit> createKDMClassReaderWithFilter(String nameToSearch) {
		return new KDMClassReaderImpl(nameToSearch);
	}
	
	@Override
	public KDMCodeGenericReader<InterfaceUnit> createKDMInterfaceReader() {
		return new KDMInterfaceReaderImpl();
	}

	@Override
	public KDMCodeGenericReader<InterfaceUnit> createKDMInterfaceReaderWithFilter(String nameToSearch) {
		return new KDMInterfaceReaderImpl(nameToSearch);
	}
	
	@Override
	public KDMCodeGenericReader<EnumeratedType> createKDMEnumeratedTypeReader() {
		return new KDMEnumeratedTypeReaderImpl();
	}

	@Override
	public KDMCodeGenericReader<EnumeratedType> createKDMEnumeratedTypeReaderWithFilter(String nameToSearch) {
		return new KDMEnumeratedTypeReaderImpl(nameToSearch);
	}
	
	@Override
	public KDMCodeGenericReader<StorableUnit> createKDMStorableReader() {
		return new KDMStorableReaderImpl();
	}

	@Override
	public KDMCodeGenericReader<StorableUnit> createKDMStorableReaderWithFilter(String nameToSearch) {
		return new KDMStorableReaderImpl(nameToSearch);
	}

	@Override
	public KDMCodeGenericReader<ActionElement> createKDMActionReader() {
		return new KDMActionElementReaderImpl();
	}

	@Override
	public KDMCodeGenericReader<ActionElement> createKDMActionReaderWithFilter(String nameToSearch) {
		return new KDMActionElementReaderImpl(nameToSearch);
	}

	@Override
	public KDMCodeGenericReader<ActionElement> createKDMActionReaderWithFilter(KDMActionElementsType kdmActionElementsType) {
		return new KDMActionElementReaderImpl(kdmActionElementsType);
	}

	@Override
	public KDMCodeGenericReader<MethodUnit> createKDMMethodReader() {
		return new KDMMethodReaderImpl();
	}

	@Override
	public KDMCodeGenericReader<MethodUnit> createKDMMethodReaderWithFilter(String nameToSearch) {
		return new KDMMethodReaderImpl(nameToSearch);
	}

	@Override
	public KDMCodeGenericReader<BlockUnit> createKDMBlockReader() {
		return new KDMBlockReaderImpl();
	}

	@Override
	public KDMCodeGenericReader<Signature> createKDMSignatureReader() {
		return new KDMSignatureReaderImpl();
	}

	@Override
	public KDMCodeGenericReader<ParameterUnit> createKDMParameterReader() {
		return new KDMParameterReaderImpl();
	}

	@Override
	public KDMCodeGenericReader<BlockUnit> createKDMBlockReaderWithFilter(String nameToSearch) {
		return new KDMBlockReaderImpl(nameToSearch);
	}

	@Override
	public KDMCodeGenericReader<Signature> createKDMSignatureReaderWithFilter(String nameToSearch) {
		return new KDMSignatureReaderImpl(nameToSearch);
	}

	@Override
	public KDMCodeGenericReader<ParameterUnit> createKDMParameterReaderWithFilter(String nameToSearch) {
		return new KDMParameterReaderImpl(nameToSearch);
	}

}
