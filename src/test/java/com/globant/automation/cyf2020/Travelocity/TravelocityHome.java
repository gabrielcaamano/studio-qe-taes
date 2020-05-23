package com.globant.automation.cyf2020.Travelocity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class TravelocityHome extends BasePage {

	public TravelocityHome(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void searchFlight() {
		
		getElement(By.id("travel-advisory-close-button")).click();
		getElement(By.id("tab-flight-tab-hp")).click();
		type(getElement(By.id("flight-origin-hp-flight")), "LAS");
		getElement(By.xpath("//div[@class='multiLineDisplay details']")).click();
		type(getElement(By.id("flight-destination-hp-flight")), "LAX");
		getElement(By.xpath("//div[@class='multiLineDisplay details']")).click();
		getElement(By.id("flight-departing-wrapper-hp-flight")).click();
		getElement(By.xpath("//button[@class='datepicker-paging datepicker-next btn-paging btn-secondary next']")).click();;
		getElement(By.cssSelector("table.datepicker-cal-weeks tbody.datepicker-cal-dates tr:nth-child(3) td.datepicker-day-number.notranslate:nth-child(7) > button.datepicker-cal-date")).click();
		getElement(By.id("flight-returning-hp-flight")).click();
		getElement(By.xpath("//button[@class='datepicker-cal-date'][contains(text(),'20')]")).click();	
		getElement(By.xpath("//form[@id='gcw-hotel-form-hp-hotel']//button[contains(@class,'btn-primary btn-action gcw-submit')]"));
		
	}
}