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
package br.ufscar.kdm_manager.core.loads.impl.loads.java;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.gmt.modisco.omg.kdm.kdm.KdmPackage;
import org.eclipse.gmt.modisco.omg.kdm.kdm.Segment;

import br.ufscar.kdm_manager.core.exceptions.KDMFileException;
import br.ufscar.kdm_manager.core.loads.interfaces.KDMFileGenericReader;

public class KDMFileReaderSegmentImpl implements KDMFileGenericReader<Segment>{


	@Override
	public Segment readFromPath(String pathKDMFile) throws KDMFileException {
		pathKDMFile = "file:///" + pathKDMFile;
		System.err.println("KDM Path: " + pathKDMFile);

		if("".equalsIgnoreCase(pathKDMFile)){
			throw new KDMFileException();
		}else{
			KdmPackage.eINSTANCE.eClass();//get the KDMPackage instance

			Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
			Map<String, Object> m = reg.getExtensionToFactoryMap();
			m.put("xmi", new XMIResourceFactoryImpl());

			// Obtain a new resource set
			ResourceSet resSet = new ResourceSetImpl();
			// Get the resource
			Resource resource = resSet.getResource(URI.createURI(pathKDMFile),
					true);

			if(resource == null){
				throw new KDMFileException("Wrong path of KDM File");
			}else{
				return (Segment) resource.getContents().get(0); //get the first element, that is the Segment
			}
		}
	}

	@Override
	public Segment readFromObject(Object objectKDM) {
		return (Segment) objectKDM;
	}

}
