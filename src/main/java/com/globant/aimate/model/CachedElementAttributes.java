package com.globant.aimate.model;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CachedElementAttributes {

	private WebElement element;
	private By by;
	private String id;
	private String name;
	private String text;
	private Point relativePosition;
	private String innertext;
	private String href;
	private String clazz;
	private String style;
	private String tag;
	private String src;
	private String url;
	private String outerhtml;
	private String alt;
	private String type;
	private String value;
	private String screenshot;
	private CachedElementAttributes parentElement;
	private List<CachedElementAttributes> siblingElements;
	private List<CachedElementAttributes> childElements;
	private CachedElementAttributes iframelement;
	private WebElement webElementIframe;
	private List<LocatorModel> locators;
	private Integer amountOfNodeLevels;

	public CachedElementAttributes(WebElement element) {
		this.element = element;
	}
	
	private String getAttribute(WebElement element, String name) {
		try {
			return element.getAttribute(name);
		} catch (Exception e) {
			return null;
		}
	}

	public String getOuterhtml() {
		if (outerhtml == null) {
			outerhtml = getAttribute(element, "outerHTML");
		}
		return outerhtml;
	}

	public void setOuterhtml(String outerhtml) {
		this.outerhtml = outerhtml;
	}

	public By getBy() {
		return by;
	}

	public void setBy(By by) {
		this.by = by;
	}

	public String getId() {
		if (id == null) {
			id = getAttribute(element, "id");
		}
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		if (name == null) {
			name = getAttribute(element, "name");
		}
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		if (text == null) {
			text = element.getText();
		}
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getInnertext() {
		if (innertext == null) {
			innertext = getAttribute(element, "innerText");
		}
		return innertext;
	}

	public void setInnertext(String innertext) {
		this.innertext = innertext;
	}

	public String getHref() {
		if (href == null) {
			href = getAttribute(element, "href");
		}
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getClazz() {
		if (clazz == null) {
			clazz = getAttribute(element, "class");
		}
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getStyle() {
		if (style == null) {
			style = getAttribute(element, "style");
		}
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getTag() {
		if (tag == null) {
			tag = element.getTagName();
		}
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getSrc() {
		if (src == null) {
			src = getAttribute(element, "src");
		}
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Point getRelativePosition() {
		return relativePosition;
	}

	public void setRelativePosition(Point relativePosition) {
		this.relativePosition = relativePosition;
	}

	public String getAlt() {
		if (alt == null) {
			alt = getAttribute(element, "alt");
		}
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public String getType() {
		if (type == null) {
			type = getAttribute(element, "type");
		}
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		if (value == null) {
			value = getAttribute(element, "value");
		}
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public WebElement getElement() {
		return element;
	}

	public void setElement(WebElement element) {
		this.element = element;
	}

	public String getScreenshot() {
		if (screenshot == null) {
			screenshot = element.getScreenshotAs(OutputType.BASE64);
		}
		return screenshot;
	}

	public void setScreenshot(String screenshot) {
		this.screenshot = screenshot;
	}

	public CachedElementAttributes getParentElement() {
		return parentElement;
	}

	public void setParentElement(CachedElementAttributes parentElement) {
		this.parentElement = parentElement;
	}

	public List<CachedElementAttributes> getSiblingElements() {
		return siblingElements;
	}

	public void setSiblingElements(List<CachedElementAttributes> siblingElements) {
		this.siblingElements = siblingElements;
	}

	public List<CachedElementAttributes> getChildElements() {
		return childElements;
	}

	public void setChildElements(List<CachedElementAttributes> childElements) {
		this.childElements = childElements;
	}

	public CachedElementAttributes getIframelement() {
		return iframelement;
	}

	public void setIframelement(CachedElementAttributes iframelement) {
		this.iframelement = iframelement;
	}

	public WebElement getWebElementIframe() {
		return webElementIframe;
	}

	public void setWebElementIframe(WebElement webElementIframe) {
		this.webElementIframe = webElementIframe;
	}

	public List<LocatorModel> getLocators() {
		return locators;
	}

	public void setLocators(List<LocatorModel> locators) {
		this.locators = locators;
	}

	public Integer getAmountOfNodeLevels() {
		return amountOfNodeLevels;
	}

	public void setAmountOfNodeLevels(Integer amountOfNodeLevels) {
		this.amountOfNodeLevels = amountOfNodeLevels;
	}
}
