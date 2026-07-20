package com.endpoints;

import static io.restassured.RestAssured.given;

import com.payload.request.AuthenticationRequest;
import com.routes.AuthenticationRoutes;
import com.utilities.APIContext;
import com.utilities.LoggerUtility;
import com.utilities.RequestSpecFactory;

import io.restassured.response.Response;

public final class AuthenticationEndpoints {

    private AuthenticationEndpoints() {

    }
    


    public static Response registerClient(AuthenticationRequest request) {

    	        
        Response res= given()
                .spec(RequestSpecFactory.getDefaultRequestSpec())
                .body(request)

        .when()

                .post(AuthenticationRoutes.REGISTER_CLIENT);
        
        APIContext.setResponse(res);
        
        return res;


    }

}