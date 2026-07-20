package com.reporting;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ExtentManager {

    private static ExtentReports extentReports;

    private ExtentManager() {

    }

    public static ExtentReports getExtentReports() {

        if (extentReports == null) {
        	
        	
        	String timeStamp = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date());

        	String reportPath = "Reports/ExtentReports/ExtentReport_" + timeStamp + ".html";

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(reportPath);

            sparkReporter.config().setDocumentTitle("API Automation Report");
            sparkReporter.config().setReportName("REST Assured Framework Execution Report");

            extentReports = new ExtentReports();

            extentReports.attachReporter(sparkReporter);

            extentReports.setSystemInfo("Framework", "REST Assured");
            extentReports.setSystemInfo("Environment", "QA");
            extentReports.setSystemInfo("Tester", System.getProperty("user.name"));
            extentReports.setSystemInfo("Operating System", System.getProperty("os.name"));
            extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));

            try {

                extentReports.setSystemInfo(
                        "Host Name",
                        InetAddress.getLocalHost().getHostName());

                extentReports.setSystemInfo(
                        "Host Address",
                        InetAddress.getLocalHost().getHostAddress());

            }
            catch (UnknownHostException exception) {

                exception.printStackTrace();

            }

        }

        return extentReports;
    }
}