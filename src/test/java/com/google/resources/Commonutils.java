package com.google.resources;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Commonutils {
	
	public static RequestSpecification request;
	
	public RequestSpecification requestSpec() throws FileNotFoundException {
		
		//given
		
		PrintStream stream = new PrintStream(new FileOutputStream("logging.txt"));
		if(request == null){
		 request = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
				 .addFilter(RequestLoggingFilter.logRequestTo(stream))
				 .addFilter(ResponseLoggingFilter.logResponseTo(stream))
		.setContentType(ContentType.JSON).build();
		}
		 return request;

	}
	
	public ResponseSpecification responseSpec() {
		
		//then
		
		ResponseSpecification response = 
				new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		return response;

	}

}
