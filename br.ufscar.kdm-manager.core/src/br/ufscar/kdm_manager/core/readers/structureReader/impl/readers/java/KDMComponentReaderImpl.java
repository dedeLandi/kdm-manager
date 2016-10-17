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

public class KDMComponentReaderImpl implements KDMStructureGenericReader<Component>{

	private boolean hasNoFilter = true;
	private boolean hasFilter = false;

	private ValidateFilter<Component, ?> filter = null;

	public KDMComponentReaderImpl() {
		super();
	}

	public KDMComponentReaderImpl(ValidateFilter<Component, ?> filter) {
		this.hasNoFilter = false;
		this.hasFilter  = true;
		this.filter = filter;
	}
	
	private boolean validateFilter(Component elementToValidate) {
		if(this.hasNoFilter){
			return true;
		}else if(this.hasFilter){
			return this.filter.validateElement(elementToValidate);
		}
		return false;
	}

	@Override
	public List<Component> getAllFrom(Segment segmentToSearch) {
		List<Component> componentsPerModel = new ArrayList<Component>();

		Map<String, List<StructureModel>> models = KDMModelReaderJavaFactory.eINSTANCE.createKDMStructureModelReader().getAllFromSegment(segmentToSearch);

		for (String nameStructureModel : models.keySet()) {

			for (StructureModel structureModel : models.get(nameStructureModel)) {

				componentsPerModel.addAll(this.getAllComponentFrom(structureModel));
			}
		}
		
		return componentsPerModel;
	}

	@Override
	public List<Component> getAllFrom(StructureModel structureModelToSearch) {
		return this.getAllComponentFrom(structureModelToSearch);
	}

	@Override
	public List<Component> getAllFrom(SoftwareSystem softwareSystemToSearch) {
		return this.getAllComponentFrom(softwareSystemToSearch);
	}

	@Override
	public List<Component> getAllFrom(Subsystem subsystemToSearch) {
		return this.getAllComponentFrom(subsystemToSearch);
	}

	@Override
	public List<Component> getAllFrom(ArchitectureView architectureViewToSearch) {
		return this.getAllComponentFrom(architectureViewToSearch);
	}

	@Override
	public List<Component> getAllFrom(Layer layerToSearch) {
		return this.getAllComponentFrom(layerToSearch);
	}

	@Override
	public List<Component> getAllFrom(Component componentToSearch) {
		return this.getAllComponentFrom(componentToSearch);
	}	

