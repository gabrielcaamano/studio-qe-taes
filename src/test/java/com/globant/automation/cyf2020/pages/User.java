package com.globant.automation.cyf2020.pages;

public class User {

	private String user; 
	private String password; 
	private String name;
	private String lastName; 
	private String job; 

	public User() {
		
	}
	
	public User (String userSet, String passwordSet, String nameSet, String lastNameSet, String jobSet) {
		user = userSet;
		password = passwordSet;
		name = nameSet;
		lastName = lastNameSet;
		job = jobSet;
	}
	
	public String getUser() {
		return this.user;
	}
	public String getPassword() {
		return this.password;
	}
	public String getName() {
		return this.name;
	}
	public String getLastName() {
		return this.lastName;
	}
	public String getJob() {
		return this.job;
	}
}
