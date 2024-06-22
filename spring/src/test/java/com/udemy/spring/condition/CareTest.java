package com.udemy.spring.condition;

import com.udemy.spring.SpringBaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.testng.annotations.Test;

public class CareTest extends SpringBaseTest {

    @Qualifier("civic")
    @Autowired
    private Car car;

    @Test(enabled = false)
    public void carTest() {
        this.car.run();
    }
}
