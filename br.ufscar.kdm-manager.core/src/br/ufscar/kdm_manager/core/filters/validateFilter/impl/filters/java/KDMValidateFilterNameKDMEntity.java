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
package br.ufscar.kdm_manager.core.filters.validateFilter.impl.filters.java;

import org.eclipse.gmt.modisco.omg.kdm.core.KDMEntity;

import br.ufscar.kdm_manager.core.filters.validateFilter.interfaces.KDMValidateFilter;

public class KDMValidateFilterNameKDMEntity implements KDMValidateFilter<KDMEntity, String> {

	private String value;
	
	@Override
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public boolean validateElement(KDMEntity elementToValidate) {
		return elementToValidate.getName().equalsIgnoreCase(this.value);
	}

	

}
