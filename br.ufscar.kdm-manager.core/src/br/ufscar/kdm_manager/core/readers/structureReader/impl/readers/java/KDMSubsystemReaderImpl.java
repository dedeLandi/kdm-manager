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

public class KDMSubsystemReaderImpl implements KDMStructureGenericReader<Subsystem>{

	private boolean hasNoFilter = true;
	private boolean hasFilter = false;

	private ValidateFilter<Subsystem, ?> filter = null;

	public KDMSubsystemReaderImpl() {
		super();
	}

	public KDMSubsystemReaderImpl(ValidateFilter<Subsystem, ?> filter) {
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
