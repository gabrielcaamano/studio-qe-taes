package com.globant.aimate.model;

import org.openqa.selenium.WebElement;

public class ElementDto {

    private WebElement elementFound;
    private WebElement iframeElement;

    public ElementDto(){

    }

    public WebElement getElementFound() {
        return elementFound;
    }

    public void setElementFound(WebElement elementFound) {
        this.elementFound = elementFound;
    }

    public WebElement getIframeElement() {
        return iframeElement;
    }

    public void setIframeElement(WebElement iframeElement) {
        this.iframeElement = iframeElement;
    }
}
