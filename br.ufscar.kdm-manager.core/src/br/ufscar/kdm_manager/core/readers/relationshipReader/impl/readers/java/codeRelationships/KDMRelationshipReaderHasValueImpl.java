package br.ufscar.kdm_manager.core.readers.relationshipReader.impl.readers.java.codeRelationships;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.gmt.modisco.omg.kdm.action.ActionElement;
import org.eclipse.gmt.modisco.omg.kdm.action.BlockUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.AbstractCodeElement;
import org.eclipse.gmt.modisco.omg.kdm.code.AbstractCodeRelationship;
import org.eclipse.gmt.modisco.omg.kdm.code.ClassUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.CodeItem;
import org.eclipse.gmt.modisco.omg.kdm.code.CodeModel;
import org.eclipse.gmt.modisco.omg.kdm.code.EnumeratedType;
import org.eclipse.gmt.modisco.omg.kdm.code.HasValue;
import org.eclipse.gmt.modisco.omg.kdm.code.InterfaceUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.MethodUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.Package;
import org.eclipse.gmt.modisco.omg.kdm.code.ParameterUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.Signature;
import org.eclipse.gmt.modisco.omg.kdm.code.StorableUnit;
import org.eclipse.gmt.modisco.omg.kdm.kdm.Segment;

import br.ufscar.kdm_manager.core.readers.modelReader.factory.KDMModelReaderJavaFactory;
import br.ufscar.kdm_manager.core.readers.relationshipReader.interfaces.KDMRelationshipGenericReader;

public class KDMRelationshipReaderHasValueImpl implements KDMRelationshipGenericReader<HasValue>{

	@Override
	public List<HasValue> getAllRelationshipOf(Segment segmentToAvaliate) {
		List<HasValue> hasValueRecovered = new ArrayList<HasValue>();

		Map<String, List<CodeModel>> models = KDMModelReaderJavaFactory.eINSTANCE.createKDMCodeModelReader().getAllFromSegment(segmentToAvaliate);

		for (String nameCodeModel : models.keySet()) {

			for (CodeModel codeModel : models.get(nameCodeModel)) {

				hasValueRecovered.addAll(this.getAllRelationshipOf(codeModel));
			}
		}

		return hasValueRecovered;
	}

