package com.udemy.spring.flights;

import com.udemy.spring.SpringBaseTest;
import com.udemy.spring.pages.flights.FlightPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightTest extends SpringBaseTest {

    @Autowired
    private FlightPage flightPage;

    @Autowired
    private FlightAppDetails appDetails;

    @Test
    public void flightTest(){
        this.flightPage.goTo(this.appDetails.getUrl());
        Assert.assertTrue(this.flightPage.isLoaded());
        Assert.assertEquals(this.flightPage.getLabels(), this.appDetails.getLabels());
    }
}
