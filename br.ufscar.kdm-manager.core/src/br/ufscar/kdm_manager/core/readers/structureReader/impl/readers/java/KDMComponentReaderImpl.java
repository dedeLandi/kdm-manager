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

public class KDMComponentReaderImpl implements KDMStructureGenericReader<Component>{

	private boolean hasNoFilter = true;
	private boolean hasFilterName = false;

	private String filterName = "";

	public KDMComponentReaderImpl() {
		super();
	}

	public KDMComponentReaderImpl(String elementName) {
		this.hasNoFilter = false;
		this.hasFilterName  = true;
		this.filterName = elementName;
	}
	
	private boolean validateFilter(Component elementToValidate) {
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
