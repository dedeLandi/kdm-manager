package br.ufscar.kdm_manager.core.readers.structureReader.impl.factory;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.gmt.modisco.omg.kdm.structure.ArchitectureView;
import org.eclipse.gmt.modisco.omg.kdm.structure.Component;
import org.eclipse.gmt.modisco.omg.kdm.structure.Layer;
import org.eclipse.gmt.modisco.omg.kdm.structure.SoftwareSystem;
import org.eclipse.gmt.modisco.omg.kdm.structure.Subsystem;

import br.ufscar.kdm_manager.core.filters.validateFilter.interfaces.ValidateFilter;
import br.ufscar.kdm_manager.core.readers.structureReader.factory.KDMStructureReaderJavaFactory;
import br.ufscar.kdm_manager.core.readers.structureReader.impl.readers.java.KDMArchitectureViewReaderImpl;
import br.ufscar.kdm_manager.core.readers.structureReader.impl.readers.java.KDMComponentReaderImpl;
import br.ufscar.kdm_manager.core.readers.structureReader.impl.readers.java.KDMLayerReaderImpl;
import br.ufscar.kdm_manager.core.readers.structureReader.impl.readers.java.KDMSoftwareSystemReaderImpl;
import br.ufscar.kdm_manager.core.readers.structureReader.impl.readers.java.KDMSubsystemReaderImpl;
import br.ufscar.kdm_manager.core.readers.structureReader.interfaces.KDMStructureGenericReader;

public class KDMStructureReaderJavaFactoryImpl extends EFactoryImpl implements KDMStructureReaderJavaFactory {

	public static KDMStructureReaderJavaFactory init() {
		try {
			KDMStructureReaderJavaFactory theKDMCodeReaderFactory = (KDMStructureReaderJavaFactory)EPackage.Registry.INSTANCE.getEFactory("br.ufscar.kdm_manager.core.readers.structureReader.factory.KDMStructureReaderJavaFactory"); //$NON-NLS-1$ 
			if (theKDMCodeReaderFactory != null) {
				return theKDMCodeReaderFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new KDMStructureReaderJavaFactoryImpl();
	}
	
	public KDMStructureReaderJavaFactoryImpl() {
		super();
	}

	@Override
	public KDMStructureGenericReader<Layer> createKDMLayerReader() {
		return new KDMLayerReaderImpl();
	}
	
	@Override
	public KDMStructureGenericReader<Component> createKDMComponentReader() {
		return new KDMComponentReaderImpl();
	}
	
	@Override
	public KDMStructureGenericReader<Subsystem> createKDMSubsystemReader() {
		return new KDMSubsystemReaderImpl();
	}
	
	@Override
	public KDMStructureGenericReader<ArchitectureView> createKDMArchitectureViewReader() {
		return new KDMArchitectureViewReaderImpl();
	}
	
	@Override
	public KDMStructureGenericReader<SoftwareSystem> createKDMSoftwareSystemReader() {
		return new KDMSoftwareSystemReaderImpl();
	}

	@Override
	public KDMStructureGenericReader<Layer> createKDMLayerReaderWithFilter(ValidateFilter filter) {
		return new KDMLayerReaderImpl(filter);
	}

	@Override
	public KDMStructureGenericReader<Component> createKDMComponentReaderWithFilter(ValidateFilter filter) {
		return new KDMComponentReaderImpl(filter);
	}

	@Override
	public KDMStructureGenericReader<Subsystem> createKDMSubsystemReaderWithFilter(ValidateFilter filter) {
		return new KDMSubsystemReaderImpl(filter);
	}

	@Override
	public KDMStructureGenericReader<ArchitectureView> createKDMArchitectureViewReaderWithFilter(ValidateFilter filter) {
		return new KDMArchitectureViewReaderImpl(filter);
	}

	@Override
	public KDMStructureGenericReader<SoftwareSystem> createKDMSoftwareSystemReaderWithFilter(ValidateFilter filter) {
		return new KDMSoftwareSystemReaderImpl(filter);
	}

}
