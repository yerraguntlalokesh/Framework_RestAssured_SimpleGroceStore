package com.reporting;

import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.ExtentTest;
import com.utilities.LoggerUtility;

public final class ExtentTestManager {

    private static final Logger logger =
            LoggerUtility.getLogger(ExtentTestManager.class);

    private static final ThreadLocal<ExtentTest> extentTest =
            new ThreadLocal<>();

    private ExtentTestManager() {

    }

    public static void createTest(String testName) {

        logger.info("Creating Extent Test : {}", testName);

        ExtentTest test =
                ExtentManager.getExtentReports().createTest(testName);

        extentTest.set(test);
    }

    public static ExtentTest getTest() {

        return extentTest.get();
    }

    public static void unload() {

        logger.info("Removing Extent Test from ThreadLocal.");

        extentTest.remove();
    }

}