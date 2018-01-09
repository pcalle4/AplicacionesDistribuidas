package interciclo.datos;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class logAdminDAO {

	private String username;
	private String password;
	 
	/**
	* @return the username
	*/
	public String getUsername() {
	return username;
	}
	 
	/**
	* @param username the username to set
	*/
	public void setUsername(String username) {
	this.username = username;
	}
	 
	/**
	* @return the password
	*/
	public String getPassword() {
	return password;
	}
	 
	/**
	* @param password the password to set
	*/
	public void setPassword(String password) {
	this.password = password;
	}
	 
	public String login() {
	if (username.equals("root") && password.equals("root")) {
	return "homepage.xhtml";
	} else 
	return "fallo.xhtml";
	
	}

}
