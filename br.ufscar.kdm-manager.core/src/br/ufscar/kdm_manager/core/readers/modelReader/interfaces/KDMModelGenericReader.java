package br.ufscar.kdm_manager.core.readers.modelReader.interfaces;

public interface KDMModelGenericReader<R,P> {
	
	public R getAllFromSegment(P segmentToSearch);
	
}
