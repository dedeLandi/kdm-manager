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
