package com.cydeo.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.image.RescaleOp;
import java.sql.PreparedStatement;

import static io.restassured.RestAssured.baseURI;

public class HrGetResults {

    //BeforeAll is a annotation equals to @BeforeClass in testNg, we use with static method name

    @BeforeAll
    public static void init() {
        //save baseurl inside this variable so that we dont need to type each http method.
        baseURI = "http://35.175.132.101:1000/ords/hr";

    }

    @DisplayName("GET request to /regions")
    @Test
    public void test1() {
        Response response = RestAssured.
                given().
                accept(ContentType.JSON).
                when().
                get("/regions");

        //print the status code
        System.out.println(response.statusCode());

    }


     /*
        Given accept type is application/json
        When user sends get request to /regions/2
        Then response status code must be 200
        and content type equals to application/json
        and response body contains   Americas
     */

    @DisplayName("Region for Americas")
    @Test
    public void test2() {

        Response response= RestAssured.given().accept(ContentType.JSON).
                when().get("/regions/2");

    assertEquals(200,response.statusCode());
    assertEquals("application/json",response.contentType());
        assertTrue(response.body().asString().contains("Americas"));

    }


}

