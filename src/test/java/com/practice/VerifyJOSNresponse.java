package com.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Map;

public class VerifyJOSNresponse {
	
   @Test
   public void validaton_Json()
   {
	   
	   Response res= given()
	   
	                    .when().get("https://dummyjson.com/products");
	    
	                     //res.then().log().body(); --> This logs the response body
	      
	   JsonPath jp=res.jsonPath();
	     
//	   //get Status code
//	   System.out.println(res.getStatusCode());
//	   
//	   //get count of no.of products
//	  int size= jp.getList("products").size();
//	  System.out.println(size);
//	  
//	  
//	  //print title of first product
//	  System.out.println(jp.getString("products[0].title"));
//	  
//	  //Print description of first product
//	  System.out.println(jp.getString("products[0].description"));
//	  
//	  //Print all Product Titles
//	  List<String> lt= jp.getList("products.title");
//	  for(int i=0; i<=lt.size()-1; i++)
//	  {
//		  System.out.println(lt.get(i));
//	  }
//	  
//	  
//	  //Print all product ID's
//	  List<Integer> pid=jp.getList("products.id");
//	  for(int i=0; i<=pid.size()-1; i++)
//	  {
//		  System.out.print(pid.get(i)+" ");
//	  }
//	  
// 	  //print width of first product
//	  double d=jp.getDouble("products[0].dimensions.width");
//	  System.out.println();
//	  System.out.println(d);
//	  
//	  //print the barcode of first product
//	  
//	  System.out.println(jp.getString("products[0].meta.barcode"));
	  
	  //print the first tag of 1st product
	  
	  System.out.println(jp.getString("products[0].tags[0]"));
	  
	  //print all tags of product 1
	  List<String> lt=jp.getList("products[0].tags");
	  for(int i=0; i<=lt.size()-1; i++) 
	  {
		  System.out.println(lt.get(i));
	  }
	  
	  //First Image URL
	  String img=jp.getString("products[0].images[0]");
	  System.out.println(img);
	  
	  
	  //verify the first product title
	  String firsttitle= jp.getString("products[0].title");
	  Assert.assertEquals(firsttitle, "Essence Mascara Lash Princess");
	  
	  //print the title where Id=3 --> VVIP
	  System.out.println(jp.getString("products.find {it.id==3}.title"));
	  
	  //print all products title with price>15
	  List<String> titles=jp.getList("products.findAll {it.price>15}.title");
	  for(int i=0; i<=titles.size()-1; i++)
	  {
		  System.out.println(titles.get(i));
	  }
	  
	  //Print the prices greater than 15
	  List<Double> prices=jp.getList("products.findAll {it.price>15}.price");
	  for(int i=0; i<=prices.size()-1; i++)
	  {
		  System.out.println(prices.get(i));
	  }
	  
	  //print both price and title for price>15
	  List<Map<String,Object>> multi=jp.getList("products.findAll {it.price > 15}");
	  for(int i=0; i<=multi.size()-1; i++)
	  {
		  System.out.println(multi.get(i).get("title")+"-------->"+ multi.get(i).get("price"));
	  }
   }

}
