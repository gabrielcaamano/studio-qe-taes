package com.globant.automation.cyf2020.infrastructure;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AutomationProperties {
	
	private Properties properties;
	
	private static AutomationProperties instance;

	private AutomationProperties() throws Exception {
		if (properties == null) {
			properties = new Properties();
			InputStream in = AutomationProperties.class.getClassLoader().getResourceAsStream("automation.properties");
			try {
				properties.load(in);
			} catch (FileNotFoundException | NullPointerException e) {
				throw new Exception("Unable to find automation properties file.", e);
			} catch (IOException e) {
				throw new Exception("Error parsing automation properties file.", e);
			}
		}
	}
	
	public static synchronized AutomationProperties getInstance() throws Exception {
		if(instance == null) {
			instance = new AutomationProperties();
		}
		return instance;
	}
	
	public String getString(String propertyName) throws Exception {
		if (null != System.getProperty(propertyName) && !System.getProperty(propertyName).isEmpty()) {
			return System.getProperty(propertyName);
		} else {
			return properties.getProperty(propertyName);
		}
	}

	public Integer getInteger(String propertyName) {
		try {
			return Integer.valueOf(properties.getProperty(propertyName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Double getDouble(String propertyName) throws NumberFormatException, Exception {
		return Double.valueOf(getString(propertyName));
	}

	public Boolean getBoolean(String propertyName) throws Exception {
		return Boolean.valueOf(getString(propertyName));
	}

	public void setProperty(String propertyName, String value) throws Exception {
		properties.setProperty(propertyName, value);
	}
	
}
