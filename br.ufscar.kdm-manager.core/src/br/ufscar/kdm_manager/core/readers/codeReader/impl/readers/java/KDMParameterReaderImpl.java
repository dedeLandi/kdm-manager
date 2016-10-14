package br.ufscar.kdm_manager.core.readers.codeReader.impl.readers.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
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

public class KDMParameterReaderImpl implements KDMCodeGenericReader<ParameterUnit> {

	private boolean hasNoFilter = true;
	private boolean hasFilter = false;

	private ValidateFilter<ParameterUnit, ?> filter = null;

	public KDMParameterReaderImpl() {
		super();
	}

	public KDMParameterReaderImpl(ValidateFilter<ParameterUnit, ?> filter) {
		this.hasNoFilter = false;
		this.hasFilter  = true;
		this.filter = filter;
	}
	
	private boolean validateFilter(ParameterUnit elementToValidate) {
		if(this.hasNoFilter){
			return true;
		}else if(this.hasFilter){
			return this.filter.validateElement(elementToValidate);
		}
		return false;
	}	
	@Override
	public List<ParameterUnit> getAllFrom(Segment segmentToSearch) {
		List<ParameterUnit> parameterUnitRecovered = new ArrayList<ParameterUnit>();

		Map<String, List<CodeModel>> models = KDMModelReaderJavaFactory.eINSTANCE.createKDMCodeModelReader().getAllFromSegment(segmentToSearch);

		for (String nameCodeModel : models.keySet()) {

			for (CodeModel codeModel : models.get(nameCodeModel)) {

				parameterUnitRecovered.addAll(this.getAllParametersFrom(codeModel));
			}
		}

		return parameterUnitRecovered;
	}

	@Override
	public List<ParameterUnit> getAllFrom(CodeModel codeModelToSearch) {
		return this.getAllParametersFrom(codeModelToSearch);
	}

	@Override
	public List<ParameterUnit> getAllFrom(Package packageToSearch) {
		return this.getAllParametersFrom(packageToSearch);
	}

	@Override
	public List<ParameterUnit> getAllFrom(ClassUnit classUnitToSearch) {
		return this.getAllParametersFrom(classUnitToSearch);
	}

	@Override
	public List<ParameterUnit> getAllFrom(InterfaceUnit interfaceUnitToSearch) {
		return this.getAllParametersFrom(interfaceUnitToSearch);
	}

	@Override
	public List<ParameterUnit> getAllFrom(EnumeratedType enumeratedTypeToSearch) {
		return this.getAllParametersFrom(enumeratedTypeToSearch);
	}

	@Override
	public List<ParameterUnit> getAllFrom(MethodUnit methodUnitToSearch) {
		return this.getAllParametersFrom(methodUnitToSearch);
	}

	@Override
	public List<ParameterUnit> getAllFrom(Signature signatureUnitToSearch) {
		return signatureUnitToSearch.getParameterUnit();
	}

	@Override
	@Deprecated
	public List<ParameterUnit> getAllFrom(ParameterUnit parameterUnitUnitToSearch) {
		return null;
	}
	
	@Override
	@Deprecated
	public List<ParameterUnit> getAllFrom(StorableUnit storableUnitToSearch) {
		return null;
	}

	@Override
	@Deprecated
	public List<ParameterUnit> getAllFrom(BlockUnit blockUnitToSearch) {
		return null;
	}
	
	@Override
	@Deprecated
	public List<ParameterUnit> getAllFrom(ActionElement actionElementToSearch) {
		return null;
	}
	
	private List<ParameterUnit> getAllParametersFrom(CodeModel codeModelToSearch) {
		List<ParameterUnit> modelParameters = new ArrayList<ParameterUnit>();
		
		for (AbstractCodeElement abstractCodeElement : codeModelToSearch.getCodeElement()) {
			
			if(abstractCodeElement instanceof ClassUnit){
			
				modelParameters.addAll(this.getAllParametersFrom((ClassUnit)abstractCodeElement));
				
			}else if(abstractCodeElement instanceof InterfaceUnit){
				
				modelParameters.addAll(this.getAllParametersFrom((InterfaceUnit)abstractCodeElement));
				
			}else if(abstractCodeElement instanceof EnumeratedType){
				
				modelParameters.addAll(this.getAllParametersFrom((EnumeratedType)abstractCodeElement));
				
			}else if(abstractCodeElement instanceof Package){
				
				modelParameters.addAll(this.getAllParametersFrom((Package)abstractCodeElement));
				
			}
			
		}
		
		return modelParameters;
	}
	
