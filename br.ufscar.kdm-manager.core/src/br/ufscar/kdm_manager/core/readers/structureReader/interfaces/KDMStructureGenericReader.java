package br.ufscar.kdm_manager.core.readers.structureReader.interfaces;

import java.util.List;

import org.eclipse.gmt.modisco.omg.kdm.kdm.Segment;
import org.eclipse.gmt.modisco.omg.kdm.structure.ArchitectureView;
import org.eclipse.gmt.modisco.omg.kdm.structure.Component;
import org.eclipse.gmt.modisco.omg.kdm.structure.Layer;
import org.eclipse.gmt.modisco.omg.kdm.structure.SoftwareSystem;
import org.eclipse.gmt.modisco.omg.kdm.structure.StructureModel;
import org.eclipse.gmt.modisco.omg.kdm.structure.Subsystem;

public interface  KDMStructureGenericReader<T> {

	public List<T> getAllFrom(Segment segmentToSearch);
	
	public List<T> getAllFrom(StructureModel structureModelToSearch);
	
	public List<T> getAllFrom(SoftwareSystem softwareSystemToSearch);
	
	public List<T> getAllFrom(Subsystem subsystemToSearch);
	
	public List<T> getAllFrom(ArchitectureView architectureViewToSearch);
	
	public List<T> getAllFrom(Layer layerToSearch);

	public List<T> getAllFrom(Component componentToSearch);
	
}
