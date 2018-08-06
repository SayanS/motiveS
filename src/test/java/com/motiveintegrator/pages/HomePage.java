package com.motiveintegrator.pages;

import io.restassured.http.Cookies;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void open() {
        open("https://www.testtrack.motiveintegrator.com/web/guest/home");
    }

    public void open(Cookies cookies) {
//        List<Cookie> cookiesList = new ArrayList<>();

       cookies.forEach(cookie ->
               getWebDriver().manage()
               .addCookie(cookies)
//                       .addCookie(new org.openqa.selenium.Cookie(cookie.getName(),cookie.getValue())));
        open("https://www.testtrack.motiveintegrator.com/web/guest/home");
    }
}
//    getDriver().manage().addCookie(new org.openqa.selenium.Cookie(cookie.getName(), cookie.getValue()));