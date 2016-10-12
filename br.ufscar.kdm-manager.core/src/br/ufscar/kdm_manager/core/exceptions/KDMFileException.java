package br.ufscar.kdm_manager.core.exceptions;

public class KDMFileException extends Exception{

	private static final long serialVersionUID = 1L;

	public KDMFileException(){
		
		super("KDM Path does not exists. ");
		
	}

	public KDMFileException(String message){
		super(message);
	}

	public KDMFileException(Throwable cause){
		super(cause);
	}

	public KDMFileException(String message, Throwable cause){
		super(message, cause);
	}

	public KDMFileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
}
