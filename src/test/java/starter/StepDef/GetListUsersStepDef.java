package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresApi;
import starter.Reqres.ReqresResponses;
import starter.Utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetListUsersStepDef {

    @Steps
    ReqresApi reqresApi;

    @Given("Get list users with valid parameter page {int}")
    public void getListUsersWithValidParameterPage(int page) {
        reqresApi.getListUserValidParamPage(page);
    }

    @When("Send get lists users")
    public void sendGetListsUsers() {
        SerenityRest.when().get(ReqresApi.GET_LIST_USERS);
    }

    @And("Response body page should be page {int}")
    public void responseBodyPageShouldBePage(int page) {
        SerenityRest.and().body(ReqresResponses.PAGE,equalTo(page));
    }

    @And("Validate get list user JSON Schema")
    public void validateGetListUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"ListUserJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

//    Invalid param page
    @Given("Get list users with invalid parameter page {}")
    public void getListUsersWithInvalidParameterPage(String page) {
        reqresApi.getListUserInvalidParamPage(page);
    }

    @Given("Get list users with invalid parameter number page {}")
    public void getListUsersWithInvalidParameterNumberPage(int page) {
        reqresApi.getListUserValidParamPage(page);
    }

//    Resource
    @Given("Get list users resource")
    public void getListUsersResource() {
        SerenityRest.given().get(ReqresApi.GET_LIST_RESOURCE);
    }

    @And("Validate get list users resource JSON Schema")
    public void validateGetListUsersResourceJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"ListUserResourceJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
