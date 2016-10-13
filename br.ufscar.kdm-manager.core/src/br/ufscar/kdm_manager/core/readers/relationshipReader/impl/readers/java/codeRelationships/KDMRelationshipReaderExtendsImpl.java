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
import org.eclipse.gmt.modisco.omg.kdm.code.Extends;
import org.eclipse.gmt.modisco.omg.kdm.code.InterfaceUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.MethodUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.Package;
import org.eclipse.gmt.modisco.omg.kdm.code.ParameterUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.Signature;
import org.eclipse.gmt.modisco.omg.kdm.code.StorableUnit;
import org.eclipse.gmt.modisco.omg.kdm.kdm.Segment;

import br.ufscar.kdm_manager.core.readers.modelReader.factory.KDMModelReaderJavaFactory;
import br.ufscar.kdm_manager.core.readers.relationshipReader.interfaces.KDMRelationshipGenericReader;

public class KDMRelationshipReaderExtendsImpl implements KDMRelationshipGenericReader<Extends>{

	@Override
	public List<Extends> getAllRelationshipOf(Segment segmentToAvaliate) {
		List<Extends> extendsRecovered = new ArrayList<Extends>();

		Map<String, List<CodeModel>> models = KDMModelReaderJavaFactory.eINSTANCE.createKDMCodeModelReader().getAllFromSegment(segmentToAvaliate);

		for (String nameCodeModel : models.keySet()) {

			for (CodeModel codeModel : models.get(nameCodeModel)) {

				extendsRecovered.addAll(this.getAllRelationshipOf(codeModel));
			}
		}

		return extendsRecovered;
	}

	@Override
	public List<Extends> getAllRelationshipOf(CodeModel codeModelToAvaliate) {
		List<Extends> extendsRecovered = new ArrayList<Extends>();
		
		for (AbstractCodeElement abstractCodeElement : codeModelToAvaliate.getCodeElement()) {
			
			if(abstractCodeElement instanceof InterfaceUnit){
				extendsRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) abstractCodeElement));
			}else if(abstractCodeElement instanceof EnumeratedType){
				extendsRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) abstractCodeElement));
			}else if(abstractCodeElement instanceof ClassUnit){
				extendsRecovered.addAll(this.getAllRelationshipOf((ClassUnit) abstractCodeElement));
			}else if(abstractCodeElement instanceof Package){
				extendsRecovered.addAll(this.getAllRelationshipOf((Package) abstractCodeElement));
			}
		}
		
		return extendsRecovered;
	}
	
	@Override
	public List<Extends> getAllRelationshipOf(Package packageToAvaliate) {
		
		List<Extends> extendsRecovered = new ArrayList<Extends>();
		
		for (AbstractCodeElement abstractCodeElement : packageToAvaliate.getCodeElement()) {
			
			if(abstractCodeElement instanceof InterfaceUnit){
				extendsRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) abstractCodeElement));
			}else if(abstractCodeElement instanceof EnumeratedType){
				extendsRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) abstractCodeElement));
			}else if(abstractCodeElement instanceof ClassUnit){
				extendsRecovered.addAll(this.getAllRelationshipOf((ClassUnit) abstractCodeElement));
			}else if(abstractCodeElement instanceof Package){
				extendsRecovered.addAll(this.getAllRelationshipOf((Package) abstractCodeElement));
			}
		}
		
		return extendsRecovered;
	}

	@Override
	public List<Extends> getAllRelationshipOf(ClassUnit classToAvaliate) {
		List<Extends> extendsRecovered = new ArrayList<Extends>();
		
		for (AbstractCodeRelationship abstractCodeRelationship : classToAvaliate.getCodeRelation()) {
			if(abstractCodeRelationship instanceof Extends){
				extendsRecovered.add((Extends) abstractCodeRelationship);
			}
		}
		for (CodeItem codeItem : classToAvaliate.getCodeElement()) {
			
			if(codeItem instanceof InterfaceUnit){
				extendsRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) codeItem));
			}else if(codeItem instanceof EnumeratedType){
				extendsRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) codeItem));
			}else if(codeItem instanceof ClassUnit){
				extendsRecovered.addAll(this.getAllRelationshipOf((ClassUnit) codeItem));
			}
		}
		
		return extendsRecovered;
	}
	
	@Override
	public List<Extends> getAllRelationshipOf(InterfaceUnit interfaceToAvaliate) {
		
		List<Extends> extendsRecovered = new ArrayList<Extends>();
		
		for (AbstractCodeRelationship abstractCodeRelationship : interfaceToAvaliate.getCodeRelation()) {
			if(abstractCodeRelationship instanceof Extends){
				extendsRecovered.add((Extends) abstractCodeRelationship);
			}
		}
		for (CodeItem codeItem : interfaceToAvaliate.getCodeElement()) {
			
			if(codeItem instanceof InterfaceUnit){
				extendsRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) codeItem));
			}else if(codeItem instanceof EnumeratedType){
				extendsRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) codeItem));
			}else if(codeItem instanceof ClassUnit){
				extendsRecovered.addAll(this.getAllRelationshipOf((ClassUnit) codeItem));
			}
		}
		
		return extendsRecovered;
	}

	@Override
	public List<Extends> getAllRelationshipOf(EnumeratedType enumeratedTypeToAvaliate) {
		List<Extends> extendsRecovered = new ArrayList<Extends>();
		
		for (AbstractCodeRelationship abstractCodeRelationship : enumeratedTypeToAvaliate.getCodeRelation()) {
			if(abstractCodeRelationship instanceof Extends){
				extendsRecovered.add((Extends) abstractCodeRelationship);
			}
		}
		for (CodeItem codeItem : enumeratedTypeToAvaliate.getCodeElement()) {
			
			if(codeItem instanceof InterfaceUnit){
				extendsRecovered.addAll(this.getAllRelationshipOf((InterfaceUnit) codeItem));
			}else if(codeItem instanceof EnumeratedType){
				extendsRecovered.addAll(this.getAllRelationshipOf((EnumeratedType) codeItem));
			}else if(codeItem instanceof ClassUnit){
				extendsRecovered.addAll(this.getAllRelationshipOf((ClassUnit) codeItem));
			}
		}
		
		return extendsRecovered;
	}

	@Override
	@Deprecated
	public List<Extends> getAllRelationshipOf(BlockUnit blockToAvaliate) {
		return null;
	}

	@Override
	@Deprecated
	public List<Extends> getAllRelationshipOf(StorableUnit storableToAvaliate) {
		return null;
	}

	@Override
	@Deprecated
	public List<Extends> getAllRelationshipOf(MethodUnit methodToAvaliate) {
		return null;
	}

	@Override
	@Deprecated
	public List<Extends> getAllRelationshipOf(ActionElement actionElementToAvaliate) {
		return null;
	}

	@Override
	@Deprecated
	public List<Extends> getAllRelationshipOf(Signature signatureToAvaliate) {
		return null;
	}

	@Override
	@Deprecated
	public List<Extends> getAllRelationshipOf(ParameterUnit parameterToAvaliate) {
		return null;
	}

}
