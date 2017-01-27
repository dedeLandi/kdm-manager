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
package br.ufscar.kdm_manager.core.examplesOfUse.atlEngine.java;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmt.modisco.omg.kdm.core.CorePackage;

import br.ufscar.kdm_manager.core.executionEngines.atlEngine.abstractions.ATLExecutionEngine;
import br.ufscar.kdm_manager.core.executionEngines.atlEngine.factory.ATLExecutionEngineFactory;

/**
 * @author Landi
 *
 */
public class ExecutionExampleEMFTVM {

	public static void main(String[] args) {

		ATLExecutionEngine<String, Resource> atlRuns = ATLExecutionEngineFactory.eINSTANCE.createATLExecutionEngineEMFTVMcompiler();

		Map<String, Resource> metamodel = new HashMap<String, Resource>();
		metamodel.put("KDM", CorePackage.eINSTANCE.eResource());

		Map<String, String> modelsIn = new HashMap<String, String>();
		modelsIn.put("IN", "file:///C:\\Java\\workspaceMestradoMars64\\ExampleATL\\FONTES\\IN\\ProjetoTeste_kdm.xmi");

		Map<String, String> modelsOut = new HashMap<String, String>();
		modelsOut.put("OUT", "file:///C:\\Java\\workspaceMestradoMars64\\ExampleATL\\FONTES\\OUT\\ProjetoTeste_kdm_testeDennis_auto.xmi");

		Map<String, String> transformationModule = new HashMap<String, String>();
		transformationModule.put("testeDennis", "file:///C:\\Java\\workspaceMestradoMars64\\ExampleATL\\ATL\\TESTE-DENNIS\\");

		atlRuns.setMetamodelData(metamodel).setModelsInData(modelsIn).setModelsOutData(modelsOut).setTransformationModule(transformationModule).configureATLEngine();

		atlRuns.launch();

	}
	
}
