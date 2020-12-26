package com.org.cucumber.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

public class HeaderSteps extends BaseSteps {

    @Given("the headers:")
    public void the_headers(DataTable dataTable) {
        requestHeaders = dataTable.asMap(String.class, String.class);
        requestSpecBuilder.addHeaders(requestHeaders);
    }

}
