package br.ufscar.kdm_manager.core.readers.relationshipReader.impl.factory;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.gmt.modisco.omg.kdm.action.Calls;
import org.eclipse.gmt.modisco.omg.kdm.action.Creates;
import org.eclipse.gmt.modisco.omg.kdm.action.Reads;
import org.eclipse.gmt.modisco.omg.kdm.action.UsesType;
import org.eclipse.gmt.modisco.omg.kdm.action.Writes;
import org.eclipse.gmt.modisco.omg.kdm.code.Extends;
import org.eclipse.gmt.modisco.omg.kdm.code.HasType;
import org.eclipse.gmt.modisco.omg.kdm.code.HasValue;
import org.eclipse.gmt.modisco.omg.kdm.code.Implements;
import org.eclipse.gmt.modisco.omg.kdm.code.Imports;

import br.ufscar.kdm_manager.core.readers.relationshipReader.factory.KDMRelationshipReaderJavaFactory;
import br.ufscar.kdm_manager.core.readers.relationshipReader.impl.readers.java.actionRelationships.KDMRelationshipReaderCallsImpl;
import br.ufscar.kdm_manager.core.readers.relationshipReader.impl.readers.java.actionRelationships.KDMRelationshipReaderCreatesImpl;
import br.ufscar.kdm_manager.core.readers.relationshipReader.impl.readers.java.actionRelationships.KDMRelationshipReaderReadsImpl;
import br.ufscar.kdm_manager.core.readers.relationshipReader.impl.readers.java.actionRelationships.KDMRelationshipReaderUsesTypeImpl;
import br.ufscar.kdm_manager.core.readers.relationshipReader.impl.readers.java.actionRelationships.KDMRelationshipReaderWritesImpl;
import br.ufscar.kdm_manager.core.readers.relationshipReader.impl.readers.java.codeRelationships.KDMRelationshipReaderExtendsImpl;
import br.ufscar.kdm_manager.core.readers.relationshipReader.impl.readers.java.codeRelationships.KDMRelationshipReaderHasTypeImpl;
import br.ufscar.kdm_manager.core.readers.relationshipReader.impl.readers.java.codeRelationships.KDMRelationshipReaderHasValueImpl;
import br.ufscar.kdm_manager.core.readers.relationshipReader.impl.readers.java.codeRelationships.KDMRelationshipReaderImplementsImpl;
import br.ufscar.kdm_manager.core.readers.relationshipReader.impl.readers.java.codeRelationships.KDMRelationshipReaderImportsImpl;
import br.ufscar.kdm_manager.core.readers.relationshipReader.interfaces.KDMRelationshipGenericReader;

public class KDMRelationshipReaderJavaFactoryImpl extends EFactoryImpl implements KDMRelationshipReaderJavaFactory {

	
	public static KDMRelationshipReaderJavaFactory init() {
		try {
			KDMRelationshipReaderJavaFactory theRecoverRelationsFactoryFactory = (KDMRelationshipReaderJavaFactory)EPackage.Registry.INSTANCE.getEFactory("br.ufscar.kdm_manager.core.readers.relationshipReader.factory.KDMRelationshipReaderJavaFactory"); //$NON-NLS-1$ 
			if (theRecoverRelationsFactoryFactory != null) {
				return theRecoverRelationsFactoryFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new KDMRelationshipReaderJavaFactoryImpl();
	}
	
	public KDMRelationshipReaderJavaFactoryImpl() {
		super();
	}

//	@Override
//	public KDMRelationshipGenericReader<InstanceOf> createInstanceOfRecover() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public KDMRelationshipGenericReader<ParameterTo> createParameterToRecover() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public KDMRelationshipGenericReader<Implements> createImplementsRecover() {
		return new KDMRelationshipReaderImplementsImpl();
	}

//	@Override
//	public KDMRelationshipGenericReader<ImplementationOf> createImplementationOfRecover() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public KDMRelationshipGenericReader<HasType> createHasTypeRecover() {
		return new KDMRelationshipReaderHasTypeImpl();
	}

	@Override
	public KDMRelationshipGenericReader<HasValue> createHasValueRecover() {
		return new KDMRelationshipReaderHasValueImpl();
	}

	@Override
	public KDMRelationshipGenericReader<Extends> createExtendsRecover() {
		return new KDMRelationshipReaderExtendsImpl();
	}

//	@Override
//	public KDMRelationshipGenericReader<GeneratedFrom> createGeneratedFromRecover() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public KDMRelationshipGenericReader<Includes> createIncludesRecover() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public KDMRelationshipGenericReader<VariantTo> createVariantToRecover() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public KDMRelationshipGenericReader<Redefines> createRedefinesRecover() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public KDMRelationshipGenericReader<VisibleIn> createVisibleInRecover() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public KDMRelationshipGenericReader<Imports> createImportsRecover() {
		return new KDMRelationshipReaderImportsImpl();
	}
	
//	@Override
//	public KDMRelationshipGenericReader<ControlFlow> createControlFlowRecover() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public KDMRelationshipGenericReader<EntryFlow> createEntryFlowRecover() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public KDMRelationshipGenericReader<Calls> createCallsRecover() {
		return new KDMRelationshipReaderCallsImpl();
	}

//	@Override
//	public KDMRelationshipGenericReader<Dispatches> createDispatchesRecover() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public KDMRelationshipGenericReader<Reads> createReadsRecover() {
		return new KDMRelationshipReaderReadsImpl();
	}

	@Override
	public KDMRelationshipGenericReader<Writes> createWritesRecover() {
		return new KDMRelationshipReaderWritesImpl();
	}

//	@Override
//	public KDMRelationshipGenericReader<Addresses> createAddressesRecover() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public KDMRelationshipGenericReader<Creates> createCreatesRecover() {
		return new KDMRelationshipReaderCreatesImpl();
	}

//	@Override
//	public KDMRelationshipGenericReader<ExitFlow> createExitFlowRecover() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public KDMRelationshipGenericReader<Throws> createThrowsRecover() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public KDMRelationshipGenericReader<UsesType> createUsesTypeRecover() {
		return new KDMRelationshipReaderUsesTypeImpl();
	}
	
	
}
