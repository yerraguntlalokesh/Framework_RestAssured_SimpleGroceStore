package com.endpoints;

import static io.restassured.RestAssured.given;

import com.routes.StatusRoutes;
import com.utilities.APIContext;
import com.utilities.RequestSpecFactory;

import io.restassured.response.Response;

public final class StatusEndpoints {

    private StatusEndpoints() {

    }

    public static Response getStatus() {

        Response res= given()
                .spec(RequestSpecFactory.getDefaultRequestSpec())

        .when()

                .get(StatusRoutes.STATUS);
        
        APIContext.setResponse(res);

        return res;

    }

}