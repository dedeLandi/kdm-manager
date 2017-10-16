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
package br.ufscar.kdm_manager.core.executionEngines.atlEngine.impl.atlEngines.modiscoAsmCompiler;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmt.modisco.infra.common.core.internal.utils.ModelUtils;
import org.eclipse.gmt.modisco.omg.kdm.action.impl.ActionPackageImpl;
import org.eclipse.gmt.modisco.omg.kdm.build.impl.BuildPackageImpl;
import org.eclipse.gmt.modisco.omg.kdm.code.impl.CodePackageImpl;
import org.eclipse.gmt.modisco.omg.kdm.conceptual.impl.ConceptualPackageImpl;
import org.eclipse.gmt.modisco.omg.kdm.core.impl.CorePackageImpl;
import org.eclipse.gmt.modisco.omg.kdm.data.impl.DataPackageImpl;
import org.eclipse.gmt.modisco.omg.kdm.event.impl.EventPackageImpl;
import org.eclipse.gmt.modisco.omg.kdm.kdm.impl.KdmPackageImpl;
import org.eclipse.gmt.modisco.omg.kdm.platform.impl.PlatformPackageImpl;
import org.eclipse.gmt.modisco.omg.kdm.source.impl.SourcePackageImpl;
import org.eclipse.gmt.modisco.omg.kdm.structure.impl.StructurePackageImpl;
import org.eclipse.gmt.modisco.omg.kdm.ui.impl.UiPackageImpl;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.emftvm.impl.resource.EMFTVMResourceImpl;
import org.eclipse.modisco.kdm.uml2converter.internal.KdmToUmlConverter;
import org.eclipse.modisco.util.atl.core.internal.AtlLaunchHelper;
import org.eclipse.modisco.util.atl.core.internal.AtlLaunchHelper.ModelInfo;

import br.ufscar.kdm_manager.core.executionEngines.atlEngine.abstractions.ATLExecutionEngine;

/**
 * @author André
 *
 */
public class ATLExecutionEngineASMModisco extends ATLExecutionEngine<Map<String, String>, Object[]>{

	private boolean atlConfigured = false;

	private List<ModelInfo> inputModels = new ArrayList<ModelInfo>();
	private List<ModelInfo> outputModels = new ArrayList<ModelInfo>();
	private URL transformation;

