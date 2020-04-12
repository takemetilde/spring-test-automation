package com.org.cucumber.steps.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.Assert.assertEquals;

public class APIBaseSteps {

    private static final String baseURL = "https://jsonplaceholder.typicode.com";

    private static URI baseURI = checkURI(baseURL);

    protected Response response;

    @Autowired
    protected RequestSpecBuilder requestSpecBuilder;

    @Autowired
    protected Map<String, String> requestHeaders;

    public static URI checkURI(String uri) {
        URI returnURI = null;
        try {
            returnURI = new URI(uri);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return returnURI;
    }

    public Response getPost(int id) {
        return given()
                .spec(requestSpecBuilder.build())
                .pathParam("id", id)
                .when()
                .get(baseURI.toString() + "/posts/{id}");
    }

    public void assertObjectsEqual(Object expected, Object actual) {
        assertEquals("Classes are not equal for comparing objects.", actual.getClass(), expected.getClass());
        assertThat(actual, is(samePropertyValuesAs(expected)));
    }

}
