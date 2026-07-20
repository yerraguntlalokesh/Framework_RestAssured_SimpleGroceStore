package com.reporting;

import io.restassured.response.Response;

public final class ReportManager {

    private ReportManager() {

    }

    public static void logResponse(Response response) {

        ExtentTestManager.getTest().info(
                "<b>Status Code :</b> " + response.getStatusCode());

        ExtentTestManager.getTest().info(
                "<b>Response Time :</b> " + response.time() + " ms");

    }

}