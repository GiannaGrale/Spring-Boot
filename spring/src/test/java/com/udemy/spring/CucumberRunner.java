package com.udemy.spring;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "classpath:features",
        glue = "com.udemy.spring.bdd",
        tags = "not @visa",
        plugin = {
                "pretty",
                "html:target/cucumber-report.html"}
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
