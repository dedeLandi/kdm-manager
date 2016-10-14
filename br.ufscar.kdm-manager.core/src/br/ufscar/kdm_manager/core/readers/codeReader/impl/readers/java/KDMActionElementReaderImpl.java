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
import br.ufscar.kdm_manager.core.readers.codeReader.enums.KDMActionElementsType;
import br.ufscar.kdm_manager.core.readers.codeReader.interfaces.KDMCodeGenericReader;
import br.ufscar.kdm_manager.core.readers.modelReader.factory.KDMModelReaderJavaFactory;

public class KDMActionElementReaderImpl implements KDMCodeGenericReader<ActionElement>{

	private boolean hasNoFilter = true;
	private boolean hasFilterType = false;
	private boolean hasFilter = false;

	private ValidateFilter<ActionElement, ?> filter = null;

	private KDMActionElementsType filterActionElementType = null;

	public KDMActionElementReaderImpl() {
		super();
	}

	public KDMActionElementReaderImpl(KDMActionElementsType actionElementType) {
		this.hasNoFilter = false;
		this.hasFilterType  = true;
		this.hasFilter = false;
		this.filter = null;
		this.filterActionElementType = actionElementType;
	}
	public KDMActionElementReaderImpl(ValidateFilter<ActionElement, ?> filter) {
		this.hasNoFilter = false;
		this.hasFilterType  = false;
		this.hasFilter  = true;
		this.filter = filter;
		this.filterActionElementType = null;
	}

