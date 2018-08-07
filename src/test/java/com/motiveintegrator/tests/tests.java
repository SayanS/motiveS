package com.motiveintegrator.tests;

import com.motiveintegrator.models.User;
import com.motiveintegrator.pages.LoginPage;
import org.testng.annotations.Test;

import java.net.URISyntaxException;
@Test(dataProviderClass = DataProviders.class)
public class tests extends BaseTest {

    @Test(enabled = true, dataProvider = "getAdminUser")
    public void checkLogin(User user) throws URISyntaxException {
        LoginPage loginPage = getPage(LoginPage.class);
        loginPage.open();
        loginPage.login(user);
        int i = 0;
    }
}
