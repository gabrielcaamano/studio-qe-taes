package com.globant.aimate.test.tests;

import com.globant.aimate.test.infrastructure.BaseWebTests;
import com.globant.aimate.test.pagemodel.WikiHome;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WikipediaTest extends BaseWebTests {

    private WikiHome home;

    @BeforeClass
    public void before() {
        driver.get("http://www.wikipedia.org/");
        home = new WikiHome(driver);
    }

    @Test
    public void testUserCanSearch() {
        String searchTerm = "Muhammad Ali";

        String titleOnPage = home.search(searchTerm).getTitle();

        Assert.assertEquals(titleOnPage, "Muhammad Ali");
    }

}
