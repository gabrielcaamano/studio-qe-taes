package com.globant.aimate.test.tests;

import com.globant.aimate.test.pagemodel.AITestPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AIAnnotationTest {

	private WebDriver driver;
	
	private AITestPage testPage;

	@BeforeTest
	public void setupTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://iamate.web.app/");
		testPage = new AITestPage(driver);
	}

	@AfterTest
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test(enabled = true)
	public void testNoChange() {
		Assert.assertEquals(testPage.getNonChangingElementText(), "Non-changing element");
	}
	
	@Test(enabled = false)
	public void testChangingFromIdToGeneratedClass() {
		Assert.assertEquals(testPage.getFirstExampleText(), "First test: from ID to CLASS");
	}
	
	@Test(enabled = false)
	public void testChangeFromXpathTextToGeneratedId() {
		Assert.assertTrue(testPage.getSecondExampleText().startsWith("Second test: from Text to ID (random new text: "), "Change from text to ID");
	}

}
