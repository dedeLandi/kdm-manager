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

import br.ufscar.kdm_manager.core.filters.validateFilter.interfaces.KDMValidateFilter;
import br.ufscar.kdm_manager.core.readers.modelReader.factory.KDMModelReaderJavaFactory;
import br.ufscar.kdm_manager.core.readers.structureReader.interfaces.KDMStructureGenericReader;

public class KDMArchitectureViewReaderImpl implements KDMStructureGenericReader<ArchitectureView>{

	private boolean hasNoFilter = true;
	private boolean hasFilter = false;

	private KDMValidateFilter<ArchitectureView, ?> filter = null;

	public KDMArchitectureViewReaderImpl() {
		super();
	}

	public KDMArchitectureViewReaderImpl(KDMValidateFilter<ArchitectureView, ?> elementName) {
		this.hasNoFilter = false;
		this.hasFilter  = true;
		this.filter = elementName;
	}
	
	private boolean validateFilter(ArchitectureView elementToValidate) {
		if(this.hasNoFilter){
			return true;
		}else if(this.hasFilter){
			return this.filter.validateElement(elementToValidate);
		}
		return false;
	}

	@Override
	public List<ArchitectureView> getAllFrom(Segment segmentToSearch) {
		List<ArchitectureView> architectureViewPerModel = new ArrayList<ArchitectureView>();

		Map<String, List<StructureModel>> models = KDMModelReaderJavaFactory.eINSTANCE.createKDMStructureModelReader().getAllFromSegment(segmentToSearch);

		for (String nameStructureModel : models.keySet()) {

			for (StructureModel structureModel : models.get(nameStructureModel)) {

				architectureViewPerModel.addAll(this.getAllArchitectureViewFrom(structureModel));
			}
		}
		
		return architectureViewPerModel;
	}

	@Override
	public List<ArchitectureView> getAllFrom(StructureModel structureModelToSearch) {
		return this.getAllArchitectureViewFrom(structureModelToSearch);
	}

	@Override
	public List<ArchitectureView> getAllFrom(SoftwareSystem softwareSystemToSearch) {
		return this.getAllArchitectureViewFrom(softwareSystemToSearch);
	}

	@Override
	public List<ArchitectureView> getAllFrom(Subsystem subsystemToSearch) {
		return this.getAllArchitectureViewFrom(subsystemToSearch);
	}

	@Override
	public List<ArchitectureView> getAllFrom(ArchitectureView architectureViewToSearch) {
		return this.getAllArchitectureViewFrom(architectureViewToSearch);
	}

	@Override
	public List<ArchitectureView> getAllFrom(Layer layerToSearch) {
		return this.getAllArchitectureViewFrom(layerToSearch);
	}

	@Override
	public List<ArchitectureView> getAllFrom(Component componentToSearch) {
		return this.getAllArchitectureViewFrom(componentToSearch);
	}	