	private Map<String, Object[]> metamodelData = null;
	private Map<String, Map<String, String>> modelsInData = null;
	private Map<String, Map<String, String>> modelsOutData = null;
	private Map<String, Map<String, String>> transformationModuleData = null;
	private Map<String, Object> options = null;





	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.executionEngines.atlEngine.abstractions.ATLExecutionEngine#setMetamodelData(java.util.Map)
	 */
	@Override
	public ATLExecutionEngine<Map<String, String>, Object[]> setMetamodelData(Map<String, Object[]> metamodelData) {
		atlConfigured = false;
		if(metamodelData.keySet().size() != 2){
			return launchException();
		}else{
			this.metamodelData  = metamodelData;
		}
		return this;
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.executionEngines.atlEngine.abstractions.ATLExecutionEngine#setModelsInData(java.util.Map)
	 */
	@Override
	public ATLExecutionEngine<Map<String, String>, Object[]> setModelsInData(
			Map<String, Map<String, String>> modelsInData) {
		atlConfigured = false;
		if(modelsInData.keySet().size() != 1){
			return launchException();
		}else{
			this.modelsInData = modelsInData;
		}
		return this;
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.executionEngines.atlEngine.abstractions.ATLExecutionEngine#setModelsOutData(java.util.Map)
	 */
	@Override
	public ATLExecutionEngine<Map<String, String>, Object[]> setModelsOutData(
			Map<String, Map<String, String>> modelsOutData) {
		atlConfigured = false;
		if(modelsOutData.keySet().size() != 1){
			return launchException();
		}else{
			this.modelsOutData = modelsOutData;
		}
		return this;
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.executionEngines.atlEngine.abstractions.ATLExecutionEngine#setTransformationModule(java.util.Map)
	 */
	@Override
	public ATLExecutionEngine<Map<String, String>, Object[]> setTransformationModule(
			Map<String, Map<String, String>> transformationModuleData) {
		atlConfigured = false;
		if(transformationModuleData.keySet().size() != 1){
			return launchException();
		}else{
			this.transformationModuleData  = transformationModuleData;
		}
		return this;
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.executionEngines.atlEngine.abstractions.ATLExecutionEngine#setOptions(java.util.Map)
	 */
	@Override
	@Deprecated
	public ATLExecutionEngine<Map<String, String>, Object[]> setOptions(Map<String, Object> options) {
		atlConfigured = false;
		this.options  = options;
		return this;
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.executionEngines.atlEngine.abstractions.ATLExecutionEngine#configureATLEngine()
	 */
	@SuppressWarnings("restriction")
	@Override
	public ATLExecutionEngine<Map<String, String>, Object[]> configureATLEngine() {
		inputModels = new ArrayList<ModelInfo>();
		outputModels = new ArrayList<ModelInfo>();
		try {
			URI umlTargetModelUri = URI.createURI("memory:/umlTargetModel"); //$NON-NLS-1$

			ModelUtils.computeReferencedPackages(KdmPackageImpl.eINSTANCE);
			ModelUtils.computeReferencedPackages(ActionPackageImpl.eINSTANCE);
			ModelUtils.computeReferencedPackages(BuildPackageImpl.eINSTANCE);
			ModelUtils.computeReferencedPackages(CodePackageImpl.eINSTANCE);
			ModelUtils.computeReferencedPackages(ConceptualPackageImpl.eINSTANCE);
			ModelUtils.computeReferencedPackages(CorePackageImpl.eINSTANCE);
			ModelUtils.computeReferencedPackages(PlatformPackageImpl.eINSTANCE);
			ModelUtils.computeReferencedPackages(DataPackageImpl.eINSTANCE);
			ModelUtils.computeReferencedPackages(EventPackageImpl.eINSTANCE);
			ModelUtils.computeReferencedPackages(SourcePackageImpl.eINSTANCE);
			ModelUtils.computeReferencedPackages(StructurePackageImpl.eINSTANCE);
			ModelUtils.computeReferencedPackages(UiPackageImpl.eINSTANCE);
			
			
			
			Resource sourceModel = null;

			for (String metamodelName : modelsInData.keySet()) {
				for (String modelInName : modelsInData.get(metamodelName).keySet()) {
					String metamodelPath = (String) metamodelData.get(metamodelName)[0];
					final URI sourceUri = URI.createFileURI(modelsInData.get(metamodelName).get(modelInName));
					sourceModel = ModelUtils.loadModel(sourceUri);
					final ModelInfo inputModel = new ModelInfo(
							modelInName, sourceModel.getURI(), sourceModel, metamodelName, //$NON-NLS-1$ //$NON-NLS-2$
							URI.createURI(metamodelPath));

					inputModels.add(inputModel);
				}		
			}
			for (String metamodelName : modelsOutData.keySet()) {
				for (String modelOutName : modelsOutData.get(metamodelName).keySet()) {
					String metamodelPath = (String) metamodelData.get(metamodelName)[0];


					final ModelInfo outputModel = new ModelInfo(
							modelOutName, umlTargetModelUri, sourceModel, metamodelName, //$NON-NLS-1$ //$NON-NLS-2$
							URI.createURI(metamodelPath));
					outputModels.add(outputModel);
				}
			}
			
			for (String transformationName : transformationModuleData.keySet()) {
				for (String nameModule : transformationModuleData.get(transformationName).keySet()) {
					String path = transformationModuleData.get(transformationName).get(nameModule);
					transformation = new URL(path); 
				}
			}
			
			atlConfigured = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			atlConfigured = false;
			e.printStackTrace();
		}

		return this;
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.executionEngines.atlEngine.abstractions.ATLExecutionEngine#launch()
	 */
	@SuppressWarnings("restriction")
	@Override
	public boolean launch() {

		try {

			AtlLaunchHelper atlHelper = new AtlLaunchHelper();
			List<Resource> results = atlHelper.runTransformation(transformation, inputModels, outputModels);
			Resource[] resultsArray = new Resource[results.size()];
			results.toArray(resultsArray);

			Resource output = resultsArray[0];

			for (String metamodelName : modelsOutData.keySet()) {
				for (String modelOutName : modelsOutData.get(metamodelName).keySet()) {
					String outputPath = modelsOutData.get(metamodelName).get(modelOutName);
					
					output.setURI(URI.createFileURI(outputPath));
					output.save(null);
				}
			}

			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return true;
		}


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
