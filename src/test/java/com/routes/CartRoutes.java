package com.routes;

public final class CartRoutes {

    private CartRoutes() {

    }

    // Cart
    public static  String CREATE_CART = "/carts";

    public static String GET_CART = "/carts/{cartId}";

    // Cart Items
    public static String ADD_ITEM_TO_CART = "/carts/{cartId}/items";

    public static String GET_CART_ITEMS = "/carts/{cartId}/items";

    public static String UPDATE_CART_ITEM = "/carts/{cartId}/items/{itemId}";

    public static String REPLACE_CART_ITEM = "/carts/{cartId}/items/{itemId}";

    public static String DELETE_CART_ITEM = "/carts/{cartId}/items/{itemId}";

}