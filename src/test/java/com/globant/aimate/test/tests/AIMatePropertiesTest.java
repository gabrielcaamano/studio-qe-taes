package com.globant.aimate.test.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.globant.aimate.model.AIMateException;
import com.globant.aimate.utils.AIMateProperties;

public class AIMatePropertiesTest {
	
	private AIMateProperties properties;
	
	@BeforeTest
	public void setUp() throws AIMateException {
		properties = AIMateProperties.getInstance();
	}
	
	@Test(enabled = false)
	public void testPropertiesFromPOM() {
		Assert.assertEquals(properties.getString("AIMateTestStringProperty"), "value", "String property assertion");
		Assert.assertEquals(properties.getDouble("AIMateTestDoubleProperty"), 3.0, "Double property assertion");
		Assert.assertEquals(properties.getInteger("AIMateTestIntegerProperty"), 3, "Integer property assertion");
		Assert.assertEquals(properties.getBoolean("AIMateTestBooleanProperty"), true, "Boolean property assertion");
		Assert.assertEquals(properties.getString("AIMateTestEmptyProperty"), "", "Empty property assertion");
		Assert.assertEquals(properties.getString("non-existent property"), null, "String property assertion");
	}

}
