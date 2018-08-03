package com.motiveintegrator.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class RestAssuredConfiguration {
//    @BeforeSuite(alwaysRun = true)
//    public void configure() {
//        RestAssured.baseURI = FilesUtils.getConfigProperty("baseUri");
//        //RestAssured.port = 8080;
////        RestAssured.basePath = "/books";
//    }

    public RequestSpecification getRequestSpecification() {
        return RestAssured.given().contentType(ContentType.JSON);
    }

    public Response getResponse(RequestSpecification requestSpecification, String endpoint, int status) {
        Response response = requestSpecification.get(endpoint);
        Assert.assertEquals(response.getStatusCode(), status);
        response.then().log().all();
        return response;
    }
}
