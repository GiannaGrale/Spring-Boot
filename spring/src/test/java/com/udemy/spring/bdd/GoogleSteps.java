package com.udemy.spring.bdd;

import com.udemy.spring.kelvin.annotation.LazyAutowired;
import com.udemy.spring.pages.google.GooglePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

//@SpringBootTest
//@CucumberContextConfiguration
//Cucumber reads all the classes as one and
// that's why we need these annotations only in 1 class
public class GoogleSteps {

    @LazyAutowired
    private GooglePage googlePage;

    @Given("I am on a google site")
    public void launchSite() {
        this.googlePage.goTo();
    }

    @When("I enter {string} as a keyword")
    public void enterKeyword(String keyword) {
        this.googlePage.getSearchComponent().search(keyword);
    }

    @Then("I should see search result page")
    public void clickSearch() {
        Assert.assertTrue(this.googlePage.getSearchResult().isLoaded());
    }

    @Then("I should see at least {int} results")
    public void verifyResult(int count) {
        Assert.assertTrue(this.googlePage.getSearchResult().getResultCount() >= count);
    }
}
