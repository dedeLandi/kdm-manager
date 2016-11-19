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
package br.ufscar.kdm_manager.core.readers.modelReader.impl.readers.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.gmt.modisco.omg.kdm.kdm.KDMModel;
import org.eclipse.gmt.modisco.omg.kdm.kdm.Segment;
import org.eclipse.gmt.modisco.omg.kdm.structure.StructureModel;

import br.ufscar.kdm_manager.core.filters.validateFilter.interfaces.KDMValidateFilter;
import br.ufscar.kdm_manager.core.readers.modelReader.interfaces.KDMModelGenericReader;

public class KDMStructureModelReaderImpl implements KDMModelGenericReader<Map<String, List<StructureModel>>,Segment> {
	
	private boolean hasNoFilter = true;
	private boolean hasFilter = false;

	private KDMValidateFilter<StructureModel, ?> filter = null;

	public KDMStructureModelReaderImpl() {
		super();
	}

	public KDMStructureModelReaderImpl(KDMValidateFilter<StructureModel, ?> filter) {
		this.hasNoFilter = false;
		this.hasFilter  = true;
		this.filter = filter;
	}
	
	private boolean validateFilter(StructureModel elementToValidate) {
		if(this.hasNoFilter){
			return true;
		}else if(this.hasFilter){
			return this.filter.validateElement(elementToValidate);
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
					//TODO Corrigir a criação da lista aqui
					models.get(kdmModel.getName()).add((StructureModel)kdmModel);
				}
				

			}
		}
		
		return models;
	}
}