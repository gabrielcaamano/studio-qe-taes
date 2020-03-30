package com.globant.automation.cyf2020.StarMeUp;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {
	
	@DataProvider(name="loginKey")
	public Object[] loginKeys() {
		Object[] key = new Object[10];
		
		key[0] = "user51@bootcampsqe.com";
		key[1] = "user52@bootcampsqe.com";
		key[2] = "user53@bootcampsqe.com";
		key[3] = "user54@bootcampsqe.com";
		key[4] = "user55@bootcampsqe.com";
		key[5] = "user56@bootcampsqe.com";
		key[6] = "user57@bootcampsqe.com";
		key[7] = "user58@bootcampsqe.com";
		key[8] = "user59@bootcampsqe.com";
		key[9] = "user60@bootcampsqe.com";
		
		return key;
	}

}
