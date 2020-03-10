package com.globant.automation.cyf2020.infrastructure;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;

public abstract class BaseTest {
	
	private static final int PAGE_LOAD_TIMEOUT = 60;
	protected WebDriver driver;
	protected AutomationProperties properties;
	
	@BeforeClass
	public void beforeSuite() throws Exception {
		properties = AutomationProperties.getInstance();
		URL serverURL = new URL(properties.getString("appium.url"));
		DesiredCapabilities caps = new DesiredCapabilities();

		switch(properties.getString("test.platform").toLowerCase()) {
		case "android":
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 600);
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
			caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 600);
			driver = new AndroidDriver<>(serverURL, caps);
			break;
		case "ios":
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, properties.getString("ios.version"));
			caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, properties.getString("iphone.name"));
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 600);
			driver = new IOSDriver<>(serverURL, caps);
			break;
		case "desktop":
			ChromeOptions options = new ChromeOptions();
			if(properties.getBoolean("chrome.headless")) {
				options.addArguments("--headless");	
			}
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			break;
		default:
			throw new Exception("test.platform not set");
		}
		
		driver.manage().timeouts().implicitlyWait(BasePage.DEFAULT_TIMEOUT.getSeconds(), TimeUnit.SECONDS);
		driver.get(properties.getString("environment.url"));
	}
	
	protected void resetDriver() throws Exception {
		afterSuite();
		beforeSuite();
	}
	
    @Attachment(value = "Screenshot {0}", type = "image/png")
    protected byte[] takeScreenshot(String value) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Screen source code (XML)", type = "application/xml")
    protected String captureScreenSource(String screenSource) {
        return screenSource;
    }
    
    @AfterMethod(enabled = false)
    public void screenshotIfErrored(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            takeScreenshot("Failed/Errored test");
        }
    }

    @AfterMethod(enabled = false)
    public void screenSourceIfFails(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenSource(driver.getPageSource());
        }
    }
	
	@AfterClass
	public void afterSuite() {
		driver.quit();
	}

}
