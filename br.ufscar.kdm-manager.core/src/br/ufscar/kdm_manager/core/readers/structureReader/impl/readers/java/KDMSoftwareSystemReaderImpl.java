/********************************************************************************
 *																				*
 * Copyright (c) 2016, Andr� de Souza Landi. All rights reserved.				*
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

public class KDMSoftwareSystemReaderImpl implements KDMStructureGenericReader<SoftwareSystem>{

	private boolean hasNoFilter = true;
	private boolean hasFilter = false;

	private KDMValidateFilter<SoftwareSystem, ?> filter = null;

	public KDMSoftwareSystemReaderImpl() {
		super();
	}

	public KDMSoftwareSystemReaderImpl(KDMValidateFilter<SoftwareSystem, ?> filter) {
		this.hasNoFilter = false;
		this.hasFilter  = true;
		this.filter = filter;
	}
	
	private boolean validateFilter(SoftwareSystem elementToValidate) {
		if(this.hasNoFilter){
			return true;
		}else if(this.hasFilter){
			return this.filter.validateElement(elementToValidate);
		}
		return false;
	}

	@Override
	public List<SoftwareSystem> getAllFrom(Segment segmentToSearch) {
		List<SoftwareSystem> softwareSystemPerModel = new ArrayList<SoftwareSystem>();

		Map<String, List<StructureModel>> models = KDMModelReaderJavaFactory.eINSTANCE.createKDMStructureModelReader().getAllFromSegment(segmentToSearch);

		for (String nameStructureModel : models.keySet()) {

			for (StructureModel structureModel : models.get(nameStructureModel)) {

				softwareSystemPerModel.addAll(this.getAllSoftwareSystemFrom(structureModel));
			}
		}
		
		return softwareSystemPerModel;
	}

	@Override
	public List<SoftwareSystem> getAllFrom(StructureModel structureModelToSearch) {
		return this.getAllSoftwareSystemFrom(structureModelToSearch);
	}

	@Override
	public List<SoftwareSystem> getAllFrom(SoftwareSystem softwareSystemToSearch) {
		return this.getAllSoftwareSystemFrom(softwareSystemToSearch);
	}

	@Override
	public List<SoftwareSystem> getAllFrom(Subsystem subsystemToSearch) {
		return this.getAllSoftwareSystemFrom(subsystemToSearch);
	}

	@Override
	public List<SoftwareSystem> getAllFrom(ArchitectureView architectureViewToSearch) {
		return this.getAllSoftwareSystemFrom(architectureViewToSearch);
	}

	@Override
	public List<SoftwareSystem> getAllFrom(Layer layerToSearch) {
		return this.getAllSoftwareSystemFrom(layerToSearch);
	}

	@Override
	public List<SoftwareSystem> getAllFrom(Component componentToSearch) {
		return this.getAllSoftwareSystemFrom(componentToSearch);
	}	

	private List<SoftwareSystem> getAllSoftwareSystemFrom(StructureModel structureModelToSearch) {
		List<SoftwareSystem> allSoftwareSystem = new ArrayList<SoftwareSystem>();
		
		for (AbstractStructureElement abstractStructureElement : structureModelToSearch.getStructureElement()) {
			
			if(abstractStructureElement instanceof Layer){
				
				allSoftwareSystem.addAll(this.getAllSoftwareSystemFrom((Layer) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Component){
				
				allSoftwareSystem.addAll(this.getAllSoftwareSystemFrom((Component) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Subsystem){
				
				allSoftwareSystem.addAll(this.getAllSoftwareSystemFrom((Subsystem) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof ArchitectureView){
				
				allSoftwareSystem.addAll(this.getAllSoftwareSystemFrom((ArchitectureView) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof SoftwareSystem){
				
				if (validateFilter((SoftwareSystem) abstractStructureElement)) {
					allSoftwareSystem.add((SoftwareSystem) abstractStructureElement);
				}
				allSoftwareSystem.addAll(this.getAllSoftwareSystemFrom((SoftwareSystem) abstractStructureElement));
				
			}
		}
		
		return allSoftwareSystem;
	}
	
	private List<SoftwareSystem> getAllSoftwareSystemFrom(Layer layerToSearch) {
		List<SoftwareSystem> allSoftwareSystem = new ArrayList<SoftwareSystem>();
		
		for (AbstractStructureElement abstractStructureElement : layerToSearch.getStructureElement()) {
			
			if(abstractStructureElement instanceof Layer){
				
				allSoftwareSystem.addAll(this.getAllSoftwareSystemFrom((Layer) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Component){
				
				allSoftwareSystem.addAll(this.getAllSoftwareSystemFrom((Component) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Subsystem){
				
				allSoftwareSystem.addAll(this.getAllSoftwareSystemFrom((Subsystem) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof ArchitectureView){
				
				allSoftwareSystem.addAll(this.getAllSoftwareSystemFrom((ArchitectureView) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof SoftwareSystem){
				
				if (validateFilter((SoftwareSystem) abstractStructureElement)) {
					allSoftwareSystem.add((SoftwareSystem) abstractStructureElement);
				}
				allSoftwareSystem.addAll(this.getAllSoftwareSystemFrom((SoftwareSystem) abstractStructureElement));
				
			}
		}
		
		return allSoftwareSystem;
	}
	
	private List<SoftwareSystem> getAllSoftwareSystemFrom(Component componentToSearch) {
		List<SoftwareSystem> allSoftwareSystem = new ArrayList<SoftwareSystem>();
		
		for (AbstractStructureElement abstractStructureElement : componentToSearch.getStructureElement()) {
			
			if(abstractStructureElement instanceof Layer){
				
				allSoftwareSystem.addAll(this.getAllSoftwareSystemFrom((Layer) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Component){
				
				allSoftwareSystem.addAll(this.getAllSoftwareSystemFrom((Component) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Subsystem){
				
				allSoftwareSystem.addAll(this.getAllSoftwareSystemFrom((Subsystem) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof ArchitectureView){
				
				allSoftwareSystem.addAll(this.getAllSoftwareSystemFrom((ArchitectureView) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof SoftwareSystem){
				
				if (validateFilter((SoftwareSystem) abstractStructureElement)) {
					allSoftwareSystem.add((SoftwareSystem) abstractStructureElement);
				}
				allSoftwareSystem.addAll(this.getAllSoftwareSystemFrom((SoftwareSystem) abstractStructureElement));
				
			}
		}
		
		return allSoftwareSystem;
	}
	
	private List<SoftwareSystem> getAllSoftwareSystemFrom(Subsystem subsystemToSearch) {
		List<SoftwareSystem> allSoftwareSystem = new ArrayList<SoftwareSystem>();
		
		for (AbstractStructureElement abstractStructureElement : subsystemToSearch.getStructureElement()) {
			
			if(abstractStructureElement instanceof Layer){
				
				allSoftwareSystem.addAll(this.getAllSoftwareSystemFrom((Layer) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Component){
				
				allSoftwareSystem.addAll(this.getAllSoftwareSystemFrom((Component) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Subsystem){
				
				allSoftwareSystem.addAll(this.getAllSoftwareSystemFrom((Subsystem) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof ArchitectureView){
				
				allSoftwareSystem.addAll(this.getAllSoftwareSystemFrom((ArchitectureView) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof SoftwareSystem){
				
				if (validateFilter((SoftwareSystem) abstractStructureElement)) {
					allSoftwareSystem.add((SoftwareSystem) abstractStructureElement);
				}
				allSoftwareSystem.addAll(this.getAllSoftwareSystemFrom((SoftwareSystem) abstractStructureElement));
				
			}
		}
		
		return allSoftwareSystem;
	}
	
	private List<SoftwareSystem> getAllSoftwareSystemFrom(ArchitectureView architectureViewToSearch) {
		List<SoftwareSystem> allSoftwareSystem = new ArrayList<SoftwareSystem>();
		
		for (AbstractStructureElement abstractStructureElement : architectureViewToSearch.getStructureElement()) {
			
			if(abstractStructureElement instanceof Layer){
				
				allSoftwareSystem.addAll(this.getAllSoftwareSystemFrom((Layer) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Component){
				
				allSoftwareSystem.addAll(this.getAllSoftwareSystemFrom((Component) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Subsystem){
				
				allSoftwareSystem.addAll(this.getAllSoftwareSystemFrom((Subsystem) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof ArchitectureView){
				
				allSoftwareSystem.addAll(this.getAllSoftwareSystemFrom((ArchitectureView) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof SoftwareSystem){
				
				if (validateFilter((SoftwareSystem) abstractStructureElement)) {
					allSoftwareSystem.add((SoftwareSystem) abstractStructureElement);
				}
				allSoftwareSystem.addAll(this.getAllSoftwareSystemFrom((SoftwareSystem) abstractStructureElement));
				
			}
		}
		
		return allSoftwareSystem;
	}
	
	private List<SoftwareSystem> getAllSoftwareSystemFrom(SoftwareSystem softwareSystemToSearch) {
		List<SoftwareSystem> allSoftwareSystem = new ArrayList<SoftwareSystem>();

		for (AbstractStructureElement abstractStructureElement : softwareSystemToSearch.getStructureElement()) {
			
			if(abstractStructureElement instanceof Layer){
				
				allSoftwareSystem.addAll(this.getAllSoftwareSystemFrom((Layer) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Component){
				
				allSoftwareSystem.addAll(this.getAllSoftwareSystemFrom((Component) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Subsystem){
				
				allSoftwareSystem.addAll(this.getAllSoftwareSystemFrom((Subsystem) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof ArchitectureView){
				
				allSoftwareSystem.addAll(this.getAllSoftwareSystemFrom((ArchitectureView) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof SoftwareSystem){
				
				if (validateFilter((SoftwareSystem) abstractStructureElement)) {
					allSoftwareSystem.add((SoftwareSystem) abstractStructureElement);
				}
				allSoftwareSystem.addAll(this.getAllSoftwareSystemFrom((SoftwareSystem) abstractStructureElement));
				
			}
		}
		
		return allSoftwareSystem;
	}
}
