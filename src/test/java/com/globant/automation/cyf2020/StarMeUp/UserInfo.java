package com.globant.automation.cyf2020.StarMeUp;

public class UserInfo {
	
	String name;
	String lastname;
	String job;
	
	public UserInfo(String name, String lastname, String job) {
		this.name = name;
		this.lastname = lastname;
		this.job = job;
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public String getLastname() {
		
		return lastname;
		
	}
	
	public String getJob() {
		
		return job;
		
	}
}
