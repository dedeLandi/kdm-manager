package br.ufscar.kdm_manager.core.readers.modelReader.interfaces;

public interface IKDMModelType<T,Y> {

	abstract T convertModelByType(Y kdmModel);
	
}