	private List<ParameterUnit> getAllParametersFrom(Package packageToSearch) {
		List<ParameterUnit> packageParameters = new ArrayList<ParameterUnit>();
		
		for (AbstractCodeElement abstractCodeElement : packageToSearch.getCodeElement()) {
			
			if(abstractCodeElement instanceof ClassUnit){
				
				packageParameters.addAll(this.getAllParametersFrom((ClassUnit)abstractCodeElement));
				
			}else if(abstractCodeElement instanceof InterfaceUnit){
				
				packageParameters.addAll(this.getAllParametersFrom((InterfaceUnit)abstractCodeElement));
				
			}else if(abstractCodeElement instanceof EnumeratedType){
			
				packageParameters.addAll(this.getAllParametersFrom((EnumeratedType)abstractCodeElement));
			
			}else if(abstractCodeElement instanceof Package){
				
				packageParameters.addAll(this.getAllParametersFrom((Package)abstractCodeElement));
				
			}
			
		}
		
		return packageParameters;
	}
	
	private List<ParameterUnit> getAllParametersFrom(ClassUnit classToSearch) {
		List<ParameterUnit> classParameters = new ArrayList<ParameterUnit>();
		
		for (CodeItem codeItem : classToSearch.getCodeElement()) {
			
			if(codeItem instanceof ClassUnit){
				
				classParameters.addAll(this.getAllParametersFrom((ClassUnit)codeItem));
				
			}else if(codeItem instanceof InterfaceUnit){
				
				classParameters.addAll(this.getAllParametersFrom((InterfaceUnit)codeItem));
				
			}else if(codeItem instanceof EnumeratedType){
			
				classParameters.addAll(this.getAllParametersFrom((EnumeratedType)codeItem));
				
			}else if(codeItem instanceof ParameterUnit){
				
				if(validateFilter((ParameterUnit)codeItem)){
					classParameters.add((ParameterUnit)codeItem);
				}
				
			}else if (codeItem instanceof MethodUnit){
				
				classParameters.addAll(this.getAllParametersFrom((MethodUnit)codeItem));
				
			}
			
		}
		
		return classParameters;
	}
	
	private List<ParameterUnit> getAllParametersFrom(InterfaceUnit interfaceToSearch) {
		List<ParameterUnit> interfaceParameters = new ArrayList<ParameterUnit>();
		
		for (CodeItem codeItem : interfaceToSearch.getCodeElement()) {
			
			if(codeItem instanceof ClassUnit){
				
				interfaceParameters.addAll(this.getAllParametersFrom((ClassUnit)codeItem));
				
			}else if(codeItem instanceof InterfaceUnit){
				
				interfaceParameters.addAll(this.getAllParametersFrom((InterfaceUnit)codeItem));
				
			}else if(codeItem instanceof EnumeratedType){
			
				interfaceParameters.addAll(this.getAllParametersFrom((EnumeratedType)codeItem));
				
			}else if(codeItem instanceof ParameterUnit){
				
				if(validateFilter((ParameterUnit)codeItem)){
					interfaceParameters.add((ParameterUnit)codeItem);
				}
				
			}else if (codeItem instanceof MethodUnit){
				
				interfaceParameters.addAll(this.getAllParametersFrom((MethodUnit)codeItem));
				
			}
			
		}
		
		return interfaceParameters;
	}
	
	private List<ParameterUnit> getAllParametersFrom(EnumeratedType enumeratedToSearch) {
		List<ParameterUnit> enumeratedTypeParameters = new ArrayList<ParameterUnit>();
		
		for (CodeItem codeItem : enumeratedToSearch.getCodeElement()) {
			
			if(codeItem instanceof ClassUnit){
				
				enumeratedTypeParameters.addAll(this.getAllParametersFrom((ClassUnit)codeItem));
				
			}else if(codeItem instanceof InterfaceUnit){
				
				enumeratedTypeParameters.addAll(this.getAllParametersFrom((InterfaceUnit)codeItem));
				
			}else if(codeItem instanceof EnumeratedType){
			
				enumeratedTypeParameters.addAll(this.getAllParametersFrom((EnumeratedType)codeItem));
				
			}else if(codeItem instanceof ParameterUnit){
			
				if(validateFilter((ParameterUnit)codeItem)){
					enumeratedTypeParameters.add((ParameterUnit)codeItem);
				}
			
			}else if (codeItem instanceof MethodUnit){
				
				enumeratedTypeParameters.addAll(this.getAllParametersFrom((MethodUnit)codeItem));
			
			}
			
		}
		
		return enumeratedTypeParameters;
	}
	
	private List<ParameterUnit> getAllParametersFrom(MethodUnit methodToSearch) {
		List<ParameterUnit> methodParameters = new ArrayList<ParameterUnit>();

		for (AbstractCodeElement abstractCodeElement : methodToSearch.getCodeElement()) {
			
			if(abstractCodeElement instanceof Signature){
				
				EList<ParameterUnit> parameterUnit = ((Signature)abstractCodeElement).getParameterUnit();
				for (ParameterUnit parameterUnit2 : parameterUnit) {
					if(validateFilter(parameterUnit2)){
						methodParameters.add(parameterUnit2);
					}
				}
				
			}
		}
		
		return methodParameters;
	}
}
