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

public class KDMSubsystemReaderImpl implements KDMStructureGenericReader<Subsystem>{

	private boolean hasNoFilter = true;
	private boolean hasFilter = false;

	private KDMValidateFilter<Subsystem, ?> filter = null;

	public KDMSubsystemReaderImpl() {
		super();
	}

	public KDMSubsystemReaderImpl(KDMValidateFilter<Subsystem, ?> filter) {
		this.hasNoFilter = false;
		this.hasFilter  = true;
		this.filter = filter;
	}
	
	private boolean validateFilter(Subsystem elementToValidate) {
		if(this.hasNoFilter){
			return true;
		}else if(this.hasFilter){
			return this.filter.validateElement(elementToValidate);
		}
		return false;
	}

	@Override
	public List<Subsystem> getAllFrom(Segment segmentToSearch) {
		List<Subsystem> subsystemPerModel = new ArrayList<Subsystem>();

		Map<String, List<StructureModel>> models = KDMModelReaderJavaFactory.eINSTANCE.createKDMStructureModelReader().getAllFromSegment(segmentToSearch);

		for (String nameStructureModel : models.keySet()) {

			for (StructureModel structureModel : models.get(nameStructureModel)) {

				subsystemPerModel.addAll(this.getAllSubsystemFrom(structureModel));
			}
		}
		
		return subsystemPerModel;
	}

	@Override
	public List<Subsystem> getAllFrom(StructureModel structureModelToSearch) {
		return this.getAllSubsystemFrom(structureModelToSearch);
	}

	@Override
	public List<Subsystem> getAllFrom(SoftwareSystem softwareSystemToSearch) {
		return this.getAllSubsystemFrom(softwareSystemToSearch);
	}

	@Override
	public List<Subsystem> getAllFrom(Subsystem subsystemToSearch) {
		return this.getAllSubsystemFrom(subsystemToSearch);
	}

	@Override
	public List<Subsystem> getAllFrom(ArchitectureView architectureViewToSearch) {
		return this.getAllSubsystemFrom(architectureViewToSearch);
	}

	@Override
	public List<Subsystem> getAllFrom(Layer layerToSearch) {
		return this.getAllSubsystemFrom(layerToSearch);
	}

	@Override
	public List<Subsystem> getAllFrom(Component componentToSearch) {
		return this.getAllSubsystemFrom(componentToSearch);
	}	

