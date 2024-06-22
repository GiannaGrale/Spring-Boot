package com.udemy.spring.selenium;

import com.udemy.spring.SpringBaseTest;
import com.udemy.spring.kelvin.annotation.LazyAutowired;
import com.udemy.spring.pages.google.GooglePage;
import com.udemy.spring.kelvin.service.ScreenshotService;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.io.IOException;


public class Google2Test extends SpringBaseTest {

    @LazyAutowired
    private GooglePage googlePage;

    @LazyAutowired
    private ScreenshotService screenshotService;

    @Test
    public void googleTest2() throws IOException {
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isLoaded());
        this.googlePage.getSearchComponent().search("spring boot ");
        Assert.assertTrue(this.googlePage.getSearchResult().isLoaded());
        Assert.assertTrue(this.googlePage.getSearchResult().getResultCount() > 2);
        this.screenshotService.takeScreenshot("img.png");
        this.googlePage.close();
    }
}
