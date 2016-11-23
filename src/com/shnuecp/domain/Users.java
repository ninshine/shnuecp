package com.shnuecp.domain;

public class Users {
	
	private int id;
	private String username;
	private String password;
	private int isAdmin;
	private int balance;
	
	public int getId() {
		return id;
	}
	public void setId(int user_id) {
		this.id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String user_pwd) {
		this.password = user_pwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String user_name) {
		this.username = user_name;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
}