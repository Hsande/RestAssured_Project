package com.cydeo.day3;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
public class ORDSApiTestsWithParameters {

    @BeforeAll
    public static void init(){
        //save baseurl inside this variable so that we dont need to type each http method.
        baseURI = "http://35.175.132.101:1000/ords/hr";
    }

    /*
        Given accept type is Json
        And parameters: q = {"region_id":2}
        When users sends a GET request to "/countries"
        Then status code is 200
        And Content type is application/json
        And Payload should contain "United States of America"
     */

    @DisplayName("GET request to /countries with Query Param")
    @Test
    public void test1(){
        Map<String, Object > queryMap= new HashMap<>();
        queryMap.put("q","{\"region_id\":2}");

        Response response = given().log().all().
                accept(ContentType.JSON).and().queryParams(queryMap).when().get("/countries");

    assertEquals(200,response.statusCode());
    assertEquals("application/json",response.contentType());
    assertTrue(response.body().asString().contains("United States of America"));


    }

 /*
        Send a GET request to employees and get only employees who works as a IT_PROG

     */

    @DisplayName("GET request to /employees with Query Param")
    @Test
    public void test2(){

        Response response = given().log().all().
                accept(ContentType.JSON).queryParam("q", "{\"job_id\": \"IT_PROG\"}").and().get("/employees");


        assertEquals(200,response.statusCode());
        assertEquals("application/json",response.contentType());
        assertTrue(response.body().asString().contains("IT_PROG"));


        response.prettyPrint();

    }




}
