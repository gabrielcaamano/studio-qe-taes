package com.globant.automation.cyf2020.infrastructure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Trago extends BasePage{
	
	
	@FindBy(id="nombre")
	private WebElement tituloTrago;
	
	
	public Trago(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void WeatherMessageBody()
	{
		RestAssured.baseURI = "https://cyf-2020.firebaseapp.com/trago.html";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get();

		// Retrieve the body of the Response
		ResponseBody body = response.getBody();

		// To check for sub string presence get the Response body as a String.
		// Do a String.contains
		String bodyAsString = body.asString();
		 
		Assert.assertEquals(bodyAsString.contains(tituloTrago()) /*Expected value*/, true /*Actual Value*/, "Response body contains menu");
	}
	
	public String tituloTrago() {
		String titulo = getText(tituloTrago);
		return titulo;
	}
	
}
