package br.ufscar.kdm_manager.core.readers.relationshipReader.impl.readers.java.actionRelationships;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.gmt.modisco.omg.kdm.action.ActionElement;
import org.eclipse.gmt.modisco.omg.kdm.action.BlockUnit;
import org.eclipse.gmt.modisco.omg.kdm.action.Reads;
import org.eclipse.gmt.modisco.omg.kdm.code.AbstractCodeElement;
import org.eclipse.gmt.modisco.omg.kdm.code.AbstractCodeRelationship;
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

import br.ufscar.kdm_manager.core.readers.modelReader.factory.KDMModelReaderJavaFactory;
import br.ufscar.kdm_manager.core.readers.relationshipReader.interfaces.KDMRelationshipGenericReader;

public class KDMRelationshipReaderReadsImpl implements KDMRelationshipGenericReader<Reads> {

	@Override
	public List<Reads> getAllRelationshipOf(Segment segmentToAvaliate) {
		List<Reads> readsRecovered = new ArrayList<Reads>();

		Map<String, List<CodeModel>> models = KDMModelReaderJavaFactory.eINSTANCE.createKDMCodeModelReader().getAllFromSegment(segmentToAvaliate);

		for (String nameCodeModel : models.keySet()) {

			for (CodeModel codeModel : models.get(nameCodeModel)) {

				readsRecovered.addAll(this.getAllRelationshipOf(codeModel));
			}
		}

		return readsRecovered;
	}

