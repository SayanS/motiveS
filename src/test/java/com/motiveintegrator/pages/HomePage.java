package com.motiveintegrator.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void open(){
        open("https://www.testtrack.motiveintegrator.com/web/guest/home");
    }
}
