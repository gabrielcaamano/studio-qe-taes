package com.globant.automation.cyf2020.StarMeUp;

public enum STARREACTIONS {
	
	COMMENTAMOUNTBEFORE ("//div[contains(@class,'suite-segment__children')]//div[1]//div[2]//span[2]//div[2]//span[2]"),
	COMMENTAMOUNTAFTER ("//div[contains(@class,'suite-segment__children')]//div[1]//div[2]//span[2]//div[1]//span[2]"),
	lIKEAMOUNT ("//div[@class='suite-segment__children']//div[1]//div[2]//span[2]//div[2]//span[2]"),
	STARAMOUNTAFTER  ("");
	
	private final String amountLocator;
	
	STARREACTIONS(String locator) {
		this.amountLocator = locator;
	}

}
