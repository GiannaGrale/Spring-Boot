package com.udemy.spring.visa;

import com.udemy.spring.SpringBaseTest;
import com.udemy.spring.entity.Customer;
import com.udemy.spring.pages.visa.VisaRegistrationPage;
import com.udemy.spring.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.Date;
import java.util.List;


public class UserVisaTest extends SpringBaseTest {
    private static final Logger logger = LoggerFactory.getLogger(UserVisaTest.class);

    @Autowired
    private VisaRegistrationPage visaRegistrationPage;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void visaTest() {
        List<Customer> customers = this.customerRepository
                .findAll()
                .stream()
                .limit(3).toList();

        for (Customer customer : customers) {
            this.visaRegistrationPage.goTo();
            this.visaRegistrationPage.setNames(customer.getFirstName(), customer.getLastName());
            this.visaRegistrationPage.setCountryFromAndTo(customer.getFromCountry(), customer.getToCountry());
            this.visaRegistrationPage.setBirthDate(customer.getDob().toLocalDate());
            this.visaRegistrationPage.setContactDetails(customer.getEmail(), customer.getPhone());
            this.visaRegistrationPage.setComments(customer.getComments());
            this.visaRegistrationPage.submit();

            logger.info("Request number INFO # : " + this.visaRegistrationPage.getConfirmationNumber());
            logger.debug("Request number DEBUG # : " + this.visaRegistrationPage.getConfirmationNumber());
            logger.warn("Request number WARN # : " + this.visaRegistrationPage.getConfirmationNumber());
        }
    }

    @Test
    public void visaTest2() {
        List<Customer> customers = this.customerRepository
                .findByFirstNameStartingWith("Mi")
                .stream()
                .limit(3).toList();
        for (Customer customer : customers) {
            this.visaRegistrationPage.goTo();
            this.visaRegistrationPage.setNames(customer.getFirstName(), customer.getLastName());
            this.visaRegistrationPage.setCountryFromAndTo(customer.getFromCountry(), customer.getToCountry());
            this.visaRegistrationPage.setBirthDate(customer.getDob().toLocalDate());
            this.visaRegistrationPage.setContactDetails(customer.getEmail(), customer.getPhone());
            this.visaRegistrationPage.setComments(customer.getComments());
            this.visaRegistrationPage.submit();
            System.out.println(this.visaRegistrationPage.getConfirmationNumber());
        }
    }

    @Test(dataProvider = "getData")
    public void visaTest3(Customer customer) {
        this.visaRegistrationPage.goTo();
        this.visaRegistrationPage.setNames(customer.getFirstName(), customer.getLastName());
        this.visaRegistrationPage.setCountryFromAndTo(customer.getFromCountry(), customer.getToCountry());
        this.visaRegistrationPage.setBirthDate(customer.getDob().toLocalDate());
        this.visaRegistrationPage.setContactDetails(customer.getEmail(), customer.getPhone());
        this.visaRegistrationPage.setComments(customer.getComments());
        this.visaRegistrationPage.submit();
        System.out.println(this.visaRegistrationPage.getConfirmationNumber());

    }

    @DataProvider
    public Object[][] getData(ITestContext context) {
        return this.customerRepository
                .findByDobBetween(
                        Date.valueOf(context.getCurrentXmlTest().getParameter("dobFrom")),
                        Date.valueOf(context.getCurrentXmlTest().getParameter("dobTo")))
                .stream()
                .limit(3)
                .map(o -> new Customer[]{o})
                .toArray(Object[][]::new);
    }
}
