package br.ufscar.kdm_manager.core.loads.factory;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.gmt.modisco.omg.kdm.kdm.Segment;

import br.ufscar.kdm_manager.core.loads.interfaces.KDMFileGenericReader;


public interface KDMFileReaderFactory extends EFactory {

	KDMFileReaderFactory eINSTANCE = br.ufscar.kdm_manager.core.loads.impl.factory.KDMFileReaderFactoryImpl.init();
	
	KDMFileGenericReader<Segment> createKDMFileReaderToSegment();
	
}
