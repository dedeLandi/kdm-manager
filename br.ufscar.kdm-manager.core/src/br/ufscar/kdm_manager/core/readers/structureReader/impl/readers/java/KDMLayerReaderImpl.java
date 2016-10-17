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
package br.ufscar.kdm_manager.core.readers.structureReader.impl.readers.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.gmt.modisco.omg.kdm.kdm.Segment;
import org.eclipse.gmt.modisco.omg.kdm.structure.AbstractStructureElement;
import org.eclipse.gmt.modisco.omg.kdm.structure.ArchitectureView;
import org.eclipse.gmt.modisco.omg.kdm.structure.Component;
import org.eclipse.gmt.modisco.omg.kdm.structure.Layer;
import org.eclipse.gmt.modisco.omg.kdm.structure.SoftwareSystem;
import org.eclipse.gmt.modisco.omg.kdm.structure.StructureModel;
import org.eclipse.gmt.modisco.omg.kdm.structure.Subsystem;

import br.ufscar.kdm_manager.core.filters.validateFilter.interfaces.ValidateFilter;
import br.ufscar.kdm_manager.core.readers.modelReader.factory.KDMModelReaderJavaFactory;
import br.ufscar.kdm_manager.core.readers.structureReader.interfaces.KDMStructureGenericReader;

public class KDMLayerReaderImpl implements KDMStructureGenericReader<Layer>{

	private boolean hasNoFilter = true;
	private boolean hasFilter = false;

	private ValidateFilter<Layer, ?> filter = null;

	public KDMLayerReaderImpl() {
		super();
	}

	public KDMLayerReaderImpl(ValidateFilter<Layer, ?> filter) {
		this.hasNoFilter = false;
		this.hasFilter  = true;
		this.filter = filter;
	}
	
	private boolean validateFilter(Layer elementToValidate) {
		if(this.hasNoFilter){
			return true;
		}else if(this.hasFilter){
			return this.filter.validateElement(elementToValidate);
		}
		return false;
	}

	@Override
	public List<Layer> getAllFrom(Segment segmentToSearch) {
		List<Layer> layersPerModel = new ArrayList<Layer>();

		Map<String, List<StructureModel>> models = KDMModelReaderJavaFactory.eINSTANCE.createKDMStructureModelReader().getAllFromSegment(segmentToSearch);

		for (String nameStructureModel : models.keySet()) {

			for (StructureModel structureModel : models.get(nameStructureModel)) {

				layersPerModel.addAll(this.getAllLayersFrom(structureModel));
			}
		}
		
		return layersPerModel;
	}

	@Override
	public List<Layer> getAllFrom(StructureModel structureModelToSearch) {
		return this.getAllLayersFrom(structureModelToSearch);
	}

	@Override
	public List<Layer> getAllFrom(SoftwareSystem softwareSystemToSearch) {
		return this.getAllLayersFrom(softwareSystemToSearch);
	}

	@Override
	public List<Layer> getAllFrom(Subsystem subsystemToSearch) {
		return this.getAllLayersFrom(subsystemToSearch);
	}

	@Override
	public List<Layer> getAllFrom(ArchitectureView architectureViewToSearch) {
		return this.getAllLayersFrom(architectureViewToSearch);
	}

	@Override
	public List<Layer> getAllFrom(Layer layerToSearch) {
		return this.getAllLayersFrom(layerToSearch);
	}

	@Override
	public List<Layer> getAllFrom(Component componentToSearch) {
		return this.getAllLayersFrom(componentToSearch);
	}	

