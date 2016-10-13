package com.webservice.soap.exception;

public class ProductException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorDetails;
	
	public ProductException(String reason,String errorDetails) {
		super(reason);
		this.errorDetails = errorDetails;
	}

	/*public String getFaultInfo(){
		return this.errorDetails;
	}*/

	public String getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}
	
	
	

}
