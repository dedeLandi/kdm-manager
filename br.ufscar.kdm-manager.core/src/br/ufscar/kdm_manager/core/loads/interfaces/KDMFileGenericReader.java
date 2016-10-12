package br.ufscar.kdm_manager.core.loads.interfaces;

import br.ufscar.kdm_manager.core.exceptions.KDMFileException;

public interface  KDMFileGenericReader<T> {

	public T readFromPath(String pathKDMFile) throws KDMFileException;
	
	public T readFromObject(Object objectKDM);
	
}
