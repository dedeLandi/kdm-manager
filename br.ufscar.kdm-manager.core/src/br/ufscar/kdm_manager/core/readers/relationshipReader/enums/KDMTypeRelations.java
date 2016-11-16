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
package br.ufscar.kdm_manager.core.readers.relationshipReader.enums;

import org.eclipse.gmt.modisco.omg.kdm.action.Calls;
import org.eclipse.gmt.modisco.omg.kdm.action.Creates;
import org.eclipse.gmt.modisco.omg.kdm.action.Reads;
import org.eclipse.gmt.modisco.omg.kdm.action.UsesType;
import org.eclipse.gmt.modisco.omg.kdm.action.Writes;
import org.eclipse.gmt.modisco.omg.kdm.code.Extends;
import org.eclipse.gmt.modisco.omg.kdm.code.HasType;
import org.eclipse.gmt.modisco.omg.kdm.code.HasValue;
import org.eclipse.gmt.modisco.omg.kdm.code.Implements;
import org.eclipse.gmt.modisco.omg.kdm.code.Imports;

/**
 * @author Landi
 *
 */
public enum KDMTypeRelations {

	CALLS		("Calls", 		Calls.class),
	CREATES		("Creates", 	Creates.class),
	READS		("Reads", 		Reads.class),
	USES_TYPE	("UsesType", 	UsesType.class),
	WRITES		("Writes", 		Writes.class),
	EXTENDS		("Extends", 	Extends.class),
	HAS_TYPE	("HasType", 	HasType.class),
	HAS_VALUE	("HasValue", 	HasValue.class),
	IMPLEMENTS	("Implements", 	Implements.class),
	IMPORTS		("Imports", 	Imports.class);
	
	private String name;
	private Class<?> classType;

	private KDMTypeRelations(String name, Class<?> classType) {
		this.name = name;
		this.classType = classType;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the classType
	 */
	public Class<?> getClassType() {
		return classType;
	}

}
