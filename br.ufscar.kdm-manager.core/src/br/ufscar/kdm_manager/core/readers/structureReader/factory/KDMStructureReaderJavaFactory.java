package br.ufscar.kdm_manager.core.readers.structureReader.factory;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.gmt.modisco.omg.kdm.structure.ArchitectureView;
import org.eclipse.gmt.modisco.omg.kdm.structure.Component;
import org.eclipse.gmt.modisco.omg.kdm.structure.Layer;
import org.eclipse.gmt.modisco.omg.kdm.structure.SoftwareSystem;
import org.eclipse.gmt.modisco.omg.kdm.structure.Subsystem;

import br.ufscar.kdm_manager.core.filters.validateFilter.interfaces.ValidateFilter;
import br.ufscar.kdm_manager.core.readers.structureReader.interfaces.KDMStructureGenericReader;


public interface KDMStructureReaderJavaFactory extends EFactory {

	KDMStructureReaderJavaFactory eINSTANCE = br.ufscar.kdm_manager.core.readers.structureReader.impl.factory.KDMStructureReaderJavaFactoryImpl.init();
	
	KDMStructureGenericReader<Layer> createKDMLayerReader();
	
	KDMStructureGenericReader<Component> createKDMComponentReader();
	
	KDMStructureGenericReader<Subsystem> createKDMSubsystemReader();
	
	KDMStructureGenericReader<ArchitectureView> createKDMArchitectureViewReader();
	
	KDMStructureGenericReader<SoftwareSystem> createKDMSoftwareSystemReader();
	
	KDMStructureGenericReader<Layer> createKDMLayerReaderWithFilter(ValidateFilter<?, ?> filter);
	
	KDMStructureGenericReader<Component> createKDMComponentReaderWithFilter(ValidateFilter<?, ?> filter);
	
	KDMStructureGenericReader<Subsystem> createKDMSubsystemReaderWithFilter(ValidateFilter<?, ?> filter);
	
	KDMStructureGenericReader<ArchitectureView> createKDMArchitectureViewReaderWithFilter(ValidateFilter<?, ?> filter);
	
	KDMStructureGenericReader<SoftwareSystem> createKDMSoftwareSystemReaderWithFilter(ValidateFilter<?, ?> filter);
	
}
