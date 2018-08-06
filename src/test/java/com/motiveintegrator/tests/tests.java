package com.motiveintegrator.tests;

import com.motiveintegrator.api.ApiUtils;
import com.motiveintegrator.pages.HomePage;
import org.testng.annotations.Test;

import java.net.URISyntaxException;

public class tests extends  BaseTest{
    @Test(enabled=true)
    public void checkLogin() throws URISyntaxException {
       ApiUtils.login("max.ivanov@gmail.com","Motive1");
       getPage(HomePage.class).open(ApiUtils.getCookies());
       int i=0;
    }
}
