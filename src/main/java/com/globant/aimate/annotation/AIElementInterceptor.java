package com.globant.aimate.annotation;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import io.appium.java_client.pagefactory.interceptors.InterceptorOfASingleElement;

public class AIElementInterceptor extends InterceptorOfASingleElement {

	public AIElementInterceptor(ElementLocator locator, WebDriver driver) {
        super(locator, driver);
    }

    @Override 
    protected Object getObject(WebElement element, Method method, Object[] args)
        throws Throwable {
        try {
            return method.invoke(element, args);
        } catch (Throwable t) {
            throw AIThrowableUtil.extractReadableException(t);
        }
    }
}
