package com.globant.aimate.annotation;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import io.appium.java_client.pagefactory.interceptors.InterceptorOfAListOfElements;

public class AIElementListInterceptor extends InterceptorOfAListOfElements {

	public AIElementListInterceptor(ElementLocator locator) {
        super(locator);
    }

    @Override 
    protected Object getObject(List<WebElement> elements, Method method, Object[] args)
        throws Throwable {
        try {
            return method.invoke(elements, args);
        } catch (Throwable t) {
            throw AIThrowableUtil.extractReadableException(t);
        }
    }
    
}
