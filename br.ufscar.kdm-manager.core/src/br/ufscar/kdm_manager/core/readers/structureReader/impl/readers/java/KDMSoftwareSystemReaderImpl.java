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

public class KDMSoftwareSystemReaderImpl implements KDMStructureGenericReader<SoftwareSystem>{

	private boolean hasNoFilter = false;
	private boolean hasFilterName = false;

	private String filterName = "";

	public KDMSoftwareSystemReaderImpl() {
		super();
	}

	public KDMSoftwareSystemReaderImpl(String elementName) {
		this.hasNoFilter = false;
		this.hasFilterName  = true;
		this.filterName = elementName;
	}
	
	private boolean validateFilter(SoftwareSystem elementToValidate) {
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
