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

import br.ufscar.kdm_manager.core.readers.modelReader.factory.KDMModelReaderJavaFactory;
import br.ufscar.kdm_manager.core.readers.structureReader.interfaces.KDMStructureGenericReader;

public class KDMLayerReaderImpl implements KDMStructureGenericReader<Layer>{

	private boolean hasNoFilter = false;
	private boolean hasFilterName = false;

	private String filterName = "";

	public KDMLayerReaderImpl() {
		super();
	}

	public KDMLayerReaderImpl(String elementName) {
		this.hasNoFilter = false;
		this.hasFilterName  = true;
		this.filterName = elementName;
	}
	
	private boolean validateFilter(Layer elementToValidate) {
		if(this.hasNoFilter){
			return true;
		}else if(this.hasFilterName){
			if(elementToValidate.getName().equalsIgnoreCase(this.filterName)){
				return true;
			}
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
