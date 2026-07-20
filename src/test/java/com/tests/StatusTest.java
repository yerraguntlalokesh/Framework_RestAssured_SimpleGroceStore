package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.endpoints.StatusEndpoints;
import com.payload.response.StatusResponse;

import io.restassured.response.Response;

public class StatusTest extends BaseTest {
	
	@Test
	public void verifyStatus()
	{
		Response statusresponse = StatusEndpoints.getStatus();
		
		statusresponse.then().statusCode(200);
		
		StatusResponse stsresponse=statusresponse.as(StatusResponse.class);
		Assert.assertEquals(stsresponse.getStatus(), "UP");
		
	}

}
