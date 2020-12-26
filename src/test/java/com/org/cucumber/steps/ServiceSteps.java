package com.org.cucumber.steps;

import com.org.model.Posts;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ServiceSteps extends BaseSteps {

    @When("^the client gets the post: (.*)$")
    public void the_client_gets_the_post(String id) {
        response = getPost(Integer.parseInt(id));
    }

    @Then("^the server returns the response code: (.*)$")
    public void the_server_returns_the_response_code(String code) {
        assertEquals("Status code: ", Integer.parseInt(code), response.getStatusCode());
    }

    @Then("^the server returns the response:$")
    public void the_server_returns_the_response(DataTable dataTable) {
        List<Posts> postsList = dataTable.asList(Posts.class);
        Posts actual = response.getBody().as(Posts.class);
        Posts expected = postsList.get(0);
        assertObjectsEqual(expected, actual);
    }

}