	@Override
	public List<HasValue> getAllRelationshipOf(CodeModel codeModelToAvaliate) {
		List<HasValue> hasValueRecovered = new ArrayList<HasValue>();

		for (AbstractCodeElement abstractCodeElement : codeModelToAvaliate.getCodeElement()) {

			if(abstractCodeElement instanceof InterfaceUnit){
				hasValueRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) abstractCodeElement));
			}else if(abstractCodeElement instanceof EnumeratedType){
				hasValueRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) abstractCodeElement));
			}else if(abstractCodeElement instanceof ClassUnit){
				hasValueRecovered.addAll(this.getAllRelationshipOf((ClassUnit) abstractCodeElement));
			}else if(abstractCodeElement instanceof Package){
				hasValueRecovered.addAll(this.getAllRelationshipOf((Package) abstractCodeElement));
			}
		}

		return hasValueRecovered;
	}

	@Override
	public List<HasValue> getAllRelationshipOf(Package packageToAvaliate) {

		List<HasValue> hasValueRecovered = new ArrayList<HasValue>();

		for (AbstractCodeElement abstractCodeElement : packageToAvaliate.getCodeElement()) {

			if(abstractCodeElement instanceof InterfaceUnit){
				hasValueRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) abstractCodeElement));
			}else if(abstractCodeElement instanceof EnumeratedType){
				hasValueRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) abstractCodeElement));
			}else if(abstractCodeElement instanceof ClassUnit){
				hasValueRecovered.addAll(this.getAllRelationshipOf((ClassUnit) abstractCodeElement));
			}else if(abstractCodeElement instanceof Package){
				hasValueRecovered.addAll(this.getAllRelationshipOf((Package) abstractCodeElement));
			}
		}

		return hasValueRecovered;
	}

	@Override
	public List<HasValue> getAllRelationshipOf(ClassUnit classToAvaliate) {
		List<HasValue> hasValueRecovered = new ArrayList<HasValue>();

		for (CodeItem codeItem : classToAvaliate.getCodeElement()) {

			if(codeItem instanceof InterfaceUnit){
				hasValueRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) codeItem));
			}else if(codeItem instanceof EnumeratedType){
				hasValueRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) codeItem));
			}else if(codeItem instanceof ClassUnit){
				hasValueRecovered.addAll(this.getAllRelationshipOf((ClassUnit) codeItem));
			}
		}

		return hasValueRecovered;
	}

	@Override
	public List<HasValue> getAllRelationshipOf(InterfaceUnit interfaceToAvaliate) {

		List<HasValue> hasValueRecovered = new ArrayList<HasValue>();

		for (CodeItem codeItem : interfaceToAvaliate.getCodeElement()) {

			if(codeItem instanceof InterfaceUnit){
				hasValueRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) codeItem));
			}else if(codeItem instanceof EnumeratedType){
				hasValueRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) codeItem));
			}else if(codeItem instanceof ClassUnit){
				hasValueRecovered.addAll(this.getAllRelationshipOf((ClassUnit) codeItem));
			}
		}

		return hasValueRecovered;
	}

	@Override
	public List<HasValue> getAllRelationshipOf(EnumeratedType enumeratedTypeToAvaliate) {
		List<HasValue> hasValueRecovered = new ArrayList<HasValue>();

		for (CodeItem codeItem : enumeratedTypeToAvaliate.getCodeElement()) {

			if(codeItem instanceof InterfaceUnit){
				hasValueRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) codeItem));
			}else if(codeItem instanceof EnumeratedType){
				hasValueRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) codeItem));
			}else if(codeItem instanceof ClassUnit){
				hasValueRecovered.addAll(this.getAllRelationshipOf((ClassUnit) codeItem));
			}
		}

		return hasValueRecovered;
	}

	@Override
	public List<HasValue> getAllRelationshipOf(StorableUnit storableToAvaliate) {
		List<HasValue> hasValueRelations = new ArrayList<HasValue>();

		for (AbstractCodeRelationship abstractCodeRelationship : storableToAvaliate.getCodeRelation()) {

			if(abstractCodeRelationship instanceof HasValue){

				hasValueRelations.add((HasValue) abstractCodeRelationship);

			}

		}

		return hasValueRelations;
	}

	@Override
	public List<HasValue> getAllRelationshipOf(MethodUnit methodToAvaliate) {
		List<HasValue> hasValueRelations = new ArrayList<HasValue>();

		for (AbstractCodeElement abstractCodeElement : methodToAvaliate.getCodeElement()) {

			if(abstractCodeElement instanceof Signature){
				hasValueRelations.addAll(this.getAllRelationshipOf((Signature)abstractCodeElement));
			}else if(abstractCodeElement instanceof BlockUnit){
				hasValueRelations.addAll(this.getAllRelationshipOf((BlockUnit)abstractCodeElement));
			}

		}

		return hasValueRelations;
	}
	
	@Override
	public List<HasValue> getAllRelationshipOf(Signature signatureToAvaliate) {
		List<HasValue> hasValueRelations = new ArrayList<HasValue>();

		for (ParameterUnit parameterUnit : signatureToAvaliate.getParameterUnit()) {

			hasValueRelations.addAll(this.getAllRelationshipOf(parameterUnit));

		}

		return hasValueRelations;
	}

	@Override
	public List<HasValue> getAllRelationshipOf(ParameterUnit parameterToAvaliate) {
		List<HasValue> hasValueRelations = new ArrayList<HasValue>();

		for (AbstractCodeRelationship abstractCodeRelationship : parameterToAvaliate.getCodeRelation()) {

			if(abstractCodeRelationship instanceof HasValue){

				hasValueRelations.add((HasValue) abstractCodeRelationship);

			}

		}

		return hasValueRelations;
	}

	@Override
	public List<HasValue> getAllRelationshipOf(BlockUnit blockToAvaliate) {
		List<HasValue> hasValueRelations = new ArrayList<HasValue>();

		for (AbstractCodeElement abstractCodeElement : blockToAvaliate.getCodeElement()) {

			if(abstractCodeElement instanceof ActionElement){
				hasValueRelations.addAll(this.getAllRelationshipOf((ActionElement)abstractCodeElement));
			}else if(abstractCodeElement instanceof StorableUnit){
				hasValueRelations.addAll(this.getAllRelationshipOf((StorableUnit)abstractCodeElement));
			}else if(abstractCodeElement instanceof BlockUnit){
				hasValueRelations.addAll(this.getAllRelationshipOf((BlockUnit)abstractCodeElement));
			}

		}

		return hasValueRelations;
	}

	@Override
	public List<HasValue> getAllRelationshipOf(ActionElement actionElementToAvaliate) {
		List<HasValue> hasValueRelations = new ArrayList<HasValue>();

		for (AbstractCodeElement abstractCodeElement : actionElementToAvaliate.getCodeElement()) {

			if(abstractCodeElement instanceof ActionElement){
				hasValueRelations.addAll(this.getAllRelationshipOf((ActionElement)abstractCodeElement));
			}else if(abstractCodeElement instanceof StorableUnit){
				hasValueRelations.addAll(this.getAllRelationshipOf((StorableUnit)abstractCodeElement));
			}else if(abstractCodeElement instanceof BlockUnit){
				hasValueRelations.addAll(this.getAllRelationshipOf((BlockUnit)abstractCodeElement));
			}

		}

		return hasValueRelations;
	}

}