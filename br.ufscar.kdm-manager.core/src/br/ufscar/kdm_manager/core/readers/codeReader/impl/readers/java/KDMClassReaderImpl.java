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

import br.ufscar.kdm_manager.core.filters.validateFilter.interfaces.ValidateFilter;
import br.ufscar.kdm_manager.core.readers.codeReader.interfaces.KDMCodeGenericReader;
import br.ufscar.kdm_manager.core.readers.modelReader.factory.KDMModelReaderJavaFactory;

public class KDMClassReaderImpl implements KDMCodeGenericReader<ClassUnit>{

	private boolean hasNoFilter = true;
	private boolean hasFilter = false;

	private ValidateFilter<ClassUnit, ?> filter = null;

	public KDMClassReaderImpl() {
		super();
	}

	public KDMClassReaderImpl(ValidateFilter<ClassUnit, ?> elementName) {
		this.hasNoFilter = false;
		this.hasFilter  = true;
		this.filter = elementName;
	}
	
	private boolean validateFilter(ClassUnit elementToValidate) {
		if(this.hasNoFilter){
			return true;
		}else if(this.hasFilter){
			return this.filter.validateElement(elementToValidate);
		}
		return false;
	}	

	@Override
	public List<ClassUnit> getAllFrom(Segment segmentToSearch) {
		
		List<ClassUnit> classUnitRecovered = new ArrayList<ClassUnit>();

		Map<String, List<CodeModel>> models = KDMModelReaderJavaFactory.eINSTANCE.createKDMCodeModelReader().getAllFromSegment(segmentToSearch);

		for (String nameCodeModel : models.keySet()) {

			for (CodeModel codeModel : models.get(nameCodeModel)) {

				classUnitRecovered.addAll(this.getAllClassesFrom(codeModel));
			}
		}
		
		return classUnitRecovered;
	}

	@Override
	public List<ClassUnit> getAllFrom(CodeModel codeModelToSearch) {
		return this.getAllClassesFrom(codeModelToSearch);
	}

	@Override
	public List<ClassUnit> getAllFrom(Package packageToSearch) {
		return this.getAllClassesFrom(packageToSearch);
	}

	@Override
	public List<ClassUnit> getAllFrom(ClassUnit classUnitToSearch) {
		return this.getAllClassesFrom(classUnitToSearch);
	}

	@Override
	public List<ClassUnit> getAllFrom(InterfaceUnit interfaceUnitToSearch) {
		return this.getAllClassesFrom(interfaceUnitToSearch);
	}

	@Override
	public List<ClassUnit> getAllFrom(EnumeratedType enumeratedTypeToSearch) {
		return this.getAllClassesFrom(enumeratedTypeToSearch);
	}

	@Override
	@Deprecated
	public List<ClassUnit> getAllFrom(MethodUnit methodUnitToSearch) {
		return null;
	}

	@Override
	@Deprecated
	public List<ClassUnit> getAllFrom(StorableUnit storableUnitToSearch) {
		return null;
	}

	@Override
	@Deprecated
	public List<ClassUnit> getAllFrom(BlockUnit blockUnitToSearch) {
		return null;
	}

	@Override
	@Deprecated
	public List<ClassUnit> getAllFrom(Signature signatureUnitToSearch) {
		return null;
	}

	@Override
	@Deprecated
	public List<ClassUnit> getAllFrom(ActionElement actionElementToSearch) {
		return null;
	}

	@Override
	@Deprecated
	public List<ClassUnit> getAllFrom(ParameterUnit parameterUnitUnitToSearch) {
		return null;
	}
	
	
	private List<ClassUnit> getAllClassesFrom(CodeModel codeModelToSearch) {
		List<ClassUnit> allClassUnits = new ArrayList<ClassUnit>();

		for (AbstractCodeElement abstractCodeElement : codeModelToSearch.getCodeElement()) {
			
			if(abstractCodeElement instanceof ClassUnit){
				
				if (validateFilter((ClassUnit) abstractCodeElement)) {
					allClassUnits.add((ClassUnit) abstractCodeElement);
				}
				allClassUnits.addAll(this.getAllClassesFrom((ClassUnit) abstractCodeElement));
				
			}else if(abstractCodeElement instanceof InterfaceUnit){
				
				allClassUnits.addAll(this.getAllClassesFrom((InterfaceUnit) abstractCodeElement));
				
			}else if(abstractCodeElement instanceof EnumeratedType){
				
				allClassUnits.addAll(this.getAllClassesFrom((EnumeratedType) abstractCodeElement));
				
			}else if(abstractCodeElement instanceof Package){
				
				allClassUnits.addAll(this.getAllClassesFrom((Package) abstractCodeElement));
				
			}
		
		
		}
		
		return allClassUnits;
	}

