package com.restassurred;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Delete {
	public static void main(String[] args) {
		RequestSpecification reqspec;

		reqspec = RestAssured.given();
		//reqspec = reqspec.body("");
		reqspec = reqspec.pathParam("page", "2");
		Response response = reqspec.delete("https://reqres.in/api/users/{page}");
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
