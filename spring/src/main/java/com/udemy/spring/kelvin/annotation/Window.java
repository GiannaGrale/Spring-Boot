package com.udemy.spring.kelvin.annotation;

import java.lang.annotation.*;

import static org.apache.commons.lang3.StringUtils.EMPTY;

@Page
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Window {
    String value() default EMPTY;
}
