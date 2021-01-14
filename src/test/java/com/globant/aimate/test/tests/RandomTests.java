package com.globant.aimate.test.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.globant.aimate.storage.LocatorsDAO;

public class RandomTests {

	@Test(enabled = false)
	public static void aTest() throws IOException, InterruptedException, ExecutionException, Exception {

		LocatorsDAO firestore = LocatorsDAO.getInstance();

		String home = System.getProperty("user.home");
		String os = System.getProperty("os.name").toLowerCase();

		if (System.getProperty("webdriver.chrome.driver") == null) {
			if (os.contains("win")) {
				System.setProperty("webdriver.chrome.driver", home + "/Documents/chromedriver.exe");
			} else {
				System.setProperty("webdriver.chrome.driver", home + "/Documents/chromedriver");
			}
		}

		ChromeOptions co = new ChromeOptions();

		Map<String, Object> prefs = new HashMap<String, Object>();
		co.setExperimentalOption("prefs", prefs);
		co.addArguments("--test-type");

		WebDriver driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.get("https://www.globant.com/#home");


		String mainLocator = "//a[@class='nav-link'][contains(@href,'work')]";
		//String mainLocator = "img[alt='cloud']";
		firestore.createOrUpdateWebElement(mainLocator,By.xpath(mainLocator),driver);
		firestore.getElementLocatorsFromDB(mainLocator);

		//WebElementAttributes wea = LocatorGenerator.getElementAttributes(driver, By.xpath(mainLocator));
		//System.out.println("Relative coordinates of the element - X: " + wea.getRelativePosition().getX() + "% - Y: " + wea.getRelativePosition().getY() + "%");

		driver.close();

	}

}