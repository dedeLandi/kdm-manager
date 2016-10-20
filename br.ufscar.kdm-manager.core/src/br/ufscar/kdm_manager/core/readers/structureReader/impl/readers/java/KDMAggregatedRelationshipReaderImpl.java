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

import org.eclipse.gmt.modisco.omg.kdm.core.AggregatedRelationship;
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

public class KDMAggregatedRelationshipReaderImpl implements KDMStructureGenericReader<AggregatedRelationship>{

	private boolean hasNoFilter = true;
	private boolean hasFilter = false;

	private ValidateFilter<AggregatedRelationship, ?> filter = null;

	public KDMAggregatedRelationshipReaderImpl() {
		super();
	}

	public KDMAggregatedRelationshipReaderImpl(ValidateFilter<AggregatedRelationship, ?> filter) {
		this.hasNoFilter = false;
		this.hasFilter  = true;
		this.filter = filter;
	}

	private boolean validateFilter(AggregatedRelationship elementToValidate) {
		if(this.hasNoFilter){
			return true;
		}else if(this.hasFilter){
			return this.filter.validateElement(elementToValidate);
		}
		return false;
	}

	@Override
	public List<AggregatedRelationship> getAllFrom(Segment segmentToSearch) {
		List<AggregatedRelationship> layersPerModel = new ArrayList<AggregatedRelationship>();

		Map<String, List<StructureModel>> models = KDMModelReaderJavaFactory.eINSTANCE.createKDMStructureModelReader().getAllFromSegment(segmentToSearch);

		for (String nameStructureModel : models.keySet()) {

			for (StructureModel structureModel : models.get(nameStructureModel)) {

				layersPerModel.addAll(this.getAllAggregatedRelationshipFrom(structureModel));
			}
		}

		return layersPerModel;
	}

	@Override
	public List<AggregatedRelationship> getAllFrom(StructureModel structureModelToSearch) {
		return this.getAllAggregatedRelationshipFrom(structureModelToSearch);
	}

	@Override
	public List<AggregatedRelationship> getAllFrom(SoftwareSystem softwareSystemToSearch) {
		return this.getAllAggregatedRelationshipFrom(softwareSystemToSearch);
	}

	@Override
	public List<AggregatedRelationship> getAllFrom(Subsystem subsystemToSearch) {
		return this.getAllAggregatedRelationshipFrom(subsystemToSearch);
	}

	@Override
	public List<AggregatedRelationship> getAllFrom(ArchitectureView architectureViewToSearch) {
		return this.getAllAggregatedRelationshipFrom(architectureViewToSearch);
	}

	@Override
	public List<AggregatedRelationship> getAllFrom(Layer layerToSearch) {
		return this.getAllAggregatedRelationshipFrom(layerToSearch);
	}

	@Override
	public List<AggregatedRelationship> getAllFrom(Component componentToSearch) {
		return this.getAllAggregatedRelationshipFrom(componentToSearch);
	}	

	private List<AggregatedRelationship> getAllAggregatedRelationshipFrom(StructureModel structureModelToSearch) {
		List<AggregatedRelationship> allAggregatedRelationships = new ArrayList<AggregatedRelationship>();

		for (AbstractStructureElement abstractStructureElement : structureModelToSearch.getStructureElement()) {

			if(abstractStructureElement instanceof Layer){

				allAggregatedRelationships.addAll(this.getAllAggregatedRelationshipFrom((Layer) abstractStructureElement));

			}else if(abstractStructureElement instanceof Component){

				allAggregatedRelationships.addAll(this.getAllAggregatedRelationshipFrom((Component) abstractStructureElement));

			}else if(abstractStructureElement instanceof Subsystem){

				allAggregatedRelationships.addAll(this.getAllAggregatedRelationshipFrom((Subsystem) abstractStructureElement));

			}else if(abstractStructureElement instanceof ArchitectureView){

				allAggregatedRelationships.addAll(this.getAllAggregatedRelationshipFrom((ArchitectureView) abstractStructureElement));

			}else if(abstractStructureElement instanceof SoftwareSystem){

				allAggregatedRelationships.addAll(this.getAllAggregatedRelationshipFrom((SoftwareSystem) abstractStructureElement));

			}
		}

		return allAggregatedRelationships;
	}

