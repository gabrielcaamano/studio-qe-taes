package com.globant.aimate.test.tests;

import java.util.concurrent.TimeUnit;

import com.globant.aimate.test.pagemodel.AITestWikiArticlePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.globant.aimate.test.pagemodel.AITestWikiPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AIAnnotationWikiTest {
	
	private WebDriver driver;
	
	private AITestWikiPage testWikiPage;
	private AITestWikiArticlePage testWikiArticlePage;
	
	@BeforeTest
	
	public void setupTest() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		testWikiPage = new AITestWikiPage(driver);
		//testWikiArticlePage = new AITestWikiArticlePage(driver);
		
	}
	@AfterTest
	public void teardown() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
	@Test(enabled=true)
	public void testResult() {
		
		testWikiArticlePage = testWikiPage.searchWiki("java");
		Assert.assertEquals(testWikiArticlePage.getTitleWiki(), "Java");
		
	}
	
	
	
	

}
