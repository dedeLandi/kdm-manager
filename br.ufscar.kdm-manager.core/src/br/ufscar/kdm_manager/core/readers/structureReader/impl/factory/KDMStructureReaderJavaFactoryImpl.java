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
package br.ufscar.kdm_manager.core.readers.structureReader.impl.factory;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.gmt.modisco.omg.kdm.core.AggregatedRelationship;
import org.eclipse.gmt.modisco.omg.kdm.structure.ArchitectureView;
import org.eclipse.gmt.modisco.omg.kdm.structure.Component;
import org.eclipse.gmt.modisco.omg.kdm.structure.Layer;
import org.eclipse.gmt.modisco.omg.kdm.structure.SoftwareSystem;
import org.eclipse.gmt.modisco.omg.kdm.structure.Subsystem;

import br.ufscar.kdm_manager.core.filters.validateFilter.interfaces.KDMValidateFilter;
import br.ufscar.kdm_manager.core.readers.structureReader.factory.KDMStructureReaderJavaFactory;
import br.ufscar.kdm_manager.core.readers.structureReader.impl.readers.java.KDMAggregatedRelationshipReaderImpl;
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
	public KDMStructureGenericReader<AggregatedRelationship> createKDMAggregatedRelationshipReader() {
		return new KDMAggregatedRelationshipReaderImpl();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public KDMStructureGenericReader<Layer> createKDMLayerReaderWithFilter(KDMValidateFilter filter) {
		return new KDMLayerReaderImpl(filter);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public KDMStructureGenericReader<Component> createKDMComponentReaderWithFilter(KDMValidateFilter filter) {
		return new KDMComponentReaderImpl(filter);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public KDMStructureGenericReader<Subsystem> createKDMSubsystemReaderWithFilter(KDMValidateFilter filter) {
		return new KDMSubsystemReaderImpl(filter);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public KDMStructureGenericReader<ArchitectureView> createKDMArchitectureViewReaderWithFilter(KDMValidateFilter filter) {
		return new KDMArchitectureViewReaderImpl(filter);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public KDMStructureGenericReader<SoftwareSystem> createKDMSoftwareSystemReaderWithFilter(KDMValidateFilter filter) {
		return new KDMSoftwareSystemReaderImpl(filter);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public KDMStructureGenericReader<AggregatedRelationship> createKDMAggregatedRelationshipReaderWithFilter(KDMValidateFilter filter) {
		return new KDMAggregatedRelationshipReaderImpl(filter);
	}

}
