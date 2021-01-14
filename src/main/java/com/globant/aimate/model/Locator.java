package com.globant.aimate.model;

import org.openqa.selenium.By;

public class Locator {
	
	private By by;
	private String reference;
	private boolean working;
	private boolean unique;
	
	public Locator(String reference) {
		this.reference = reference;
		this.by = By.xpath(reference);
		this.working = false;
		this.unique = false;
	}
	
	public Locator(By by) {
		this.by = by;
		this.working = false;
		this.unique = false;
	}

	public Locator(By by, String reference) {
		this.by = by;
		this.reference = reference;
		this.working = false;
		this.unique = false;
	}
	
	public By getBy() {
		return by;
	}
	
	public void setBy(By by) {
		this.by = by;
	}
	
	public boolean isWorking() {
		return working;
	}
	
	public void setWorking(Boolean working) {
		this.working = working;
	}
	
	public boolean isUnique() {
		return unique;
	}
	
	public void setUnique(Boolean unique) {
		this.unique = unique;
	}
	
	public String getReference() {
		return reference;
	}
	
	public void setReference(String reference) {
		this.reference = reference;
		this.by = By.xpath(reference);
	}
	
}
