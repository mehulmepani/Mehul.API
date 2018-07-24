package com.qa.test.RESTAssured_swagger;

import org.junit.Ignore;
import org.junit.Test;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Junit_Swagger_Test {

	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	
	@Test
	@Ignore
	public void postSwagger() {
		JSONObject requestParams = new JSONObject();
		
		request = given().contentType(ContentType.JSON);
		RestAssured.baseURI = "http://localhost:8090/example/v1/hotels";

		requestParams.put("city", "Manchester");
		requestParams.put("description", "This is a test");
		requestParams.put("name", "ANTHIA");
		requestParams.put("rating", 10);
		
		request.body(requestParams.toString());
		response = request.post("http://localhost:8090/example/v1/hotels");
	}
	
	
	@Test
	@Ignore
	public void delete() {
		request = given().contentType(ContentType.JSON);
		response = request.delete("http://localhost:8090/example/v1/hotels/1");
	}
	
	@Test
	@Ignore
	public void getID() {
		request = given().contentType(ContentType.JSON);
		response = request.get("http://localhost:8090/example/v1/hotels/3");
		System.out.println("response: "+ response.prettyPrint());
	}
	
	@Test

	public void PUTSwagger() {
		JSONObject requestParams = new JSONObject();
		request = given().contentType(ContentType.JSON);
		response = request.when().get("http://localhost:8090/example/v1/hotels");

		requestParams.put("city", "london");
		requestParams.put("description", "This is a test2");
		requestParams.put("id", 5);
		requestParams.put("name", "ANTHIA A");
		requestParams.put("rating", 5);
		
		request.body(requestParams.toString());
		response = request.put("http://localhost:8090/example/v1/hotels/5");
		
		System.out.println(response.getStatusCode());
	}
}
