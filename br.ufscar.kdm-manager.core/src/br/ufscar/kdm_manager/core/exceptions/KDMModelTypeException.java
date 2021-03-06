/********************************************************************************
 *																				*
 * Copyright (c) 2016, Andr� de Souza Landi. All rights reserved.				*
 *																				*
 * This file is part of KDM-MANAGER software.									*
 *																				*
 * KDM-MANAGER is free software: you can redistribute it and/or modify			*
 * it under the terms of the GNU General Public License as published by			*
 * the Free Software Foundation, either version 3 of the License, or			*
 * (at your option) any later version.											*
 *																				*
 * KDM-MANAGER is distributed in the hope that it will be useful,				*
 * but WITHOUT ANY WARRANTY; without even the implied warranty of				*
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the				*
 * GNU General Public License for more details.									*
 *																				*
 * You should have received a copy of the GNU General Public License			*
 * along with KDM-MANAGER.  If not, see <http://www.gnu.org/licenses/>.			*
 *																				*
  *******************************************************************************/
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
