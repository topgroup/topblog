package com.dao.entity;

public class ShiroSession {
	private int sessionId;
	private String sessionKey;
	private String sessionValue;
	
	public void setSessionId(int sessionId){
		this.sessionId=sessionId;
	}
	
	public int getSessionId(){
		return this.sessionId;
	}
	
	public void setSessionKey(String sessionKey){
		this.sessionKey=sessionKey;
	}
	
	public String getSessionKey(){
		return this.sessionKey;
	}
	
	public void setSessionValue(String sessionValue){
		this.sessionValue=sessionValue;
	}
	
	public String getSessionValue(){
		return this.sessionValue;
	}
}
