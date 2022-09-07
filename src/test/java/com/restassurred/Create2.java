package com.restassurred;

import org.junit.Assert;

import com.base.BaseClass;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Create2 extends BaseClass {
	private void JsonPath() {
		addHeader("content-Type", "application/json");
		Response response = requestMethodType("GET", "https://reqres.in/api/users?page=2");
		int statuscode = getStatusCode(response);
		System.out.println(statuscode);
		// map
		JsonPath path = response.jsonPath();
		Object object = path.get("data[0],first_name");
		String first_name = (String) object;
		Assert.assertEquals(first_name, "Michael", "verify firstname");

	}

}
