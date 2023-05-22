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

public class GetSingleUserStepDef {

    @Steps
    ReqresApi reqresApi;

    @Given("Get single user with valid id {int}")
    public void getSingleUserWithValidId(int id) {
        reqresApi.getSingleUser(id);
    }

    @When("Send get single user")
    public void sendGetSingleUser() {
        SerenityRest.when().get(ReqresApi.GET_SINGLE_USER);
    }

    @And("Response body id should be id {int}")
    public void responseBodyIdShouldBeId(int id) {
        SerenityRest.and().body("data.id",equalTo(id));
    }

    @And("Validate get single user JSON Schema")
    public void validateGetSingleUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"SingleUserJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

//    Invalid id
    @Given("Get single user with invalid number id {int}")
    public void getSingleUserWithInvalidNumberId(int id) {
        reqresApi.getSingleUser(id);
    }

    @Given("Get single user with invalid id {}")
    public void getSingleUserWithInvalidId(String id) {
        reqresApi.getSingleUserInvalid(id);
    }

//    Resource
    @Given("Get single user resource with valid id {int}")
    public void getSingleUserResourceWithValidId(int id) {
        reqresApi.getSingleUserResource(id);
    }

    @When("Send get single user resource")
    public void sendGetSingleUserResource() {
        SerenityRest.when().get(ReqresApi.GET_SINGLE_RESOURCE);
    }

    @And("Validate get single user resource JSON Schema")
    public void validateGetSingleUserResourceJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"SingleUserResourceJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

//    Invalid resource
    @Given("Get single user resource with invalid id {int}")
    public void getSingleUserResourceWithInvalidId(int id) {
        reqresApi.getSingleUserResource(id);
    }
}
