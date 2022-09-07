package com.restassurred;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostCreate {
	public static void main(String[] args) {
		RequestSpecification reqspec;
		// initialize the resr assurred
		reqspec = RestAssured.given();
		// Header,auth,req body,query/path----heatder
		 reqspec = reqspec.header("content-Type","application/json");
		// pass path parameter
		//reqspec = reqspec.pathParam("page", "2");
		// method type and end point
		reqspec = reqspec.body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}");
		Response response = reqspec.post("https://reqres.in/api/users");
		// status cord
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		// get the res body
		String asString = response.asString();
		System.out.println(asString);
		// pretty String
		String asPrettyString = response.asPrettyString();
		System.out.println(asPrettyString);

	}
}