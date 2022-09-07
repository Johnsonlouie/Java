package com.integration;

import org.junit.Test;

import com.base.BaseClass;

import io.restassured.response.Response;

public class Sample extends BaseClass {
	@Test
	public void CreateUser() {
		// header
		addHeader("content-type", "application/json");
		// req body
		addBody("{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"leader\"\r\n" + "}");
		// methode type
		Response response = requestMethodType("post", "https://reqres.in/api/users");
		// ststus cord
		int statuscode = getStatusCode(response);
		System.out.println(statuscode);
		// aspretty
		String resBodyAsPrettyString = getResBodyAsPrettyString(response);
		System.out.println(resBodyAsPrettyString);

	}

}
