package com.cydeo.day1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class SimpleGetRequests {

    String url ="http://35.175.132.101:8000/api/spartans";
    @Test
    public void test(){
        Response response= RestAssured.get("http://35.175.132.101:8000/api/spartans");
        System.out.println("response.statusCode() = " + response.statusCode());
        response.prettyPrint();

    }
}
