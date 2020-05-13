package com.globant.automation.cyf2020.infrastructure;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.globant.aimate.annotation.AIFieldDecorator;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public abstract class BasePage {

	public static final Duration ANIMATION_DURATION = Duration.ofSeconds(5);
	public static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(15);
	public static final Duration EXTENDED_TIMEOUT = Duration.ofSeconds(30);
	protected final WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AIFieldDecorator(driver), this);
	}
	
	protected <T extends BasePage> T getNextPage(Class<T> tClass) {
		try {
			return tClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	private FluentWait<WebDriver> getWait(Duration duration) {
		return new WebDriverWait(driver, duration.getSeconds()).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
	}

	protected void click(WebElement element) {
		click(element, DEFAULT_TIMEOUT);
	}

	protected void click(WebElement element, Duration timeout) {
		getWait(timeout).until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
	protected WebElement getElement(By locator) {
		return getElement(locator, DEFAULT_TIMEOUT);
	}
	
	protected WebElement getElement(By locator, Duration timeout) {
		try {
			return getWait(timeout).until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (TimeoutException | NoSuchElementException e) {
			return null;
		}
	}
	
	protected List<WebElement> getElements(By locator) {
		return getElements(locator, DEFAULT_TIMEOUT);
	}
	
	protected List<WebElement> getElements(By locator, Duration timeout) {
		try {
			return getWait(timeout).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		} catch (TimeoutException | NoSuchElementException e) {
			return null;
		}
	}
	
	protected WebElement getNestedElement(WebElement parent, By childLocator) {
		return getNestedElement(parent, childLocator, DEFAULT_TIMEOUT);
	}
	
	protected WebElement getNestedElement(WebElement parent, By childLocator, Duration timeout) {
		try {
			return getWait(timeout).until(ExpectedConditions.presenceOfNestedElementLocatedBy(parent, childLocator));
		} catch (TimeoutException | NoSuchElementException e) {
			return null;
		}
	}

	protected String getText(WebElement element) {
		return getText(element, DEFAULT_TIMEOUT);
	}

	protected String getText(WebElement element, Duration timeout) {
		try {
			getWait(timeout).until(ExpectedConditions.attributeToBeNotEmpty(element, "innerHTML"));
			return getWait(timeout).until(ExpectedConditions.visibilityOf(element)).getText();
		} catch (TimeoutException | NoSuchElementException e) {
			return null;
		}
	}
	
	protected void hideKeyboard() {
		if(driver instanceof AppiumDriver<?>) {
			((AppiumDriver<?>) driver).hideKeyboard();
		}
	}
	
    protected boolean isElementDisplayed(WebElement element) {
    	return isElementDisplayed(element, DEFAULT_TIMEOUT);
    }
	
    protected boolean isElementDisplayed(WebElement element, Duration timeout) {
        try {
            getWait(timeout).until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean isElementPresent(By locator) {
    	return getElement(locator, DEFAULT_TIMEOUT) != null;
    }
	
    protected boolean isElementPresent(By locator, Duration timeout) {
    	return getElement(locator, timeout) != null;
    }
    
    protected boolean isElementPresent(WebElement element) {
    	return isElementPresent(element, DEFAULT_TIMEOUT);
    }
	
    protected boolean isElementPresent(WebElement element, Duration timeout) {
        try {
            getWait(timeout).until(webDriver -> null != element.getText() || null != element.getAttribute("id") || null != element.getTagName());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    protected boolean isElementEnabled(WebElement element) {
    	return isElementPresent(element, DEFAULT_TIMEOUT);
    }
	
    protected boolean isElementEnabled(WebElement element, Duration timeout) {
        try {
            getWait(timeout).until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
	
    public boolean isTextPresent(String text) {
        return isTextPresent(text, DEFAULT_TIMEOUT);
    }

    public boolean isTextPresent(String text, Duration timeout) {
        try {
            getWait(timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(".//*[normalize-space(text())=\"%s\"]", text))));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }
    
	protected void select(WebElement element, String value) {
		select(element, value, DEFAULT_TIMEOUT);
	}

	protected void select(WebElement element, String value, Duration timeout) {
		getWait(timeout).until(ExpectedConditions.elementToBeClickable(element));
		new Select(element).selectByValue(value);
	}
    
    protected void swipe(int startx, int starty, int endx, int endy) {
    	if(driver instanceof AppiumDriver<?>) {
    		new TouchAction<>((AppiumDriver<?>) driver).press(PointOption.point(startx, starty))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(endx, endy))
				.release();
    	}
    }

	protected void type(WebElement element, String text) {
		type(element, text, DEFAULT_TIMEOUT);
	}

	protected void type(WebElement element, String text, Duration timeout) {
		getWait(timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.clear();
		element.sendKeys(text);
	}
	
	protected void wait(Duration duration) {
		try {
			getWait(duration).ignoring(NoSuchElementException.class).until(ExpectedConditions.alertIsPresent());
		} catch (TimeoutException e) { }
	}
	
	protected void waitForElementToDisappear(By locator, Duration duration) {
		try {
			WebElement element = getElement(locator);
			if(element != null) {
				getWait(duration).ignoring(NoSuchElementException.class).until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(element)));				
			}
		} catch (TimeoutException e) { }
	}

}
