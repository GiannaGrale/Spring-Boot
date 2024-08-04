package com.udemy.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

import java.util.List;

@SpringBootTest
class ApplicationTests {
    @Autowired
    private User user;

    @Value("${fruits}")
    private List<String> fruits;

    @Value("${timeout}")
    private int timeout;

    @Test(enabled = false)
    void contextLoads() {
        user.printDetails();
        System.out.println(fruits);
        System.out.println(fruits.size());
        System.out.println(timeout);
    }
}
