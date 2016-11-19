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
package br.ufscar.kdm_manager.core.examplesOfUse;

import java.util.List;

import org.eclipse.gmt.modisco.omg.kdm.code.MethodUnit;
import org.eclipse.gmt.modisco.omg.kdm.kdm.Segment;

import br.ufscar.kdm_manager.core.exceptions.KDMFileException;
import br.ufscar.kdm_manager.core.loads.factory.KDMFileReaderFactory;
import br.ufscar.kdm_manager.core.readers.codeReader.factory.KDMCodeReaderJavaFactory;
import br.ufscar.kdm_manager.core.recovers.recoverHierarchy.factory.RecoverHierarchyJavaFactory;

public class RecoverHierarchyUse {

	public static void main(String[] args) {
		
		try {
			String pathKDMFile = "C:/Java/workspaceMestradoMars64/kdm-manager/br.ufscar.kdm-manager.core/tests/br/ufscar/kdm_manager/core/examplesOfUse/labSystemKDMComdesvios.xmi";
			
			Segment raizKDM = KDMFileReaderFactory.eINSTANCE.createKDMFileReaderToSegment().readFromPath(pathKDMFile);
			
//			ValidateFilter<?, ?> filter = ValidateFilterJavaFactory.eINSTANCE.createValidateFilterNameOfKDMEntity("StudentClassController");
//			List<MethodUnit> allMethods = KDMCodeReaderJavaFactory.eINSTANCE.createKDMMethodReaderWithFilter(filter).getAllFrom(raizKDM);
			List<MethodUnit> allMethods = KDMCodeReaderJavaFactory.eINSTANCE.createKDMMethodReader().getAllFrom(raizKDM);
			
			
			for (MethodUnit methodUnit : allMethods) {
				System.out.print("MethodUnit: " + methodUnit.getName() + " Caminho: ");
				System.err.println(RecoverHierarchyJavaFactory.eINSTANCE.createRecoverHierarchyCompleteArchitectural().getHierarchyOf(methodUnit));
				System.out.println();
			}
		} catch (KDMFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
