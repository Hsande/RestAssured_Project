package com.cydeo.utilities;

import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public abstract class SpartanTestBase {


    @BeforeAll
    public static void init() {
        baseURI = ConfigurationReader.get("base_URL_for_spartans");

    }

}