package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresApi;
import starter.Utils.Constants;

import java.io.File;
public class RegisterStepDef {

    @Steps
    ReqresApi reqresApi;

    @Given("Register user with valid json")
    public void registerUserWithValidJson() {
        File json = new File(Constants.REQ_BODY_DIR+"UserLogRegBody.json");
        reqresApi.registerUser(json);
    }

    @When("Send register user")
    public void sendRegisterUser() {
        SerenityRest.when()
                .post(ReqresApi.REGISTER_USER);
    }

    @And("Validate register user JSON Schema")
    public void validateRegisterUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"RegisterUserJSONSchema.json");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

//    Invalid no password
    @Given("Register user with invalid json no password")
    public void registerUserWithInvalidJsonNoPassword() {
        File json = new File(Constants.REQ_BODY_DIR+"UserLogRegBodyNoPassword.json");
        reqresApi.registerUser(json);
    }

    @And("Validate error register user JSON Schema")
    public void validateErrorRegisterUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"RegisterErrorJSONSchema.json");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

//    Invalid no email
    @Given("Register user with invalid json no email")
    public void registerUserWithInvalidJsonNoEmail() {
        File json = new File(Constants.REQ_BODY_DIR+"UserLogRegBodyNoEmail.json");
        reqresApi.registerUser(json);
    }
}
