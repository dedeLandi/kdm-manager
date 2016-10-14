package br.ufscar.kdm_manager.core.readers.modelReader.factory;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.gmt.modisco.omg.kdm.code.CodeModel;
import org.eclipse.gmt.modisco.omg.kdm.kdm.KDMModel;
import org.eclipse.gmt.modisco.omg.kdm.kdm.Segment;
import org.eclipse.gmt.modisco.omg.kdm.structure.StructureModel;

import br.ufscar.kdm_manager.core.filters.validateFilter.interfaces.ValidateFilter;
import br.ufscar.kdm_manager.core.readers.modelReader.interfaces.KDMModelGenericReader;


public interface KDMModelReaderJavaFactory extends EFactory {

	KDMModelReaderJavaFactory eINSTANCE = br.ufscar.kdm_manager.core.readers.modelReader.impl.factory.KDMModelReaderJavaFactoryImpl.init();
	
	KDMModelGenericReader<Map<String, List<KDMModel>>,Segment> createKDMKDMModelReader();
	
//	KDMModelGenericReader<BuildModel,Segment> createKDMBuildModelReader();
	
	KDMModelGenericReader<Map<String, List<CodeModel>>,Segment> createKDMCodeModelReader();
	
//	KDMModelGenericReader<ConceptualModel,Segment> createKDMConceptualModelReader();
	
//	KDMModelGenericReader<DataModel,Segment> createKDMDataModelReader();
	
//	KDMModelGenericReader<EventModel,Segment> createKDMEventModelReader();
	
//	KDMModelGenericReader<InventoryModel,Segment> createKDMInventoryModelReader();
	
//	KDMModelGenericReader<PlatformModel,Segment> createKDMPlatformModelReader();

	KDMModelGenericReader<Map<String, List<StructureModel>>,Segment> createKDMStructureModelReader();
	
//	KDMModelGenericReader<UIModel,Segment> createKDMUIModelReader();
	
	KDMModelGenericReader<Map<String, List<KDMModel>>,Segment> createKDMModelReaderWithFilter(ValidateFilter<?, ?> filter);
	
//	KDMModelGenericReader<BuildModel,Segment> createKDMBuildModelReaderWithFilter(String nameToSearch);
	
	KDMModelGenericReader<Map<String, List<CodeModel>>,Segment> createKDMCodeModelReaderWithFilter(ValidateFilter<?, ?> filter);
	
//	KDMModelGenericReader<ConceptualModel,Segment> createKDMConceptualModelReaderWithFilter(String nameToSearch);
	
//	KDMModelGenericReader<DataModel,Segment> createKDMDataModelReaderWithFilter(String nameToSearch);
	
//	KDMModelGenericReader<EventModel,Segment> createKDMEventModelReaderWithFilter(String nameToSearch);
	
//	KDMModelGenericReader<InventoryModel,Segment> createKDMInventoryModelReaderWithFilter(String nameToSearch);
	
//	KDMModelGenericReader<PlatformModel,Segment> createKDMPlatformModelReaderWithFilter(String nameToSearch);

	KDMModelGenericReader<Map<String, List<StructureModel>>,Segment> createKDMStructureModelReaderWithFilter(ValidateFilter<?, ?> filter);
	
//	KDMModelGenericReader<UIModel,Segment> createKDMUIModelReaderWithFilter(String nameToSearch);
	
}
