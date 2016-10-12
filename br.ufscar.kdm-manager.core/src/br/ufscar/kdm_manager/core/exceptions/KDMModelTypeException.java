package br.ufscar.kdm_manager.core.exceptions;

public class KDMModelTypeException extends Exception{

	private static final long serialVersionUID = 1L;

	public KDMModelTypeException(){
		
		super("KDM Model passed is wrong for this type operation. ");
		
	}

	public KDMModelTypeException(String message){
		super(message);
	}

	public KDMModelTypeException(Throwable cause){
		super(cause);
	}

	public KDMModelTypeException(String message, Throwable cause){
		super(message, cause);
	}

	public KDMModelTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
}
