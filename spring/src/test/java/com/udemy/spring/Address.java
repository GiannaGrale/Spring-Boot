package com.udemy.spring;

import org.springframework.stereotype.Component;

@Component
public class Address {
    private String street;

    public Address() {
        this.street = "123 some main street";
    }

    public String getStreet() {
        return street;
    }
}
