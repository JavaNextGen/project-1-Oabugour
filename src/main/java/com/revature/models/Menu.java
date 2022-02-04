package com.revature.models;

import java.util.List;
import java.util.Scanner;

import com.revature.repositories.UserDAO;
import com.revature.services.UserService;
import com.revature.services.ReimbursementService;
import com.revature.services.*;


// import com.revature.services.EmployeeService;   // from ben's demo for reference
//import com.revature.services.RoleService;  


public class Menu {
	
	UserService us = new UserService();
	ReimbursementService rs = new ReimbursementService();
	AuthService as = new AuthService();
	
	
	//All of the menu display options and control flow are contained within this method
		public void displayMenu() {
			
			boolean displayMenu = true; //we're going to use this to toggle whether the menu continues after user input
			Scanner scan = new Scanner(System.in); //Scanner object to parse (take) user input
			
			//give the user a pretty greeting :)
			System.out.println("*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
			System.out.println("Welcome to The revature employee Reimbursement System ");
			System.out.println("*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
			
			
			//display the menu as long as the displayMenu boolean == true
			//this is going to hold and display all my menu options until displayMenu == false
			while(displayMenu) { 
				
				//menu options
				System.out.println("hi -> get greeted");
				System.out.println("User -> show all User");
				System.out.println("UserById -> get User with a certain ID");
				System.out.println("UserByTitle -> get User of a certain title");
				System.out.println("add -> add a new User");
				System.out.println("exit -> exit the application");
				
				
				//parse user input after they choose a menu option, and put it into a String variable
				String input = scan.nextLine();
				
				//switch statement that takes the user input and executes the appropriate code
				//BEN MAY ADD MORE COMMENTS HERE ONCE WE DO DATABASE CONNECTIVITY
				switch(input) {
				
				case "hi": {
					System.out.println("Hello there.");
					
					break; //we need a break in each case block, or else all the other cases will still run
				}
				
				case "Users" :{
					
					//get the List of employees from the repository layer
					List<User> Users = us.getUsers();
					
					//enhanced for loop to print out the Employees one by one
					for (User u: Users) {
						System.out.println(u);
					}
					
					break;
				}
				
				case "UserById" :{
					System.out.println("What employee id would you like to search for?");
					
					int idInput = scan.nextInt(); //get user's input for id
					scan.nextLine(); //we still need nextLine so that we can move to the next line for more input
					
					//what if the user inputs a String? program crashes
					//up to you to polish your project a bit and add some foolproofing mechanisms
					
					List<User> User = us.getUserById(idInput);
					
					for(User usr : User) {
						System.out.println(usr);
					}
					
					break;
				}
				
				case "Userbytitle": {
					
				System.out.println("Enter User Role to Search: (Case Sensitive! e.g. \"Trainer\")");
				String roleInput = scan.nextLine(); //get user's input for Role to search by
				
				List<User> User = us.getUserByReimbursementTitle(roleInput); //get the List of Employees from the dao
				
				for(User e : User)
				{
					System.out.println(e); //print them out one by one via the enhanced for loop
				}
				break;				
				
			}
				
				case "add" : {
					
//					//we need to prompt the user for the employee's name, and their role_id
//				 System.out.println("Enter User's First Name");
//					//String f_name = scan.nextLine();
//					
//					//System.out.println("Enter User Last Name");
//				//	String l_name = scan.nextLine();
//					
//					System.out.println("Enter Role Id: 1) Manager 2) Fry Cook 3) Cashier 4) Marketing 5) Nepotism");
//					int roleId = scan.nextInt(); //we need nextInt because ID is an int datatype in the database
//					scan.nextLine(); //without any nextLine(), your enter keystroke will be grabbed as the next input
					//so we need nextLine() in order to actually move to the..... NEXT line!
					
					//Given all this information, we'll create a new Employee object to send to the service layer
					//then the service layer will send it to the repository layer.
				//	User newUser = new User(10, "", "", "", ""); 
					
					
				//	Put the new Employee into the addEmployee() method in the EmployeeService Class
				//  us.addUser(newUser);
					
					break;
				}
					
					case "updateReimbursement": {
					
					System.out.println("Enter Reimbursement amount to change");
					String DifferenceInChange = scan.nextLine();
					
					System.out.println(" new reimbursement amount");
					int NewAmount  = scan.nextInt();
					scan.nextLine();
					
					rs.updateReimbursement(DifferenceInChange, NewAmount);
					break;
				}
				
				case "exit": {
					displayMenu = false;
					break;
				}
				
				//this default block will catch any user inputs that don't match a valid menu option
				default: {
					System.out.println("Invalid selection... try again :'( ");
					break;
				}
				
				
				} //end of switch
				
			} //end of while loop
			
			
		}
		
	}
