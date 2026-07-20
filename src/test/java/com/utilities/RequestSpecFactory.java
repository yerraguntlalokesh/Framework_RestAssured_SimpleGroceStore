package com.utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public final class RequestSpecFactory {

    private static final RequestSpecification DEFAULT_REQUEST_SPEC = new RequestSpecBuilder()
                                                                         .setContentType(ContentType.JSON)
                                                                         .setAccept(ContentType.JSON)
                                                                         .build();

    private RequestSpecFactory() {

    }

    public static RequestSpecification getDefaultRequestSpec() {

        return DEFAULT_REQUEST_SPEC;

    }

}