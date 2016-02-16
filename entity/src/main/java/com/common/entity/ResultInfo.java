package com.common.entity;

public class ResultInfo {
	private Integer errorCode;
	private String errorMessage;
	
	public void setErrorCode(Integer errorCode){
		this.errorCode=errorCode;
	}
	
	public Integer getErrorCode() {
		return this.errorCode;
	}
	
	public void setErrorMessage(String errorMessage){
		this.errorMessage=errorMessage;
	}
	
	public String getErrorMessage() {
		return this.errorMessage;
	}
}
