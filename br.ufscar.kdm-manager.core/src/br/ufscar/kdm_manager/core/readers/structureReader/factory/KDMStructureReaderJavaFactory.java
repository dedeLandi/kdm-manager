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
package br.ufscar.kdm_manager.core.readers.structureReader.factory;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.gmt.modisco.omg.kdm.core.AggregatedRelationship;
import org.eclipse.gmt.modisco.omg.kdm.structure.ArchitectureView;
import org.eclipse.gmt.modisco.omg.kdm.structure.Component;
import org.eclipse.gmt.modisco.omg.kdm.structure.Layer;
import org.eclipse.gmt.modisco.omg.kdm.structure.SoftwareSystem;
import org.eclipse.gmt.modisco.omg.kdm.structure.Subsystem;

import br.ufscar.kdm_manager.core.filters.validateFilter.interfaces.KDMValidateFilter;
import br.ufscar.kdm_manager.core.readers.structureReader.interfaces.KDMStructureGenericReader;


public interface KDMStructureReaderJavaFactory extends EFactory {

	KDMStructureReaderJavaFactory eINSTANCE = br.ufscar.kdm_manager.core.readers.structureReader.impl.factory.KDMStructureReaderJavaFactoryImpl.init();
	
	KDMStructureGenericReader<Layer> createKDMLayerReader();
	
	KDMStructureGenericReader<Component> createKDMComponentReader();
	
	KDMStructureGenericReader<Subsystem> createKDMSubsystemReader();
	
	KDMStructureGenericReader<ArchitectureView> createKDMArchitectureViewReader();
	
	KDMStructureGenericReader<SoftwareSystem> createKDMSoftwareSystemReader();
	
	KDMStructureGenericReader<AggregatedRelationship> createKDMAggregatedRelationshipReader();
	
	KDMStructureGenericReader<Layer> createKDMLayerReaderWithFilter(KDMValidateFilter<?, ?> filter);
	
	KDMStructureGenericReader<Component> createKDMComponentReaderWithFilter(KDMValidateFilter<?, ?> filter);
	
	KDMStructureGenericReader<Subsystem> createKDMSubsystemReaderWithFilter(KDMValidateFilter<?, ?> filter);
	
	KDMStructureGenericReader<ArchitectureView> createKDMArchitectureViewReaderWithFilter(KDMValidateFilter<?, ?> filter);
	
	KDMStructureGenericReader<SoftwareSystem> createKDMSoftwareSystemReaderWithFilter(KDMValidateFilter<?, ?> filter);
	
	KDMStructureGenericReader<AggregatedRelationship> createKDMAggregatedRelationshipReaderWithFilter(KDMValidateFilter<?, ?> filter);
}
