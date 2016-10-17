/********************************************************************************
 *																				*
 * Copyright (c) 2016, André de Souza Landi. All rights reserved.				*
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
package br.ufscar.kdm_manager.core.readers.codeReader.enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.gmt.modisco.java.InfixExpressionKind;
import org.eclipse.gmt.modisco.java.PostfixExpressionKind;
import org.eclipse.gmt.modisco.java.PrefixExpressionKind;

/**
 * These Action Elements Type are from MoDisco, then 
 * @author Landi
 *
 */
public enum KDMActionElementsType {

	ACTION_ELEMENT_VARIABLE_DECLARATION 			(1,"variable declaration","variable declaration"),      
	ACTION_ELEMENT_TYPE_DECLARATION 				(2,"type declaration","type declaration"),          
	                                        		
	ACTION_ELEMENT_EXPRESSION_STATEMENT 			(3,"expression statement","expression statement"),      
	                                        		
	ACTION_ELEMENT_ARRAY_ACCESS 					(4,"array access","array access"),              
	ACTION_ELEMENT_ARRAY_LENGTH_ACCESS 				(5,"array length access","array length access"),       
	ACTION_ELEMENT_FIELD_ACCESS 					(6,"field access","field access"),              
	ACTION_ELEMENT_SUPER_FIELD_ACCESS 				(7,"super field access","super field access"),        
	                                        		
	ACTION_ELEMENT_ARRAY_INITIALIZER 				(8,"array initializer","array initializer"),         
	                                        		
	ACTION_ELEMENT_ARRAY_CREATION 					(9,"array creation","array creation"),            
	ACTION_ELEMENT_CLASS_INSTANCE_CREATION 			(10,"class instance creation","class instance creation"),   
                                            		
	ACTION_ELEMENT_SUPER_METHOD_INVOCATION 			(11,"super method invocation","super method invocation"),   
	ACTION_ELEMENT_SUPER_CONSTRUCTOR_INVOCATION 	(12,"super constructor invocation","super constructor invocation"),
	ACTION_ELEMENT_METHOD_INVOCATION 				(13,"method invocation","method invocation"),         
	ACTION_ELEMENT_CONSTRUCTOR_INVOCATION 			(14,"constructor invocation","constructor invocation"),    
	                                        		
	ACTION_ELEMENT_IF 								(15,"if","if"),                        
	                                        		
	ACTION_ELEMENT_FOR 								(16,"for","for"),                       
	ACTION_ELEMENT_FOREACH 							(17,"foreach","foreach"),                   
	ACTION_ELEMENT_WHILE 							(18,"while","while"),                     
	ACTION_ELEMENT_DO 								(19,"do","do"),                        
	                                        		
	ACTION_ELEMENT_CONTINUE 						(20,"continue","continue"),                  
	ACTION_ELEMENT_BREAK 							(21,"break","break"),                     
                                            		
	ACTION_ELEMENT_PARENTHESIZED 					(22,"parenthesized","parenthesized"),             
	                                        		
	ACTION_ELEMENT_RETURN 							(23,"return","return"),                    
                                            		
	ACTION_ELEMENT_EMPTY 							(24,"empty","empty"),                     
                                            		
	ACTION_ELEMENT_LABEL 							(25,"label","label"),                     
	                                        		
	ACTION_ELEMENT_ASSERT 							(26,"assert","assert"),                    
	                                        		
	ACTION_ELEMENT_SWITCH 							(27,"switch","switch"),                    
	ACTION_ELEMENT_CASE 							(28,"case","case"),                      
                                            		
	ACTION_ELEMENT_SYNCHRONIZED 					(29,"syncronized","syncronized"),               
	                                        		
	ACTION_ELEMENT_THROW 							(30,"throw","throw"),                     
                                            		
	ACTION_ELEMENT_CAST 							(31,"cast","cast"),                      
	                                        		
	ACTION_ELEMENT_ANNOTATION 						(32,"annotation","annotation"),                
	ACTION_ELEMENT_ANNOTATION_MEMBER_VALUE 			(33,"annotation member value","annotation member value"),   
                                            		
	ACTION_ELEMENT_INFIX_EXPRESSION 				(34,"infix expression",InfixExpressionKind.class),          
	ACTION_ELEMENT_POSTFIX_EXPRESSION 				(35,"postfix expression",PostfixExpressionKind.class),        
	ACTION_ELEMENT_PREFIX_EXPRESSION 				(36,"prefix expression",PrefixExpressionKind.class),         
                                            		
