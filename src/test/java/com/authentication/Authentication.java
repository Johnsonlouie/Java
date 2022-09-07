package com.authentication;

import org.testng.annotations.Test;

import com.base.BaseClass;

import io.restassured.response.Response;

public class Authentication extends BaseClass {
	@Test
	public void login() {
		
	// Header
		addHeader("accept", "application/json");
		basicAuth("johnsonaroaro@gmail.com", "Johnson@123");
		Response response = requestMethodType("post", "https://omrbranch.com/api/postmanBasicAuthLogin");

		int statuscode = getStatusCode(response);
		System.out.println(statuscode);
		String resBodyAsPrettyString = getResBodyAsPrettyString(response);
		System.out.println(resBodyAsPrettyString);
	}
	}


