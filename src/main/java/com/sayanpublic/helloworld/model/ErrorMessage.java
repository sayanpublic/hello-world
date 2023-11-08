package com.sayanpublic.helloworld.model;

import org.springframework.http.HttpStatusCode;

public class ErrorMessage {
	
	private HttpStatusCode status;
	private String errorMessage;
	
	public ErrorMessage() {
		super();
	}
	
	public ErrorMessage(HttpStatusCode status, String errorMessage) {
		super();
		this.status = status;
		this.errorMessage = errorMessage;
	}

	public HttpStatusCode getStatus() {
		return status;
	}
	public void setStatus(HttpStatusCode status) {
		this.status = status;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
