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
package br.ufscar.kdm_manager.core.serializes.impl.factory;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.gmt.modisco.omg.kdm.kdm.Segment;

import br.ufscar.kdm_manager.core.serializes.factory.KDMFileSerializeFactory;
import br.ufscar.kdm_manager.core.serializes.impl.serializes.java.KDMFileSerializeSegmentImpl;
import br.ufscar.kdm_manager.core.serializes.interfaces.KDMFileGenericSerialize;

public class KDMFileSerializeFactoryImpl extends EFactoryImpl implements KDMFileSerializeFactory {

	
	public static KDMFileSerializeFactory init() {
		try {
			KDMFileSerializeFactory theKDMFileSerializeFactory = (KDMFileSerializeFactory)EPackage.Registry.INSTANCE.getEFactory("br.ufscar.kdm_manager.core.loads.factory.KDMFileReaderFactory"); //$NON-NLS-1$ 
			if (theKDMFileSerializeFactory != null) {
				return theKDMFileSerializeFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new KDMFileSerializeFactoryImpl();
	}
	
	public KDMFileSerializeFactoryImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.serializes.factory.KDMFileSerializeFactory#createKDMFileSerializeFromSegment()
	 */
	@Override
	public KDMFileGenericSerialize<Boolean, Segment> createKDMFileSerializeFromSegment() {
		return new KDMFileSerializeSegmentImpl();
	}

	

}