	private List<Layer> getAllLayersFrom(StructureModel structureModelToSearch) {
		List<Layer> allLayers = new ArrayList<Layer>();
		
		for (AbstractStructureElement abstractStructureElement : structureModelToSearch.getStructureElement()) {
			
			if(abstractStructureElement instanceof Layer){
				
				if (validateFilter((Layer) abstractStructureElement)) {
					allLayers.add((Layer) abstractStructureElement);
				}
				allLayers.addAll(this.getAllLayersFrom((Layer) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Component){
				
				allLayers.addAll(this.getAllLayersFrom((Component) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Subsystem){
				
				allLayers.addAll(this.getAllLayersFrom((Subsystem) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof ArchitectureView){
				
				allLayers.addAll(this.getAllLayersFrom((ArchitectureView) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof SoftwareSystem){
				
				allLayers.addAll(this.getAllLayersFrom((SoftwareSystem) abstractStructureElement));
				
			}
		}
		
		return allLayers;
	}
	
	private List<Layer> getAllLayersFrom(Layer layerToSearch) {
		List<Layer> allLayers = new ArrayList<Layer>();
		
		for (AbstractStructureElement abstractStructureElement : layerToSearch.getStructureElement()) {
			
			if(abstractStructureElement instanceof Layer){
				
				if (validateFilter((Layer) abstractStructureElement)) {
					allLayers.add((Layer) abstractStructureElement);
				}
				allLayers.addAll(this.getAllLayersFrom((Layer) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Component){
				
				allLayers.addAll(this.getAllLayersFrom((Component) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Subsystem){
				
				allLayers.addAll(this.getAllLayersFrom((Subsystem) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof ArchitectureView){
				
				allLayers.addAll(this.getAllLayersFrom((ArchitectureView) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof SoftwareSystem){
				
				allLayers.addAll(this.getAllLayersFrom((SoftwareSystem) abstractStructureElement));
				
			}
		}
		
		return allLayers;
	}
	
	private List<Layer> getAllLayersFrom(Component componentToSearch) {
		List<Layer> allLayers = new ArrayList<Layer>();
		
		for (AbstractStructureElement abstractStructureElement : componentToSearch.getStructureElement()) {
			
			if(abstractStructureElement instanceof Layer){
				
				if (validateFilter((Layer) abstractStructureElement)) {
					allLayers.add((Layer) abstractStructureElement);
				}
				allLayers.addAll(this.getAllLayersFrom((Layer) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Component){
				
				allLayers.addAll(this.getAllLayersFrom((Component) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Subsystem){
				
				allLayers.addAll(this.getAllLayersFrom((Subsystem) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof ArchitectureView){
				
				allLayers.addAll(this.getAllLayersFrom((ArchitectureView) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof SoftwareSystem){
				
				allLayers.addAll(this.getAllLayersFrom((SoftwareSystem) abstractStructureElement));
				
			}
		}
		
		return allLayers;
	}
	
	private List<Layer> getAllLayersFrom(Subsystem subsystemToSearch) {
		List<Layer> allLayers = new ArrayList<Layer>();
		
		for (AbstractStructureElement abstractStructureElement : subsystemToSearch.getStructureElement()) {
			
			if(abstractStructureElement instanceof Layer){
				
				if (validateFilter((Layer) abstractStructureElement)) {
					allLayers.add((Layer) abstractStructureElement);
				}
				allLayers.addAll(this.getAllLayersFrom((Layer) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Component){
				
				allLayers.addAll(this.getAllLayersFrom((Component) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Subsystem){
				
				allLayers.addAll(this.getAllLayersFrom((Subsystem) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof ArchitectureView){
				
				allLayers.addAll(this.getAllLayersFrom((ArchitectureView) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof SoftwareSystem){
				
				allLayers.addAll(this.getAllLayersFrom((SoftwareSystem) abstractStructureElement));
				
			}
		}
		
		return allLayers;
	}
	
	private List<Layer> getAllLayersFrom(ArchitectureView architectureViewToSearch) {
		List<Layer> allLayers = new ArrayList<Layer>();
		
		for (AbstractStructureElement abstractStructureElement : architectureViewToSearch.getStructureElement()) {
			
			if(abstractStructureElement instanceof Layer){
				
				if (validateFilter((Layer) abstractStructureElement)) {
					allLayers.add((Layer) abstractStructureElement);
				}
				allLayers.addAll(this.getAllLayersFrom((Layer) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Component){
				
				allLayers.addAll(this.getAllLayersFrom((Component) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Subsystem){
				
				allLayers.addAll(this.getAllLayersFrom((Subsystem) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof ArchitectureView){
				
				allLayers.addAll(this.getAllLayersFrom((ArchitectureView) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof SoftwareSystem){
				
				allLayers.addAll(this.getAllLayersFrom((SoftwareSystem) abstractStructureElement));
				
			}
		}
		
		return allLayers;
	}
	
	private List<Layer> getAllLayersFrom(SoftwareSystem softwareSystemToSearch) {
		List<Layer> allLayers = new ArrayList<Layer>();

		for (AbstractStructureElement abstractStructureElement : softwareSystemToSearch.getStructureElement()) {
			
			if(abstractStructureElement instanceof Layer){
				
				if (validateFilter((Layer) abstractStructureElement)) {
					allLayers.add((Layer) abstractStructureElement);
				}
				allLayers.addAll(this.getAllLayersFrom((Layer) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Component){
				
				allLayers.addAll(this.getAllLayersFrom((Component) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Subsystem){
				
				allLayers.addAll(this.getAllLayersFrom((Subsystem) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof ArchitectureView){
				
				allLayers.addAll(this.getAllLayersFrom((ArchitectureView) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof SoftwareSystem){
				
				allLayers.addAll(this.getAllLayersFrom((SoftwareSystem) abstractStructureElement));
				
			}
		}
		
		return allLayers;
	}
}
