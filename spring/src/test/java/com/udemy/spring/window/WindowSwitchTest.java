package com.udemy.spring.window;

import com.udemy.spring.SpringBaseTest;
import com.udemy.spring.kelvin.service.WindowSwitchService;
import com.udemy.spring.pages.window.MainPage;
import com.udemy.spring.pages.window.PageA;
import com.udemy.spring.pages.window.PageB;
import com.udemy.spring.pages.window.PageC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@TestPropertySource(properties = "browser=edge")
public class WindowSwitchTest extends SpringBaseTest {

    @Autowired
    private MainPage mainPage;

    @Autowired
    private WindowSwitchService switchService;

    @Autowired
    private PageA pageA;

    @Autowired
    private PageB pageB;

    @Autowired
    private PageC pageC;

    @BeforeClass
    public void setup(){
        this.mainPage.goTo();
        this.mainPage.isLoaded();
        this.mainPage.launchAllWindows();
    }

    @Test(dataProvider = "getData")
    public void switchTest(int index){
        this.pageA.addToArea(index + "\n");
        this.pageB.addToArea((index * 2) + "\n");
        this.pageC.addToArea((index * 3) + "\n");
    }

    @DataProvider
    public Object[][] getData(){
        return new Object[][] {
                {4},
                {2},
                {8},
                {2},
                {7},
                {3}
        };
    }
}
