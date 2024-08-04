package com.udemy.spring.bdd;


import com.udemy.spring.kelvin.annotation.LazyAutowired;
import com.udemy.spring.pages.visa.VisaRegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import java.time.LocalDate;

@SpringBootTest
@CucumberContextConfiguration
public class VisaSteps {

    @LazyAutowired
    private VisaRegistrationPage registrationPage;

    @Given("I am on VISA registration form")
    public void goTo() {
        this.registrationPage.goTo();
        Assert.assertTrue(this.registrationPage.isLoaded());
    }

    @When("I select my from country {string} and to country {string}")
    public void selectCountry(String from, String to) {
        this.registrationPage.setCountryFromAndTo(from, to);
    }

    @And("I enter my dob as {string}")
    public void enterDob(String date) {
        this.registrationPage.setBirthDate(LocalDate.parse(date));
    }

    @And("I enter my name as {string} and {string}")
    public void enterNames(String firstName, String lastName) {
        this.registrationPage.setNames(firstName, lastName);

    }

    @And("I enter my contact details as {string} and {string}")
    public void enterContactDetails(String email, String phone) {
        this.registrationPage.setContactDetails(email, phone);
    }

    @And("I enter the comment {string}")
    public void enterComments(String comments) {
        this.registrationPage.setComments(comments);
    }

    @And("I submit the form")
    public void submit() {
        this.registrationPage.submit();
    }

    @And("I should see get the confirmation number")
    public void getConfirmationNumber() {
        boolean isEmpty = this.registrationPage.getConfirmationNumber().isEmpty();
        Assert.assertFalse(isEmpty);
    }
}
