package com.restassurred;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.base.BaseClass;

import io.restassured.response.Response;

public class Create extends BaseClass {
	public void createUser() throws ParseException {
		// Hearter
		addHeader("content-Type", "application/json");
		// Method Type
		Response response = requestMethodType("GET", "https://reqres.in/api/users?page=2");
		int statuscode = getStatusCode(response);
		System.out.println(statuscode);

		String resBodyAsPrettyString = getResBodyAsPrettyString(response);
		
		JSONParser jsonParser = new JSONParser();
		Object parse = jsonParser.parse(resBodyAsPrettyString);
		// conver jsonobject
		JSONObject jsonObject = (JSONObject) parse;
		Object object = jsonObject.get("data");

		// conver jsonarray
		JSONArray array = (JSONArray) object;
		Object object2 = array.get(0);

		// conver jsonobject
		JSONObject jsonObject2 = (JSONObject) object2;
		Object object3 = jsonObject2.get("first_name");
		String first_name = (String) object3;
		System.out.println(first_name);

	}
}
