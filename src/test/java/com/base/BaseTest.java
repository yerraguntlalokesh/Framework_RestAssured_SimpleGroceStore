package com.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.configuration.PropertyReader;
import com.utilities.APIContext;

import io.restassured.RestAssured;

public class BaseTest {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {

        PropertyReader.loadPropertyFile("QA.properties");

        RestAssured.baseURI =
                PropertyReader.getProperty("base.url");

    }
    
    @AfterMethod(alwaysRun = true)
    public void clearContext() {
        APIContext.clear();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {

        // LoggerManager.close();       // Later

        // ExtentManager.flush();       // Later

    }

}