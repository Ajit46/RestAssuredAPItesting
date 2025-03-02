package com.thetestingacademy.base;

import com.thetestingacademy.actions.AssertActions;
import com.thetestingacademy.endpoints.APIConstants;
import com.thetestingacademy.modules.PayloadManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    // Base Test is Father -> Testcase is son - Single Inheritence
    public RequestSpecification requestSpecification;
    public AssertActions assertActions;
    public PayloadManager payloadManager;
    public JsonPath jsonPath;
    public Response response;
    public ValidatableResponse validatableResponse;

    @BeforeTest
    public void setConfig()
    {
        System.out.println("Before Test");
        payloadManager = new PayloadManager();
        assertActions = new AssertActions();
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(APIConstants.BASE_URL).addHeader("Content-Type","application/json")
                .build().log().all();
//        OR
//        requestSpecification = RestAssured.given().baseUri(APIConstants.BASE_URL)
//                .contentType(ContentType.JSON)
//                .log().all();
    }
    public  String getToken(){
        //Set up the URLs
        requestSpecification = RestAssured.given().baseUri(APIConstants.BASE_URL)
                .basePath(APIConstants.AUTH_URL);
        //Setting up the Payload
        String payload =payloadManager.setAuthPayload();
        //Getting the Response
        response= requestSpecification.contentType(ContentType.JSON)
                        .body(payload)
                        .when().post();
        //Extracting of the Token via Deserialization
        String token = payloadManager.getTokenFromJSON(response.asString());
        return token;

    }
}
