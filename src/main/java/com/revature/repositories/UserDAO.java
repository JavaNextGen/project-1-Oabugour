package com.revature.repositories;

import java.util.Optional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class UserDAO {
	
	public List<User> getUsers() { //This will use SQL SELECT functionality
		
		try { Connection conn = ConnectionFactory.getConnection(); //all of my SQL stuff will be within this try block
			
			//Initialize an empty ResultSet object that will store the results of our SQL query
			ResultSet rs = null;
			
			
			
			//write the query that we want to send to the database, and assign it to a String
			String sql = "SELECT * FROM ers_user;"; 

			
			//Put the SQL query into a Statement object (The Connection object has a method for this!!)
			Statement statement = conn.createStatement();
			
			//EXECUTE THE QUERY, by putting the results of the query into our ResultSet object
			//The Statement object has a method that takes Strings to execute as a SQL query
			rs = statement.executeQuery(sql);
			
			//All the code above makes a call to your database... Now we need to store the data in an ArrayList.
			
			//create an empty ArrayList to be filled with the data from the database
		List<User> user = new ArrayList<>();
			
			//while there are results in the resultset...
			while(rs.next()) {
				
				//Use the all args constructor to create a new Employee object from each returned row from the DB
				User u = new User(
						
					
						//we want to use rs.get for each column in the record
        				rs.getInt("user_id"),
				        rs.getString("ers_username"),
        				rs.getString("ers_password"),
    					rs.getString("user_f_name"),
    					rs.getString("user_l_name"),
    					rs.getString("email"),
    					rs.getInt("user_role_id_fk")
			);
				
				System.out.println(u);
				user.add(u); //and populate the ArrayList with each created Role Object
			}
			
			return user; //Finally, return the populated List of Roles.
			
		} catch (SQLException u) {
			System.out.println("hmmm something isn't right. Try again!");
			u.printStackTrace();
		}
		
		return null;
	

	}


//--------------------------------------------------------------------------------------

	public List<User> getUserById(int id) {
		
	try(Connection conn = ConnectionFactory.getConnection()) {
		
		ResultSet rs = null;
		
		String sql = "SELECT * FROM ers_user WHERE user_id ;";
		
		//when we need parameters we need to use a PREPARED Statement, as opposed to a Statement (seen above)
		PreparedStatement ps = conn.prepareStatement(sql); //prepareStatment() as opposed to createStatment()
		
		//insert the methods argument (int id) as the first (and only) variable in our SQL query
		ps.setInt(7, id); //the 1 here is referring to the first parameter (?) found in our SQL String
		
		rs = ps.executeQuery();
		
		//create an empty List to be filled with the data from the database
		List<User> user = new ArrayList<>();
		
//we technically don't need this while loop since we're only getting one result back... see if you can refactor :)
		while(rs.next()) { //while there are results in the result set...
			
		//Use the all args Constructor to create a new Employee object from each returned row...
		User u = new User(
				//we want to use rs.getXYZ for each column in the record
				rs.getInt("user_id"),
		        rs.getString("ers_username"),
				rs.getString("ers_password"),
				rs.getString("user_f_name"),
				rs.getString("user_l_name"),
				rs.getString("email"),
				rs.getInt("user_role_id_fk")
	);
		
		//and populate the ArrayList with each new Employee object
		
		
		user.add(u); //e is the new Employee object we created above
		
		}
		
		//when there are no more results in the ResultSet the while loop will break...
		//return the populated List of Employees
		return user;
		
	} catch (SQLException u) {
		System.out.println("Something went wrong with your database!"); 
		u.printStackTrace();
	}
	return null;
}



public void insertUser(User newUser) { //This is INSERT functionality 
	
	try(Connection conn = ConnectionFactory.getConnection()){
		
		//we'll create a SQL statement using parameters to insert a new Employee
		String sql = "INSERT INTO ers_user (Ers_username,Ers_password,User_f_name, user_l_name,email, user_role_id_fk) " //creating a line break for readability
				    + "VALUES (?,?,?, ?,?,?); "; //these are parameters!! We have to specify the value of each "?"
		
		PreparedStatement ps = conn.prepareStatement(sql); //we use PreparedStatements for SQL commands with variables
		
		//use the PreparedStatement objects' methods to insert values into the query's ?s
		//the values will come from the Employee object we send in.
		ps.setString(1, newUser.getErs_username());
		ps.setString(2, newUser.getErs_password());
		ps.setString(3, newUser. getUser_f_name());
		ps.setString(4, newUser.getUser_l_name());
		ps.setString(5, newUser.getEmail());
		ps.setInt(6, newUser.getUser_role_id_fk());
		
		
		//*********** these are trying to call getters*******/// 
		//1  work on get all reimbursements
		
		
		//this executeUpdate() method actually sends and executes the SQL command we built
		ps.executeUpdate(); //we use executeUpdate() for inserts, updates, and deletes. 
		//we use executeQuery() for selects
		
		//send confirmation to the console if successul.
		System.out.println("User " + newUser.getUser_f_name() + " created. Welcome aboard!");
		
		
	} catch(SQLException e) {
		System.out.println("Add employee failed! :(");
		e.printStackTrace();
	}
	
}


	//Bit more complicated query, uses a join to get more data than usual from two tables 
	public List<User> getEmployeesByRoleTitle(String title) {
		
		try(Connection conn = ConnectionFactory.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "select * from employees inner join roles "
					     + "on employees.role_id = roles.role_id where roles.role_title = ?";
			//we need to join employees to roles in order to access the role_title column and return employees
			//since I want to get employees based on something found in the roles table, we need a join 
			
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, title); //insert the method's argument as the first (and only) variable in the query
			
			rs = ps.executeQuery();	
			
			List<User> user = new ArrayList<>();
			
			while(rs.next()) { //while there are results in the result set...
				
				User u = new User( //create a new Employee Object from each returned row..
						
        				rs.getInt("user_id"),
				        rs.getString("ers_username"),
        				rs.getString("ers_password"),
    					rs.getString("user_f_name"),
    					rs.getString("user_l_name"),
    					rs.getString("email"),
    					rs.getInt("user_role_id_fk")
			);
				user.add(u); //and populate the ArrayList with each created Role Object
			}
			
			return user; //Finally, return the populated List of Roles.
			
		} catch (SQLException u) {
			u.printStackTrace();
		}
		
		return null;
	}







				
				//and populate the ArrayList with each new Employee object
			//	UserList.add(u); //e is the new Employee object we created above
		

	

    /**
     * Should retrieve a User from the DB with the corresponding username or an empty optional if there is no match.
     */
    public Optional<User> getByUsername(String username) {
        return Optional.empty();
    }

    /**
     * <ul>
     *     <li>Should Insert a new User record into the DB with the provided information.</li>
     *     <li>Should throw an exception if the creation is unsuccessful.</li>
     *     <li>Should return a User object with an updated ID.</li>
     * </ul>
     *
     * Note: The userToBeRegistered will have an id=0, and username and password will not be null.
     * Additional fields may be null.
     */
    public User create(User userToBeRegistered) {
        return userToBeRegistered;
    }
}
