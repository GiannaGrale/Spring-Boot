package com.udemy.spring.flights;

import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = "app.locale=id")
public class IdFlightTest extends FlightTest {
}