	private List<AggregatedRelationship> getAllAggregatedRelationshipFrom(Layer layerToSearch) {
		List<AggregatedRelationship> allAggregatedRelationships = new ArrayList<AggregatedRelationship>();

		for (AggregatedRelationship aggregatedRelationship : layerToSearch.getAggregated()) {
			if (validateFilter((AggregatedRelationship) aggregatedRelationship)) {
				allAggregatedRelationships.add((AggregatedRelationship) aggregatedRelationship);
			}
		}

		for (AbstractStructureElement abstractStructureElement : layerToSearch.getStructureElement()) {

			if(abstractStructureElement instanceof Layer){

				allAggregatedRelationships.addAll(this.getAllAggregatedRelationshipFrom((Layer) abstractStructureElement));

			}else if(abstractStructureElement instanceof Component){

				allAggregatedRelationships.addAll(this.getAllAggregatedRelationshipFrom((Component) abstractStructureElement));

			}else if(abstractStructureElement instanceof Subsystem){

				allAggregatedRelationships.addAll(this.getAllAggregatedRelationshipFrom((Subsystem) abstractStructureElement));

			}else if(abstractStructureElement instanceof ArchitectureView){

				allAggregatedRelationships.addAll(this.getAllAggregatedRelationshipFrom((ArchitectureView) abstractStructureElement));

			}else if(abstractStructureElement instanceof SoftwareSystem){

				allAggregatedRelationships.addAll(this.getAllAggregatedRelationshipFrom((SoftwareSystem) abstractStructureElement));

			}
		}

		return allAggregatedRelationships;
	}

	private List<AggregatedRelationship> getAllAggregatedRelationshipFrom(Component componentToSearch) {
		List<AggregatedRelationship> allAggregatedRelationships = new ArrayList<AggregatedRelationship>();

		for (AggregatedRelationship aggregatedRelationship : componentToSearch.getAggregated()) {
			if (validateFilter((AggregatedRelationship) aggregatedRelationship)) {
				allAggregatedRelationships.add((AggregatedRelationship) aggregatedRelationship);
			}
		}
		
		for (AbstractStructureElement abstractStructureElement : componentToSearch.getStructureElement()) {

			if(abstractStructureElement instanceof Layer){

				allAggregatedRelationships.addAll(this.getAllAggregatedRelationshipFrom((Layer) abstractStructureElement));

			}else if(abstractStructureElement instanceof Component){

				allAggregatedRelationships.addAll(this.getAllAggregatedRelationshipFrom((Component) abstractStructureElement));

			}else if(abstractStructureElement instanceof Subsystem){

				allAggregatedRelationships.addAll(this.getAllAggregatedRelationshipFrom((Subsystem) abstractStructureElement));

			}else if(abstractStructureElement instanceof ArchitectureView){

				allAggregatedRelationships.addAll(this.getAllAggregatedRelationshipFrom((ArchitectureView) abstractStructureElement));

			}else if(abstractStructureElement instanceof SoftwareSystem){

				allAggregatedRelationships.addAll(this.getAllAggregatedRelationshipFrom((SoftwareSystem) abstractStructureElement));

			}
		}

		return allAggregatedRelationships;
	}

