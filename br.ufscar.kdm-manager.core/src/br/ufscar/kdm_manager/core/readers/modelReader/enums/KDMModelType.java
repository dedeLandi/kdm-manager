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
package br.ufscar.kdm_manager.core.readers.modelReader.enums;

import org.eclipse.gmt.modisco.omg.kdm.build.BuildModel;
import org.eclipse.gmt.modisco.omg.kdm.code.CodeModel;
import org.eclipse.gmt.modisco.omg.kdm.conceptual.ConceptualModel;
import org.eclipse.gmt.modisco.omg.kdm.data.DataModel;
import org.eclipse.gmt.modisco.omg.kdm.event.EventModel;
import org.eclipse.gmt.modisco.omg.kdm.kdm.KDMModel;
import org.eclipse.gmt.modisco.omg.kdm.platform.PlatformModel;
import org.eclipse.gmt.modisco.omg.kdm.source.InventoryModel;
import org.eclipse.gmt.modisco.omg.kdm.structure.StructureModel;
import org.eclipse.gmt.modisco.omg.kdm.ui.UIModel;

import br.ufscar.kdm_manager.core.readers.modelReader.interfaces.IKDMModelType;

public enum KDMModelType implements IKDMModelType<KDMModel,KDMModel>{

	BUILD_MODEL ("BuildModel"){
		public BuildModel convertModelByType(KDMModel kdmModel) {
			return (BuildModel) kdmModel;
		}
	},
	
	CODE_MODEL ("CodeModel"){
		public CodeModel convertModelByType(KDMModel kdmModel) {
			return (CodeModel) kdmModel;
		}
	},
	
	CONCEPTUAL_MODEL ("ConceptualModel"){
		public ConceptualModel convertModelByType(KDMModel kdmModel) {
			return (ConceptualModel) kdmModel;
		}
	},
	
	DATA_MODEL ("DataModel"){
		public DataModel convertModelByType(KDMModel kdmModel) {
			return (DataModel) kdmModel;
		}
	},
	
	EVENT_MODEL ("EventModel"){
		public EventModel convertModelByType(KDMModel kdmModel) {
			return (EventModel) kdmModel;
		}
	},
	
	INVENTORY_MODEL ("InventoryModel"){
		public InventoryModel convertModelByType(KDMModel kdmModel) {
			return (InventoryModel) kdmModel;
		}
	},
	
	PLATFORM_MODEL ("PlatformModel"){
		public PlatformModel convertModelByType(KDMModel kdmModel) {
			return (PlatformModel) kdmModel;
		}
	},
	
	STRUCTURE_MODEL ("StructureModel"){
		public StructureModel convertModelByType(KDMModel kdmModel) {
			return (StructureModel) kdmModel;
		}
	},
	
	UI_MODEL ("UIModel"){
		public UIModel convertModelByType(KDMModel kdmModel) {
			return (UIModel) kdmModel;
		}
	};
	
	private String typeModel;
	
	private KDMModelType(String typeModel) {
		this.typeModel = typeModel;
	}
	
	public String getTypeModel() {
		return typeModel;
	}
}
