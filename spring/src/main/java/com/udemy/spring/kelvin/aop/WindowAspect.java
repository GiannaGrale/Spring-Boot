package com.udemy.spring.kelvin.aop;

import com.udemy.spring.kelvin.annotation.Window;
import com.udemy.spring.kelvin.service.WindowSwitchService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WindowAspect {

    @Autowired
    private WindowSwitchService windowSwitchService;

    @Before("@target(window) && within(com.udemy.spring..*)")
    public void before(Window window){
        this.windowSwitchService.switchByTitle(window.value());
    }

    @After("@target(window) && within(com.udemy.spring..*)")
    public void after(Window window){
        this.windowSwitchService.switchByIndex(0);
    }
}
