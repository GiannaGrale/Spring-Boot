package com.udemy.spring.pages.flights;

import com.udemy.spring.kelvin.annotation.Page;
import com.udemy.spring.pages.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@Page
public class FlightPage extends Base {

    @FindBy(css = "nav.P6Wwdb.OE019d span.VfPpkd-vQzf8d")
    private List<WebElement> elements;


    public void goTo(final String url){
        this.driver.get(url);
    }

    public List<String> getLabels() {
        return this.elements
                .stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isLoaded() {
        return this.wait.until(webDriver -> !elements.isEmpty());
    }
}
