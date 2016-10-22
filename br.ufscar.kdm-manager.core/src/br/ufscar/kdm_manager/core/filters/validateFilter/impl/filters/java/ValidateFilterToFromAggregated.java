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

import org.eclipse.gmt.modisco.omg.kdm.core.AggregatedRelationship;
import org.eclipse.gmt.modisco.omg.kdm.core.KDMEntity;

import br.ufscar.kdm_manager.core.filters.validateFilter.interfaces.ValidateFilter;

/**
 * @author Landi
 *
 */
public class ValidateFilterToFromAggregated implements ValidateFilter<AggregatedRelationship, KDMEntity[]> {

	private KDMEntity elementToToAvaliate = null;
	private KDMEntity elementFromToAvaliate = null;
	
	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.filters.validateFilter.interfaces.ValidateFilter#setValue(java.lang.Object)
	 */
	@Override
	public void setValue(KDMEntity[] elementToAvaliate) {
		this.elementToToAvaliate = elementToAvaliate[0];
		this.elementFromToAvaliate = elementToAvaliate[1];
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.filters.validateFilter.interfaces.ValidateFilter#validateElement(java.lang.Object)
	 */
	@Override
	public boolean validateElement(AggregatedRelationship elementToValidate) {
		return this.elementToToAvaliate.equals(elementToValidate.getTo()) && this.elementFromToAvaliate.equals(elementToValidate.getFrom());
	}


}
