package com.payload.response;

public class AuthenticationResponse {
	
	private String accessToken;
	
	public AuthenticationResponse()
	{
		
	}
	 
	public String getaccesstoken()
	{
		return accessToken;
	}
	
	public void setAccessToken(String accessToken)
	{
		this.accessToken=accessToken;
	}

	 @Override
	    public String toString() {
	        return "AuthenticationResponse{" +
	                "accessToken=" + accessToken +
	                '}';
	    }
}
