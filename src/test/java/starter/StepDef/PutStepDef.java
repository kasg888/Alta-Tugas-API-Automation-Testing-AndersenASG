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

public class PutStepDef {

    @Steps
    ReqresApi reqresApi;

    @Given("Put update user with valid json and id {int}")
    public void putUpdateUserWithValidJsonAndId(int id) {
        File json = new File(Constants.REQ_BODY_DIR+"UserReqBody.json");
        reqresApi.putUpdateUser(id, json);
    }

    @When("Send put update user")
    public void sendPutUpdateUser() {
        SerenityRest.when().put(ReqresApi.PUT_UPDATE_USER);
    }

    @And("Response put body name was {string} and job was {string}")
    public void responsePutBodyNameWasAndJobWas(String name, String job) {
        SerenityRest.and()
                .body(ReqresResponses.NAME,equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job));
    }

    @And("Validate put update user JSON Schema")
    public void validatePutUpdateUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"UpdateUserJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
