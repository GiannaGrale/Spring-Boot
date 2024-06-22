package com.udemy.spring.pages.google;

import com.udemy.spring.kelvin.annotation.PageFragment;
import com.udemy.spring.pages.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageFragment
public class SearchResult extends Base {

    @FindBy(css = "div.MjjYud")
    private List<WebElement> results;

    public int getResultCount() {
        return this.results.size();
    }

    @Override
    public boolean isLoaded() {
        return this.wait.until(webDriver -> !this.results.isEmpty());
    }
}
