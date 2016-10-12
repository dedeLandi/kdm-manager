package br.ufscar.kdm_manager.core.loads.impl.factory;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.gmt.modisco.omg.kdm.kdm.Segment;

import br.ufscar.kdm_manager.core.loads.factory.KDMFileReaderFactory;
import br.ufscar.kdm_manager.core.loads.impl.loads.KDMFileReaderSegmentImpl;
import br.ufscar.kdm_manager.core.loads.interfaces.KDMFileGenericReader;

public class KDMFileReaderFactoryImpl extends EFactoryImpl implements KDMFileReaderFactory {

	
	public static KDMFileReaderFactory init() {
		try {
			KDMFileReaderFactory theKDMCodeReaderFactory = (KDMFileReaderFactory)EPackage.Registry.INSTANCE.getEFactory("br.ufscar.kdm_manager.core.loads.factory.KDMFileReaderFactory"); //$NON-NLS-1$ 
			if (theKDMCodeReaderFactory != null) {
				return theKDMCodeReaderFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new KDMFileReaderFactoryImpl();
	}
	
	public KDMFileReaderFactoryImpl() {
		super();
	}

	@Override
	public KDMFileGenericReader<Segment> createKDMFileReaderToSegment() {
		return new KDMFileReaderSegmentImpl();
	}
	

}
