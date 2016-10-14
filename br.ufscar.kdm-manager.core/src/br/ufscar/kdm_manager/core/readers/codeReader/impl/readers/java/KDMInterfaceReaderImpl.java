package br.ufscar.kdm_manager.core.readers.codeReader.impl.readers.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.gmt.modisco.omg.kdm.action.ActionElement;
import org.eclipse.gmt.modisco.omg.kdm.action.BlockUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.AbstractCodeElement;
import org.eclipse.gmt.modisco.omg.kdm.code.ClassUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.CodeItem;
import org.eclipse.gmt.modisco.omg.kdm.code.CodeModel;
import org.eclipse.gmt.modisco.omg.kdm.code.EnumeratedType;
import org.eclipse.gmt.modisco.omg.kdm.code.InterfaceUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.MethodUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.Package;
import org.eclipse.gmt.modisco.omg.kdm.code.ParameterUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.Signature;
import org.eclipse.gmt.modisco.omg.kdm.code.StorableUnit;
import org.eclipse.gmt.modisco.omg.kdm.kdm.Segment;

import br.ufscar.kdm_manager.core.readers.codeReader.interfaces.KDMCodeGenericReader;
import br.ufscar.kdm_manager.core.readers.modelReader.factory.KDMModelReaderJavaFactory;

public class KDMInterfaceReaderImpl implements KDMCodeGenericReader<InterfaceUnit>{

	private boolean hasNoFilter = false;
	private boolean hasFilterName = false;

	private String filterName = "";

	public KDMInterfaceReaderImpl() {
		super();
	}

	public KDMInterfaceReaderImpl(String elementName) {
		this.hasNoFilter = false;
		this.hasFilterName  = true;
		this.filterName = elementName;
	}
	
	private boolean validateFilter(InterfaceUnit elementToValidate) {
		if(this.hasNoFilter){
			return true;
		}else if(this.hasFilterName){
			if(elementToValidate.getName().equalsIgnoreCase(this.filterName)){
				return true;
			}
		}
		return false;
	}	
	@Override
	public List<InterfaceUnit> getAllFrom(Segment segmentToSearch) {
		
		List<InterfaceUnit> interfaceUnitRecovered = new ArrayList<InterfaceUnit>();

		Map<String, List<CodeModel>> models = KDMModelReaderJavaFactory.eINSTANCE.createKDMCodeModelReader().getAllFromSegment(segmentToSearch);

		for (String nameCodeModel : models.keySet()) {

			for (CodeModel codeModel : models.get(nameCodeModel)) {

				interfaceUnitRecovered.addAll(this.getAllInterfaceFrom(codeModel));
			}
		}
		
		return interfaceUnitRecovered;
	}

	@Override
	public List<InterfaceUnit> getAllFrom(CodeModel codeModelToSearch) {
		return this.getAllInterfaceFrom(codeModelToSearch);
	}

	@Override
	public List<InterfaceUnit> getAllFrom(Package packageToSearch) {
		return this.getAllInterfacesFrom(packageToSearch);
	}

	@Override
	public List<InterfaceUnit> getAllFrom(ClassUnit classUnitToSearch) {
		return this.getAllInterfacesFrom(classUnitToSearch);
	}

	@Override
	public List<InterfaceUnit> getAllFrom(InterfaceUnit interfaceUnitToSearch) {
		return this.getAllInterfacesFrom(interfaceUnitToSearch);
	}

	@Override
	public List<InterfaceUnit> getAllFrom(EnumeratedType enumeratedTypeToSearch) {
		return this.getAllInterfacesFrom(enumeratedTypeToSearch);
	}

	@Override
	@Deprecated
	public List<InterfaceUnit> getAllFrom(MethodUnit methodUnitToSearch) {
		return null;
	}

	@Override
	@Deprecated
	public List<InterfaceUnit> getAllFrom(StorableUnit storableUnitToSearch) {
		return null;
	}

	@Override
	@Deprecated
	public List<InterfaceUnit> getAllFrom(BlockUnit blockUnitToSearch) {
		return null;
	}

	@Override
	@Deprecated
	public List<InterfaceUnit> getAllFrom(Signature signatureUnitToSearch) {
		return null;
	}

	@Override
	@Deprecated
	public List<InterfaceUnit> getAllFrom(ActionElement actionElementToSearch) {
		return null;
	}

	@Override
	@Deprecated
	public List<InterfaceUnit> getAllFrom(ParameterUnit parameterUnitUnitToSearch) {
		return null;
	}
	
	
	private List<InterfaceUnit> getAllInterfaceFrom(CodeModel codeModelToSearch) {
		List<InterfaceUnit> allInterfaceUnit = new ArrayList<InterfaceUnit>();

		for (AbstractCodeElement abstractCodeElement : codeModelToSearch.getCodeElement()) {
			
			if(abstractCodeElement instanceof ClassUnit){
				
				allInterfaceUnit.addAll(this.getAllInterfacesFrom((ClassUnit) abstractCodeElement));
				
			}else if(abstractCodeElement instanceof InterfaceUnit){
				
				if(validateFilter((InterfaceUnit) abstractCodeElement)){
					allInterfaceUnit.add((InterfaceUnit) abstractCodeElement);
				}
				allInterfaceUnit.addAll(this.getAllInterfacesFrom((InterfaceUnit) abstractCodeElement));
				
			}else if(abstractCodeElement instanceof EnumeratedType){
				
				allInterfaceUnit.addAll(this.getAllInterfacesFrom((EnumeratedType) abstractCodeElement));
				
			}else if(abstractCodeElement instanceof Package){
				
				allInterfaceUnit.addAll(this.getAllInterfacesFrom((Package) abstractCodeElement));
				
			}
		
		
		}
		
		return allInterfaceUnit;
	}

