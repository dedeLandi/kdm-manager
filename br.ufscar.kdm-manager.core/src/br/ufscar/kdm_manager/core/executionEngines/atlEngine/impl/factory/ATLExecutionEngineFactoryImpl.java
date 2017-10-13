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
package br.ufscar.kdm_manager.core.executionEngines.atlEngine.impl.factory;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;

import br.ufscar.kdm_manager.core.executionEngines.atlEngine.abstractions.ATLExecutionEngine;
import br.ufscar.kdm_manager.core.executionEngines.atlEngine.factory.ATLExecutionEngineFactory;
import br.ufscar.kdm_manager.core.executionEngines.atlEngine.impl.atlEngines.emfasmCompiler.ATLExecutionEngineASM;
import br.ufscar.kdm_manager.core.executionEngines.atlEngine.impl.atlEngines.emfasmCompiler.ATLExecutionEngineRefiningASMVariousMetamodels;
import br.ufscar.kdm_manager.core.executionEngines.atlEngine.impl.atlEngines.emftvmCompiler.ATLExecutionEngineEMFTVM;
import br.ufscar.kdm_manager.core.executionEngines.atlEngine.impl.atlEngines.emftvmCompiler.ATLExecutionEngineRefiningEMFTVMUniqueMetamodel;

/**
 * @author Landi
 *
 */
public class ATLExecutionEngineFactoryImpl extends EFactoryImpl implements ATLExecutionEngineFactory  {

	public static ATLExecutionEngineFactory init() {
		try {
			ATLExecutionEngineFactory theATLExecutionEngineFactory = (ATLExecutionEngineFactory)EPackage.Registry.INSTANCE.getEFactory("br.ufscar.kdm_manager.core.executionEngines.atlEngine.factory.ATLExecutionEngineFactory"); //$NON-NLS-1$ 
			if (theATLExecutionEngineFactory != null) {
				return theATLExecutionEngineFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ATLExecutionEngineFactoryImpl();
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.executionEngines.atlEngine.factory.ATLExecutionEngineFactory#createATLExecutionEngineASMcompiler()
	 */
	@Override
	public ATLExecutionEngine<Map<String, String>, Object[]> createATLExecutionRefiningEngineASMcompiler() {
		ATLExecutionEngineRefiningASMVariousMetamodels atlCompiler = new ATLExecutionEngineRefiningASMVariousMetamodels();
		return atlCompiler;
	}
	
	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.executionEngines.atlEngine.factory.ATLExecutionEngineFactory#createATLExecutionEngineASMcompiler()
	 */
	@Override
	public ATLExecutionEngine<Map<String, String>, Object[]> createATLExecutionEngineASMcompiler() {
		ATLExecutionEngineASM atlCompiler = new ATLExecutionEngineASM();
		return atlCompiler;
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.executionEngines.atlEngine.factory.ATLExecutionEngineFactory#createATLExecutionEngineEMFTVMcompiler()
	 */
	@Override
	public ATLExecutionEngine<String, Resource> createATLExecutionEngineRefiningEMFTVMcompiler() {
		ATLExecutionEngineRefiningEMFTVMUniqueMetamodel atlCompiler = new ATLExecutionEngineRefiningEMFTVMUniqueMetamodel();
		return atlCompiler;
	}
	
	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.executionEngines.atlEngine.factory.ATLExecutionEngineFactory#createATLExecutionEngineEMFTVMcompiler()
	 */
	@Override
	public ATLExecutionEngine<String, Resource> createATLExecutionEngineEMFTVMcompiler() {
		ATLExecutionEngineEMFTVM atlCompiler = new ATLExecutionEngineEMFTVM();
		return atlCompiler;
	}
	
	
}
