package br.ufscar.kdm_manager.core.readers.modelReader.impl.readers.java;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.gmt.modisco.omg.kdm.kdm.KDMModel;
import org.eclipse.gmt.modisco.omg.kdm.kdm.Segment;
import org.eclipse.gmt.modisco.omg.kdm.structure.StructureModel;

import br.ufscar.kdm_manager.core.readers.modelReader.interfaces.KDMModelGenericReader;

public class KDMStructureModelReaderImpl implements KDMModelGenericReader<Map<String, List<StructureModel>>,Segment> {
	
	private boolean hasNoFilter = false;
	private boolean hasFilterName = false;

	private String filterName = "";

	public KDMStructureModelReaderImpl() {
		super();
	}

	public KDMStructureModelReaderImpl(String elementName) {
		this.hasNoFilter = false;
		this.hasFilterName  = true;
		this.filterName = elementName;
	}
	
	private boolean validateFilter(StructureModel elementToValidate) {
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
	public Map<String, List<StructureModel>> getAllFromSegment(Segment segmentToSearch) {
		Map<String, List<StructureModel>> models = new HashMap<String, List<StructureModel>>();

		for (KDMModel kdmModel : segmentToSearch.getModel()) {

			if(kdmModel instanceof StructureModel){

				if(validateFilter((StructureModel)kdmModel)){
					models.put(kdmModel.getName(), new ArrayList<StructureModel>());
					
					models.get(kdmModel.getName()).add((StructureModel)kdmModel);
				}
				

			}
		}
		
		return models;
	}
}