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

import br.ufscar.kdm_manager.core.readers.relationshipReader.factory.KDMRelationshipReaderJavaFactory;
import br.ufscar.kdm_manager.core.readers.relationshipReader.interfaces.KDMITypeRelations;
import br.ufscar.kdm_manager.core.readers.relationshipReader.interfaces.KDMRelationshipGenericReader;

/**
 * @author Landi
 *
 */
public enum KDMTypeRelations implements KDMITypeRelations{

	CALLS		("Calls", 		Calls.class){
		@Override
		public KDMRelationshipGenericReader<?> getReader() {
			return KDMRelationshipReaderJavaFactory.eINSTANCE.createCallsRecover();
		}
		@Override
		public String getPatternLoC() {
			return "#1 .(access) #2() | new #2()";
		}
	},
	CREATES		("Creates", 	Creates.class){
		@Override
		public KDMRelationshipGenericReader<?> getReader() {
			return KDMRelationshipReaderJavaFactory.eINSTANCE.createCreatesRecover();
		}
		@Override
		public String getPatternLoC() {
			return "#1 = new #2()";
		}
	},
	READS		("Reads", 		Reads.class){
		@Override
		public KDMRelationshipGenericReader<?> getReader() {
			return KDMRelationshipReaderJavaFactory.eINSTANCE.createReadsRecover();
		}
		@Override
		public String getPatternLoC() {
			return "#1 .(read) #2";
		}
	},
	USES_TYPE	("UsesType", 	UsesType.class){
		@Override
		public KDMRelationshipGenericReader<?> getReader() {
			return KDMRelationshipReaderJavaFactory.eINSTANCE.createUsesTypeRecover();
		}
		@Override
		public String getPatternLoC() {
			return "#1 is type of #2";
		}
	},
	WRITES		("Writes", 		Writes.class){
		@Override
		public KDMRelationshipGenericReader<?> getReader() {
			return KDMRelationshipReaderJavaFactory.eINSTANCE.createWritesRecover();
		}
		@Override
		public String getPatternLoC() {
			return "#1 =(assignment) #2";
		}
	},
	EXTENDS		("Extends", 	Extends.class){
		@Override
		public KDMRelationshipGenericReader<?> getReader() {
			return KDMRelationshipReaderJavaFactory.eINSTANCE.createExtendsRecover();
		}
		@Override
		public String getPatternLoC() {
			return "#1 extends #2";
		}
	},
	HAS_TYPE	("HasType", 	HasType.class){
		@Override
		public KDMRelationshipGenericReader<?> getReader() {
			return KDMRelationshipReaderJavaFactory.eINSTANCE.createHasTypeRecover();
		}
		@Override
		public String getPatternLoC() {
			return "#1 initial value is #2";
		}
	},
	HAS_VALUE	("HasValue", 	HasValue.class){
		@Override
		public KDMRelationshipGenericReader<?> getReader() {
			return KDMRelationshipReaderJavaFactory.eINSTANCE.createHasValueRecover();
		}
		@Override
		public String getPatternLoC() {
			return "#1 actual value is  #2";
		}
	},
	IMPLEMENTS	("Implements", 	Implements.class){
		@Override
		public KDMRelationshipGenericReader<?> getReader() {
			return KDMRelationshipReaderJavaFactory.eINSTANCE.createImplementsRecover();
		}
		@Override
		public String getPatternLoC() {
			return "#1 implements #2";
		}
	},
	IMPORTS		("Imports", 	Imports.class){
		@Override
		public KDMRelationshipGenericReader<?> getReader() {
			return KDMRelationshipReaderJavaFactory.eINSTANCE.createImportsRecover();
		}
		@Override
		public String getPatternLoC() {
			return "#1 imports #2";
		}
	};
	
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