	private List<Subsystem> getAllSubsystemFrom(StructureModel structureModelToSearch) {
		List<Subsystem> allSubsystem = new ArrayList<Subsystem>();
		
		for (AbstractStructureElement abstractStructureElement : structureModelToSearch.getStructureElement()) {
			
			if(abstractStructureElement instanceof Layer){
				
				allSubsystem.addAll(this.getAllSubsystemFrom((Layer) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Component){
				
				allSubsystem.addAll(this.getAllSubsystemFrom((Component) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Subsystem){
				
				if (validateFilter((Subsystem) abstractStructureElement)) {
					allSubsystem.add((Subsystem) abstractStructureElement);
				}
				allSubsystem.addAll(this.getAllSubsystemFrom((Subsystem) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof ArchitectureView){
				
				allSubsystem.addAll(this.getAllSubsystemFrom((ArchitectureView) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof SoftwareSystem){
				
				allSubsystem.addAll(this.getAllSubsystemFrom((SoftwareSystem) abstractStructureElement));
				
			}
		}
		
		return allSubsystem;
	}
	
	private List<Subsystem> getAllSubsystemFrom(Layer layerToSearch) {
		List<Subsystem> allSubsystem = new ArrayList<Subsystem>();
		
		for (AbstractStructureElement abstractStructureElement : layerToSearch.getStructureElement()) {
			
			if(abstractStructureElement instanceof Layer){
				
				allSubsystem.addAll(this.getAllSubsystemFrom((Layer) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Component){
				
				allSubsystem.addAll(this.getAllSubsystemFrom((Component) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Subsystem){
				
				if (validateFilter((Subsystem) abstractStructureElement)) {
					allSubsystem.add((Subsystem) abstractStructureElement);
				}
				allSubsystem.addAll(this.getAllSubsystemFrom((Subsystem) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof ArchitectureView){
				
				allSubsystem.addAll(this.getAllSubsystemFrom((ArchitectureView) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof SoftwareSystem){
				
				allSubsystem.addAll(this.getAllSubsystemFrom((SoftwareSystem) abstractStructureElement));
				
			}
		}
		
		return allSubsystem;
	}
	
	private List<Subsystem> getAllSubsystemFrom(Component componentToSearch) {
		List<Subsystem> allSubsystem = new ArrayList<Subsystem>();
		
		for (AbstractStructureElement abstractStructureElement : componentToSearch.getStructureElement()) {
			
			if(abstractStructureElement instanceof Layer){
				
				allSubsystem.addAll(this.getAllSubsystemFrom((Layer) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Component){
				
				allSubsystem.addAll(this.getAllSubsystemFrom((Component) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Subsystem){
				
				if (validateFilter((Subsystem) abstractStructureElement)) {
					allSubsystem.add((Subsystem) abstractStructureElement);
				}
				allSubsystem.addAll(this.getAllSubsystemFrom((Subsystem) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof ArchitectureView){
				
				allSubsystem.addAll(this.getAllSubsystemFrom((ArchitectureView) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof SoftwareSystem){
				
				allSubsystem.addAll(this.getAllSubsystemFrom((SoftwareSystem) abstractStructureElement));
				
			}
		}
		
		return allSubsystem;
	}
	
	private List<Subsystem> getAllSubsystemFrom(Subsystem subsystemToSearch) {
		List<Subsystem> allSubsystem = new ArrayList<Subsystem>();
		
		for (AbstractStructureElement abstractStructureElement : subsystemToSearch.getStructureElement()) {
			
			if(abstractStructureElement instanceof Layer){
				
				allSubsystem.addAll(this.getAllSubsystemFrom((Layer) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Component){
				
				allSubsystem.addAll(this.getAllSubsystemFrom((Component) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Subsystem){
				
				if (validateFilter((Subsystem) abstractStructureElement)) {
					allSubsystem.add((Subsystem) abstractStructureElement);
				}
				allSubsystem.addAll(this.getAllSubsystemFrom((Subsystem) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof ArchitectureView){
				
				allSubsystem.addAll(this.getAllSubsystemFrom((ArchitectureView) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof SoftwareSystem){
				
				allSubsystem.addAll(this.getAllSubsystemFrom((SoftwareSystem) abstractStructureElement));
				
			}
		}
		
		return allSubsystem;
	}
	
	private List<Subsystem> getAllSubsystemFrom(ArchitectureView architectureViewToSearch) {
		List<Subsystem> allSubsystem = new ArrayList<Subsystem>();
		
		for (AbstractStructureElement abstractStructureElement : architectureViewToSearch.getStructureElement()) {
			
			if(abstractStructureElement instanceof Layer){
				
				allSubsystem.addAll(this.getAllSubsystemFrom((Layer) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Component){
				
				allSubsystem.addAll(this.getAllSubsystemFrom((Component) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Subsystem){
				
				if (validateFilter((Subsystem) abstractStructureElement)) {
					allSubsystem.add((Subsystem) abstractStructureElement);
				}
				allSubsystem.addAll(this.getAllSubsystemFrom((Subsystem) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof ArchitectureView){
				
				allSubsystem.addAll(this.getAllSubsystemFrom((ArchitectureView) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof SoftwareSystem){
				
				allSubsystem.addAll(this.getAllSubsystemFrom((SoftwareSystem) abstractStructureElement));
				
			}
		}
		
		return allSubsystem;
	}
	
	private List<Subsystem> getAllSubsystemFrom(SoftwareSystem softwareSystemToSearch) {
		List<Subsystem> allSubsystem = new ArrayList<Subsystem>();

		for (AbstractStructureElement abstractStructureElement : softwareSystemToSearch.getStructureElement()) {
			
			if(abstractStructureElement instanceof Layer){
				
				allSubsystem.addAll(this.getAllSubsystemFrom((Layer) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Component){
				
				allSubsystem.addAll(this.getAllSubsystemFrom((Component) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof Subsystem){
				
				if (validateFilter((Subsystem) abstractStructureElement)) {
					allSubsystem.add((Subsystem) abstractStructureElement);
				}
				allSubsystem.addAll(this.getAllSubsystemFrom((Subsystem) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof ArchitectureView){
				
				allSubsystem.addAll(this.getAllSubsystemFrom((ArchitectureView) abstractStructureElement));
				
			}else if(abstractStructureElement instanceof SoftwareSystem){
				
				allSubsystem.addAll(this.getAllSubsystemFrom((SoftwareSystem) abstractStructureElement));
				
			}
		}
		
		return allSubsystem;
	}
}
