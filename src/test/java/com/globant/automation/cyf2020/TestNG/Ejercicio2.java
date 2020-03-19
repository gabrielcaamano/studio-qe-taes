package com.globant.automation.cyf2020.TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ejercicio2 {

	@DataProvider(name = "Authentication")

	public static Object[][] credentials() {

		return new Object[][] { { "testuser_1", "Test@123" }};

	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("ANTES DE LAS CLASES");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Antes del metodo1");
	}

	//@Parameters({"author","searchKey"})
    public void testParameterWithXML( @Optional("Abc") String author,String searchKey) throws InterruptedException{

		ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://google.com");

        WebElement searchText = driver.findElement(By.name("q"));
        //Searching text in google text box
        searchText.sendKeys(searchKey);

        System.out.println("Welcome ->"+author+" Your search key is->"+searchKey);
	
	}
	
	//@Test(dataProvider = "Authentication")
	
	@Test()
	public void test2() {
		System.out.println("Este es el segundo test");
	}

	@AfterMethod
	public void aferMethod1() {
		System.out.println("Despues del metodo1");

	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("DESPUES DE LAS CLASES");
	}

}
