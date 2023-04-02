package com.cydeo.utilities;

import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public abstract class HRTestBase {

    @BeforeAll
    public static void init() {
        //save baseurl inside this variable so that we dont need to type each http method.
        baseURI = ConfigurationReader.get("base_URL_for_HR");

    }
}
