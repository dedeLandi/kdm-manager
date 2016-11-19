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
package br.ufscar.kdm_manager.core.recovers.recoverStructureHierarchy.impl.recovers.java;

import org.eclipse.gmt.modisco.omg.kdm.kdm.KDMModel;
import org.eclipse.gmt.modisco.omg.kdm.structure.AbstractStructureElement;
import org.eclipse.gmt.modisco.omg.kdm.structure.ArchitectureView;
import org.eclipse.gmt.modisco.omg.kdm.structure.Component;
import org.eclipse.gmt.modisco.omg.kdm.structure.Layer;
import org.eclipse.gmt.modisco.omg.kdm.structure.SoftwareSystem;
import org.eclipse.gmt.modisco.omg.kdm.structure.Subsystem;

import br.ufscar.kdm_manager.core.recovers.recoverStructureHierarchy.interfaces.KDMRecoverGenericStructureHierarchy;

/**
 * @author Landi
 *
 */
public class KDMRecoverStructureHierarchyModelImpl implements KDMRecoverGenericStructureHierarchy<String> {

	private String getHierarchyOf(KDMModel modelToAvaliate) {
		String completePath = "";

		if(modelToAvaliate.eContainer() instanceof KDMModel){
			completePath = completePath.concat(this.getHierarchyOf((KDMModel) modelToAvaliate.eContainer()));
		}

		//String nameObject = modelToAvaliate.getName() == null ? "anonymous" : modelToAvaliate.getName();
		//String nameThisObjectIteration = (SEPARATOR_CLASS_TYPE.replace("?", modelToAvaliate.eClass().getName())).concat(nameObject);

		//return (completePath.concat(SEPARATOR_TYPE)).concat(nameThisObjectIteration);
		return SEPARATOR_CLASS_TYPE.replace("?", modelToAvaliate.eClass().getName());
	}
	
	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.recovers.recoverStructureHierarchy.interfaces.KDMRecoverGenericStructureHierarchy#getHierarchyOf(org.eclipse.gmt.modisco.omg.kdm.structure.AbstractStructureElement)
	 */
	@Override
	public String getHierarchyOf(AbstractStructureElement elementToAvaliate) {
		String completePath = "";
		
		if(elementToAvaliate.eContainer() instanceof AbstractStructureElement){
			completePath = completePath.concat(this.getHierarchyOf((AbstractStructureElement) elementToAvaliate.eContainer()));
		}else if(elementToAvaliate.eContainer() instanceof KDMModel){
			completePath = completePath.concat(this.getHierarchyOf((KDMModel) elementToAvaliate.eContainer()));
		}
		
		String nameObject = elementToAvaliate.getName() == null ? "anonymous" : elementToAvaliate.getName();
		String nameThisObjectIteration = (SEPARATOR_CLASS_TYPE.replace("?", elementToAvaliate.eClass().getName())).concat(nameObject);
		
		return (completePath.concat(SEPARATOR_TYPE)).concat(nameThisObjectIteration);
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.recovers.recoverStructureHierarchy.interfaces.KDMRecoverGenericStructureHierarchy#getHierarchyOf(org.eclipse.gmt.modisco.omg.kdm.structure.Layer)
	 */
	@Override
	public String getHierarchyOf(Layer elementToAvaliate) {
		String completePath = "";
		
		if(elementToAvaliate.eContainer() instanceof Layer){
			completePath = completePath.concat(this.getHierarchyOf((Layer) elementToAvaliate.eContainer()));
		}else if(elementToAvaliate.eContainer() instanceof Subsystem){
			completePath = completePath.concat(this.getHierarchyOf((Subsystem) elementToAvaliate.eContainer()));
		}else if(elementToAvaliate.eContainer() instanceof Component){
			completePath = completePath.concat(this.getHierarchyOf((Component) elementToAvaliate.eContainer()));
		}else if(elementToAvaliate.eContainer() instanceof ArchitectureView){
			completePath = completePath.concat(this.getHierarchyOf((ArchitectureView) elementToAvaliate.eContainer()));
		}else if(elementToAvaliate.eContainer() instanceof SoftwareSystem){
			completePath = completePath.concat(this.getHierarchyOf((SoftwareSystem) elementToAvaliate.eContainer()));
		}else if(elementToAvaliate.eContainer() instanceof KDMModel){
			completePath = completePath.concat(this.getHierarchyOf((KDMModel) elementToAvaliate.eContainer()));
		}
		
		String nameObject = elementToAvaliate.getName() == null ? "anonymous" : elementToAvaliate.getName();
		String nameThisObjectIteration = (SEPARATOR_CLASS_TYPE.replace("?", elementToAvaliate.eClass().getName())).concat(nameObject);
		
		return (completePath.concat(SEPARATOR_TYPE)).concat(nameThisObjectIteration);
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.recovers.recoverStructureHierarchy.interfaces.KDMRecoverGenericStructureHierarchy#getHierarchyOf(org.eclipse.gmt.modisco.omg.kdm.structure.Subsystem)
	 */
	@Override
	public String getHierarchyOf(Subsystem elementToAvaliate) {
		String completePath = "";
		
		if(elementToAvaliate.eContainer() instanceof Layer){
			completePath = completePath.concat(this.getHierarchyOf((Layer) elementToAvaliate.eContainer()));
		}else if(elementToAvaliate.eContainer() instanceof Subsystem){
			completePath = completePath.concat(this.getHierarchyOf((Subsystem) elementToAvaliate.eContainer()));
		}else if(elementToAvaliate.eContainer() instanceof Component){
			completePath = completePath.concat(this.getHierarchyOf((Component) elementToAvaliate.eContainer()));
		}else if(elementToAvaliate.eContainer() instanceof ArchitectureView){
			completePath = completePath.concat(this.getHierarchyOf((ArchitectureView) elementToAvaliate.eContainer()));
		}else if(elementToAvaliate.eContainer() instanceof SoftwareSystem){
			completePath = completePath.concat(this.getHierarchyOf((SoftwareSystem) elementToAvaliate.eContainer()));
		}else if(elementToAvaliate.eContainer() instanceof KDMModel){
			completePath = completePath.concat(this.getHierarchyOf((KDMModel) elementToAvaliate.eContainer()));
		}
		
		String nameObject = elementToAvaliate.getName() == null ? "anonymous" : elementToAvaliate.getName();
		String nameThisObjectIteration = (SEPARATOR_CLASS_TYPE.replace("?", elementToAvaliate.eClass().getName())).concat(nameObject);
		
		return (completePath.concat(SEPARATOR_TYPE)).concat(nameThisObjectIteration);
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.recovers.recoverStructureHierarchy.interfaces.KDMRecoverGenericStructureHierarchy#getHierarchyOf(org.eclipse.gmt.modisco.omg.kdm.structure.Component)
	 */
	@Override
	public String getHierarchyOf(Component elementToAvaliate) {
		String completePath = "";
		
		if(elementToAvaliate.eContainer() instanceof Layer){
			completePath = completePath.concat(this.getHierarchyOf((Layer) elementToAvaliate.eContainer()));
		}else if(elementToAvaliate.eContainer() instanceof Subsystem){
			completePath = completePath.concat(this.getHierarchyOf((Subsystem) elementToAvaliate.eContainer()));
		}else if(elementToAvaliate.eContainer() instanceof Component){
			completePath = completePath.concat(this.getHierarchyOf((Component) elementToAvaliate.eContainer()));
		}else if(elementToAvaliate.eContainer() instanceof ArchitectureView){
			completePath = completePath.concat(this.getHierarchyOf((ArchitectureView) elementToAvaliate.eContainer()));
		}else if(elementToAvaliate.eContainer() instanceof SoftwareSystem){
			completePath = completePath.concat(this.getHierarchyOf((SoftwareSystem) elementToAvaliate.eContainer()));
		}else if(elementToAvaliate.eContainer() instanceof KDMModel){
			completePath = completePath.concat(this.getHierarchyOf((KDMModel) elementToAvaliate.eContainer()));
		}
		
		String nameObject = elementToAvaliate.getName() == null ? "anonymous" : elementToAvaliate.getName();
		String nameThisObjectIteration = (SEPARATOR_CLASS_TYPE.replace("?", elementToAvaliate.eClass().getName())).concat(nameObject);
		
		return (completePath.concat(SEPARATOR_TYPE)).concat(nameThisObjectIteration);
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.recovers.recoverStructureHierarchy.interfaces.KDMRecoverGenericStructureHierarchy#getHierarchyOf(org.eclipse.gmt.modisco.omg.kdm.structure.ArchitectureView)
	 */
	@Override
	public String getHierarchyOf(ArchitectureView elementToAvaliate) {
		String completePath = "";
		
		if(elementToAvaliate.eContainer() instanceof Layer){
			completePath = completePath.concat(this.getHierarchyOf((Layer) elementToAvaliate.eContainer()));
		}else if(elementToAvaliate.eContainer() instanceof Subsystem){
			completePath = completePath.concat(this.getHierarchyOf((Subsystem) elementToAvaliate.eContainer()));
		}else if(elementToAvaliate.eContainer() instanceof Component){
			completePath = completePath.concat(this.getHierarchyOf((Component) elementToAvaliate.eContainer()));
		}else if(elementToAvaliate.eContainer() instanceof ArchitectureView){
			completePath = completePath.concat(this.getHierarchyOf((ArchitectureView) elementToAvaliate.eContainer()));
		}else if(elementToAvaliate.eContainer() instanceof SoftwareSystem){
			completePath = completePath.concat(this.getHierarchyOf((SoftwareSystem) elementToAvaliate.eContainer()));
		}else if(elementToAvaliate.eContainer() instanceof KDMModel){
			completePath = completePath.concat(this.getHierarchyOf((KDMModel) elementToAvaliate.eContainer()));
		}
		
		String nameObject = elementToAvaliate.getName() == null ? "anonymous" : elementToAvaliate.getName();
		String nameThisObjectIteration = (SEPARATOR_CLASS_TYPE.replace("?", elementToAvaliate.eClass().getName())).concat(nameObject);
		
		return (completePath.concat(SEPARATOR_TYPE)).concat(nameThisObjectIteration);
	}

	/* (non-Javadoc)
	 * @see br.ufscar.kdm_manager.core.recovers.recoverStructureHierarchy.interfaces.KDMRecoverGenericStructureHierarchy#getHierarchyOf(org.eclipse.gmt.modisco.omg.kdm.structure.SoftwareSystem)
	 */
	@Override
	public String getHierarchyOf(SoftwareSystem elementToAvaliate) {
		String completePath = "";
		
		if(elementToAvaliate.eContainer() instanceof Layer){
			completePath = completePath.concat(this.getHierarchyOf((Layer) elementToAvaliate.eContainer()));
		}else if(elementToAvaliate.eContainer() instanceof Subsystem){
			completePath = completePath.concat(this.getHierarchyOf((Subsystem) elementToAvaliate.eContainer()));
		}else if(elementToAvaliate.eContainer() instanceof Component){
			completePath = completePath.concat(this.getHierarchyOf((Component) elementToAvaliate.eContainer()));
		}else if(elementToAvaliate.eContainer() instanceof ArchitectureView){
			completePath = completePath.concat(this.getHierarchyOf((ArchitectureView) elementToAvaliate.eContainer()));
		}else if(elementToAvaliate.eContainer() instanceof SoftwareSystem){
			completePath = completePath.concat(this.getHierarchyOf((SoftwareSystem) elementToAvaliate.eContainer()));
		}else if(elementToAvaliate.eContainer() instanceof KDMModel){
			completePath = completePath.concat(this.getHierarchyOf((KDMModel) elementToAvaliate.eContainer()));
		}
		
		String nameObject = elementToAvaliate.getName() == null ? "anonymous" : elementToAvaliate.getName();
		String nameThisObjectIteration = (SEPARATOR_CLASS_TYPE.replace("?", elementToAvaliate.eClass().getName())).concat(nameObject);
		
		return (completePath.concat(SEPARATOR_TYPE)).concat(nameThisObjectIteration);
	}


}
