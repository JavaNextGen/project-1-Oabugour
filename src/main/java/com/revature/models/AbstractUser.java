package com.revature.models;

import java.util.Objects;

/**
 * This AbstractUser class defines a minimum functionality for
 * interacting with users in the ERS application.
 *
 * All users in this application must at least have:
 * <ul>
 *     <li>ID</li>
 *     <li>Username</li>
 *     <li>Password</li>
 *     <li>Role</li>
 * </ul>
 *
 * Additional fields can be added to the concrete {@link com.revature.models.User} class.
 *
 * @author Center of Excellence
 */

/*CREATE TABLE ers_user (
		user_id serial PRIMARY KEY,
		ers_username VARCHAR (50) UNIQUE,
		ers_password VARCHAR (50),
		user_f_name TEXT,    --first name
		user_l_name TEXT, --last name 
		user_role_id_fk int REFERENCES ers_user_roles(ers_user_roleid)
*/

// the above have to match the private fields below 

public class AbstractUser {

    private int user_id;
    private String ers_username;
    private String user_f_name;
    private String user_l_name;
    private String ers_password;
    private Role user_role_id_fk;

    public AbstractUser() {
        super();
    }

    public AbstractUser(String username, String password) {
		super();
		this.ers_username = username;
		this.ers_password = password;
	}
    
    public AbstractUser(int id, String username, String password) {
		super();
		this.user_id=id;
		this.ers_username = username;
		this.ers_password = password;
	}

	public AbstractUser(int id, String username, String password, Role role) {
        super();
        this.user_id = id;
        this.ers_username = username;
        this.ers_password = password;
        this.user_role_id_fk = role;
    }

    public int getId() {
        return user_id;
    }

    public void setId(int id) {
        this.user_id = id;
    }

    public String getUsername() {
        return ers_username;
    }

    public void setUsername(String username) {
        this.ers_username = username;
    }

    public String getPassword() {
        return ers_password;
    }

    public void setPassword(String password) {
        this.ers_password = password;
    }

    public Role getRole() {
        return user_role_id_fk;
    }

    public void setRole(Role role) {
        this.user_role_id_fk = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractUser that = (AbstractUser) o;
        return user_id == that.user_id && Objects.equals(ers_username, that.ers_username) && Objects.equals(ers_password, that.ers_password) && user_role_id_fk == that.user_role_id_fk;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id,ers_username, ers_password, user_role_id_fk);
    }

    @Override
    public String toString() {
        return "AbstractUser{" +
                "id=" + user_id +
                ", username='" + ers_username + '\'' +
                ", password='" + ers_password + '\'' +
                ", role=" + user_role_id_fk +
                '}';
    }
}
