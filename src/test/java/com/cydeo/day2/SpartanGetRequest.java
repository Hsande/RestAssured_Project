package com.cydeo.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.geom.RectangularShape;

public class SpartanGetRequest {
/*
Given Accept type application/json
• When I send a GET request to
• http://54.204.128.200:8000/api/spartans
• Then Response STATUS CODE must be 200
• And I Should see all Spartans data in JSON format
 */

    String baseURL = "http://35.175.132.101:8000";

    @DisplayName("Get all Spartans")
    @Test
    public void test1() {
        Response response = RestAssured.
                given().accept(ContentType.JSON).
                when().get(baseURL + "/api/spartans");


        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println("response.contentType() = " + response.contentType());

        response.prettyPrint();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("application/json", response.contentType());


    }

        /*
        Given accept header is application/json
        When users sends a get request to /api/spartans/3
        Then status code should be 200
        And content type should be application/json
        and json body should contain Fidole
     */

@DisplayName("Get one spartan")
    @Test
    public void test2() {

    Response response = RestAssured.given().accept(ContentType.JSON).
            when().get(baseURL + "/api/spartans/3");



    Assertions.assertEquals(200,response.statusCode());
    Assertions.assertEquals("application/json",response.contentType());
    Assertions.assertTrue(response.body().asString().contains("Fidole"));


    }

    /*
        Given no headers provided
        When Users sends GET request to /api/hello
        Then response status code should be 200
        And Content type header should be “text/plain;charset=UTF-8”
        And header should contain date
        And Content-Length should be 17
        And body should be “Hello from Sparta"
        */
@DisplayName("Hello text")
    @Test
    public void test3(){
        Response response= RestAssured.
                given().get(baseURL+ "/api/hello");

        Assertions.assertEquals(200,response.statusCode());
        Assertions.assertEquals("text/plain;charset=UTF-8",response.contentType());
        Assertions.assertTrue(response.headers().hasHeaderWithName("date"));
        Assertions.assertEquals("17",response.header("Content-Length"));
        Assertions.assertEquals("Hello from Sparta",response.body().asString());



}




}
