package com.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Google {
    private WebDriver driver;
    private String baseURL;

    public Google(WebDriver driver){
        this.driver = driver;
        baseURL = "https://www.google.com/";
        driver.get(baseURL + "?gws_rd=cr,ssl&ei=qZlNVpOUMNCauQS0iYmoCA&fg=1");
        System.out.println("Page title: " + driver.getTitle());
        if (!driver.getTitle().equals("Google")){
            throw new WrongPageException("Incorrect page for Google Home page");
        }
    }
    public GoogleSearchPage goToSearchPage(){
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Mastering Selenium Testing Tools");
        searchBox.submit();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));
        return new GoogleSearchPage(driver);
    }
}