	private List<AggregatedRelationship> getAllAggregatedRelationshipFrom(Subsystem subsystemToSearch) {
		List<AggregatedRelationship> allAggregatedRelationships = new ArrayList<AggregatedRelationship>();

		for (AggregatedRelationship aggregatedRelationship : subsystemToSearch.getAggregated()) {
			if (validateFilter((AggregatedRelationship) aggregatedRelationship)) {
				allAggregatedRelationships.add((AggregatedRelationship) aggregatedRelationship);
			}
		}
		
		for (AbstractStructureElement abstractStructureElement : subsystemToSearch.getStructureElement()) {

			if(abstractStructureElement instanceof Layer){

				allAggregatedRelationships.addAll(this.getAllAggregatedRelationshipFrom((Layer) abstractStructureElement));

			}else if(abstractStructureElement instanceof Component){

				allAggregatedRelationships.addAll(this.getAllAggregatedRelationshipFrom((Component) abstractStructureElement));

			}else if(abstractStructureElement instanceof Subsystem){

				allAggregatedRelationships.addAll(this.getAllAggregatedRelationshipFrom((Subsystem) abstractStructureElement));

			}else if(abstractStructureElement instanceof ArchitectureView){

				allAggregatedRelationships.addAll(this.getAllAggregatedRelationshipFrom((ArchitectureView) abstractStructureElement));

			}else if(abstractStructureElement instanceof SoftwareSystem){

				allAggregatedRelationships.addAll(this.getAllAggregatedRelationshipFrom((SoftwareSystem) abstractStructureElement));

			}
		}

		return allAggregatedRelationships;
	}

	private List<AggregatedRelationship> getAllAggregatedRelationshipFrom(ArchitectureView architectureViewToSearch) {
		List<AggregatedRelationship> allAggregatedRelationships = new ArrayList<AggregatedRelationship>();

		for (AggregatedRelationship aggregatedRelationship : architectureViewToSearch.getAggregated()) {
			if (validateFilter((AggregatedRelationship) aggregatedRelationship)) {
				allAggregatedRelationships.add((AggregatedRelationship) aggregatedRelationship);
			}
		}
		
		for (AbstractStructureElement abstractStructureElement : architectureViewToSearch.getStructureElement()) {

			if(abstractStructureElement instanceof Layer){

				allAggregatedRelationships.addAll(this.getAllAggregatedRelationshipFrom((Layer) abstractStructureElement));

			}else if(abstractStructureElement instanceof Component){

				allAggregatedRelationships.addAll(this.getAllAggregatedRelationshipFrom((Component) abstractStructureElement));

			}else if(abstractStructureElement instanceof Subsystem){

				allAggregatedRelationships.addAll(this.getAllAggregatedRelationshipFrom((Subsystem) abstractStructureElement));

			}else if(abstractStructureElement instanceof ArchitectureView){

				allAggregatedRelationships.addAll(this.getAllAggregatedRelationshipFrom((ArchitectureView) abstractStructureElement));

			}else if(abstractStructureElement instanceof SoftwareSystem){

				allAggregatedRelationships.addAll(this.getAllAggregatedRelationshipFrom((SoftwareSystem) abstractStructureElement));

			}
		}

		return allAggregatedRelationships;
	}

	private List<AggregatedRelationship> getAllAggregatedRelationshipFrom(SoftwareSystem softwareSystemToSearch) {
		List<AggregatedRelationship> allAggregatedRelationships = new ArrayList<AggregatedRelationship>();

		for (AggregatedRelationship aggregatedRelationship : softwareSystemToSearch.getAggregated()) {
			if (validateFilter((AggregatedRelationship) aggregatedRelationship)) {
				allAggregatedRelationships.add((AggregatedRelationship) aggregatedRelationship);
			}
		}
		
		for (AbstractStructureElement abstractStructureElement : softwareSystemToSearch.getStructureElement()) {

			if(abstractStructureElement instanceof Layer){

				allAggregatedRelationships.addAll(this.getAllAggregatedRelationshipFrom((Layer) abstractStructureElement));

			}else if(abstractStructureElement instanceof Component){

				allAggregatedRelationships.addAll(this.getAllAggregatedRelationshipFrom((Component) abstractStructureElement));

			}else if(abstractStructureElement instanceof Subsystem){

				allAggregatedRelationships.addAll(this.getAllAggregatedRelationshipFrom((Subsystem) abstractStructureElement));

			}else if(abstractStructureElement instanceof ArchitectureView){

				allAggregatedRelationships.addAll(this.getAllAggregatedRelationshipFrom((ArchitectureView) abstractStructureElement));

			}else if(abstractStructureElement instanceof SoftwareSystem){

				allAggregatedRelationships.addAll(this.getAllAggregatedRelationshipFrom((SoftwareSystem) abstractStructureElement));

			}
		}

		return allAggregatedRelationships;
	}
}
