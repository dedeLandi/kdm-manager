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
package br.ufscar.kdm_manager.core.recovers.recoverRelationshipLoC.impl.factory;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.gmt.modisco.omg.kdm.core.KDMRelationship;

import br.ufscar.kdm_manager.core.recovers.recoverRelationshipLoC.factory.KDMRecoverLoCRelationshipFactory;
import br.ufscar.kdm_manager.core.recovers.recoverRelationshipLoC.impl.recovers.KDMRecoverLoCRelationship;
import br.ufscar.kdm_manager.core.recovers.recoverRelationshipLoC.interfaces.KDMRecoverGenericLoCRelationship;

/**
 * @author Landi
 *
 */
public class KDMRecoverLoCRelationshipFactoryImpl extends EFactoryImpl implements KDMRecoverLoCRelationshipFactory{

	public static KDMRecoverLoCRelationshipFactory init() {
		try {
			KDMRecoverLoCRelationshipFactory theKDMRecoverLoCRelationshipFactory = (KDMRecoverLoCRelationshipFactory)EPackage.Registry.INSTANCE.getEFactory("br.ufscar.kdm_manager.core.recovers.recoverRelationshipLoC.factory.KDMRecoverLoCRelationshipFactory"); //$NON-NLS-1$ 
			if (theKDMRecoverLoCRelationshipFactory != null) {
				return theKDMRecoverLoCRelationshipFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new KDMRecoverLoCRelationshipFactoryImpl();
	}
	
	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.recovers.recoverRelationshipLoC.factory.KDMRecoverLoCRelationshipFactory#createRecoverLoCRelationship()
	 */
	@Override
	public KDMRecoverGenericLoCRelationship<KDMRelationship> createRecoverLoCRelationship() {
		KDMRecoverLoCRelationship loc = new KDMRecoverLoCRelationship();
		return loc;
	}

}
