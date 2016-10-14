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

public class KDMArchitectureViewReaderImpl implements KDMStructureGenericReader<ArchitectureView>{

	private boolean hasNoFilter = true;
	private boolean hasFilterName = false;

	private String filterName = "";

	public KDMArchitectureViewReaderImpl() {
		super();
	}

	public KDMArchitectureViewReaderImpl(String elementName) {
		this.hasNoFilter = false;
		this.hasFilterName  = true;
		this.filterName = elementName;
	}
	
	private boolean validateFilter(ArchitectureView elementToValidate) {
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
