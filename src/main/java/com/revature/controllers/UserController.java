package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.AbstractUser;
import com.revature.models.User;
import com.revature.services.UserService;
import io.javalin.http.Handler;

public class UserController {

	UserService us = new UserService();

	// *****This layer is where we'll parse our JSON into Java objects and vice vera*****
	// Sits between the Javalin Front Controller and the Service Layer
	// We'll either be getting data from the service layer (which is our DAO)
	// ORR sending data to the service layer (will probably return some response that it was successful)
	
	
	public Handler getUserHandler = (ctx) -> {
		if(ctx.req.getSession() != null) { //if the session exist
			
			List<User> allUsers = us.getUsers();
			
			// Add the dependency into your pom.xml so it can import the Gson library
			Gson gson = new Gson();
			
			// Use gson library to convert the java object to a JSON string
			String JSONUsers = gson.toJson(allUsers);
			
			// Give a response body with a JSON string 
			ctx.result(JSONUsers);
			ctx.status(200);
			

		} else {
			ctx.result("Oh no you failed to get the employees!!!!");
			ctx.status(404);
		}
	};
	
	public Handler insertUserHandler = (ctx) -> {
		
		if(ctx.req.getSession() != null) {
			String body = ctx.body();
			
			Gson gson = new Gson();
			
			User newUser = gson.fromJson(body, User.class);
			
			
			us.addUser(newUser);
			
			
			ctx.result("User was successfully added!");
			ctx.status(201);
			
		} else {
			ctx.result("Oh no you failed to insert a User!!!!");
			ctx.status(404);
		}
		
		
	};
	
}
/*
public Handler getReimbursementByIdHandler = (ctx) -> {
	if(ctx.req.getSession() != null) { //if the session exist
		
		List<User> allUsers = us.getUsers();
		
		// Add the dependency into your pom.xml so it can import the Gson library
		Gson gson = new Gson();
	}
}

*/