	private List<ClassUnit> getAllClassesFrom(ClassUnit classUnitToSearch) {
		List<ClassUnit> allClassUnits = new ArrayList<ClassUnit>();

		for (CodeItem codeItem : classUnitToSearch.getCodeElement()) {
			
			if(codeItem instanceof ClassUnit){
				
				if (validateFilter((ClassUnit) codeItem)) {
					allClassUnits.add((ClassUnit) codeItem);
				}
				allClassUnits.addAll(this.getAllClassesFrom((ClassUnit) codeItem));
				
			}else if(codeItem instanceof InterfaceUnit){
				
				allClassUnits.addAll(this.getAllClassesFrom((InterfaceUnit) codeItem));
			
			}else if (codeItem instanceof EnumeratedType) {
				
				allClassUnits.addAll(this.getAllClassesFrom((EnumeratedType) codeItem));
				
			}
		
		}
		
		return allClassUnits;
	}


	private List<ClassUnit> getAllClassesFrom(InterfaceUnit interfaceUnitToSearch) {
		List<ClassUnit> allClassUnits = new ArrayList<ClassUnit>();

		for (CodeItem codeItem : interfaceUnitToSearch.getCodeElement()) {
			
			if(codeItem instanceof ClassUnit){
				
				if (validateFilter((ClassUnit) codeItem)) {
					allClassUnits.add((ClassUnit) codeItem);
				}
				allClassUnits.addAll(this.getAllClassesFrom((ClassUnit) codeItem));
				
			}else if(codeItem instanceof InterfaceUnit){
				
				allClassUnits.addAll(this.getAllClassesFrom((InterfaceUnit) codeItem));
			
			}else if (codeItem instanceof EnumeratedType) {
				
				allClassUnits.addAll(this.getAllClassesFrom((EnumeratedType) codeItem));
				
			}
			
		}
		
		return allClassUnits;
	}
	
	private List<ClassUnit> getAllClassesFrom(EnumeratedType enumeratedTypeToSearch) {
		List<ClassUnit> allClassUnits = new ArrayList<ClassUnit>();

		for (CodeItem codeItem : enumeratedTypeToSearch.getCodeElement()) {
			
			if(codeItem instanceof ClassUnit){
				
				if (validateFilter((ClassUnit) codeItem)) {
					allClassUnits.add((ClassUnit) codeItem);
				}
				allClassUnits.addAll(this.getAllClassesFrom((ClassUnit) codeItem));
				
			}else if(codeItem instanceof InterfaceUnit){
				
				allClassUnits.addAll(this.getAllClassesFrom((InterfaceUnit) codeItem));
			
			}else if (codeItem instanceof EnumeratedType) {
				
				allClassUnits.addAll(this.getAllClassesFrom((EnumeratedType) codeItem));
				
			}
		
		}
		
		return allClassUnits;
	}
	
	private List<ClassUnit> getAllClassesFrom(Package packageToSearch) {
		List<ClassUnit> allClassUnits = new ArrayList<ClassUnit>();

		for (AbstractCodeElement abstractCodeElement : packageToSearch.getCodeElement()) {
			
			if(abstractCodeElement instanceof ClassUnit){
				
				if (validateFilter((ClassUnit) abstractCodeElement)) {
					allClassUnits.add((ClassUnit) abstractCodeElement);
				}
				allClassUnits.addAll(this.getAllClassesFrom((ClassUnit) abstractCodeElement));
				
			}else if(abstractCodeElement instanceof InterfaceUnit){
				
				allClassUnits.addAll(this.getAllClassesFrom((InterfaceUnit) abstractCodeElement));
			
			}else if (abstractCodeElement instanceof EnumeratedType) {
				
				allClassUnits.addAll(this.getAllClassesFrom((EnumeratedType) abstractCodeElement));
				
			}else if (abstractCodeElement instanceof Package) {
				
				allClassUnits.addAll(this.getAllClassesFrom((Package) abstractCodeElement));

			}
		
		}
		
		return allClassUnits;
	}

}