	@Override
	public List<Reads> getAllRelationshipOf(CodeModel codeModelToAvaliate) {
		List<Reads> readsRecovered = new ArrayList<Reads>();
		
		for (AbstractCodeElement abstractCodeElement : codeModelToAvaliate.getCodeElement()) {
			
			if(abstractCodeElement instanceof InterfaceUnit){
				readsRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) abstractCodeElement));
			}else if(abstractCodeElement instanceof EnumeratedType){
				readsRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) abstractCodeElement));
			}else if(abstractCodeElement instanceof ClassUnit){
				readsRecovered.addAll(this.getAllRelationshipOf((ClassUnit) abstractCodeElement));
			}else if(abstractCodeElement instanceof Package){
				readsRecovered.addAll(this.getAllRelationshipOf((Package) abstractCodeElement));
			}
		}
		
		return readsRecovered;
	}
	
	@Override
	public List<Reads> getAllRelationshipOf(Package packageToAvaliate) {

		List<Reads> readsRecovered = new ArrayList<Reads>();
		
		for (AbstractCodeElement abstractCodeElement : packageToAvaliate.getCodeElement()) {
			
			if(abstractCodeElement instanceof ClassUnit){
				readsRecovered.addAll(this.getAllRelationshipOf((ClassUnit) abstractCodeElement));
			}else if(abstractCodeElement instanceof InterfaceUnit){
				readsRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) abstractCodeElement));
			}else if(abstractCodeElement instanceof EnumeratedType){
				readsRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) abstractCodeElement));
			}else if(abstractCodeElement instanceof Package){
				readsRecovered.addAll(this.getAllRelationshipOf((Package) abstractCodeElement));
			}
			
		}
		
		return readsRecovered;
	}
	
	@Override
	public List<Reads> getAllRelationshipOf(ClassUnit classToAvaliate) {

		List<Reads> readsRecovered = new ArrayList<Reads>();
		
		for (CodeItem codeItem : classToAvaliate.getCodeElement()) {
			
			if(codeItem instanceof MethodUnit){
				readsRecovered.addAll(this.getAllRelationshipOf((MethodUnit) codeItem));
			}else if(codeItem instanceof ClassUnit){
				readsRecovered.addAll(this.getAllRelationshipOf((ClassUnit) codeItem));
			}else if(codeItem instanceof InterfaceUnit){
				readsRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) codeItem));
			}else if(codeItem instanceof EnumeratedType){
				readsRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) codeItem));
			}
			
		}
		
		return readsRecovered;
	}
	
	@Override
	public List<Reads> getAllRelationshipOf(InterfaceUnit interfaceToAvaliate) {

		List<Reads> readsRecovered = new ArrayList<Reads>();
		
		for (CodeItem codeItem : interfaceToAvaliate.getCodeElement()) {
			
			if(codeItem instanceof MethodUnit){
				readsRecovered.addAll(this.getAllRelationshipOf((MethodUnit) codeItem));
			}else if(codeItem instanceof ClassUnit){
				readsRecovered.addAll(this.getAllRelationshipOf((ClassUnit) codeItem));
			}else if(codeItem instanceof InterfaceUnit){
				readsRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) codeItem));
			}else if(codeItem instanceof EnumeratedType){
				readsRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) codeItem));
			}
			
		}
		
		return readsRecovered;
	}

	@Override
	public List<Reads> getAllRelationshipOf(EnumeratedType enumeratedTypeToAvaliate) {
		List<Reads> readsRecovered = new ArrayList<Reads>();
		
		for (CodeItem codeItem : enumeratedTypeToAvaliate.getCodeElement()) {
			
			if(codeItem instanceof MethodUnit){
				readsRecovered.addAll(this.getAllRelationshipOf((MethodUnit) codeItem));
			}else if(codeItem instanceof ClassUnit){
				readsRecovered.addAll(this.getAllRelationshipOf((ClassUnit) codeItem));
			}else if(codeItem instanceof InterfaceUnit){
				readsRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) codeItem));
			}else if(codeItem instanceof EnumeratedType){
				readsRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) codeItem));
			}
			
		}
		
		return readsRecovered;
	}

	@Override
	@Deprecated
	public List<Reads> getAllRelationshipOf(StorableUnit storableToAvaliate) {
		return null;
	}

	@Override
	public List<Reads> getAllRelationshipOf(MethodUnit methodToAvaliate) {

		List<Reads> readsRecovered = new ArrayList<Reads>();
		
		for (AbstractCodeElement abstractCodeElement : methodToAvaliate.getCodeElement()) {
			
			if(abstractCodeElement instanceof BlockUnit){
				readsRecovered.addAll(this.getAllRelationshipOf((BlockUnit) abstractCodeElement));
			}
			
		}
		
		return readsRecovered;
	}

	@Override
	@Deprecated
	public List<Reads> getAllRelationshipOf(Signature signatureToAvaliate) {
		return null;
	}

	@Override
	@Deprecated
	public List<Reads> getAllRelationshipOf(ParameterUnit parameterToAvaliate) {
		return null;
	}
	
	@Override
	public List<Reads> getAllRelationshipOf(BlockUnit blockToAvaliate) {
		
		List<Reads> readsRecovered = new ArrayList<Reads>();

		for (AbstractCodeElement abstractCodeElement : blockToAvaliate.getCodeElement()) {

			if(abstractCodeElement instanceof ActionElement){

				readsRecovered.addAll(this.getAllRelationshipOf((ActionElement) abstractCodeElement));

			}else if(abstractCodeElement instanceof BlockUnit){

				readsRecovered.addAll(this.getAllRelationshipOf((BlockUnit) abstractCodeElement));

			}

		}

		return readsRecovered;
	}

	@Override
	public List<Reads> getAllRelationshipOf(ActionElement actionElementToAvaliate) {
		
		List<Reads> readsRecovered = new ArrayList<Reads>();

		for (AbstractCodeRelationship abstractCodeRelationship : actionElementToAvaliate.getCodeRelation()) {
			
			if(abstractCodeRelationship instanceof Reads){
				readsRecovered.add((Reads) abstractCodeRelationship);
			}
			
		}
		
		for (AbstractCodeElement abstractCodeElement : actionElementToAvaliate.getCodeElement()) {

			if(abstractCodeElement instanceof ActionElement){

				readsRecovered.addAll(this.getAllRelationshipOf((ActionElement) abstractCodeElement));

			}else if(abstractCodeElement instanceof BlockUnit){

				readsRecovered.addAll(this.getAllRelationshipOf((BlockUnit) abstractCodeElement));

			}
		}
		
		return readsRecovered;
	}

}
