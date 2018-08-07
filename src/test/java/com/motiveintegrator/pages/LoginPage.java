package com.motiveintegrator.pages;

import com.motiveintegrator.models.User;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    WebDriver webDriver;
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver=webDriver;
        this.pageURL="https://www.testtrack.motiveintegrator.com/web/guest/home";
    }

    String LOGIN_FIELD = "//input[@id='_58_login']";
    String PASSWORD_FIELD = "//input[@id='_58_password']";
    String SIGNIN_BUTTON = "//button[.=' Sign In ']";

    public HomePage login(User user) {
        sendKeys(LOGIN_FIELD, user.getLogin());
        sendKeys(PASSWORD_FIELD, user.getPassword());
        clickOn(SIGNIN_BUTTON);
        return new HomePage(webDriver);
    }
}
