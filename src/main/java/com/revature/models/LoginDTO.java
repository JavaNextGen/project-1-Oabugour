package com.revature.models;


public class LoginDTO {

	//our LoginDTO models ONLY the username/password of our users
	private String ers_username;
	private String ers_password;

		
	
	public LoginDTO(String ers_username, String ers_password) {
		super();
		this.ers_username = ers_username;
		this.ers_password = ers_password;
	}


	public String geters_username() {
		return ers_username;
	}


	public void seters_username(String ers_username) {
		this.ers_username = ers_username;
	}


	public String geters_password() {
		return ers_password;
	}


	public void seters_password(String ers_password) {
		this.ers_password = ers_password;
	}
	

	//toString just incase we want to print out the object (could be helpful for debug)
	@Override
	public String toString() {
		return "LoginDTO [ers_username" + ers_username + ", ers_password=" + ers_password+ "]";
	}
}
	
	






// For each of these controller classes we need handlers & each
//references a class in the services 

// reference videos from end of last week (friday)