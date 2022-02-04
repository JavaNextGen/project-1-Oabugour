package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.controllers.AuthController;
import com.revature.controllers.ReimbursementController;
import com.revature.controllers.UserController;
import com.revature.models.Menu;
import com.revature.util.ConnectionFactory;

import io.javalin.Javalin;

public class Driver {

    public static void main(String[] args) {
    	
    		// Test Database Connectivity here 
   UserController uc = new UserController();
   
   ReimbursementController rc = new ReimbursementController();
   
   AuthController ac = new AuthController();
    	
    		try(Connection conn = ConnectionFactory.getConnection()){
    			System.out.println("Connection Successful :)");
    		} catch(SQLException e) {
    			System.out.println("Connection failed");
    			e.printStackTrace();
    		}
    		
    		//Instantiate a menu object
    		// Menu menu = new Menu();
    		
    		//Use the Menu Class's displayMenu() method to give the user the menu
    		// menu.displayMenu();
    		
    		
    		
    		
    		
    		// bellow is what was og provided for me 
    		
    		
    	Javalin app = Javalin.create(
					config -> {
						config.enableCorsForAllOrigins(); 
					}
				).start(3000);
	
    		
	app.get("/user", uc.getUserHandler);
	app.post("/user", uc.insertUserHandler);
	
	
    app.get("/reimbursement", rc.getReimbursementHandler);
	app.post("/reimbursement", rc.insertReimbursementHandler);
	
	
	app.get("/login", ac.loginHandler);
	
		
app.get("/reimbursementstatus", rc.reimbursementstatus);



//	
//	app.post("/reimbursement", rc.insertReimbursementHandler);
//	
//	app.get("/ReimByType", rc.getReimbursementHandler);
//	
//	
//	app.get("/login", ac.loginHandler);
//
//	//port pid 3384 (process id 
//	
	
	
	
	/*	
    
Javalin app = Javalin.create().start(3000);
app.get("/",ctx -> {

	ctx.result ("Hello you've been sucessfully set up Javalin!! Hoo Rah!");
	ctx.status(200);
});

app.get ("/hi/{name}", ctx -> {
ctx.result ("Hi Winner" + ctx.pathParam ("name"));
ctx.status(200);
});

app.get("/hello/<name>", ctx ->{
ctx.result("Hello" + ctx.pathParam("name").replace ("/",""));
ctx.status (200);
});

app.get("/employee/{e_id}", ctx -> {
ctx.result(1+ctx.pathParam("e_id"));
ctx.status(200);
});

    
*/ 
}


}
	


