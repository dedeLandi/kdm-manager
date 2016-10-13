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
