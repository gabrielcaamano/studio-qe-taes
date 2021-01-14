package com.globant.aimate.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.Widget;

/**
 * This annotation cannot be used inside a {@link Widget}.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.TYPE })
public @interface AIFindBy {

	String accessibility() default "";
	
	String className() default "";

	String css() default "";
	
	String id() default "";
	
	String iOSClassChain() default "";
	
	String iOSNsPredicate() default "";

	String linkText() default "";

	String name() default "";
	
	String partialLinkText() default "";
	
	String tagName() default "";
	
	String uiAutomator() default "";
	
	String xpath() default "";

	public static class AIFindByUtils {

		private AIFindByUtils() {}

		protected static By buildBy(AIFindBy findBy) {
			if (!"".equals(findBy.accessibility())) {
				return MobileBy.AccessibilityId(findBy.accessibility());
			}
			if (!"".equals(findBy.className())) {
				return By.className(findBy.className());
			}
			if (!"".equals(findBy.css())) {
				return By.cssSelector(findBy.css());
			}
			if (!"".equals(findBy.id())) {
				return By.id(findBy.id());
			}
			if (!"".equals(findBy.iOSClassChain())) {
				return MobileBy.iOSClassChain(findBy.iOSClassChain());
			}
			if (!"".equals(findBy.iOSNsPredicate())) {
				return MobileBy.iOSClassChain(findBy.iOSNsPredicate());
			}
			if (!"".equals(findBy.linkText())) {
				return By.linkText(findBy.linkText());
			}
			if (!"".equals(findBy.name())) {
				return By.name(findBy.name());
			}
			if (!"".equals(findBy.partialLinkText())) {
				return By.partialLinkText(findBy.partialLinkText());
			}
			if (!"".equals(findBy.tagName())) {
				return By.tagName(findBy.tagName());
			}
			if (!"".equals(findBy.uiAutomator())) {
				return MobileBy.AndroidUIAutomator(findBy.uiAutomator());
			}
			if (!"".equals(findBy.xpath())) {
				return By.xpath(findBy.xpath());
			}
			// Fall through
			return null;
		}

		protected static String getLocator(AIFindBy findBy) {
			if (!"".equals(findBy.className())) {
				return findBy.className();
			}
			if (!"".equals(findBy.css())) {
				return findBy.css();
			}
			if (!"".equals(findBy.id())) {
				return findBy.id();
			}
			if (!"".equals(findBy.linkText())) {
				return findBy.linkText();
			}
			if (!"".equals(findBy.name())) {
				return findBy.name();
			}
			if (!"".equals(findBy.partialLinkText())) {
				return findBy.partialLinkText();
			}
			if (!"".equals(findBy.tagName())) {
				return findBy.tagName();
			}
			if (!"".equals(findBy.xpath())) {
				return findBy.xpath();
			}
			// Fall through
			return null;
		}
	}

}
