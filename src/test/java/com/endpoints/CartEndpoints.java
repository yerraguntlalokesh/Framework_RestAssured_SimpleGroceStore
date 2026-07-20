package com.endpoints;

import static io.restassured.RestAssured.given;

import com.routes.CartRoutes;
import com.utilities.APIContext;
import com.utilities.RequestSpecFactory;

import io.restassured.response.Response;

public final class CartEndpoints {

    private CartEndpoints() {

    }

    public static Response createCart() {

        Response res= given()
                .spec(RequestSpecFactory.getDefaultRequestSpec())

        .when()

                .post(CartRoutes.CREATE_CART);
        
        APIContext.setResponse(res);

        return res;
    }

    public static Response getCart(String cartId) {

       Response res= given()
                .spec(RequestSpecFactory.getDefaultRequestSpec())
                .pathParam("cartId", cartId)

        .when()

                .get(CartRoutes.GET_CART);

       APIContext.setResponse(res);

       return res;
    }

    public static Response addItemToCart(String cartId, Object request) {

        Response res= given()
                .spec(RequestSpecFactory.getDefaultRequestSpec())
                .pathParam("cartId", cartId)
                .body(request)

        .when()

                .post(CartRoutes.ADD_ITEM_TO_CART);
        APIContext.setResponse(res);

        return res;
    }

    public static Response getCartItems(String cartId) {

        Response res=given()
                .spec(RequestSpecFactory.getDefaultRequestSpec())
                .pathParam("cartId", cartId)

        .when()

                .get(CartRoutes.GET_CART_ITEMS);
        
        APIContext.setResponse(res);

        return res;

    }

    public static Response updateCartItem(String cartId,
                                          String itemId,
                                          Object request) {

        return given()
                .spec(RequestSpecFactory.getDefaultRequestSpec())
                .pathParam("cartId", cartId)
                .pathParam("itemId", itemId)
                .body(request)

        .when()

                .patch(CartRoutes.UPDATE_CART_ITEM);

    }

    public static Response replaceCartItem(String cartId,
                                           String itemId,
                                           Object request) {

        return given()
                .spec(RequestSpecFactory.getDefaultRequestSpec())
                .pathParam("cartId", cartId)
                .pathParam("itemId", itemId)
                .body(request)

        .when()

                .put(CartRoutes.REPLACE_CART_ITEM);

    }

    public static Response deleteCartItem(String cartId,
                                          String itemId) {

        return given()
                .spec(RequestSpecFactory.getDefaultRequestSpec())
                .pathParam("cartId", cartId)
                .pathParam("itemId", itemId)

        .when()

                .delete(CartRoutes.DELETE_CART_ITEM);

    }

}