	ACTION_ELEMENT_ASSIGNMENT 						(37,"assignment","assignment"),                
	                                        		
	ACTION_ELEMENT_CONDITIONAL 						(38,"conditional","conditional"),               
	                                        		
	ACTION_ELEMENT_INSTANCEOF 						(39,"instanceof","instanceof"),                
	
	ACTION_ELEMENT_NULL 							(40,"null","null"),                      
	
	ACTION_ELEMENT_THIS 							(41,"this","this")                      

	;

	private final int value;

	private final String kind;

	private final Object name;
	
	private static final KDMActionElementsType[] VALUES_ARRAY =
			new KDMActionElementsType[] {
					ACTION_ELEMENT_VARIABLE_DECLARATION 			,
					ACTION_ELEMENT_TYPE_DECLARATION 				,
					                                        		
					ACTION_ELEMENT_EXPRESSION_STATEMENT 			,
					                                        		
					ACTION_ELEMENT_ARRAY_ACCESS 					,
					ACTION_ELEMENT_ARRAY_LENGTH_ACCESS 				,
					ACTION_ELEMENT_FIELD_ACCESS 					,
					ACTION_ELEMENT_SUPER_FIELD_ACCESS 				,
					                                        		
					ACTION_ELEMENT_ARRAY_INITIALIZER 				,
					                                        		
					ACTION_ELEMENT_ARRAY_CREATION 					,
					ACTION_ELEMENT_CLASS_INSTANCE_CREATION 			,
					                                        		
					ACTION_ELEMENT_SUPER_METHOD_INVOCATION 			,
					ACTION_ELEMENT_SUPER_CONSTRUCTOR_INVOCATION 	,
					ACTION_ELEMENT_METHOD_INVOCATION 				,
					ACTION_ELEMENT_CONSTRUCTOR_INVOCATION 			,
					                                        		
					ACTION_ELEMENT_IF 								,
					                                        		
					ACTION_ELEMENT_FOR 								,
					ACTION_ELEMENT_FOREACH 							,
					ACTION_ELEMENT_WHILE 							,
					ACTION_ELEMENT_DO 								,
					                                        		
					ACTION_ELEMENT_CONTINUE 						,
					ACTION_ELEMENT_BREAK 							,
					                                        		
					ACTION_ELEMENT_PARENTHESIZED 					,
					                                        		
					ACTION_ELEMENT_RETURN 							,
					                                        		
					ACTION_ELEMENT_EMPTY 							,
					                                        		
					ACTION_ELEMENT_LABEL 							,
					                                        		
					ACTION_ELEMENT_ASSERT 							,
					                                        		
					ACTION_ELEMENT_SWITCH 							,
					ACTION_ELEMENT_CASE 							,
					                                        		
					ACTION_ELEMENT_SYNCHRONIZED 					,
					                                        		
					ACTION_ELEMENT_THROW 							,
					                                        		
					ACTION_ELEMENT_CAST 							,
					                                        		
					ACTION_ELEMENT_ANNOTATION 						,
					ACTION_ELEMENT_ANNOTATION_MEMBER_VALUE 			,
					                                        		
					ACTION_ELEMENT_INFIX_EXPRESSION 				,
					ACTION_ELEMENT_POSTFIX_EXPRESSION 				,
					ACTION_ELEMENT_PREFIX_EXPRESSION 				,
					                                        		
					ACTION_ELEMENT_ASSIGNMENT 						,
					                                        		
					ACTION_ELEMENT_CONDITIONAL 						,
					                                        		
					ACTION_ELEMENT_INSTANCEOF 						,
					                                                
					ACTION_ELEMENT_NULL 							,
					                                                
					ACTION_ELEMENT_THIS 							,
			};
	
	public static final List<KDMActionElementsType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));
	
	private KDMActionElementsType(int value, String kind, Object name) {
		this.value = value;
		this.kind = kind;
		this.name = name;
	}
	
	public static KDMActionElementsType getByName(Object name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			KDMActionElementsType result = VALUES_ARRAY[i];
			if (result.getName().toString().equals(name.toString())) {
				return result;
			}
		}
		return null;
	}
	
	public static KDMActionElementsType getByType(String kind) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			KDMActionElementsType result = VALUES_ARRAY[i];
			if (result.getKind().equals(kind)) {
				return result;
			}
		}
		return null;
	}
	
	public int getValue() {
	  return value;
	}

	public Object getName() {
	  return name;
	}

	public String getKind() {
	  return kind;
	}

}