	private boolean validateFilter(ActionElement actionElementToValidate) {
		if(this.hasNoFilter){
			return true;
		}else if(this.hasFilter){
			return this.filter.validateElement(actionElementToValidate);
		}else if(this.hasFilterType){
			if(actionElementToValidate.getName().toString().equalsIgnoreCase(this.filterActionElementType.getName().toString())
					|| 
					actionElementToValidate.getKind().equalsIgnoreCase(this.filterActionElementType.getKind())){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public List<ActionElement> getAllFrom(Segment segmentToSearch) {
		List<ActionElement> actionElementRecovered = new ArrayList<ActionElement>();

		Map<String, List<CodeModel>> models = KDMModelReaderJavaFactory.eINSTANCE.createKDMCodeModelReader().getAllFromSegment(segmentToSearch);

		for (String nameCodeModel : models.keySet()) {

			for (CodeModel codeModel : models.get(nameCodeModel)) {

				actionElementRecovered.addAll(this.getAllActionElementsFrom(codeModel));
			}
		}

		return actionElementRecovered;
	}
	
	@Override
	public List<ActionElement> getAllFrom(CodeModel codeModelToSearch) {
		return this.getAllActionElementsFrom(codeModelToSearch);
	}
	
	@Override
	public List<ActionElement> getAllFrom(Package packageToSearch) {
		return this.getAllActionElementsFrom(packageToSearch);
	}
	
	@Override
	public List<ActionElement> getAllFrom(ClassUnit classUnitToSearch) {
		return this.getAllActionElementsFrom(classUnitToSearch);
	}
	
	@Override
	public List<ActionElement> getAllFrom(InterfaceUnit interfaceUnitToSearch) {
		return this.getAllActionElementsFrom(interfaceUnitToSearch);
	}
	
	@Override
	public List<ActionElement> getAllFrom(EnumeratedType enumeratedTypeToSearch) {
		return this.getAllActionElementsFrom(enumeratedTypeToSearch);
	}
	
	@Override
	public List<ActionElement> getAllFrom(MethodUnit methodUnitToSearch) {
		return this.getAllActionElementsFrom(methodUnitToSearch);
	}
	
	@Override
	public List<ActionElement> getAllFrom(BlockUnit blockUnitToSearch) {
		return this.getAllActionElementsFrom(blockUnitToSearch);
	}
	
	@Override
	public List<ActionElement> getAllFrom(ActionElement actionElementToSearch) {
		return this.getAllActionElementsFrom(actionElementToSearch);
	}
	
	@Override
	@Deprecated
	public List<ActionElement> getAllFrom(StorableUnit storableUnitToSearch) {
		return null;
	}
	
	@Override
	@Deprecated
	public List<ActionElement> getAllFrom(Signature signatureUnitToSearch) {
		return null;
	}
	
	@Override
	@Deprecated
	public List<ActionElement> getAllFrom(ParameterUnit parameterUnitUnitToSearch) {
		return null;
	}
	
	private List<ActionElement> getAllActionElementsFrom(CodeModel codeModelToSearch) {
		List<ActionElement> modelActionElements = new ArrayList<ActionElement>();

		for (AbstractCodeElement abstractCodeElement : codeModelToSearch.getCodeElement()) {

			if(abstractCodeElement instanceof ClassUnit){
				
				modelActionElements.addAll(this.getAllActionElementsFrom((ClassUnit)abstractCodeElement));
				
			}else if(abstractCodeElement instanceof InterfaceUnit){
				
				modelActionElements.addAll(this.getAllActionElementsFrom((InterfaceUnit)abstractCodeElement));

			}else if(abstractCodeElement instanceof EnumeratedType){

				modelActionElements.addAll(this.getAllActionElementsFrom((EnumeratedType)abstractCodeElement));

			}else if(abstractCodeElement instanceof Package){

				modelActionElements.addAll(this.getAllActionElementsFrom((Package)abstractCodeElement));

			}

		}

		return modelActionElements;
	}

	private List<ActionElement> getAllActionElementsFrom(Package packageToSearch) {
		List<ActionElement> packageActionElements = new ArrayList<ActionElement>();

		for (AbstractCodeElement abstractCodeElement : packageToSearch.getCodeElement()) {

			if(abstractCodeElement instanceof ClassUnit){

				packageActionElements.addAll(this.getAllActionElementsFrom((ClassUnit)abstractCodeElement));
				
			}else if(abstractCodeElement instanceof InterfaceUnit){
				
				packageActionElements.addAll(this.getAllActionElementsFrom((InterfaceUnit)abstractCodeElement));

			}else if(abstractCodeElement instanceof EnumeratedType){

				packageActionElements.addAll(this.getAllActionElementsFrom((EnumeratedType)abstractCodeElement));

			}else if(abstractCodeElement instanceof Package){

				packageActionElements.addAll(this.getAllActionElementsFrom((Package)abstractCodeElement));

			}

		}

		return packageActionElements;
	}
	
	private List<ActionElement> getAllActionElementsFrom(ClassUnit classToSearch) {
		List<ActionElement> classActionElements = new ArrayList<ActionElement>();
		
		for (CodeItem codeItem : classToSearch.getCodeElement()) {
			
			if(codeItem instanceof ActionElement){
				
				if(validateFilter((ActionElement)codeItem)){
					classActionElements.add((ActionElement)codeItem);
				}
				
			}else if(codeItem instanceof ClassUnit){
				
				classActionElements.addAll(this.getAllActionElementsFrom((ClassUnit)codeItem));
				
			}else if(codeItem instanceof InterfaceUnit){
				
				classActionElements.addAll(this.getAllActionElementsFrom((InterfaceUnit)codeItem));
				
			}else if(codeItem instanceof EnumeratedType){
				
				classActionElements.addAll(this.getAllActionElementsFrom((EnumeratedType)codeItem)); 
				
			}else if (codeItem instanceof MethodUnit){
				
				classActionElements.addAll(this.getAllActionElementsFrom((MethodUnit)codeItem));
				
			}
			
		}
		
		return classActionElements;
	}
	
	private List<ActionElement> getAllActionElementsFrom(InterfaceUnit interfaceToSearch) {
		List<ActionElement> interfaceActionElements = new ArrayList<ActionElement>();
		
		for (CodeItem codeItem : interfaceToSearch.getCodeElement()) {
			
			if(codeItem instanceof ActionElement){
				
				if(validateFilter((ActionElement)codeItem)){
					interfaceActionElements.add((ActionElement)codeItem);
				}
				
			}else if(codeItem instanceof ClassUnit){
				
				interfaceActionElements.addAll(this.getAllActionElementsFrom((ClassUnit)codeItem));
				
			}else if(codeItem instanceof InterfaceUnit){
				
				interfaceActionElements.addAll(this.getAllActionElementsFrom((InterfaceUnit)codeItem));
				
			}else if(codeItem instanceof EnumeratedType){
				
				interfaceActionElements.addAll(this.getAllActionElementsFrom((EnumeratedType)codeItem)); 
				
			}else if (codeItem instanceof MethodUnit){
				
				interfaceActionElements.addAll(this.getAllActionElementsFrom((MethodUnit)codeItem));
				
			}
			
		}
		
		return interfaceActionElements;
	}

	private List<ActionElement> getAllActionElementsFrom(EnumeratedType enumeratedTypeToSearch) {
		List<ActionElement> enumeratedTypeActionElements = new ArrayList<ActionElement>();

		for (CodeItem codeItem : enumeratedTypeToSearch.getCodeElement()) {

			if(codeItem instanceof ActionElement){

				if(validateFilter((ActionElement)codeItem)){
					enumeratedTypeActionElements.add((ActionElement)codeItem);
				}

			}else if(codeItem instanceof ClassUnit){

				enumeratedTypeActionElements.addAll(this.getAllActionElementsFrom((ClassUnit)codeItem));
				
			}else if(codeItem instanceof InterfaceUnit){
				
				enumeratedTypeActionElements.addAll(this.getAllActionElementsFrom((InterfaceUnit)codeItem));

			}else if(codeItem instanceof EnumeratedType){

				enumeratedTypeActionElements.addAll(this.getAllActionElementsFrom((EnumeratedType)codeItem)); 
				
			}else if (codeItem instanceof MethodUnit){

				enumeratedTypeActionElements.addAll(this.getAllActionElementsFrom((MethodUnit)codeItem));

			}

		}

		return enumeratedTypeActionElements;
	}

	private List<ActionElement> getAllActionElementsFrom(MethodUnit methodToSearch) {
		List<ActionElement> methodActionElements = new ArrayList<ActionElement>();

		for (AbstractCodeElement abstractCodeElement : methodToSearch.getCodeElement()) {

			if(abstractCodeElement instanceof BlockUnit){

				methodActionElements.addAll(this.getAllActionElementsFrom((BlockUnit) abstractCodeElement));

			}
		}

		return methodActionElements;
	}

	private List<ActionElement> getAllActionElementsFrom(BlockUnit blockToSearch) {

		List<ActionElement> blockActionElements = new ArrayList<ActionElement>();

		for (AbstractCodeElement abstractCodeElement : blockToSearch.getCodeElement()) {

			if (abstractCodeElement instanceof ActionElement) {

				if(validateFilter((ActionElement) abstractCodeElement)){
					blockActionElements.add((ActionElement) abstractCodeElement);
				}
				blockActionElements.addAll(this.getAllActionElementsFrom((ActionElement)abstractCodeElement));

			}else if(abstractCodeElement instanceof BlockUnit ){

				blockActionElements.addAll(this.getAllActionElementsFrom((BlockUnit)abstractCodeElement));

			}

		}

		return blockActionElements;
	}

	private List<ActionElement> getAllActionElementsFrom(ActionElement actionToSearch) {
		List<ActionElement> actionActionElements = new ArrayList<ActionElement>();

		for (AbstractCodeElement abstractCodeElement : actionToSearch.getCodeElement()) {

			if (abstractCodeElement instanceof ActionElement) {

				if(validateFilter((ActionElement) abstractCodeElement)){
					actionActionElements.add((ActionElement) abstractCodeElement);
				}
				actionActionElements.addAll(this.getAllActionElementsFrom((ActionElement)abstractCodeElement));

			}else if(abstractCodeElement instanceof BlockUnit ){

				actionActionElements.addAll(this.getAllActionElementsFrom((BlockUnit)abstractCodeElement));

			}

		}

		return actionActionElements;
	}

}
