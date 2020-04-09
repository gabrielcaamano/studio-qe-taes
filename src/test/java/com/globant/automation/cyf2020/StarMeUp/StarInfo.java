package com.globant.automation.cyf2020.StarMeUp;

import com.globant.automation.cyf2020.tests.LoginStarMeUpTest.GLOBANTVALUES;

public class StarInfo {

	private String nameWhoSends;
	private String nameWhoRecibes;
	private GLOBANTVALUES valueSent;

	public void setNameWhoRecibes(String name) {
		
		nameWhoRecibes = name;
		
	}
	
	public void setNameWhoSends(String name) {
		
		nameWhoSends = name;
		
	}
	
	public void setValue(GLOBANTVALUES value) {
		
		valueSent = value;
	}
	
	public String getNameWhoRecibes() {

		return nameWhoRecibes;

	}

	public String getNameWhoSends() {

		return nameWhoSends;
	}
	
	public GLOBANTVALUES getValue() {
		
		return valueSent;
		
	}

}