	private List<InterfaceUnit> getAllInterfacesFrom(ClassUnit classUnitToSearch) {
		List<InterfaceUnit> allInterfaceUnit = new ArrayList<InterfaceUnit>();

		for (CodeItem codeItem : classUnitToSearch.getCodeElement()) {
			
			if(codeItem instanceof ClassUnit){
				
				allInterfaceUnit.addAll(this.getAllInterfacesFrom((ClassUnit) codeItem));
				
			}else if(codeItem instanceof InterfaceUnit){
				
				if(validateFilter((InterfaceUnit) codeItem)){
					allInterfaceUnit.add((InterfaceUnit) codeItem);
				}
				allInterfaceUnit.addAll(this.getAllInterfacesFrom((InterfaceUnit) codeItem));
			
			}else if (codeItem instanceof EnumeratedType) {
				
				allInterfaceUnit.addAll(this.getAllInterfacesFrom((EnumeratedType) codeItem));
				
			}
		
		}
		
		return allInterfaceUnit;
	}


	private List<InterfaceUnit> getAllInterfacesFrom(InterfaceUnit interfaceUnitToSearch) {
		List<InterfaceUnit> allInterfaceUnit = new ArrayList<InterfaceUnit>();

		for (CodeItem codeItem : interfaceUnitToSearch.getCodeElement()) {
			
			if(codeItem instanceof ClassUnit){
				
				allInterfaceUnit.addAll(this.getAllInterfacesFrom((ClassUnit) codeItem));
				
			}else if(codeItem instanceof InterfaceUnit){
				
				if(validateFilter((InterfaceUnit) codeItem)){
					allInterfaceUnit.add((InterfaceUnit) codeItem);
				}
				allInterfaceUnit.addAll(this.getAllInterfacesFrom((InterfaceUnit) codeItem));
			
			}else if (codeItem instanceof EnumeratedType) {
				
				allInterfaceUnit.addAll(this.getAllInterfacesFrom((EnumeratedType) codeItem));
				
			}
			
		}
		
		return allInterfaceUnit;
	}
	
	private List<InterfaceUnit> getAllInterfacesFrom(EnumeratedType enumeratedTypeToSearch) {
		List<InterfaceUnit> allInterfaceUnit = new ArrayList<InterfaceUnit>();

		for (CodeItem codeItem : enumeratedTypeToSearch.getCodeElement()) {
			
			if(codeItem instanceof ClassUnit){
				
				allInterfaceUnit.addAll(this.getAllInterfacesFrom((ClassUnit) codeItem));
				
			}else if(codeItem instanceof InterfaceUnit){
				
				if(validateFilter((InterfaceUnit) codeItem)){
					allInterfaceUnit.add((InterfaceUnit) codeItem);
				}
				allInterfaceUnit.addAll(this.getAllInterfacesFrom((InterfaceUnit) codeItem));
			
			}else if (codeItem instanceof EnumeratedType) {
				
				allInterfaceUnit.addAll(this.getAllInterfacesFrom((EnumeratedType) codeItem));
				
			}
		
		}
		
		return allInterfaceUnit;
	}
	
	private List<InterfaceUnit> getAllInterfacesFrom(Package packageToSearch) {
		List<InterfaceUnit> allInterfaceUnit = new ArrayList<InterfaceUnit>();

		for (AbstractCodeElement abstractCodeElement : packageToSearch.getCodeElement()) {
			
			if(abstractCodeElement instanceof ClassUnit){
				
				allInterfaceUnit.addAll(this.getAllInterfacesFrom((ClassUnit) abstractCodeElement));
				
			}else if(abstractCodeElement instanceof InterfaceUnit){
				
				if(validateFilter((InterfaceUnit) abstractCodeElement)){
					allInterfaceUnit.add((InterfaceUnit) abstractCodeElement);
				}
				allInterfaceUnit.addAll(this.getAllInterfacesFrom((InterfaceUnit) abstractCodeElement));
			
			}else if (abstractCodeElement instanceof EnumeratedType) {
				
				allInterfaceUnit.addAll(this.getAllInterfacesFrom((EnumeratedType) abstractCodeElement));
				
			}else if (abstractCodeElement instanceof Package) {
				
				allInterfaceUnit.addAll(this.getAllInterfacesFrom((Package) abstractCodeElement));

			}
		
		}
		
		return allInterfaceUnit;
	}

}
