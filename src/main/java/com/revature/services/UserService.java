package com.revature.services;

import java.util.List;
import java.util.Optional;

import com.revature.models.User;
import com.revature.repositories.UserDAO;

/**
 * The UserService should handle the processing and retrieval of Users for the ERS application.
 *
 * {@code getByUsername} is the only method required;
 * however, additional methods can be added.
 *
 * Examples:
 * <ul>
 *     <li>Create User</li>
 *     <li>Update User Information</li>
 *     <li>Get Users by ID</li>
 *     <li>Get Users by Email</li>
 *     <li>Get All Users</li>
 * </ul>
 */
public class UserService {
 
	UserDAO u = new UserDAO();
	
	
	/**
	 *     Should retrieve a User with the corresponding username or an empty optional if there is no match.
     */
	public Optional<User> getByUsername(String username) {
		return Optional.empty();
	}

	//********************************************************
	// below are suggestions from menu ask if these were the right move 
	
	//public List<User> getUserByReimbursementTitle(String roleInput) {
		// TODO Auto-generated method stub
	//	return null;
	//}

	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return u.getUsers();
	}


	public List<User> getUserById(int idInput) {
		// TODO Auto-generated method stub
		return null;
	}
	

	public void addUser(User newUser) {
		// TODO Auto-generated method stub
		u.insertUser(newUser);
	}

	public List<User> getUserByReimbursementTitle(String roleInput) {
		// TODO Auto-generated method stub
		return null;
	}
}
