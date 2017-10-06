package com.selenium.ui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.selenium.pageobjects.*;

import java.util.concurrent.TimeUnit;

public class SearchGoogleTest {
    private WebDriver driver;
    public Google googlePage;
    public GoogleSearchPage searchPage;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();
        //driver.manage().window().maximize(); // this will fail in jenkins, since no physical browser exist
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
    @Test
    public void testGoogleSearch(){
        googlePage = new Google(driver);
        searchPage = googlePage.goToSearchPage();
        searchPage.getNumberOfResults();
    }
}
