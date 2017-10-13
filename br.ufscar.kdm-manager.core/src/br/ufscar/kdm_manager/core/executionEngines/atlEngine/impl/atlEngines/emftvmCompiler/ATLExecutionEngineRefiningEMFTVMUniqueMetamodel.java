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
package br.ufscar.kdm_manager.core.executionEngines.atlEngine.impl.atlEngines.emftvmCompiler;


import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.impl.resource.EMFTVMResourceFactoryImpl;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.TimingData;

import br.ufscar.kdm_manager.core.executionEngines.atlEngine.abstractions.ATLExecutionEngine;

/**
 * @author André
 *
 */
public class ATLExecutionEngineRefiningEMFTVMUniqueMetamodel extends ATLExecutionEngine<String, Resource>{

	private boolean atlConfigured = false;
	private Map<String, Resource> metamodelData = null;
	private Map<String, String> modelsInData = null;
	private Map<String, String> modelsOutData = null;
	private Map<String, String> transformationModuleData = null;

	private ExecEnv env = null;
	private TimingData td = null;
	private Model inOutModel;

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.executionEngines.atlEngine.interfaces.ATLExecutionEngine#setMetamodelData(java.util.Map)
	 */
	@Override
	public ATLExecutionEngine<String, Resource> setMetamodelData(Map<String, Resource> metamodelData) {
		atlConfigured = false;
		if(metamodelData.keySet().size() != 1){
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
	public ATLExecutionEngine<String, Resource> setModelsInData(Map<String, String> modelsInData) {
		atlConfigured = false;
		if(modelsInData.keySet().size() != 1){
			return launchException();
		}else{
			this.modelsInData = modelsInData;
		}
		return this;
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.executionEngines.atlEngine.interfaces.ATLExecutionEngine#setModelsOutData(java.util.Map)
	 */
	@Override
	public ATLExecutionEngine<String, Resource> setModelsOutData(Map<String, String> modelsOutData) {
		atlConfigured = false;
		if(modelsOutData.keySet().size() != 1){
			return launchException();
		}else{
			this.modelsOutData = modelsOutData;
		}
		return this;
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.executionEngines.atlEngine.interfaces.ATLExecutionEngine#setTransformationModule(java.lang.Object)
	 */
	@Override
	public ATLExecutionEngine<String, Resource> setTransformationModule(Map<String, String> transformationModuleData) {
		atlConfigured = false;
		if(transformationModuleData.keySet().size() != 1){
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
	@Deprecated
	public ATLExecutionEngine<String, Resource> setOptions(Map<String, Object> options) {
		return null;
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.executionEngines.atlEngine.interfaces.ATLExecutionEngine#configureATLEngine()
	 */
	@Override
	public ATLExecutionEngine<String, Resource> configureATLEngine() {
		atlConfigured = false;
		this.env = EmftvmFactory.eINSTANCE.createExecEnv();
		ResourceSet rs = new ResourceSetImpl();

		/*
		 * Load meta-models in the resource set we just created, the idea here is to make the meta-models
		 * available in the context of the execution environment, the ResourceSet is later passed to the
		 * ModuleResolver that is the actual class that will run the transformation.
		 * Notice that we use the nsUris to locate the metamodels in the package registry, we initialize them 
		 * from Ecore files that we registered lazily as shown below in e.g. registerInputMetamodel(...) 
		 */
		for (String metamodelName : this.metamodelData.keySet()) {

			Metamodel metamodel = EmftvmFactory.eINSTANCE.createMetamodel();
			metamodel.setResource(this.metamodelData.get(metamodelName));
			this.env.registerMetaModel(metamodelName, metamodel);
		}

		/*
		 * Create and register resource factories to read/parse .xmi and .emftvm files,
		 * we need an .xmi parser because our in/output models are .xmi and our transformations are
		 * compiled using the ATL-EMFTV compiler that generates .emftvm files
		 */
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xml", new XMLResourceFactoryImpl());
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("emftvm", new EMFTVMResourceFactoryImpl());
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());

		// Load models
		for (String inModelName: modelsInData.keySet()) {

			inOutModel = EmftvmFactory.eINSTANCE.createModel();
			inOutModel.setResource(rs.getResource(URI.createURI(modelsInData.get(inModelName), true), true));
			env.registerInOutModel(inModelName, inOutModel);
		}

		/*
		 *  Load and run the transformation module
		 *  Point at the directory your transformations are stored, the ModuleResolver will 
		 *  look for the .emftvm file corresponding to the module you want to load and run
		 */
		for (String moduleName: transformationModuleData.keySet()) {

			ModuleResolver mr = new DefaultModuleResolver(transformationModuleData.get(moduleName), rs);
			td = new TimingData();
			env.loadModule(mr, moduleName);
			td.finishLoading();
		}

		atlConfigured = true;
		return this;
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.executionEngines.atlEngine.interfaces.ATLExecutionEngine#launch()
	 */
	@Override
	public boolean launch() {
		boolean launchOk = false;
		if(atlConfigured){
			try {
				env.run(td);
				td.finish();
				// Save models
				for (String outModelName : modelsOutData.keySet()) {

					inOutModel.getResource().setURI(URI.createURI(modelsOutData.get(outModelName), true));
					inOutModel.getResource().save(Collections.emptyMap());
				}
				launchOk = true;
			} catch (IOException e) {
				launchOk = false;
				e.printStackTrace();
			}
		}
		return launchOk;
	}

	
	/**
	 * @author Landi
	 */
	private ATLExecutionEngine<String, Resource> launchException() {
		try {
			throw new Exception("Please, use only one parameter of each type to this type of ATL launch.");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
