package com.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.endpoints.ProductEndpoints;
import com.payload.response.ProductResponse;
import com.utilities.APIContext;

import io.restassured.response.Response;

public class ProductTest extends BaseTest {

    @Test(description = "Verify Get All Products API")
    public void verifyGetAllProducts() {

        // Call Get Products API
        Response response = ProductEndpoints.getAllProducts();

        // Validate Status Code
        response.then().statusCode(200);

        // Deserialize Response
        List<ProductResponse> productList =
                response.jsonPath().getList("", ProductResponse.class);

        // Validate Product List
        Assert.assertNotNull(productList, "Product List should not be null.");
        Assert.assertFalse(productList.isEmpty(), "Product List should not be empty.");

        System.out.println("==========================================================");
        System.out.println("                AVAILABLE PRODUCTS");
        System.out.println("==========================================================");

        for (ProductResponse product : productList) {

            System.out.println("----------------------------------------------");
            System.out.println("Product ID   : " + product.getId());
            System.out.println("Product Name : " + product.getName());
            System.out.println("Category     : " + product.getCategory());
            System.out.println("In Stock     : " + product.isInStock());

            // Common Validations
            Assert.assertTrue(product.getId() > 0,
                    "Invalid Product Id");

            Assert.assertNotNull(product.getName(),
                    "Product Name should not be null");

            Assert.assertFalse(product.getName().trim().isEmpty(),
                    "Product Name should not be empty");

            Assert.assertNotNull(product.getCategory(),
                    "Category should not be null");
        }

    }
}