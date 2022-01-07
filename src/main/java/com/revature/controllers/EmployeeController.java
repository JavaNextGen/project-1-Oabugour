package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.User;
import com.revature.services.UserService;

import io.javalin.http.Handler;

public class EmployeeController {

	UserService us = new UserService();
	
	public Handler getUserHandler = (ctx) -> {
		if(ctx.req.getSession() != null) { //if the session exist
			
			List<User> allEmployees = us.getByUsername();
			
			// Add the dependency into your pom.xml so it can import the Gson library
			Gson gson = new Gson();
			
			// Use gson library to convert the java object to a JSON string
			String JSONEmployees = gson.toJson(allEmployees);
			
			// Give a response body with a JSON string 
			ctx.result(JSONEmployees);
			ctx.status(200);
			

		} else {
			ctx.result("Oh no you failed to get the employees!!!!");
			ctx.status(404);
		}
	};
	
	public Handler insertEmployeeHandler = (ctx) -> {
		
		if(ctx.req.getSession() != null) {
			String body = ctx.body();
			
			Gson gson = new Gson();
			
			User user = gson.fromJson(body, User.class);
			
			us.addUser(User);
			
			ctx.result("User was successfully added!");
			ctx.status(201);
			
		} else {
			ctx.result("Oh no you failed to insert a User!!!!");
			ctx.status(404);
		}
		
		
	};
	
}