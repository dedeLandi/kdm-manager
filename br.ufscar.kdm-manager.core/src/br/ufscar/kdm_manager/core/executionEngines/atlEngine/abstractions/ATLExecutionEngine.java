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
package br.ufscar.kdm_manager.core.executionEngines.atlEngine.abstractions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

/**
 * @author André
 *
 */
public abstract class ATLExecutionEngine<T,R> {
	
	public abstract ATLExecutionEngine<T,R> setMetamodelData(Map<String,R> metamodelData);
	
	public abstract ATLExecutionEngine<T,R> setModelsInData(Map<String,T> modelsInData);

	public abstract ATLExecutionEngine<T,R> setModelsOutData(Map<String,T> modelsOutData);
	
	public abstract ATLExecutionEngine<T,R> setTransformationModule(Map<String, T> transformationModuleData);
	
	public abstract ATLExecutionEngine<T,R> setOptions(Map<String, Object> options);
	
	public abstract ATLExecutionEngine<T,R> configureATLEngine();
	
	public abstract boolean launch();
	
	public String externalMetamodelRegistration(String completeEcorePath) {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		ResourceSet rs = new ResourceSetImpl();
		// Enables extended meta-data, weird we have to do this but well...
		final ExtendedMetaData extendedMetaData = new BasicExtendedMetaData(EPackage.Registry.INSTANCE);
		rs.getLoadOptions().put(XMLResource.OPTION_EXTENDED_META_DATA, extendedMetaData);

		URI uri = null;
		if(completeEcorePath.contains("http")){
			try {
				uri = URI.createURI(new URL(completeEcorePath).toString());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			uri = URI.createFileURI(completeEcorePath);
		}
		Resource r = rs.getResource(uri, true);
		EObject eObject = r.getContents().get(0);
		// A meta-model might have multiple packages we assume the main package is the first one listed
		if (eObject instanceof EPackage) {
			EPackage p = (EPackage)eObject;
			System.out.println(p.getNsURI());
			EPackage.Registry.INSTANCE.put(p.getNsURI(), p);
			return p.getNsURI();
		}
		return null;
	}
	
}
