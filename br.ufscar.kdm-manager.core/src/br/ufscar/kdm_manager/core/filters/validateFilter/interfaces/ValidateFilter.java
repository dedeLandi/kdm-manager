package br.ufscar.kdm_manager.core.filters.validateFilter.interfaces;

public interface ValidateFilter<Z, Y> {

	public void setValue(Y value);
	
	public boolean validateElement(Z elementToValidate);
	
}