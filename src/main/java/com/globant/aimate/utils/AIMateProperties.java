package com.globant.aimate.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

import com.globant.aimate.model.AIMateException;

public class AIMateProperties {
	
	private Model model;
	private Properties properties;
	
	private static AIMateProperties instance;

	private AIMateProperties() throws AIMateException {
		if (model == null) {
	        try {
	        	MavenXpp3Reader reader = new MavenXpp3Reader();
				model = reader.read(new FileReader("pom.xml"));
				properties = model.getProperties();
			} catch (IOException | XmlPullParserException e) {
				throw new AIMateException("Unable to read pom file for properties", e);
			}
			
		}
	}
	
	public static synchronized AIMateProperties getInstance() throws AIMateException {
		if(instance == null) {
			instance = new AIMateProperties();
		}
		return instance;
	}
	
	public String getString(String propertyName) {
		if (null != System.getProperty(propertyName) && !System.getProperty(propertyName).isEmpty()) {
			return System.getProperty(propertyName);
		} else {
			return properties.getProperty(propertyName);
		}
	}

	public int getInteger(String propertyName) {
		return Integer.valueOf(properties.getProperty(propertyName));
	}

	public double getDouble(String propertyName) {
		return Double.valueOf(getString(propertyName));
	}

	public boolean getBoolean(String propertyName) {
		return Boolean.valueOf(getString(propertyName));
	}

	public void setProperty(String propertyName, String value) {
		properties.setProperty(propertyName, value);
	}
	
}
