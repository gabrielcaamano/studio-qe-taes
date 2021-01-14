package com.globant.aimate.model;

import org.openqa.selenium.By;

public class LocatorModel {

    private By by;
    private By originalBy;
    private String strategyClass;
    private Integer found;
    private Integer nonFound;
    private long responseTime;

    public LocatorModel() {
    }

    public By getBy() {
        return by;
    }

    public void setBy(By by) {
        this.by = by;
    }

    public String getStrategyClass() {
        return strategyClass;
    }

    public void setStrategyClass(String strategyClass) {
        this.strategyClass = strategyClass;
    }

    public Integer getFound() {
        return found;
    }

    public void setFound(Integer found) {
        this.found = found;
    }

    public Integer getNonFound() {
        return nonFound;
    }

    public void setNonFound(Integer nonFound) {
        this.nonFound = nonFound;
    }

    public long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(long responseTime) {
        this.responseTime = responseTime;
    }

	public By getOriginalBy() {
		return originalBy;
	}

	public void setOriginalBy(By originalBy) {
		this.originalBy = originalBy;
	}
}
