package com.globant.automation.cyf2020.infrastructure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TravelocityHome extends Travelocity {

	public TravelocityHome(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void GoFlights() {
		
		getElement(By.id("#section-flight-tab-hp")).click();
	}

}
