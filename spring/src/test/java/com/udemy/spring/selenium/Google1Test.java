package com.udemy.spring.selenium;

import com.udemy.spring.SpringBaseTest;
import com.udemy.spring.kelvin.annotation.LazyAutowired;
import com.udemy.spring.pages.google.GooglePage;
import com.udemy.spring.kelvin.service.ScreenshotService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class Google1Test extends SpringBaseTest {

    @LazyAutowired
    private GooglePage googlePage;

    @LazyAutowired
    private ScreenshotService screenshotService;

    @Test
    public void googleTest() throws IOException {
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isLoaded());
        this.googlePage.getSearchComponent().search("environment ");
        Assert.assertTrue(this.googlePage.getSearchResult().isLoaded());
        Assert.assertTrue(this.googlePage.getSearchResult().getResultCount() > 2);
        this.screenshotService.takeScreenShot();
        this.googlePage.close();
    }
}
