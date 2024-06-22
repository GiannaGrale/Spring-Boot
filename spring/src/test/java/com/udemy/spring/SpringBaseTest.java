package com.udemy.spring;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;

@SpringBootTest
public class SpringBaseTest extends AbstractTestNGSpringContextTests {
    @Autowired
    protected WebDriver driver;

    @AfterMethod
    public void closeBrowser() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
