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

public class KDMEnumeratedTypeReaderImpl implements KDMCodeGenericReader<EnumeratedType>{
	
	private boolean hasNoFilter = true;
	private boolean hasFilter = false;

	private ValidateFilter<EnumeratedType, ?> filter = null;

	public KDMEnumeratedTypeReaderImpl() {
		super();
	}

	public KDMEnumeratedTypeReaderImpl(ValidateFilter<EnumeratedType, ?> filter) {
		this.hasNoFilter = false;
		this.hasFilter = true;
		this.filter = filter;
	}
	
	private boolean validateFilter(EnumeratedType elementToValidate) {
		if(this.hasNoFilter){
			return true;
		}else if(this.hasFilter){
			return this.filter.validateElement(elementToValidate);
		}
		return false;
	}	

	@Override
	public List<EnumeratedType> getAllFrom(Segment segmentToSearch) {
		
		List<EnumeratedType> enumeratedTypeRecovered = new ArrayList<EnumeratedType>();

		Map<String, List<CodeModel>> models = KDMModelReaderJavaFactory.eINSTANCE.createKDMCodeModelReader().getAllFromSegment(segmentToSearch);

		for (String nameCodeModel : models.keySet()) {

			for (CodeModel codeModel : models.get(nameCodeModel)) {

				enumeratedTypeRecovered.addAll(this.getAllEnumeratedTypeFrom(codeModel));
			}
		}
		
		return enumeratedTypeRecovered;
	}

	@Override
	public List<EnumeratedType> getAllFrom(CodeModel codeModelToSearch) {
		return this.getAllEnumeratedTypeFrom(codeModelToSearch);
	}

	@Override
	public List<EnumeratedType> getAllFrom(Package packageToSearch) {
		return this.getAllEnumeratedTypeFrom(packageToSearch);
	}

	@Override
	public List<EnumeratedType> getAllFrom(ClassUnit classUnitToSearch) {
		return this.getAllEnumeratedTypeFrom(classUnitToSearch);
	}

	@Override
	public List<EnumeratedType> getAllFrom(InterfaceUnit interfaceUnitToSearch) {
		return this.getAllEnumeratedTypeFrom(interfaceUnitToSearch);
	}

	@Override
	public List<EnumeratedType> getAllFrom(EnumeratedType enumeratedTypeToSearch) {
		return this.getAllEnumeratedTypeFrom(enumeratedTypeToSearch);
	}

	@Override
	@Deprecated
	public List<EnumeratedType> getAllFrom(MethodUnit methodUnitToSearch) {
		return null;
	}

	@Override
	@Deprecated
	public List<EnumeratedType> getAllFrom(StorableUnit storableUnitToSearch) {
		return null;
	}

	@Override
	@Deprecated
	public List<EnumeratedType> getAllFrom(BlockUnit blockUnitToSearch) {
		return null;
	}

	@Override
	@Deprecated
	public List<EnumeratedType> getAllFrom(Signature signatureUnitToSearch) {
		return null;
	}

	@Override
	@Deprecated
	public List<EnumeratedType> getAllFrom(ActionElement actionElementToSearch) {
		return null;
	}

	@Override
	@Deprecated
	public List<EnumeratedType> getAllFrom(ParameterUnit parameterUnitUnitToSearch) {
		return null;
	}
	
	
	private List<EnumeratedType> getAllEnumeratedTypeFrom(CodeModel codeModelToSearch) {
		List<EnumeratedType> allEnumeratedType = new ArrayList<EnumeratedType>();

		for (AbstractCodeElement abstractCodeElement : codeModelToSearch.getCodeElement()) {
			
			if(abstractCodeElement instanceof ClassUnit){
				
				allEnumeratedType.addAll(this.getAllEnumeratedTypeFrom((ClassUnit) abstractCodeElement));
				
			}else if(abstractCodeElement instanceof InterfaceUnit){
				
				allEnumeratedType.addAll(this.getAllEnumeratedTypeFrom((InterfaceUnit) abstractCodeElement));
				
			}else if(abstractCodeElement instanceof EnumeratedType){
				
				if (validateFilter((EnumeratedType) abstractCodeElement)) {
					allEnumeratedType.add((EnumeratedType) abstractCodeElement);
				}
				allEnumeratedType.addAll(this.getAllEnumeratedTypeFrom((EnumeratedType) abstractCodeElement));
				
			}else if(abstractCodeElement instanceof Package){
				
				allEnumeratedType.addAll(this.getAllEnumeratedTypeFrom((Package) abstractCodeElement));
				
			}
		
		
		}
		
		return allEnumeratedType;
	}

