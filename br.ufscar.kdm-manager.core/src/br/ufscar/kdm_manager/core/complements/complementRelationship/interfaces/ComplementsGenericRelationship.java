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
package br.ufscar.kdm_manager.core.complements.complementRelationship.interfaces;

import org.eclipse.gmt.modisco.omg.kdm.action.ActionElement;
import org.eclipse.gmt.modisco.omg.kdm.action.BlockUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.ClassUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.CodeModel;
import org.eclipse.gmt.modisco.omg.kdm.code.EnumeratedType;
import org.eclipse.gmt.modisco.omg.kdm.code.InterfaceUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.MethodUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.Package;
import org.eclipse.gmt.modisco.omg.kdm.code.ParameterUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.Signature;
import org.eclipse.gmt.modisco.omg.kdm.code.StorableUnit;
import org.eclipse.gmt.modisco.omg.kdm.kdm.Segment;

public interface ComplementsGenericRelationship {

	
	public ClassUnit complementsRelationOf(ClassUnit classToUpdate);
	
	public Package complementsRelationOf(Package packageToUpdate);

	public BlockUnit complementsRelationOf(BlockUnit blockToUpdate);
	
	public StorableUnit complementsRelationOf(StorableUnit storableToUpdate);
	
	public MethodUnit complementsRelationOf(MethodUnit methodToUpdate);
	
	public ActionElement complementsRelationOf(ActionElement actionElementToUpdate);

	public ParameterUnit complementsRelationOf(ParameterUnit parameterToUpdate);
	
	public Signature complementsRelationOf(Signature signatureToUpdate);
	
	public InterfaceUnit complementsRelationOf(InterfaceUnit interfaceToUpdate);

	public EnumeratedType complementsRelationOf(EnumeratedType enumeratedTypeToUpdate);
	
	public Segment complementsRelationOf(Segment segmentToUpdate);
	
	public CodeModel complementsRelationOf(CodeModel codeModelToUpdate);
	
	
	
	
	
}
