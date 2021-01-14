package com.globant.aimate.test.mobiletests;

import com.globant.aimate.test.mobilepagemodel.AIMobileTestLoginPage;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AIMobileTest {

	
	private AndroidDriver driver;
	private AIMobileTestLoginPage aIMobileTestLoginPage;

	
	
	@BeforeTest
	public void testCaseSetup(){
		
		try {
	   
			DesiredCapabilities cap = new DesiredCapabilities();
		
	   
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
			//cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "4000");
			cap.setCapability(MobileCapabilityType.APPLICATION_NAME, "Take care");
			cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.globant.foo.takecare");
			cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.globant.foo.takecare.globers.presentation.activity.SplashActivity");											   
			cap.setCapability(AndroidMobileCapabilityType.APP_WAIT_DURATION, "10000");
	   
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			aIMobileTestLoginPage = new AIMobileTestLoginPage(driver);
		
			//cap.setCapability(MobileCapabilityType.APP, "c://apk//sample.apk");
			//cap.setCapability(MobileCapabilityType.APP, "com.android.chrome");
			//cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
			
		} catch (MalformedURLException e) {
		
			e.printStackTrace(System.out);
	
		}
	   

	}

	@Test
	public void testLogin() {
				
		aIMobileTestLoginPage.enterLogin(driver);

		
	   //Asser.assertTrue(driver.findElementByID("Example").isDisplayed));
	}

	
	
	@AfterTest
	public void testCaseTearDown() {
	//   driver.quit();
	}
	
	
	
}
