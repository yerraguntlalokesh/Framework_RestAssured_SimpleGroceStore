package com.endpoints;

import static io.restassured.RestAssured.given;

import com.routes.ProductRoutes;
import com.utilities.APIContext;
import com.utilities.RequestSpecFactory;

import io.restassured.response.Response;

public final class ProductEndpoints {
	
    private ProductEndpoints() {
    }

    public static Response getAllProducts() {

        Response res= given()
                .spec(RequestSpecFactory.getDefaultRequestSpec())
        .when()
                .get(ProductRoutes.GET_ALL_PRODUCTS);
        
        APIContext.setResponse(res);

        return res;

    }

    public static Response getProductById(int productId) {
        Response res= given()
                .spec(RequestSpecFactory.getDefaultRequestSpec())
                .pathParam("productId", productId)
        .when()
                .get(ProductRoutes.GET_PRODUCT_BY_ID);

        APIContext.setResponse(res);

        return res;
    }

}