package br.ufscar.kdm_manager.core.loads.impl.loads;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.gmt.modisco.omg.kdm.kdm.KdmPackage;
import org.eclipse.gmt.modisco.omg.kdm.kdm.Segment;

import br.ufscar.kdm_manager.core.exceptions.KDMFileException;
import br.ufscar.kdm_manager.core.loads.interfaces.KDMFileGenericReader;

public class KDMFileReaderSegmentImpl implements KDMFileGenericReader<Segment>{


	@Override
	public Segment readFromPath(String pathKDMFile) throws KDMFileException {
		pathKDMFile = "file:///" + pathKDMFile;
		System.err.println("KDM Path: " + pathKDMFile);

		if("".equalsIgnoreCase(pathKDMFile)){
			throw new KDMFileException();
		}else{
			KdmPackage.eINSTANCE.eClass();//get the KDMPackage instance

			Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
			Map<String, Object> m = reg.getExtensionToFactoryMap();
			m.put("xmi", new XMIResourceFactoryImpl());

			// Obtain a new resource set
			ResourceSet resSet = new ResourceSetImpl();
			// Get the resource
			Resource resource = resSet.getResource(URI.createURI(pathKDMFile),
					true);

			if(resource == null){
				throw new KDMFileException("Wrong path of KDM File");
			}else{
				return (Segment) resource.getContents().get(0); //get the first element, that is the Segment
			}
		}
	}

	@Override
	public Segment readFromObject(Object objectKDM) {
		return (Segment) objectKDM;
	}

}
