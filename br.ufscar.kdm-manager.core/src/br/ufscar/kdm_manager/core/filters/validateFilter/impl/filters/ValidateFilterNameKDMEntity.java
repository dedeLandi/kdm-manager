package br.ufscar.kdm_manager.core.filters.validateFilter.impl.filters;

import org.eclipse.gmt.modisco.omg.kdm.core.KDMEntity;

import br.ufscar.kdm_manager.core.filters.validateFilter.interfaces.ValidateFilter;

public class ValidateFilterNameKDMEntity implements ValidateFilter<KDMEntity, String> {

	private String value;
	
	@Override
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public boolean validateElement(KDMEntity elementToValidate) {
		return elementToValidate.getName().equalsIgnoreCase(this.value);
	}

	

}
