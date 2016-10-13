package com.learn.rest.service.exception;

public class ErrorDetails {
	
	private Integer errorCode;
	private String errorDetails;
	
	  public ErrorDetails() {
		// TODO Auto-generated constructor stub
	}

	public ErrorDetails(Integer errorCode, String errorDetails) {
		super();
		this.errorCode = errorCode;
		this.errorDetails = errorDetails;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}
	  
	  
	

}
