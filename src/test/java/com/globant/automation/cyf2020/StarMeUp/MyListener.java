package com.globant.automation.cyf2020.StarMeUp;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {
	
	@Override
	public void onTestSuccess(ITestResult arg0) {
		System.out.println("Successfull logIn test");
	}
	
	@Override
	public void onTestFailure(ITestResult arg0) {
		System.out.println("Unsuccessfull logIn test");
	}

}
