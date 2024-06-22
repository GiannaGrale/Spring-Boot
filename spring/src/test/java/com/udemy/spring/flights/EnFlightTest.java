package com.udemy.spring.flights;

import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = {"app.locale=en", "browser=edge"})
public class EnFlightTest extends FlightTest{
}
