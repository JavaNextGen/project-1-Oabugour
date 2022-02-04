package com.revature.models;

/**
 * This concrete User class can include additional fields that can be used for
 * extended functionality of the ERS application.
 *
 * Example fields:
 * <ul>
 *     <li>First Name</li>
 *     <li>Last Name</li>
 *     <li>Email</li>
 *     <li>Phone Number</li>
 *     <li>Address</li>
 *     
 * </ul>
 *
 */

// user extends abstract user, do the fields will change in user
public class User {

	private int user_id;
	private String ers_username;
	private String ers_password;
	private String user_f_name;
	private String user_l_name;
	private String email;
	private int user_role_id_fk; 


	// change the getters & setters to match the below fields




	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", ers_username=" + ers_username + ", ers_password=" + ers_password
				+ ", user_f_name=" + user_f_name + ", user_l_name=" + user_l_name + ", email=" + email
				+ ", user_role_id_fk=" + user_role_id_fk + "]";
	}
	public User(int user_id, String ers_username, String ers_password, int user_role_id_fk) {
		super();
		this.user_id = user_id;
		this.ers_username = ers_username;
		this.ers_password = ers_password;
		this.user_role_id_fk = user_role_id_fk;
	}
	public User(int user_id, String ers_username, String ers_password, String user_f_name, String user_l_name,
			String email, int user_role_id_fk) {
		super();
		this.user_id = user_id;
		this.ers_username = ers_username;
		this.ers_password = ers_password;
		this.user_f_name = user_f_name;
		this.user_l_name = user_l_name;
		this.email = email;
		this.user_role_id_fk = user_role_id_fk;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((ers_password == null) ? 0 : ers_password.hashCode());
		result = prime * result + ((ers_username == null) ? 0 : ers_username.hashCode());
		result = prime * result + ((user_f_name == null) ? 0 : user_f_name.hashCode());
		result = prime * result + user_id;
		result = prime * result + ((user_l_name == null) ? 0 : user_l_name.hashCode());
		result = prime * result + user_role_id_fk;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (ers_password == null) {
			if (other.ers_password != null)
				return false;
		} else if (!ers_password.equals(other.ers_password))
			return false;
		if (ers_username == null) {
			if (other.ers_username != null)
				return false;
		} else if (!ers_username.equals(other.ers_username))
			return false;
		if (user_f_name == null) {
			if (other.user_f_name != null)
				return false;
		} else if (!user_f_name.equals(other.user_f_name))
			return false;
		if (user_id != other.user_id)
			return false;
		if (user_l_name == null) {
			if (other.user_l_name != null)
				return false;
		} else if (!user_l_name.equals(other.user_l_name))
			return false;
		if (user_role_id_fk != other.user_role_id_fk)
			return false;
		return true;
	}



	public User( String ers_username, String ers_password, String user_first_name, String user_last_name, String user_email, int user_role_id, String user_l_name, String user_f_name, String email, int user_role_id_fk) {
        
    
  
    this.ers_username = ers_username;
    this.ers_password = ers_password;
    this.user_f_name = user_f_name;
    this.user_l_name =user_l_name;
    this. email =  email;
    this.user_role_id_fk = user_role_id_fk;
}







public int getUser_id() {
	return user_id;
}



public void setUser_id(int user_id) {
	this.user_id = user_id;
}



public String getErs_username() {
	return ers_username;
}



public void setErs_username(String ers_username) {
	this.ers_username = ers_username;
}



public String getErs_password() {
	return ers_password;
}



public void setErs_password(String ers_password) {
	this.ers_password = ers_password;
}



public String getUser_f_name() {
	return user_f_name;
}



public void setUser_f_name(String user_f_name) {
	this.user_f_name = user_f_name;
}



public String getUser_l_name() {
	return user_l_name;
}



public void setUser_l_name(String user_l_name) {
	this.user_l_name = user_l_name;
}



public String getEmail() {
	return email;
}



public void setEmail(String email) {
	this.email = email;
}



public int getUser_role_id_fk() {
	return user_role_id_fk;
}



public void setUser_role_id_fk(int user_role_id_fk) {
	this.user_role_id_fk = user_role_id_fk;
}


}


