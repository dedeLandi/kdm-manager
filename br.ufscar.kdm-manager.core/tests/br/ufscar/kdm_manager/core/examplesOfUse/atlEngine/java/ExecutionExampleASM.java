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

import br.ufscar.kdm_manager.core.executionEngines.atlEngine.abstractions.ATLExecutionEngine;
import br.ufscar.kdm_manager.core.executionEngines.atlEngine.factory.ATLExecutionEngineFactory;

/**
 * @author Landi
 *
 */
public class ExecutionExampleASM {

	/**
	 * @author Landi
	 * @param args
	 */
	public static void main(String[] args) {
		ATLExecutionEngine<Map<String, String>, Object[]> atlRuns = ATLExecutionEngineFactory.eINSTANCE.createATLExecutionEngineASMcompiler();
		//------------------------------------------------------------------------------------------------------------------------
		//Map<String, Object[]> metamodel = new HashMap<String, Object[]>();
		//				
		//Object metamodelData[] = new Object[2];
		//metamodelData[0]=org.eclipse.gmt.modisco.omg.kdm.kdm.KdmPackage.eINSTANCE;
		//metamodelData[1]="http://www.eclipse.org/MoDisco/kdm/kdm";
		//metamodel.put("KDM", metamodelData);
		//				
		//Object metamodelData2[] = new Object[2];
		//metamodelData2[0]=org.eclipse.gmt.modisco.omg.kdm.kdm.KdmPackage.eINSTANCE;
		//metamodelData2[1]="http://www.eclipse.org/MoDisco/kdm/kdm";
		//metamodel.put("KDM2", metamodelData2);
		//
		//Map<String, Map<String, String>> metamodelsInModels = new HashMap<String, Map<String, String>>();
		//
		//Map<String, String> KDMmodelsIn = new HashMap<>();
		//KDMmodelsIn.put("IN", "file:///C:\\Java\\workspaceMestradoMars64\\ExampleATL\\FONTES\\IN\\ProjetoTeste_kdm.xmi");
		//metamodelsInModels.put("KDM", KDMmodelsIn);
		//
		//Map<String, String> KDM2modelsIn = new HashMap<>();
		//KDM2modelsIn.put("IN2", "file:///C:\\Java\\workspaceMestradoMars64\\ExampleATL\\FONTES\\IN\\Estereotipos.xmi");
		//metamodelsInModels.put("KDM2", KDM2modelsIn);
		//
		////Map<String, String> modelsOut = new HashMap<String, String>();
		////modelsOut.put("OUT", "file:///C:\\Java\\workspaceMestradoMars64\\ExampleATL\\FONTES\\OUT\\ProjetoTeste_kdm_testeDennis_auto.xmi");
		//
		//Map<String, Map<String, String>> transformationModule = new HashMap<>();
		//
		//Map<String, String> module = new HashMap<>();
		//module.put("teste3", "file:///C:\\Java\\workspaceMestradoMars64\\ExampleATL\\ATL\\TESTE3\\");
		//
		//transformationModule.put("transformation", module);
		////transformationModule.put("library", library);
		//------------------------------------------------------------------------------------------------------------------------		
		//Map<String, Object[]> metamodel = new HashMap<String, Object[]>();
		//				
		//Object metamodelData[] = new Object[2];
		//metamodelData[0]=org.eclipse.gmt.modisco.omg.kdm.kdm.KdmPackage.eINSTANCE;
		//metamodelData[1]="http://www.eclipse.org/MoDisco/kdm/kdm";
		//metamodel.put("KDM", metamodelData);
		//
		//Map<String, Map<String, String>> metamodelsInModels = new HashMap<String, Map<String, String>>();
		//
		//Map<String, String> KDMmodelsIn = new HashMap<>();
		//KDMmodelsIn.put("IN", "file:///C:\\Java\\workspaceMestradoMars64\\ExampleATL\\FONTES\\IN\\ProjetoTeste_kdm.xmi");
		//metamodelsInModels.put("KDM", KDMmodelsIn);
		//
		////Map<String, String> modelsOut = new HashMap<String, String>();
		////modelsOut.put("OUT", "file:///C:\\Java\\workspaceMestradoMars64\\ExampleATL\\FONTES\\OUT\\ProjetoTeste_kdm_testeDennis_auto.xmi");
		//
		//Map<String, Map<String, String>> transformationModule = new HashMap<>();
		//
		//Map<String, String> module = new HashMap<>();
		//module.put("teste_1", "file:///C:\\Java\\workspaceMestradoMars64\\ExampleATL\\ATL\\TESTE1\\");
		//
		//transformationModule.put("transformation", module);
		////transformationModule.put("library", library);
		//--------------------------------------------------------------------------------------------------------------
		Map<String, Object[]> metamodel = new HashMap<String, Object[]>();

		Object metamodelData[] = new Object[2];
		metamodelData[0]=org.eclipse.gmt.modisco.omg.kdm.code.CodePackage.eINSTANCE;
		metamodelData[1]="http://www.eclipse.org/MoDisco/kdm/code";
		metamodel.put("KDM", metamodelData);

		Object metamodelData2[] = new Object[2];
		metamodelData2[0]=atlRuns.externalMetamodelRegistration("C:\\Java\\workspaceMestradoMars64\\ExampleATL\\ATL\\TESTE4\\Parameters.ecore");
		metamodelData2[1]="platform:/resource/ExampleATL/ATL/TESTE4/Parameters.ecore";
		metamodel.put("PAR", metamodelData2);

		Map<String, Map<String, String>> metamodelsInModels = new HashMap<String, Map<String, String>>();

		Map<String, String> KDMmodelsIn = new HashMap<>();
		KDMmodelsIn.put("IN", "file:///C:\\Java\\workspaceMestradoMars64\\ExampleATL\\FONTES\\IN\\ProjetoTeste_kdm.xmi");
		metamodelsInModels.put("KDM", KDMmodelsIn);

		Map<String, String> KDM2modelsIn = new HashMap<>();
		KDM2modelsIn.put("IN2", "file:///C:\\Java\\workspaceMestradoMars64\\ExampleATL\\ATL\\TESTE4\\parameters.xmi");
		metamodelsInModels.put("PAR", KDM2modelsIn);

		//Map<String, String> modelsOut = new HashMap<String, String>();
		//modelsOut.put("OUT", "file:///C:\\Java\\workspaceMestradoMars64\\ExampleATL\\FONTES\\OUT\\ProjetoTeste_kdm_testeDennis_auto.xmi");

		Map<String, Map<String, String>> transformationModule = new HashMap<>();

		Map<String, String> module = new HashMap<>();
		module.put("teste4", "file:///C:\\Java\\workspaceMestradoMars64\\ExampleATL\\ATL\\TESTE4\\");

		transformationModule.put("transformation", module);
		//transformationModule.put("library", library);
		//-------------------------------------------------------------------------------------------------------------------------
		atlRuns.setMetamodelData(metamodel).setModelsInData(metamodelsInModels).setTransformationModule(transformationModule).configureATLEngine();

		atlRuns.launch();
	}

}