	private List<Component> getAllComponentFrom(StructureModel structureModelToSearch) {
		List<Component> allComponent = new ArrayList<Component>();
		
		for (AbstractStructureElement abstractStructureElement : structureModelToSearch.getStructureElement()) {
			
			if(abstractStructureElement instanceof Layer){
				
				allComponent.addAll(this.getAllComponentFrom((Layer) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Component){
				
				if (validateFilter((Component) abstractStructureElement)) {
					allComponent.add((Component) abstractStructureElement);
				}
				allComponent.addAll(this.getAllComponentFrom((Component) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Subsystem){
				
				allComponent.addAll(this.getAllComponentFrom((Subsystem) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof ArchitectureView){
				
				allComponent.addAll(this.getAllComponentFrom((ArchitectureView) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof SoftwareSystem){
				
				allComponent.addAll(this.getAllComponentFrom((SoftwareSystem) abstractStructureElement));
				
			}
		}
		
		return allComponent;
	}
	
	private List<Component> getAllComponentFrom(Layer layerToSearch) {
		List<Component> allComponent = new ArrayList<Component>();
		
		for (AbstractStructureElement abstractStructureElement : layerToSearch.getStructureElement()) {
			
			if(abstractStructureElement instanceof Layer){
				
				allComponent.addAll(this.getAllComponentFrom((Layer) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Component){
				
				if (validateFilter((Component) abstractStructureElement)) {
					allComponent.add((Component) abstractStructureElement);
				}
				allComponent.addAll(this.getAllComponentFrom((Component) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Subsystem){
				
				allComponent.addAll(this.getAllComponentFrom((Subsystem) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof ArchitectureView){
				
				allComponent.addAll(this.getAllComponentFrom((ArchitectureView) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof SoftwareSystem){
				
				allComponent.addAll(this.getAllComponentFrom((SoftwareSystem) abstractStructureElement));
				
			}
		}
		
		return allComponent;
	}
	
	private List<Component> getAllComponentFrom(Component componentToSearch) {
		List<Component> allComponent = new ArrayList<Component>();
		
		for (AbstractStructureElement abstractStructureElement : componentToSearch.getStructureElement()) {
			
			if(abstractStructureElement instanceof Layer){
				
				allComponent.addAll(this.getAllComponentFrom((Layer) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Component){
				
				if (validateFilter((Component) abstractStructureElement)) {
					allComponent.add((Component) abstractStructureElement);
				}
				allComponent.addAll(this.getAllComponentFrom((Component) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Subsystem){
				
				allComponent.addAll(this.getAllComponentFrom((Subsystem) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof ArchitectureView){
				
				allComponent.addAll(this.getAllComponentFrom((ArchitectureView) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof SoftwareSystem){
				
				allComponent.addAll(this.getAllComponentFrom((SoftwareSystem) abstractStructureElement));
				
			}
		}
		
		return allComponent;
	}
	
	private List<Component> getAllComponentFrom(Subsystem subsystemToSearch) {
		List<Component> allComponent = new ArrayList<Component>();
		
		for (AbstractStructureElement abstractStructureElement : subsystemToSearch.getStructureElement()) {
			
			if(abstractStructureElement instanceof Layer){
				
				allComponent.addAll(this.getAllComponentFrom((Layer) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Component){
				
				if (validateFilter((Component) abstractStructureElement)) {
					allComponent.add((Component) abstractStructureElement);
				}
				allComponent.addAll(this.getAllComponentFrom((Component) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Subsystem){
				
				allComponent.addAll(this.getAllComponentFrom((Subsystem) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof ArchitectureView){
				
				allComponent.addAll(this.getAllComponentFrom((ArchitectureView) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof SoftwareSystem){
				
				allComponent.addAll(this.getAllComponentFrom((SoftwareSystem) abstractStructureElement));
				
			}
		}
		
		return allComponent;
	}
	
	private List<Component> getAllComponentFrom(ArchitectureView architectureViewToSearch) {
		List<Component> allComponent = new ArrayList<Component>();
		
		for (AbstractStructureElement abstractStructureElement : architectureViewToSearch.getStructureElement()) {
			
			if(abstractStructureElement instanceof Layer){
				
				allComponent.addAll(this.getAllComponentFrom((Layer) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Component){
				
				if (validateFilter((Component) abstractStructureElement)) {
					allComponent.add((Component) abstractStructureElement);
				}
				allComponent.addAll(this.getAllComponentFrom((Component) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Subsystem){
				
				allComponent.addAll(this.getAllComponentFrom((Subsystem) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof ArchitectureView){
				
				allComponent.addAll(this.getAllComponentFrom((ArchitectureView) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof SoftwareSystem){
				
				allComponent.addAll(this.getAllComponentFrom((SoftwareSystem) abstractStructureElement));
				
			}
		}
		
		return allComponent;
	}
	
	private List<Component> getAllComponentFrom(SoftwareSystem softwareSystemToSearch) {
		List<Component> allComponent = new ArrayList<Component>();

		for (AbstractStructureElement abstractStructureElement : softwareSystemToSearch.getStructureElement()) {
			
			if(abstractStructureElement instanceof Layer){
				
				allComponent.addAll(this.getAllComponentFrom((Layer) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Component){
				
				if (validateFilter((Component) abstractStructureElement)) {
					allComponent.add((Component) abstractStructureElement);
				}
				allComponent.addAll(this.getAllComponentFrom((Component) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Subsystem){
				
				allComponent.addAll(this.getAllComponentFrom((Subsystem) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof ArchitectureView){
				
				allComponent.addAll(this.getAllComponentFrom((ArchitectureView) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof SoftwareSystem){
				
				allComponent.addAll(this.getAllComponentFrom((SoftwareSystem) abstractStructureElement));
				
			}
		}
		
		return allComponent;
	}
}
