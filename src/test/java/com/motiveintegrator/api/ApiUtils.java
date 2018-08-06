package com.motiveintegrator.api;

import io.restassured.http.Cookies;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.NotFoundException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.given;

public final class ApiUtils {
    static RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification();
    static Cookies cookies;

    private static String getAuthToken(String responseBody) {
        Pattern p = Pattern.compile("authToken=\"(.+?)\"");
        Matcher m = p.matcher(responseBody);
        if (m.find())
            return responseBody.substring(m.start() + 11, m.end() - 1);
        else
            throw new NotFoundException("authToken wans't found.");
    }

    private static int getSavedEntityId(String responseBody) {
        Pattern p = Pattern.compile("<div class=\"saved-entity-id\">(.+?)</div>");
        Matcher m = p.matcher(responseBody);
        if (m.find())
            return Integer.parseInt(responseBody.substring(m.start() + 29, m.end() - 6));
        else
            throw new NotFoundException("saved-entity-id wasn't found.");
    }

    private static int getSavedPayloadId(String responseBody) {
        Pattern p = Pattern.compile("\"payloadId\":(.+?),");
        Matcher m = p.matcher(responseBody);
        if (m.find())
            return Integer.parseInt(responseBody.substring(m.start() + 12, m.end() - 1));
        else
            throw new NotFoundException("payloadId wasn't found.");
    }

    private static int getTestCaseIdId(String responseBody) {
        Pattern p = Pattern.compile("\"testCaseId\":(.+?),");
        Matcher m = p.matcher(responseBody);
        if (m.find())
            return Integer.parseInt(responseBody.substring(m.start() + 13, m.end() - 1));
        else
            throw new NotFoundException("testCaseId wan't found.");
    }

    private static int getSavedOrganizationId(String responseBody) {
        Pattern p = Pattern.compile("\"organizationId\":(.+?),");
        Matcher m = p.matcher(responseBody);
        if (m.find())
            return Integer.parseInt(responseBody.substring(m.start() + 17, m.end() - 1));
        else
            throw new NotFoundException("organizationId wan't found.");
    }


    public static boolean login(String loginName, String password) {
//        Send POST to login
        String authToken = null;
        String url1 = "?p_p_id=58&p_p_lifecycle=1&p_p_state=normal&p_p_mode=view&p_p_col_id=column-2&p_p_col_count=2&_58_struts_action=/login/login";
        Response response1 = given().relaxedHTTPSValidation()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .formParam("_58_doActionAfterLogin", "false")
                .formParam("_58_formDate", "1509105088194")
                .formParam("_58_login", loginName)
                .formParam("_58_password", password)
                .formParam("_58_redirect", "/group/guest")
                .formParam("_58_saveLastPath", "false")
                .post(url1);

//        I'm getting 302 response code. Then I extract Location where to redirect, extract Cookies (JSESSIONID)
        String url2 = response1.then().extract().header("Location");
        cookies = response1.getDetailedCookies();

//        I'm going to redirect Url with Remembered Cookies (JSESSIONID)
        String responseBody = given().relaxedHTTPSValidation()
                .cookies(cookies)
                .get(url2)
                .then()
                .extract()
                .body().asString();
//        Get authToken
        authToken = getAuthToken(responseBody);
        return !authToken.equals("");
    }

    public static Cookies getCookies(){
        return cookies;
    }
}
