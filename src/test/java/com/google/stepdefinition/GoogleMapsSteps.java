package com.google.stepdefinition;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.google.objectrepository.AddPlace;
import com.google.objectrepository.Location;
import com.google.objectrepository.Types;
import com.google.resources.Commonutils;
import com.google.resources.Resources;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

public class GoogleMapsSteps extends Commonutils{
	
	AddPlace addplace;
	
	Commonutils c = new Commonutils();
	ResponseSpecification response;
	
	@Given("add place payload")
	public void add_place_payload() {
		
		 addplace = new AddPlace();
		
		Location location = new Location();
		location.setLat("-38.383494");
		location.setLng("33.427362");
		
		addplace.setLocation(location);
		addplace.setAccuracy(60);
		addplace.setName("CG Technologies");
        addplace.setPhone("757657687");
        addplace.setAddress("Guduvanchery");
        
        
        
        List<String> l = new ArrayList<String>();
        l.add("institution");
        l.add("placements");
        
        addplace.setTypes(l);
        addplace.setWebsite("https://www.cgtech.com/");
        addplace.setLanguage("English & Tamil");
	    
	}

	RequestSpecification req;
	
	@When("user calls addPlaceApi with post http request")
	public void user_calls_addPlaceApi_with_post_http_request() throws FileNotFoundException {
		
		//response
		
		
		c.requestSpec();
		
		
		  req = given().spec(request)
		.body(addplace);
		
		
		
	    
	}

	@Then("user verify {string} status code {int}")
	public void user_verify_status_code(String resources, Integer int1) {
		
		 response = c.responseSpec();
		 
		 Resources resource = Resources.valueOf(resources);
		 
		 Response add = req.when().post(resource.getResource())
		 .then().spec(response).extract().response();
		 
		 System.out.println(add.getStatusCode());
		 String s = String.valueOf(add.getStatusCode());
		 Assert.assertEquals(int1.toString(), s);
		 
		// JsonPath j = new JsonPath(add);
		// System.out.println(j.getString("status"));
		 
		 
		
	    
	}

}
