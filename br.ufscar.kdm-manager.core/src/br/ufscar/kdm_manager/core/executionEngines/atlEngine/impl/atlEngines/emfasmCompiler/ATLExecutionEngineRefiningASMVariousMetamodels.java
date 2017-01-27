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
package br.ufscar.kdm_manager.core.executionEngines.atlEngine.impl.atlEngines.emfasmCompiler;


import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IExtractor;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFExtractor;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;

import br.ufscar.kdm_manager.core.executionEngines.atlEngine.abstractions.ATLExecutionEngine;

/**
 * @author André
 *
 */
public class ATLExecutionEngineRefiningASMVariousMetamodels extends ATLExecutionEngine<Map<String, String>, Object[]>{

	private boolean atlConfigured = false;
	private Map<String, Object[]> metamodelData = null;
	private Map<String, Map<String, String>> modelsInData = null;
	@SuppressWarnings("unused")
	private Map<String, Map<String, String>> modelsOutData = null;
	private Map<String, Map<String, String>> transformationModuleData = null;
	private Map<String, Object> options;

	private Map<String, Object[]> inModels = null;
	private Map<String, IReferenceModel> metamodels = null;

	private ILauncher launcher;
	private Object[] modulesList;

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.executionEngines.atlEngine.interfaces.ATLExecutionEngine#setMetamodelData(java.util.Map)
	 */
	@Override
	public ATLExecutionEngine<Map<String, String>, Object[]> setMetamodelData(Map<String, Object[]> metamodelData) {
		atlConfigured = false;
		if(metamodelData.keySet().size() < 1){
			return launchException();
		}else{
			this.metamodelData  = metamodelData;
		}
		return this;
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.executionEngines.atlEngine.interfaces.ATLExecutionEngine#setModelsInData(java.util.Map)
	 */
	@Override
	public ATLExecutionEngine<Map<String, String>, Object[]> setModelsInData(Map<String, Map<String, String>> modelsInData) {
		atlConfigured = false;
		if(modelsInData.keySet().size() < 1){
			return launchException();
		}else{
			this.modelsInData = modelsInData;
		}
		return this;
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.executionEngines.atlEngine.interfaces.ATLExecutionEngine#setModelsOutData(java.util.Map)
	 * 
	 * The refining module uses the in/out model like the same
	 * 
	 */
	@Override
	@Deprecated 
	public ATLExecutionEngine<Map<String, String>, Object[]> setModelsOutData(Map<String, Map<String, String>> modelsOutData) {
		atlConfigured = false;
		if(modelsOutData.keySet().size() < 1){
			return launchException();
		}else{
			this.modelsOutData = modelsOutData;
		}
		return this;
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.executionEngines.atlEngine.interfaces.ATLExecutionEngine#setTransformationModule(java.util.Map)
	 */
	@Override
	public ATLExecutionEngine<Map<String, String>, Object[]> setTransformationModule(Map<String, Map<String, String>> transformationModuleData) {
		atlConfigured = false;
		if(transformationModuleData.keySet().size() < 1){
			return launchException();
		}else{
			this.transformationModuleData = transformationModuleData;
		}
		return this;
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.executionEngines.atlEngine.abstractions.ATLExecutionEngine#setOptions(java.util.Map)
	 */
	@Override
	public ATLExecutionEngine<Map<String, String>, Object[]> setOptions(Map<String, Object> options) {
		atlConfigured = false;
		this.options = options;
		return this;
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.executionEngines.atlEngine.interfaces.ATLExecutionEngine#configureATLEngine()
	 */
	@Override
	public ATLExecutionEngine<Map<String, String>, Object[]> configureATLEngine() {
		atlConfigured = false;
		inModels = new HashMap<>();
		metamodels = new HashMap<>();

		try {

			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());

			ModelFactory factory = new EMFModelFactory();
			IInjector injector = new EMFInjector();

			//configure metamodels
			for (String metamodelName : metamodelData.keySet()) {
				EPackage.Registry.INSTANCE.put(metamodelName, metamodelData.get(metamodelName)[0]);
				IReferenceModel metamodelUsed = factory.newReferenceModel();
				metamodels.put(metamodelName, metamodelUsed);
				injector.inject(metamodelUsed, ((String)metamodelData.get(metamodelName)[1]));

			}

			//configure options
			launcher = new EMFVMLauncher();
			if(options == null){
				options = new HashMap<String, Object>();
			}
			launcher.initialize(options);

			//configure in/out models
			for (String metamodelsModelsInName : modelsInData.keySet()) {
				for (String modelsInName : modelsInData.get(metamodelsModelsInName).keySet()) {

					IModel inModel = factory.newModel(metamodels.get(metamodelsModelsInName));
					injector.inject(inModel, modelsInData.get(metamodelsModelsInName).get(modelsInName));
					
					Object modelData[] = new Object[2];
					modelData[0]=inModel;
					modelData[1]=modelsInData.get(metamodelsModelsInName).get(modelsInName);
					inModels.put(modelsInName, modelData);

					launcher.addInOutModel(inModel, modelsInName, metamodelsModelsInName);
				}

			}

			//configure refining module
			IReferenceModel refiningTraceMetamodel = factory.getBuiltInResource("RefiningTrace.ecore");
			IModel refiningTraceModel = factory.newModel(refiningTraceMetamodel);
			launcher.addOutModel(refiningTraceModel, "refiningTrace", "RefiningTrace");

			//configure modules
			InputStream[] modules = new InputStream[transformationModuleData.size()];
			int moduleIndex = 0;
			for (String transformationName : transformationModuleData.keySet()) {
				for (String nameModule : transformationModuleData.get(transformationName).keySet()) {
					modules[moduleIndex] = new URL(transformationModuleData.get(transformationName).get(nameModule)+nameModule+".asm").openStream(); 
				}
			}
			modulesList = (Object[]) modules;

			atlConfigured = true;
		} catch (ATLCoreException e) {
			atlConfigured = false;
			e.printStackTrace();
		} catch (MalformedURLException e) {
			atlConfigured = false;
			e.printStackTrace();
		} catch (IOException e) {
			atlConfigured = false;
			e.printStackTrace();
		}
		return this;
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.executionEngines.atlEngine.interfaces.ATLExecutionEngine#launch()
	 */
	@Override
	public boolean launch() {
		try {
			if(atlConfigured){
				launcher.launch("run", new NullProgressMonitor(), options, modulesList);

				IExtractor extractor = new EMFExtractor();
				for (String inModelName : inModels.keySet()) {
					extractor.extract(((IModel)inModels.get(inModelName)[0]), ((String)inModels.get(inModelName)[1]).replace(".xmi", "_out.xmi"));
				}
				return true;
			}
		} catch (ATLCoreException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	/**
	 * @author Landi
	 */
	private ATLExecutionEngine<Map<String, String>, Object[]> launchException() {
		try {
			throw new Exception("Please, use at least one parameter of each type to do this type of ATL launch.");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
