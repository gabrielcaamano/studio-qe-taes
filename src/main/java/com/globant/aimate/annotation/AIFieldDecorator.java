package com.globant.aimate.annotation;

import static io.appium.java_client.internal.ElementMap.getElementClass;
import static io.appium.java_client.pagefactory.utils.ProxyFactory.getEnhancedProxy;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import com.google.common.collect.ImmutableList;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.internal.CapabilityHelpers;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.windows.WindowsElement;

public class AIFieldDecorator extends AppiumFieldDecorator {
	
    private static final List<Class<? extends WebElement>> availableElementClasses = ImmutableList.of(WebElement.class,
            RemoteWebElement.class, MobileElement.class, AndroidElement.class,
            IOSElement.class, WindowsElement.class);
	private final DefaultFieldDecorator fieldDecorator;
	private WebDriver webDriver;
    private final String platform;
    private final String automation;
    
    public AIFieldDecorator(SearchContext context) {
        this(context, DEFAULT_WAITING_TIMEOUT);
    }

    public AIFieldDecorator(SearchContext context, Duration duration) {
    	super(context, duration);
    	
    	this.webDriver = (WebDriver) context;
    	
        if (this.webDriver instanceof HasCapabilities) {
            Capabilities caps = ((HasCapabilities) this.webDriver).getCapabilities();
            this.platform = CapabilityHelpers.getCapability(caps, "platformName", String.class);
            this.automation = CapabilityHelpers.getCapability(caps, "automationName", String.class);
        } else {
            this.platform = null;
            this.automation = null;
        }
    	
    	// The magic inside the brackets is overriding proxyForLocator and proxyForListLocator methods of DefaultFieldDecorator class
		fieldDecorator = new DefaultFieldDecorator(new AIElementLocatorFactory(context))  {
            @Override
            protected WebElement proxyForLocator(ClassLoader ignored, ElementLocator locator) {
                AIElementInterceptor elementInterceptor = new AIElementInterceptor(locator, webDriver);
                return getEnhancedProxy(getElementClass(platform, automation), elementInterceptor);
            }

            @Override
            @SuppressWarnings("unchecked")
            protected List<WebElement> proxyForListLocator(ClassLoader ignored,
                                                           ElementLocator locator) {
                AIElementListInterceptor elementInterceptor = new AIElementListInterceptor(locator);
                return getEnhancedProxy(ArrayList.class, elementInterceptor);
            }

            @Override
            protected boolean isDecoratableList(Field field) {
                if (!List.class.isAssignableFrom(field.getType())) {
                    return false;
                }

                Type genericType = field.getGenericType();
                if (!(genericType instanceof ParameterizedType)) {
                    return false;
                }

                Type listType = ((ParameterizedType) genericType).getActualTypeArguments()[0];

                for (Class<? extends WebElement> webElementClass : availableElementClasses) {
                    if (webElementClass.equals(listType)) {
                        return true;
                    }
                }

                return ((listType instanceof TypeVariable)
                        && Arrays.asList(((TypeVariable<?>) listType).getBounds())
                        .stream().anyMatch(item -> availableElementClasses.contains(item)));
            }
        };
    }
    
    @Override
    public Object decorate(ClassLoader ignored, Field field) {
		if (field.isAnnotationPresent(AIFindBy.class)) {
			return fieldDecorator.decorate(ignored, field);
		}
    	return super.decorate(ignored, field);
    }
    
}
