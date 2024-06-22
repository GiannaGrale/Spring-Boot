package com.udemy.spring.selenium;

import com.udemy.spring.SpringBaseTest;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.Test;

public class MultiBrowserTest extends SpringBaseTest {

    @Autowired
    private ApplicationContext ctx;

    @Test
    public void browserTest(){
        this.ctx.getBean("getChromeDriver", WebDriver.class).get("https://www.google.com");
        this.ctx.getBean("getEdgeDriver", WebDriver.class).get("https://www.yahoo.com");
    }
}
