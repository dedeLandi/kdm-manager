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
package br.ufscar.kdm_manager.core.recovers.recoverRelationshipLoC.impl.recovers;

import java.util.List;

import org.eclipse.gmt.modisco.omg.kdm.core.KDMEntity;
import org.eclipse.gmt.modisco.omg.kdm.core.KDMRelationship;

import br.ufscar.kdm_manager.core.readers.relationshipReader.enums.KDMTypeRelations;
import br.ufscar.kdm_manager.core.recovers.recoverRelationshipLoC.interfaces.KDMRecoverGenericLoCRelationship;

/**
 * @author Landi
 *
 */
public class KDMRecoverLoCRelationship implements KDMRecoverGenericLoCRelationship<KDMRelationship> {

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.recovers.recoverRelationshipLoC.interfaces.KDMRecoverGenericLoCRelationship#getLoCPatternFromRelationship(java.lang.Object)
	 */
	@Override
	public String getLoCPatternFromRelationship(KDMRelationship relationship) {
		String possibleLoC = "";
		for (KDMTypeRelations typeRelationship : KDMTypeRelations.values()) {

			if(typeRelationship.getClassType().getName().contains(relationship.eClass().getName())){
				
				String[] patternLoC = typeRelationship.getPatternLoC().split("\\|");
				
				for (String pattern : patternLoC) {
					
					KDMEntity from = relationship.getFrom();
					KDMEntity to = relationship.getTo();
					
					String nameF = from.getName() == null ? "anonymous" : from.getName();
					String nameFrom = ("[?]".replace("?", from.eClass().getName())).concat(nameF);
					
					String LoC = pattern.replace("#1", nameFrom);
					
					String nameT = to.getName() == null ? "anonymous" : to.getName();
					String nameTo = ("[?]".replace("?", to.eClass().getName())).concat(nameT);
					
					LoC = LoC.replace("#2", nameTo);
					
					possibleLoC = possibleLoC.concat(LoC);
					
					if(!pattern.equalsIgnoreCase(patternLoC[patternLoC.length-1])){
						possibleLoC = possibleLoC.concat(" OR ");
					}
					
				}
			}
		}
		return possibleLoC;
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.recovers.recoverRelationshipLoC.interfaces.KDMRecoverGenericLoCRelationship#getLoCPatternFromRelationships(java.util.List)
	 */
	@Override
	public String getLoCPatternFromRelationships(List<KDMRelationship> relationships) {
		// TODO Auto-generated method stub
		return null;
	}

}
