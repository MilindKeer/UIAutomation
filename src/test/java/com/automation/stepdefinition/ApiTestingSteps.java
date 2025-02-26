package com.automation.stepdefinition;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ApiTestingSteps {

    private Response response;

    @Given("User sends a GET request to {string}")
    public void user_sends_a_get_request_to(String url) {
        response = RestAssured.get(url);  
    }

    @Then("Response status should be {int}")
    public void response_status_should_be(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode()); 
    }

    @Then("Response body should contain {string}")
    public void response_body_should_contain(String expectedText) {
        assertTrue(response.getBody().asString().contains(expectedText)); 
    }
}

// Note:
// API Test Coverage
// Our test framework includes API testing using RestAssured, focusing on the following HTTP methods:

// GET - Retrieve data from a public API (already implemented).
// POST - Create a new resource (not implemented but can be added).
// PUT - Update an existing resource.
// DELETE - Remove a resource.
// For demonstration purposes, our framework currently includes GET requests, but similar logic can be applied to implement other methods.