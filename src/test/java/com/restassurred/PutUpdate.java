package com.restassurred;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutUpdate {
	public static void main(String[] args) {
		RequestSpecification reqspec;

		reqspec = RestAssured.given();
		reqspec = reqspec.header("content-Type","application/json");
		reqspec = reqspec
				.body("{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"zion resident\"\r\n" + "}");
		reqspec = reqspec.pathParam("page", "2");
		Response response = reqspec.put("https://reqres.in/api/users/{page}");
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
