package com.listeners;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.reporting.ExtentManager;
import com.reporting.ExtentTestManager;
import com.utilities.APIContext;
import com.utilities.LoggerUtility;

public class TestListener implements ITestListener {

    private static final Logger logger =
            LoggerUtility.getLogger(TestListener.class);

    @Override
    public void onStart(ITestContext context) {

        logger.info("Execution Started.");

    }

    @Override
    public void onTestStart(ITestResult result) {

        String testName = result.getMethod().getMethodName();

        logger.info("Test Started : {}", testName);

        ExtentTestManager.createTest(result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        logger.info("Test Passed : {}", result.getMethod().getMethodName());


        ExtentTestManager.getTest().info(
                "Status Code : " + APIContext.getStatusCode());

        ExtentTestManager.getTest().info(
                "Response Time : " + APIContext.getResponseTime() + " ms");

        ExtentTestManager.getTest().pass(
                result.getMethod().getMethodName() + " Passed Successfully.");

    }

    @Override
    public void onTestFailure(ITestResult result) {

        logger.error("Test Failed : {}", result.getMethod().getMethodName());

        logger.error(result.getThrowable());

        ExtentTestManager.getTest().info(
                "Status Code : " + APIContext.getStatusCode());

        ExtentTestManager.getTest().info(
                "Response Time : " + APIContext.getResponseTime() + " ms");

        ExtentTestManager.getTest().fail(result.getThrowable());

    }

    @Override
    public void onTestSkipped(ITestResult result) {

        logger.warn("Test Skipped : {}", result.getMethod().getMethodName());

        ExtentTestManager.getTest().info(
                "Status Code : " + APIContext.getStatusCode());

        ExtentTestManager.getTest().info(
                "Response Time : " + APIContext.getResponseTime() + " ms");

        ExtentTestManager.getTest().skip(
                result.getMethod().getMethodName() + " Skipped.");

    }

    @Override
    public void onFinish(ITestContext context) {

        logger.info("Execution Completed.");

        ExtentManager.getExtentReports().flush();

        ExtentTestManager.unload();

    }

}