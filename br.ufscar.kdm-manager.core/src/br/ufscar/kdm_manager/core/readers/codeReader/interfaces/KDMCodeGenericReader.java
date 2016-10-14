package br.ufscar.kdm_manager.core.readers.codeReader.interfaces;

import java.util.List;

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

public interface  KDMCodeGenericReader<T> {

	public List<T> getAllFrom(Segment segmentToSearch);
	
	public List<T> getAllFrom(CodeModel codeModelToSearch);
	
	public List<T> getAllFrom(Package packageToSearch);
	
	public List<T> getAllFrom(ClassUnit classUnitToSearch);
	
	public List<T> getAllFrom(InterfaceUnit interfaceUnitToSearch);
	
	public List<T> getAllFrom(EnumeratedType enumeratedTypeToSearch);
	
	public List<T> getAllFrom(StorableUnit storableUnitToSearch);

	public List<T> getAllFrom(MethodUnit methodUnitToSearch);
	
	public List<T> getAllFrom(Signature signatureUnitToSearch);
	
	public List<T> getAllFrom(ParameterUnit parameterUnitUnitToSearch);

	public List<T> getAllFrom(BlockUnit blockUnitToSearch);
    
	public List<T> getAllFrom(ActionElement actionElementToSearch);
}
