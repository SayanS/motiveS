package com.motiveintegrator.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        this.pageURL="https://www.testtrack.motiveintegrator.com/web/guest/home";
    }

}


