package com.globant.aimate.test.infrastructure;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.globant.aimate.annotation.AIElementLocatorFactory;

public abstract class BaseWebPage {

	private static final int DEFAULT_TIMEOUT = 15;
	private WebDriver driver;

	public BaseWebPage(WebDriver pDriver) {
		PageFactory.initElements(new AIElementLocatorFactory(pDriver, pDriver), this);
		driver = pDriver;
	}

	protected WebDriver getDriver() {
		return driver;
	}

	protected WebDriverWait getWait() {
		return getWait(DEFAULT_TIMEOUT);
	}

	protected WebDriverWait getWait(int timeout) {
		return new WebDriverWait(getDriver(), timeout);
	}

	protected void click(WebElement element) {
		click(element, DEFAULT_TIMEOUT);
	}

	protected void click(WebElement element, int timeout) {
		getWait(timeout)
				.until(ExpectedConditions.elementToBeClickable(element))
				.click();
	}

	protected String getText(WebElement element) {
		return getText(element, DEFAULT_TIMEOUT);
	}

	protected String getText(WebElement element, int timeout) {
		isElementPresent(element, timeout);
		return element.getText();
	}

	protected boolean isElementPresent(WebElement element) {
		return isElementPresent(element, DEFAULT_TIMEOUT);
	}

	protected boolean isElementPresent(WebElement element, int timeout) {
		try {
			getWait(timeout).ignoring(NoSuchElementException.class)
					.until(webDriver -> null != element.getText() || null != element.getTagName());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	protected void sendKeys(WebElement element, String text) {
		sendKeys(element, text, DEFAULT_TIMEOUT);
	}

	protected void sendKeys(WebElement element, String text, int timeout) {
		isElementPresent(element, timeout);
		element.sendKeys(text);
	}

}
