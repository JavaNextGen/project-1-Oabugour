package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.controllers.EmployeeController;
import com.revature.models.Menu;
import com.revature.util.ConnectionFactory;

import io.javalin.Javalin;

public class Driver {

    public static void main(String[] args) {
    	
    		
    		EmployeeController ec = new EmployeeController();
    	
    		try(Connection conn = ConnectionFactory.getConnection()){
    			System.out.println("Connection Successful :)");
    		} catch(SQLException e) {
    			System.out.println("Connection failed");
    			e.printStackTrace();
    		}
    		Javalin app = Javalin.create(
					config -> {
						config.enableCorsForAllOrigins(); 
					}
				).start(3000);
		
		app.get("/employee", ec.getEmployeesHandler);
		app.post("/employee", ec.insertEmployeeHandler);
	}
    }
}
