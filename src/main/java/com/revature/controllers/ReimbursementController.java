package com.revature.controllers;

import java.util.List;
import java.util.Objects;

import com.google.gson.Gson;
import com.revature.models.AbstractReimbursement;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.ReimbursementService;
import com.revature.services.UserService;

import io.javalin.http.Handler;

public class ReimbursementController {
	
	ReimbursementService rs = new ReimbursementService();
	

	public Handler getReimbursementHandler = (ctx) -> {
		if(ctx.req.getSession() != null) { 
			
			List<AbstractReimbursement> allReimbursement = rs.GetReimbursementsAll();		
		
			Gson gson = new Gson();
		
			String JSONAbstractReimbursement = gson.toJson(allReimbursement);
			
		
			ctx.result(JSONAbstractReimbursement);
			ctx.status(200);
			

		} else {
			ctx.result("Something went wrong");
			ctx.status(404);
		}
	};
	
	
			
	

		public Handler reimbursementstatus = (ctx) -> {
			if(ctx.req.getSession() != null) { 
				
				int ers_reimbursement_status = Integer.parseInt( Objects.requireNonNull(ctx.pathParam("ers_reimbursement_status")));	
				
				List<AbstractReimbursement> allReimbursement = rs.GetReimbursementsbyStatus("ers_reimbursement_status");		
			
				Gson gson = new Gson();
			
				String JSONAbstractReimbursement = gson.toJson(allReimbursement);
				
			
				ctx.result(JSONAbstractReimbursement);
				ctx.status(200);
				
				
				

			} else {
				ctx.result("Oh no no !!!!");
				ctx.status(404);
			}
		};
	

	
	public Handler insertReimbursementHandler = (ctx) -> {
		
		if(ctx.req.getSession() != null) {
			String body = ctx.body();
			
			Gson gson = new Gson();
			
			AbstractReimbursement ar = gson.fromJson(body, AbstractReimbursement .class);
			
			rs.insertRemRq(ar);
			
			ctx.result("Reimbursement Successfully added!");
			ctx.status(201);
			
		} else {
			ctx.result("Something Went Wrong");
			ctx.status(404);
		}
	
		
		
	
		
	};


	public Handler getReimbursementbyStatusIdntroller;


	public Handler getReimbursementByIdHandler;


	


			// Add the dependency into your pom.xml so it can import the Gson library
		

	};

	
	


