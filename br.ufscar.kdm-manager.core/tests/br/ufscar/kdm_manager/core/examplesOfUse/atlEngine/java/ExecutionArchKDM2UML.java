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

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.gmt.modisco.omg.kdm.action.ActionPackage;
import org.eclipse.gmt.modisco.omg.kdm.code.CodePackage;
import org.eclipse.gmt.modisco.omg.kdm.core.CorePackage;
import org.eclipse.gmt.modisco.omg.kdm.kdm.KdmPackage;
import org.eclipse.gmt.modisco.omg.kdm.structure.StructurePackage;
import org.eclipse.m2m.atl.engine.emfvm.adapter.UML2ModelAdapter;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;

import br.ufscar.kdm_manager.core.executionEngines.atlEngine.abstractions.ATLExecutionEngine;
import br.ufscar.kdm_manager.core.executionEngines.atlEngine.factory.ATLExecutionEngineFactory;

/**
 * @author André
 *
 */
public class ExecutionArchKDM2UML {

	public static void main(String[] args) {
		try {
		//atlRefining();
		//emftvmUnique();
		//emftvm();
		//atl();
			atlModisco();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @author André
	 * @throws MalformedURLException 
	 */
	private static void atlModisco() throws MalformedURLException {
		Map<String, Object[]> metamodel = new HashMap<String, Object[]>();

		Object metamodelData[] = new Object[1];
		metamodelData[0]="platform:/plugin/org.eclipse.gmt.modisco.omg.kdm/model/kdm.ecore";
		metamodel.put("kdm", metamodelData);
		
		Object metamodelData2[] = new Object[1];
		metamodelData2[0]="platform:/plugin/org.eclipse.uml2.uml/model/UML.ecore";
		metamodel.put("uml", metamodelData2);
		
		Map<String, Map<String, String>> metamodelsInModels = new HashMap<String, Map<String, String>>();

		Map<String, String> KDMmodelsIn = new HashMap<>();
		KDMmodelsIn.put("kdmInput", "C:\\JavaLab\\workspace\\ArchKDM2UML\\samples\\ModiscoTargetApp_kdm-hastype-violations.sample1.xmi");
		metamodelsInModels.put("kdm", KDMmodelsIn);
		
		Map<String, Map<String, String>> metamodelsOutModels = new HashMap<String, Map<String, String>>();
		
		Map<String, String> KDMmodelsOut = new HashMap<>();
		KDMmodelsOut.put("umlOutput", "C:\\JavaLab\\workspace\\ArchKDM2UML\\samples\\ModiscoTargetApp_kdm-hastype-violations.sample1-codeView.uml");
		metamodelsOutModels.put("uml", KDMmodelsOut);
		
		Map<String, Map<String, String>> transformationModule = new HashMap<>();

		Map<String, String> module = new HashMap<>();
		URL asmFile = new URL("file://C:\\JavaLab\\workspace\\ArchKDM2UML\\ArchKDM2UML_CodeView.asm");
		module.put("ArchKDM2UML_CodeView", asmFile.toString());

		transformationModule.put("transformation", module);
		
		ATLExecutionEngine<Map<String, String>, Object[]> atlRuns = ATLExecutionEngineFactory.eINSTANCE.createATLExecutionEngineASMModiscoCompiler();
		atlRuns.setMetamodelData(metamodel).setModelsInData(metamodelsInModels).setModelsOutData(metamodelsOutModels).setTransformationModule(transformationModule).configureATLEngine();

		atlRuns.launch();
	}

	private static void atl() {
		ATLExecutionEngine<Map<String, String>, Object[]> atlRuns = ATLExecutionEngineFactory.eINSTANCE.createATLExecutionEngineASMcompiler();
		Map<String, Object[]> metamodel = new HashMap<String, Object[]>();

		Object metamodelData[] = new Object[2];
		metamodelData[0]=EcorePackage.eINSTANCE;
		metamodelData[1]="file:///C:\\JavaLab\\workspace\\ArchKDM2UML\\kdm.ecore";
		metamodel.put("kdm", metamodelData);
		
		Object metamodelData2[] = new Object[2];
		metamodelData2[0]=UMLPackage.eINSTANCE;
		metamodelData2[1]="file:///C:\\JavaLab\\workspace\\ArchKDM2UML\\uml.ecore";
		metamodel.put("uml", metamodelData2);

		Map<String, Map<String, String>> metamodelsInModels = new HashMap<String, Map<String, String>>();

		Map<String, String> KDMmodelsIn = new HashMap<>();
		KDMmodelsIn.put("kdmInput", "file:///C:\\JavaLab\\workspace\\ArchKDM2UML\\samples\\ModiscoTargetApp_kdm-hastype-violations.sample1.xmi");
		metamodelsInModels.put("kdm", KDMmodelsIn);
		
		Map<String, Map<String, String>> metamodelsOutModels = new HashMap<String, Map<String, String>>();
		
		Map<String, String> KDMmodelsOut = new HashMap<>();
		KDMmodelsOut.put("umlOutput", "file:///C:\\JavaLab\\workspace\\ArchKDM2UML\\samples\\ModiscoTargetApp_kdm-hastype-violations.sample1_auto.uml");
		metamodelsOutModels.put("uml", KDMmodelsOut);

		Map<String, Map<String, String>> transformationModule = new HashMap<>();

		Map<String, String> module = new HashMap<>();
		module.put("KDM2UML", "file:///C:\\JavaLab\\workspace\\ArchKDM2UML\\");

		transformationModule.put("transformation", module);
		
		atlRuns.setMetamodelData(metamodel).setModelsInData(metamodelsInModels).setModelsOutData(metamodelsOutModels).setTransformationModule(transformationModule).configureATLEngine();

		atlRuns.launch();
	}

	/**
	 * @author André
	 */
	private static void emftvm() {
		ATLExecutionEngine<String, Resource> atlRuns = ATLExecutionEngineFactory.eINSTANCE.createATLExecutionEngineEMFTVMcompiler();

		Map<String, Resource> metamodel = new HashMap<String, Resource>();
		
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());

		URI fileURI = URI.createFileURI("C:\\JavaLab\\workspace\\ArchKDM2UML\\kdm.ecore");
		System.out.println(fileURI);
		Resource resource = resourceSet.getResource(fileURI, true);
		
		metamodel.put("kdm", resource);
		
		URI fileURIUML = URI.createFileURI("C:\\JavaLab\\workspace\\ArchKDM2UML\\uml.ecore");
		System.out.println(fileURIUML);
		Resource resourceUML = resourceSet.getResource(fileURIUML, true);
		
		metamodel.put("uml", resourceUML);

		Map<String, String> modelsIn = new HashMap<String, String>();
		modelsIn.put("kdmInput", "file:/C:\\JavaLab\\workspace\\ArchKDM2UML\\samples\\ModiscoTargetApp_kdm-hastype-violations.sample1.xmi");

		Map<String, String> modelsOut = new HashMap<String, String>();
		modelsOut.put("umlOutput", "file:/C:\\JavaLab\\workspace\\ArchKDM2UML\\samples\\ModiscoTargetApp_kdm-hastype-violations.sample1_auto.uml");

		Map<String, String> transformationModule = new HashMap<String, String>();
		transformationModule.put("KDM2UML", "file:///C:\\JavaLab\\workspace\\ArchKDM2UML\\");

		atlRuns.setMetamodelData(metamodel).setModelsInData(modelsIn).setModelsOutData(modelsOut).setTransformationModule(transformationModule).configureATLEngine();

		atlRuns.launch();
	}

	/**
	 * @author André
	 */
	private static void emftvmUnique() {
		ATLExecutionEngine<String, Resource> atlRuns = ATLExecutionEngineFactory.eINSTANCE.createATLExecutionEngineRefiningEMFTVMcompiler();

		Map<String, Resource> metamodel = new HashMap<String, Resource>();
		metamodel.put("kdm", ActionPackage.eINSTANCE.eResource());
		metamodel.put("uml", UMLPackage.eINSTANCE.eResource());

		Map<String, String> modelsIn = new HashMap<String, String>();
		modelsIn.put("kdmInput", "file:/C:\\JavaLab\\workspace\\arch-kdm\\br.ufscar.ARCH-KDM.ui\\src\\br\\ufscar\\arch_kdm\\ui\\tests\\violationsGroupedToFrom.xmi");

		Map<String, String> modelsOut = new HashMap<String, String>();
		modelsOut.put("umlOutput", "C:\\JavaLab\\workspace\\arch-kdm\\br.ufscar.ARCH-KDM.ui\\src\\br\\ufscar\\arch_kdm\\ui\\tests\\violationsGroupedToFrom_auto.xmi");

		Map<String, String> transformationModule = new HashMap<String, String>();
		transformationModule.put("KDM2UML", "file:///C:\\JavaLab\\workspace\\TESTE\\TESTE\\");

		atlRuns.setMetamodelData(metamodel).setModelsInData(modelsIn).setModelsOutData(modelsOut).setTransformationModule(transformationModule).configureATLEngine();

		atlRuns.launch();
	}

	/**
	 * @author André
	 */
	private static void atlRefining() {
		ATLExecutionEngine<Map<String, String>, Object[]> atlRuns = ATLExecutionEngineFactory.eINSTANCE.createATLExecutionRefiningEngineASMcompiler();
		Map<String, Object[]> metamodel = new HashMap<String, Object[]>();

		Object metamodelData2[] = new Object[2];
		metamodelData2[0]=ActionPackage.eINSTANCE;
		metamodelData2[1]=ActionPackage.eNS_URI;
		metamodel.put("kdm", metamodelData2);

		Map<String, Map<String, String>> metamodelsInModels = new HashMap<String, Map<String, String>>();

		Map<String, String> KDMmodelsIn = new HashMap<>();
		KDMmodelsIn.put("kdmInput", "file:///C:\\JavaLab\\workspace\\arch-kdm\\br.ufscar.ARCH-KDM.ui\\src\\br\\ufscar\\arch_kdm\\ui\\tests\\violationsGroupedToFrom.xmi");
		metamodelsInModels.put("kdm", KDMmodelsIn);

		Map<String, Map<String, String>> transformationModule = new HashMap<>();

		Map<String, String> module = new HashMap<>();
//		module.put("KDM2UML", "file:///C:\\JavaLab\\workspace\\arch-kdm\\br.ufscar.ARCH-KDM.core\\resources\\");
		module.put("KDM2UML", "file:///C:\\JavaLab\\workspace\\TESTE\\TESTE\\");

		transformationModule.put("transformation", module);
		
		atlRuns.setMetamodelData(metamodel).setModelsInData(metamodelsInModels).setTransformationModule(transformationModule).configureATLEngine();

		atlRuns.launch();
	}
	
}
