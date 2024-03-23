package com.nagarro.eshopping.model;
import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * Admin 
 * 
 * Model class from admin
 */

@Entity
public class Admin {
	
	@Id
	private int idAdmin;
	private String username;
	private String password;
	
	public int getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [idAdmin=" + idAdmin + ", username=" + username + ", password=" + password + "]";
	}
	
	
}
