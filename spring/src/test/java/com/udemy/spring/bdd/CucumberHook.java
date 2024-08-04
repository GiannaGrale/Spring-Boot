package com.udemy.spring.bdd;

import com.udemy.spring.kelvin.annotation.LazyAutowired;
import com.udemy.spring.kelvin.service.ScreenshotService;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;

public class CucumberHook {

    @LazyAutowired
    private ScreenshotService screenshotService;

    @LazyAutowired
    private ApplicationContext applicationContext;

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.attach(this.screenshotService.getScreenshot(), "image/png", scenario.getName());
        }
    }

    @After
    public void afterScenario(){
        this.applicationContext.getBean(WebDriver.class).quit();
    }
}
