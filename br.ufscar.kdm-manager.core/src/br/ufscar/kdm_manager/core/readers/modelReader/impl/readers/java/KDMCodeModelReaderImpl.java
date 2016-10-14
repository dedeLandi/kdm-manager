package br.ufscar.kdm_manager.core.readers.modelReader.impl.readers.java;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.gmt.modisco.omg.kdm.code.CodeModel;
import org.eclipse.gmt.modisco.omg.kdm.kdm.KDMModel;
import org.eclipse.gmt.modisco.omg.kdm.kdm.Segment;

import br.ufscar.kdm_manager.core.readers.modelReader.interfaces.KDMModelGenericReader;

public class KDMCodeModelReaderImpl implements KDMModelGenericReader<Map<String, List<CodeModel>>,Segment> {
	
	private boolean hasNoFilter = true;
	private boolean hasFilterName = false;

	private String filterName = "";

	public KDMCodeModelReaderImpl() {
		super();
	}

	public KDMCodeModelReaderImpl(String elementName) {
		this.hasNoFilter = false;
		this.hasFilterName  = true;
		this.filterName = elementName;
	}
	
	private boolean validateFilter(CodeModel elementToValidate) {
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
	public Map<String, List<CodeModel>> getAllFromSegment(Segment segmentToSearch) {
		Map<String, List<CodeModel>> models = new HashMap<String, List<CodeModel>>();

		for (KDMModel kdmModel : segmentToSearch.getModel()) {

			if(kdmModel instanceof CodeModel){

				if(validateFilter((CodeModel)kdmModel)){
					models.put(kdmModel.getName(), new ArrayList<CodeModel>());
					
					models.get(kdmModel.getName()).add((CodeModel)kdmModel);
				}
				

			}
		}
		
		return models;
	}
}