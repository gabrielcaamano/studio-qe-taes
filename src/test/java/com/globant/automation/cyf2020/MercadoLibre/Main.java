package com.globant.automation.cyf2020.MercadoLibre;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {
	
	@FindBy(xpath = "//ul[@class=\"nav-menu-list\"]//li[@class=\"nav-menu-item\"][6]//a[@class=\"nav-menu-item-link \"]")
	static
	WebElement vender;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = openDriver();
		driver.manage().window().maximize();
		MLHome Mlhome = new MLHome(driver);
		Mlhome.GoHome("https://www.mercadolibre.com.uy/");
		vender.click();
		
	}
	
	public static WebDriver openDriver() {
		DesiredCapabilities caps = new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver(options);

	}

}
