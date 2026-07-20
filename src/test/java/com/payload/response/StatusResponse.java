package com.payload.response;

public class StatusResponse {

	private String status;
	
	public String getStatus()
	{
		return status;
	}
	
	public void setStatus(String status)
	{
		this.status=status;
	}
	
	@Override
	public String toString() {
        return "StatusResponse{" +
                "status=" + status +
                '}';
	
}
}