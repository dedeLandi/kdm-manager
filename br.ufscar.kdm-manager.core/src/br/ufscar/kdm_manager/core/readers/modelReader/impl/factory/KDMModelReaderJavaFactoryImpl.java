package br.ufscar.kdm_manager.core.readers.modelReader.impl.factory;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.gmt.modisco.omg.kdm.code.CodeModel;
import org.eclipse.gmt.modisco.omg.kdm.kdm.KDMModel;
import org.eclipse.gmt.modisco.omg.kdm.kdm.Segment;
import org.eclipse.gmt.modisco.omg.kdm.structure.StructureModel;

import br.ufscar.kdm_manager.core.filters.validateFilter.interfaces.ValidateFilter;
import br.ufscar.kdm_manager.core.readers.modelReader.factory.KDMModelReaderJavaFactory;
import br.ufscar.kdm_manager.core.readers.modelReader.impl.readers.java.KDMCodeModelReaderImpl;
import br.ufscar.kdm_manager.core.readers.modelReader.impl.readers.java.KDMKDMModelReaderImpl;
import br.ufscar.kdm_manager.core.readers.modelReader.impl.readers.java.KDMStructureModelReaderImpl;
import br.ufscar.kdm_manager.core.readers.modelReader.interfaces.KDMModelGenericReader;

public class KDMModelReaderJavaFactoryImpl extends EFactoryImpl implements KDMModelReaderJavaFactory {

	
	public static KDMModelReaderJavaFactory init() {
		try {
			KDMModelReaderJavaFactory theKDMModelReaderFactory = (KDMModelReaderJavaFactory)EPackage.Registry.INSTANCE.getEFactory("br.ufscar.kdm_manager.core.readers.modelReader.factory.KDMModelReaderJavaFactory"); //$NON-NLS-1$ 
			if (theKDMModelReaderFactory != null) {
				return theKDMModelReaderFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new KDMModelReaderJavaFactoryImpl();
	}
	
	public KDMModelReaderJavaFactoryImpl() {
		super();
	}

	@Override
	public KDMModelGenericReader<Map<String, List<KDMModel>>,Segment> createKDMKDMModelReader() {
		return new KDMKDMModelReaderImpl();
	}

//	@Override
//	public KDMModelGenericReader<BuildModel,Segment> createKDMBuildModelReader() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public KDMModelGenericReader<Map<String, List<CodeModel>>,Segment> createKDMCodeModelReader() {
		return new KDMCodeModelReaderImpl();
	}

//	@Override
//	public KDMModelGenericReader<ConceptualModel,Segment> createKDMConceptualModelReader() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public KDMModelGenericReader<DataModel,Segment> createKDMDataModelReader() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public KDMModelGenericReader<EventModel,Segment> createKDMEventModelReader() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public KDMModelGenericReader<InventoryModel,Segment> createKDMInventoryModelReader() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public KDMModelGenericReader<PlatformModel,Segment> createKDMPlatformModelReader() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public KDMModelGenericReader<Map<String, List<StructureModel>>,Segment> createKDMStructureModelReader() {
		return new KDMStructureModelReaderImpl();
	}

//	@Override
//	public KDMModelGenericReader<UIModel,Segment> createKDMUIModelReader() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public KDMModelGenericReader<Map<String, List<KDMModel>>,Segment> createKDMModelReaderWithFilter(ValidateFilter filter) {
		return new KDMKDMModelReaderImpl(filter);
	}

//	@Override
//	public KDMModelGenericReader<BuildModel,Segment> createKDMBuildModelReaderWithFilter(String nameToSearch) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public KDMModelGenericReader<Map<String, List<CodeModel>>,Segment> createKDMCodeModelReaderWithFilter(ValidateFilter filter) {
		return new KDMCodeModelReaderImpl(filter);
	}

//	@Override
//	public KDMModelGenericReader<ConceptualModel,Segment> createKDMConceptualModelReaderWithFilter(String nameToSearch) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public KDMModelGenericReader<DataModel,Segment> createKDMDataModelReaderWithFilter(String nameToSearch) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public KDMModelGenericReader<EventModel,Segment> createKDMEventModelReaderWithFilter(String nameToSearch) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public KDMModelGenericReader<InventoryModel,Segment> createKDMInventoryModelReaderWithFilter(String nameToSearch) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public KDMModelGenericReader<PlatformModel,Segment> createKDMPlatformModelReaderWithFilter(String nameToSearch) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public KDMModelGenericReader<Map<String, List<StructureModel>>,Segment> createKDMStructureModelReaderWithFilter(ValidateFilter filter) {
		return new KDMStructureModelReaderImpl(filter);
	}

//	@Override
//	public KDMModelGenericReader<UIModel,Segment> createKDMUIModelReaderWithFilter(String nameToSearch) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
