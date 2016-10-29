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
package br.ufscar.kdm_manager.core.serializes.impl.serializes.java;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.gmt.modisco.omg.kdm.kdm.KdmPackage;
import org.eclipse.gmt.modisco.omg.kdm.kdm.Segment;

import br.ufscar.kdm_manager.core.serializes.interfaces.KDMFileGenericSerialize;

/**
 * @author André
 *
 */
public class KDMFileSerializeSegmentImpl implements KDMFileGenericSerialize<Boolean, Segment>{

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.serializes.interfaces.KDMFileGenericSerialize#serializeFromObject(java.lang.String, java.lang.Object)
	 */
	@Override
	public Boolean serializeFromObject(String pathKDMFileToSave, Segment objectToSerialize){
		try {
			KdmPackage.eINSTANCE.eClass();

			Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
			Map<String, Object> m = reg.getExtensionToFactoryMap();
			m.put("website", new XMIResourceFactoryImpl());

			// Obtain a new resource set
			ResourceSet resSet = new ResourceSetImpl();

			if(!pathKDMFileToSave.contains("file:///")){
				pathKDMFileToSave = "file:///" + pathKDMFileToSave;
			}

			Resource resource = resSet.createResource(URI.createURI(pathKDMFileToSave));

			resource.getContents().add(objectToSerialize);


			resource.save(Collections.EMPTY_MAP);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