	private List<ArchitectureView> getAllArchitectureViewFrom(StructureModel structureModelToSearch) {
		List<ArchitectureView> allArchitectureView = new ArrayList<ArchitectureView>();
		
		for (AbstractStructureElement abstractStructureElement : structureModelToSearch.getStructureElement()) {
			
			if(abstractStructureElement instanceof Layer){
				
				allArchitectureView.addAll(this.getAllArchitectureViewFrom((Layer) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Component){
				
				allArchitectureView.addAll(this.getAllArchitectureViewFrom((Component) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Subsystem){
				
				allArchitectureView.addAll(this.getAllArchitectureViewFrom((Subsystem) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof ArchitectureView){
				
				if (validateFilter((ArchitectureView) abstractStructureElement)) {
					allArchitectureView.add((ArchitectureView) abstractStructureElement);
				}
				allArchitectureView.addAll(this.getAllArchitectureViewFrom((ArchitectureView) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof SoftwareSystem){
				
				allArchitectureView.addAll(this.getAllArchitectureViewFrom((SoftwareSystem) abstractStructureElement));
				
			}
		}
		
		return allArchitectureView;
	}
	
	private List<ArchitectureView> getAllArchitectureViewFrom(Layer layerToSearch) {
		List<ArchitectureView> allArchitectureView = new ArrayList<ArchitectureView>();
		
		for (AbstractStructureElement abstractStructureElement : layerToSearch.getStructureElement()) {
			
			if(abstractStructureElement instanceof Layer){
				
				allArchitectureView.addAll(this.getAllArchitectureViewFrom((Layer) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Component){
				
				allArchitectureView.addAll(this.getAllArchitectureViewFrom((Component) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Subsystem){
				
				allArchitectureView.addAll(this.getAllArchitectureViewFrom((Subsystem) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof ArchitectureView){
				
				if (validateFilter((ArchitectureView) abstractStructureElement)) {
					allArchitectureView.add((ArchitectureView) abstractStructureElement);
				}
				allArchitectureView.addAll(this.getAllArchitectureViewFrom((ArchitectureView) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof SoftwareSystem){
				
				allArchitectureView.addAll(this.getAllArchitectureViewFrom((SoftwareSystem) abstractStructureElement));
				
			}
		}
		
		return allArchitectureView;
	}
	
	private List<ArchitectureView> getAllArchitectureViewFrom(Component componentToSearch) {
		List<ArchitectureView> allArchitectureView = new ArrayList<ArchitectureView>();
		
		for (AbstractStructureElement abstractStructureElement : componentToSearch.getStructureElement()) {
			
			if(abstractStructureElement instanceof Layer){
				
				allArchitectureView.addAll(this.getAllArchitectureViewFrom((Layer) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Component){
				
				allArchitectureView.addAll(this.getAllArchitectureViewFrom((Component) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Subsystem){
				
				allArchitectureView.addAll(this.getAllArchitectureViewFrom((Subsystem) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof ArchitectureView){
				
				if (validateFilter((ArchitectureView) abstractStructureElement)) {
					allArchitectureView.add((ArchitectureView) abstractStructureElement);
				}
				allArchitectureView.addAll(this.getAllArchitectureViewFrom((ArchitectureView) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof SoftwareSystem){
				
				allArchitectureView.addAll(this.getAllArchitectureViewFrom((SoftwareSystem) abstractStructureElement));
				
			}
		}
		
		return allArchitectureView;
	}
	
	private List<ArchitectureView> getAllArchitectureViewFrom(Subsystem subsystemToSearch) {
		List<ArchitectureView> allArchitectureView = new ArrayList<ArchitectureView>();
		
		for (AbstractStructureElement abstractStructureElement : subsystemToSearch.getStructureElement()) {
			
			if(abstractStructureElement instanceof Layer){
				
				allArchitectureView.addAll(this.getAllArchitectureViewFrom((Layer) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Component){
				
				allArchitectureView.addAll(this.getAllArchitectureViewFrom((Component) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Subsystem){
				
				allArchitectureView.addAll(this.getAllArchitectureViewFrom((Subsystem) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof ArchitectureView){
				
				if (validateFilter((ArchitectureView) abstractStructureElement)) {
					allArchitectureView.add((ArchitectureView) abstractStructureElement);
				}
				allArchitectureView.addAll(this.getAllArchitectureViewFrom((ArchitectureView) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof SoftwareSystem){
				
				allArchitectureView.addAll(this.getAllArchitectureViewFrom((SoftwareSystem) abstractStructureElement));
				
			}
		}
		
		return allArchitectureView;
	}
	
	private List<ArchitectureView> getAllArchitectureViewFrom(ArchitectureView architectureViewToSearch) {
		List<ArchitectureView> allArchitectureView = new ArrayList<ArchitectureView>();
		
		for (AbstractStructureElement abstractStructureElement : architectureViewToSearch.getStructureElement()) {
			
			if(abstractStructureElement instanceof Layer){
				
				allArchitectureView.addAll(this.getAllArchitectureViewFrom((Layer) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Component){
				
				allArchitectureView.addAll(this.getAllArchitectureViewFrom((Component) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Subsystem){
				
				allArchitectureView.addAll(this.getAllArchitectureViewFrom((Subsystem) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof ArchitectureView){
				
				if (validateFilter((ArchitectureView) abstractStructureElement)) {
					allArchitectureView.add((ArchitectureView) abstractStructureElement);
				}
				allArchitectureView.addAll(this.getAllArchitectureViewFrom((ArchitectureView) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof SoftwareSystem){
				
				allArchitectureView.addAll(this.getAllArchitectureViewFrom((SoftwareSystem) abstractStructureElement));
				
			}
		}
		
		return allArchitectureView;
	}
	
	private List<ArchitectureView> getAllArchitectureViewFrom(SoftwareSystem softwareSystemToSearch) {
		List<ArchitectureView> allArchitectureView = new ArrayList<ArchitectureView>();

		for (AbstractStructureElement abstractStructureElement : softwareSystemToSearch.getStructureElement()) {
			
			if(abstractStructureElement instanceof Layer){
				
				allArchitectureView.addAll(this.getAllArchitectureViewFrom((Layer) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Component){
				
				allArchitectureView.addAll(this.getAllArchitectureViewFrom((Component) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Subsystem){
				
				allArchitectureView.addAll(this.getAllArchitectureViewFrom((Subsystem) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof ArchitectureView){
				
				if (validateFilter((ArchitectureView) abstractStructureElement)) {
					allArchitectureView.add((ArchitectureView) abstractStructureElement);
				}
				allArchitectureView.addAll(this.getAllArchitectureViewFrom((ArchitectureView) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof SoftwareSystem){
				
				allArchitectureView.addAll(this.getAllArchitectureViewFrom((SoftwareSystem) abstractStructureElement));
				
			}
		}
		
		return allArchitectureView;
	}
}
