package br.ufscar.kdm_manager.core.readers.modelReader.impl.readers.java;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.gmt.modisco.omg.kdm.build.BuildModel;
import org.eclipse.gmt.modisco.omg.kdm.code.CodeModel;
import org.eclipse.gmt.modisco.omg.kdm.conceptual.ConceptualModel;
import org.eclipse.gmt.modisco.omg.kdm.data.DataModel;
import org.eclipse.gmt.modisco.omg.kdm.event.EventModel;
import org.eclipse.gmt.modisco.omg.kdm.kdm.KDMModel;
import org.eclipse.gmt.modisco.omg.kdm.kdm.Segment;
import org.eclipse.gmt.modisco.omg.kdm.platform.PlatformModel;
import org.eclipse.gmt.modisco.omg.kdm.source.InventoryModel;
import org.eclipse.gmt.modisco.omg.kdm.structure.StructureModel;
import org.eclipse.gmt.modisco.omg.kdm.ui.UIModel;

import br.ufscar.kdm_manager.core.filters.validateFilter.interfaces.ValidateFilter;
import br.ufscar.kdm_manager.core.readers.modelReader.enums.KDMModelType;
import br.ufscar.kdm_manager.core.readers.modelReader.interfaces.KDMModelGenericReader;

public class KDMKDMModelReaderImpl implements KDMModelGenericReader<Map<String, List<KDMModel>>,Segment> {
	
	private boolean hasNoFilter = true;
	private boolean hasFilter = false;

	private ValidateFilter<KDMModel, ?> filter = null;

	public KDMKDMModelReaderImpl() {
		super();
	}

	public KDMKDMModelReaderImpl(ValidateFilter<KDMModel, ?> filter) {
		this.hasNoFilter = false;
		this.hasFilter  = true;
		this.filter = filter;
	}
	
	private boolean validateFilter(KDMModel elementToValidate) {
		if(this.hasNoFilter){
			return true;
		}else if(this.hasFilter){
			return this.filter.validateElement(elementToValidate);
		}
		return false;
	}	
	

	@Override
	public Map<String, List<KDMModel>> getAllFromSegment(Segment segmentToSearch) {
		Map<String, List<KDMModel>> models = new HashMap<String, List<KDMModel>>();

		models.put(KDMModelType.BUILD_MODEL.getTypeModel(), new ArrayList<>());
		models.put(KDMModelType.CODE_MODEL.getTypeModel(), new ArrayList<>());
		models.put(KDMModelType.CONCEPTUAL_MODEL.getTypeModel(), new ArrayList<>());
		models.put(KDMModelType.DATA_MODEL.getTypeModel(), new ArrayList<>());
		models.put(KDMModelType.EVENT_MODEL.getTypeModel(), new ArrayList<>());
		models.put(KDMModelType.INVENTORY_MODEL.getTypeModel(), new ArrayList<>());
		models.put(KDMModelType.PLATFORM_MODEL.getTypeModel(), new ArrayList<>());
		models.put(KDMModelType.STRUCTURE_MODEL.getTypeModel(), new ArrayList<>());
		models.put(KDMModelType.UI_MODEL.getTypeModel(), new ArrayList<>());
		
		
		for (KDMModel kdmModel : segmentToSearch.getModel()) {

			if(!validateFilter(kdmModel)){
				continue;
			}
			
			if(kdmModel instanceof BuildModel){

				models.get(KDMModelType.BUILD_MODEL.getTypeModel()).add(KDMModelType.BUILD_MODEL.convertModelByType(kdmModel));

			}else if(kdmModel instanceof CodeModel){

				models.get(KDMModelType.CODE_MODEL.getTypeModel()).add(KDMModelType.CODE_MODEL.convertModelByType(kdmModel));

			}else if(kdmModel instanceof ConceptualModel){

				models.get(KDMModelType.CONCEPTUAL_MODEL.getTypeModel()).add(KDMModelType.CONCEPTUAL_MODEL.convertModelByType(kdmModel));

			}else if(kdmModel instanceof DataModel){

				models.get(KDMModelType.DATA_MODEL.getTypeModel()).add(KDMModelType.DATA_MODEL.convertModelByType(kdmModel));

			}else if(kdmModel instanceof EventModel){

				models.get(KDMModelType.EVENT_MODEL.getTypeModel()).add(KDMModelType.EVENT_MODEL.convertModelByType(kdmModel));

			}else if(kdmModel instanceof InventoryModel){

				models.get(KDMModelType.INVENTORY_MODEL.getTypeModel()).add(KDMModelType.INVENTORY_MODEL.convertModelByType(kdmModel));

			}else if(kdmModel instanceof PlatformModel){

				models.get(KDMModelType.PLATFORM_MODEL.getTypeModel()).add(KDMModelType.PLATFORM_MODEL.convertModelByType(kdmModel));

			}else if (kdmModel instanceof StructureModel) {

				models.get(KDMModelType.STRUCTURE_MODEL.getTypeModel()).add(KDMModelType.STRUCTURE_MODEL.convertModelByType(kdmModel));

			}else if(kdmModel instanceof UIModel){

				models.get(KDMModelType.UI_MODEL.getTypeModel()).add(KDMModelType.UI_MODEL.convertModelByType(kdmModel));
				
			}
		}
		
		return models;
	}
}