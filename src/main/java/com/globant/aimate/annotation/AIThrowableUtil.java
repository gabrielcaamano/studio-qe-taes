package com.globant.aimate.annotation;

import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.StaleElementReferenceException;

import java.lang.reflect.InvocationTargetException;

/**
 * Author: santiago.blanco
 * Date: 5/6/20
 */
public class AIThrowableUtil {
    private static final String INVALID_SELECTOR_PATTERN = "Invalid locator strategy:";

    AIThrowableUtil() {
    }

    protected static boolean isInvalidSelectorRootCause(Throwable e) {
        if (e == null) {
            return false;
        } else if (InvalidSelectorException.class.isAssignableFrom(e.getClass())) {
            return true;
        } else {
            return !String.valueOf(e.getMessage()).contains(INVALID_SELECTOR_PATTERN) && !String.valueOf(e.getMessage()).contains("Locator Strategy \\w+ is not supported") ? isInvalidSelectorRootCause(e.getCause()) : true;
        }
    }

    protected static boolean isStaleElementReferenceException(Throwable e) {
        if (e == null) {
            return false;
        } else {
            return StaleElementReferenceException.class.isAssignableFrom(e.getClass()) || isStaleElementReferenceException(e.getCause());
        }
    }

    protected static Throwable extractReadableException(Throwable e) {
        return !RuntimeException.class.equals(e.getClass()) && !InvocationTargetException.class.equals(e.getClass()) ? e : extractReadableException(e.getCause());
    }
}