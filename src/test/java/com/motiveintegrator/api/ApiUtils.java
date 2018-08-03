package com.motiveintegrator.api;

import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public final class ApiUtils {
    //    static RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification();
//    p_p_id=58&p_p_lifecycle=1&p_p_state=normal&p_p_mode=view&p_p_col_id=column-2&p_p_col_count=2&_58_struts_action=%2Flogin%2Flogin
    public static String login(String loginName, String password) {
        String url1 = "https://www.testtrack.motiveintegrator.com/web/guest/home?p_p_id=58&p_p_lifecycle=1&p_p_state=normal&p_p_mode=view&p_p_col_id=column-2&p_p_col_count=2&_58_struts_action=/login/login";

        JSONObject requestParams = new JSONObject();
        requestParams.put("_58_doActionAfterLogin", "false");
        requestParams.put("_58_formDate", "1533299764687");
        requestParams.put("_58_login", "max.ivanov%40gmail.com");
        requestParams.put("_58_password", password);
        requestParams.put("_58_redirect", null);
        requestParams.put("_58_saveLastPath", "false");
        Response response2 = given()
                .relaxedHTTPSValidation()
//             .spec(requestSpecification)
                .header("Content-Type", "text/plain;charset=UTF-8")
                .header("Accept","*/*")
//               .header("Origin","https://www.testtrack.motiveintegrator.com")
//               .header("Upgrade-Insecure-Requests","1")
//               .header("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
//               .header("Referer","https://www.testtrack.motiveintegrator.com/web/guest/home")
//               .header("Accept-Encoding","gzip, deflate, br")
//               .header("Accept-Language","en-US,en;q=0.9")
//               .body(requestParams.toJSONString())
                .post("https://www.testtrack.motiveintegrator.com/c/portal/extend_session");
//        Map<String,String> cookies= response2.getCookies();
        given()
                .relaxedHTTPSValidation()
                .contentType("application/x-www-form-urlencoded")
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                .formParam("_58_doActionAfterLogin", false)
                .formParam("_58_formDate", "1533299764687")
                .formParam("_58_login", "max.ivanov%40gmail.com")
                .formParam("_58_password", password)
                .formParam("_58_redirect", "/group/guest/home")
                .formParam("_58_saveLastPath", false)
                .post("https://www.testtrack.motiveintegrator.com/web/guest/home?p_p_id=58&p_p_lifecycle=1&p_p_state=normal&p_p_mode=view&p_p_col_id=column-2&p_p_col_count=2&_58_struts_action=%2Flogin%2Flogin");


        return "";

    }
}
