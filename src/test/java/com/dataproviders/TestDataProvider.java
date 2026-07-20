package com.dataproviders;

import org.testng.annotations.DataProvider;

import com.configuration.PropertyReader;
import com.utilities.ExcelUtility;

public class TestDataProvider {

    private TestDataProvider() {

    }

    @DataProvider(name = "authenticationData")
    public static Object[][] getAuthenticationData() {
        return ExcelUtility.getSheetData("Authentication");
    }

  /* public static void main(String args[])
    
    {
        PropertyReader.loadPropertyFile("QA.properties");

    	Object[][] data=getAuthenticationData();
    	 
    	for(int i=0; i<data.length; i++)
    	{
    		for(int j=0; j<data[i].length; j++)
    		{
                System.out.print(data[i][j] + "\t");

    		}
    		System.out.println();
    	} 
    } */    //--> This code is only provided to check whether the excel data is coming or not

}