	private List<EnumeratedType> getAllEnumeratedTypeFrom(ClassUnit classUnitToSearch) {
		List<EnumeratedType> allEnumeratedType = new ArrayList<EnumeratedType>();

		for (CodeItem codeItem : classUnitToSearch.getCodeElement()) {
			
			if(codeItem instanceof ClassUnit){
				
				allEnumeratedType.addAll(this.getAllEnumeratedTypeFrom((ClassUnit) codeItem));
				
			}else if(codeItem instanceof InterfaceUnit){
				
				allEnumeratedType.addAll(this.getAllEnumeratedTypeFrom((InterfaceUnit) codeItem));
			
			}else if (codeItem instanceof EnumeratedType) {
				
				if (validateFilter((EnumeratedType) codeItem)) {
					allEnumeratedType.add((EnumeratedType) codeItem);
				}
				allEnumeratedType.addAll(this.getAllEnumeratedTypeFrom((EnumeratedType) codeItem));
				
			}
		
		}
		
		return allEnumeratedType;
	}


	private List<EnumeratedType> getAllEnumeratedTypeFrom(InterfaceUnit interfaceUnitToSearch) {
		List<EnumeratedType> allEnumeratedType = new ArrayList<EnumeratedType>();

		for (CodeItem codeItem : interfaceUnitToSearch.getCodeElement()) {
			
			if(codeItem instanceof ClassUnit){
				
				allEnumeratedType.addAll(this.getAllEnumeratedTypeFrom((ClassUnit) codeItem));
				
			}else if(codeItem instanceof InterfaceUnit){
				
				allEnumeratedType.addAll(this.getAllEnumeratedTypeFrom((InterfaceUnit) codeItem));
			
			}else if (codeItem instanceof EnumeratedType) {
				
				if (validateFilter((EnumeratedType) codeItem)) {
					allEnumeratedType.add((EnumeratedType) codeItem);
				}
				allEnumeratedType.addAll(this.getAllEnumeratedTypeFrom((EnumeratedType) codeItem));
				
			}
			
		}
		
		return allEnumeratedType;
	}
	
	private List<EnumeratedType> getAllEnumeratedTypeFrom(EnumeratedType enumeratedTypeToSearch) {
		List<EnumeratedType> allEnumeratedType = new ArrayList<EnumeratedType>();

		for (CodeItem codeItem : enumeratedTypeToSearch.getCodeElement()) {
			
			if(codeItem instanceof ClassUnit){
				
				allEnumeratedType.addAll(this.getAllEnumeratedTypeFrom((ClassUnit) codeItem));
				
			}else if(codeItem instanceof InterfaceUnit){
				
				allEnumeratedType.addAll(this.getAllEnumeratedTypeFrom((InterfaceUnit) codeItem));
			
			}else if (codeItem instanceof EnumeratedType) {
				
				if (validateFilter((EnumeratedType) codeItem)) {
					allEnumeratedType.add((EnumeratedType) codeItem);
				}
				allEnumeratedType.addAll(this.getAllEnumeratedTypeFrom((EnumeratedType) codeItem));
				
			}
		
		}
		
		return allEnumeratedType;
	}
	
	private List<EnumeratedType> getAllEnumeratedTypeFrom(Package packageToSearch) {
		List<EnumeratedType> allEnumeratedType = new ArrayList<EnumeratedType>();

		for (AbstractCodeElement abstractCodeElement : packageToSearch.getCodeElement()) {
			
			if(abstractCodeElement instanceof ClassUnit){
				
				allEnumeratedType.addAll(this.getAllEnumeratedTypeFrom((ClassUnit) abstractCodeElement));
				
			}else if(abstractCodeElement instanceof InterfaceUnit){
				
				allEnumeratedType.addAll(this.getAllEnumeratedTypeFrom((InterfaceUnit) abstractCodeElement));
			
			}else if (abstractCodeElement instanceof EnumeratedType) {
				
				if (validateFilter((EnumeratedType) abstractCodeElement)) {
					allEnumeratedType.add((EnumeratedType) abstractCodeElement);
				}
				allEnumeratedType.addAll(this.getAllEnumeratedTypeFrom((EnumeratedType) abstractCodeElement));
				
			}else if (abstractCodeElement instanceof Package) {
				
				allEnumeratedType.addAll(this.getAllEnumeratedTypeFrom((Package) abstractCodeElement));

			}
		
		}
		
		return allEnumeratedType;
	}

}
