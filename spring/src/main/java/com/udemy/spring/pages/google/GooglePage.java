package com.udemy.spring.pages.google;


import com.udemy.spring.kelvin.annotation.Page;
import com.udemy.spring.pages.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Page
public class GooglePage extends Base {

    @Autowired
    private SearchComponent searchComponent;

    @Autowired
    private SearchResult searchResult;

    public SearchComponent getSearchComponent() {
        return searchComponent;
    }

    public SearchResult getSearchResult() {
        return searchResult;
    }

    @Value("${app_url}")
    private String url;

    public void goTo() {
        this.driver.get(url);
    }

    @Override
    public boolean isLoaded() {
        return this.searchComponent.isLoaded();
    }

    public void close() {
        this.driver.quit();
    }
}
