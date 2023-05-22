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

public class PatchStepDef {

    @Steps
    ReqresApi reqresApi;

    @Given("Patch update user with valid json and id {int}")
    public void patchUpdateUserWithValidJsonAndId(int id) {
        File json = new File(Constants.REQ_BODY_DIR+"UserReqBody.json");
        reqresApi.putUpdateUser(id, json);
    }

    @When("Send patch update user")
    public void sendPatchUpdateUser() {
        SerenityRest.when().put(ReqresApi.PATCH_UPDATE_USER);
    }

    @And("Response patch body name was {string} and job was {string}")
    public void responsePatchBodyNameWasAndJobWas(String name, String job) {
        SerenityRest.and()
                .body(ReqresResponses.NAME,equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job));
    }

    @And("Validate patch update user JSON Schema")
    public void validatePatchUpdateUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"UpdateUserJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
