package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresApi;
import starter.Reqres.ReqresResponses;
import starter.Utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PostStepDef {

    @Steps
    ReqresApi reqresApi;

    @Given("Post create user with valid json")
    public void postCreateUserWithValidJson() {
        File json = new File(Constants.REQ_BODY_DIR+"UserReqBody.json");
        reqresApi.postCreateUser(json);
    }

    @When("Send post create user")
    public void sendPostCreateUser() {
        SerenityRest.when().post(ReqresApi.POST_CREATE_USER);
    }

    @And("Response body name was {string} and job was {string}")
    public void responseBodyNameWasAndJobWas(String name, String job) {
        SerenityRest.and()
                .body(ReqresResponses.NAME,equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job));
    }

    @And("Validate post create user JSON Schema")
    public void validatePostCreateUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"CreateUserJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
