package com.udemy.spring.pages.window;

import com.udemy.spring.kelvin.annotation.Window;
import com.udemy.spring.pages.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Window("Page C")
public class PageC  extends Base {

    @FindBy(id = "area")
    private WebElement textArea;

    public void addToArea(String msg) {
        this.textArea.sendKeys(msg);
    }

    @Override
    public boolean isLoaded() {
        return this.wait.until((driver -> this.textArea.isDisplayed()));
    }
}
