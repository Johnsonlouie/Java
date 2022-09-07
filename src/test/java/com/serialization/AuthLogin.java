package com.serialization;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class AuthLogin extends BaseClass {
	String logtoken;
	String address_id;

	@Test(priority = 1)
	public void login() {

		addHeader("accept", "application/json");
		basicAuth(getus, "Johnson@123");
		Response response = requestMethodType("POST", "EndPoints. POSTMANBASICAUTHLOGIN");

		int statuscode = getStatusCode(response);
		System.out.println(statuscode);

		Assert.assertEquals(statuscode, 200, "verify status code");

		Login_Output_Pojo login_Output_Pojo = response.as(Login_Output_Pojo.class);

		String first_name = login_Output_Pojo.getData().getFirst_name();

		Assert.assertEquals(first_name, "Arockia", "verify firstname");

		logtoken = login_Output_Pojo.getData().getLogtoken();

	}

	@Test(priority = 2)
	public void AddUserAddress() {

		// add header
		List<Header> h = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		h.add(h1);
		h.add(h2);
		h.add(h3);
		Headers headers = new Headers(h);
		addHeaders(headers);
		// pass the paylode
		AddUserAddress_Input_Pojo adduserAddress_Input_Pojo = new AddUserAddress_Input_Pojo("mani", "kumar",
				"9876543210", "ABC", 10, 20, 101, "54321", "chennai", "Home");
		addBody(adduserAddress_Input_Pojo);

		// Method Type
		Response response = requestMethodType("POST", "EndPoints.ADDUSERADDERSS");

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);

		// String resBodyAsPrettyString = getResBodyAsPrettyString(response);
		// System.out.println(resBodyAsPrettyString);

		Assert.assertEquals(statusCode, 200, "verfy status code");
		AddUserAddress_Output_Pojo address_Output_Pojo = response.as(AddUserAddress_Output_Pojo.class);

		String message = address_Output_Pojo.getMessage();
		Assert.assertEquals(message, "Address added successfully", "verify Address added successfully");

		int id = address_Output_Pojo.getAddress_id();
		address_id = String.valueOf(id);
		System.out.println(address_id);
	}

	@Test(priority = 3)
	public void UpdateUserAddress() {

		// 1. add header
		List<Header> h = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		h.add(h1);
		h.add(h2);
		h.add(h3);
		Headers headers = new Headers(h);
		addHeaders(headers);

		// 2.pass the paylode---> add body
		UpdateUserAddress_Input_Pojo updateUserAddress_Input_Pojo = new UpdateUserAddress_Input_Pojo(address_id, "John",
				"Son", "9876543210", "ABC", 10, 20, 101, "54321", "chennai", "Home");
		addBody(updateUserAddress_Input_Pojo);
		// method type
		Response response = requestMethodType("PUT", "EndPoints.UPDATEUSERADDRESS");
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "verify status code");

		UpdateUserAddress_Output_Pojo updateUserAddress_Output_Pojo = response.as(UpdateUserAddress_Output_Pojo.class);
		String message = updateUserAddress_Output_Pojo.getMessage();
		// System.out.println(message);
		Assert.assertEquals(message, "Address updated successfully", "verify Address updated successfully");
		System.out.println(address_id);
	}

	@Test(priority = 4)
	public void DeleteUserAddress() {
		// 1. add header
		List<Header> h = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		h.add(h1);
		h.add(h2);
		h.add(h3);
		Headers headers = new Headers(h);
		addHeaders(headers);

		// 2.pay lode
		DeleteUserAddress_Input_Pojo deleteUserAddress_Input_Pojo = new DeleteUserAddress_Input_Pojo(address_id);

		addBody(deleteUserAddress_Input_Pojo);

		// 3.req type
		Response response = requestMethodType("DELETE", "EndPoints.DELETEUSERADDRESS");
		int statusCode = getStatusCode(response);

		Assert.assertEquals(statusCode, 200, "verify status code");

		DeleteUserAddress_Output_Pojo deleteUserAddress_Output_Pojo = response.as(DeleteUserAddress_Output_Pojo.class);
		String message = deleteUserAddress_Output_Pojo.getMessage();

		Assert.assertEquals(message, "Address deleted successfully", "verify Address deleted successfully");

	}

	@Test(priority = 5)
	public void GetUserAddress() {
		// 1. add header
		List<Header> h = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		h.add(h1);
		h.add(h2);
		Headers headers = new Headers(h);
		addHeaders(headers);
		// req type
		Response response = requestMethodType("GET", "EndPoints.GETUSERADDRESS");
		int statusCode = getStatusCode(response);

		Assert.assertEquals(statusCode, 200, "verify the statusCode");

		GetUserAddress_Output_Pojo getUserAddress_Output_Pojo = response.as(GetUserAddress_Output_Pojo.class);
		String message = getUserAddress_Output_Pojo.getMessage();

		Assert.assertEquals(message, "OK", "verify OK ");
	}

	@Test(priority = 6)
		public void ChangeProfilePic() {
			
			// 1. add header
			List<Header> h = new ArrayList<>();
			Header h1 = new Header("accept", "application/json");
			Header h2 = new Header("Authorization", "Bearer " + logtoken);
			Header h3 = new Header("Content-Type", "application/json");
			h.add(h1);
			h.add(h2);
			h.add(h3);
			Headers headers = new Headers(h);
			addHeaders(headers);
			
		    //2.pay load----->formData
			FromData("Profile_Picture",new File(System.getProperty("user.dir")+getPropertyFile("\\ProfilePic\\heart.jpg")));
		
		
		//3.method type
		Response response = requestMethodType("POST", "EndPoints.UPDATEPROPILE");
		
	      int statusCode = getStatusCode(response);
	      Assert.assertEquals(statusCode, 200,"Verify Status Code");
	      
	      UpdateProfilePic_Output_Pojo updateProfilePic_Output_Pojo = response.as(UpdateProfilePic_Output_Pojo.class);
	      Asseret.asserte
				
			
	}		
			
			
			
			
			
		    	}


