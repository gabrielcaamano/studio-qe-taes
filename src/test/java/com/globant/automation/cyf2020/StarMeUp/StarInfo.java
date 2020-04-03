package com.globant.automation.cyf2020.StarMeUp;

public class StarInfo {

	private String nameWhoSends;
	private String nameWhoRecibes;
	private String valueSent;

	public void setNameWhoRecibes(String name) {
		
		nameWhoRecibes = name;
		
	}
	
	public void setNameWhoSends(String name) {
		
		nameWhoSends = name;
		
	}
	
	public void setValue(String value) {
		
		valueSent = value;
	}
	
	public String getNameWhoRecibes() {

		return nameWhoRecibes;

	}

	public String getNameWhoSends() {

		return nameWhoSends;
	}
	
	public String getValue() {
		
		return valueSent;
		
	}

}
