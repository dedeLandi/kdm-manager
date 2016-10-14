package br.ufscar.kdm_manager.core.filters.validateFilter.impl.filters;

import org.eclipse.gmt.modisco.omg.kdm.kdm.KDMFramework;

import br.ufscar.kdm_manager.core.filters.validateFilter.interfaces.ValidateFilter;

public class ValidateFilterNameKDMFramework implements ValidateFilter<KDMFramework, String> {

	private String value;

	@Override
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public boolean validateElement(KDMFramework elementToValidate) {
		return elementToValidate.getName().equalsIgnoreCase(value);
	}

}
