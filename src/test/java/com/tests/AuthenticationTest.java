package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.dataproviders.TestDataProvider;
import com.endpoints.AuthenticationEndpoints;
import com.payload.request.AuthenticationRequest;
import com.payload.response.AuthenticationResponse;
import com.utilities.APIContext;

import io.restassured.response.Response;

public class AuthenticationTest extends BaseTest {

    @Test(dataProvider = "authenticationData", dataProviderClass = TestDataProvider.class)
    public void verifyAuthentication(String clientName, String clientEmail) {

        AuthenticationRequest request =
                new AuthenticationRequest(clientName, clientEmail);

        Response response=AuthenticationEndpoints.registerClient(request);
        
        response.then().statusCode(201);
        
        Assert.assertNotNull(response);
        
        AuthenticationResponse authenticationresponse=response.as(AuthenticationResponse.class); // Here we are deserializing the response
        
        String access_token=authenticationresponse.getaccesstoken(); //we are storing the token, now we need to make it as global
        
        //store Access Token
        
        APIContext.set("accesstoken", access_token);
        
        String response_accesstoken= (String) APIContext.get(access_token);
        
        Assert.assertNotNull(response_accesstoken);
        
    }
}