package br.ufscar.kdm_manager.core.recovers.recoverHierarchy.interfaces;

import org.eclipse.gmt.modisco.omg.kdm.action.ActionElement;
import org.eclipse.gmt.modisco.omg.kdm.action.BlockUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.ClassUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.EnumeratedType;
import org.eclipse.gmt.modisco.omg.kdm.code.InterfaceUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.MethodUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.Package;
import org.eclipse.gmt.modisco.omg.kdm.code.ParameterUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.Signature;
import org.eclipse.gmt.modisco.omg.kdm.code.StorableUnit;

public interface RecoverGenericHierarchy<R> {

	public static final String SEPARATOR_TYPE = ".";
	public static final String SEPARATOR_CLASS_TYPE = "[?]";
	public static final String SEPARATOR_IMPLEMENT_TYPE = "{?}";
	
	public R getHierarchyOf(Package packageToAvaliate);

	public R getHierarchyOf(ClassUnit classToAvaliate);
	
	public R getHierarchyOf(InterfaceUnit interfaceToAvaliate);
	
	public R getHierarchyOf(EnumeratedType enumeratedTypeToAvaliate);
	
	public R getHierarchyOf(StorableUnit storableToAvaliate);
	
	public R getHierarchyOf(MethodUnit methodToAvaliate);
	
	public R getHierarchyOf(Signature signatureToAvaliate);
	
	public R getHierarchyOf(ParameterUnit parameterToAvaliate);

	public R getHierarchyOf(BlockUnit blockToAvaliate);
	
	public R getHierarchyOf(ActionElement actionElementToAvaliate);
	
}
