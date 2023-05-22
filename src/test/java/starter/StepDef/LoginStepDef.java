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

public class LoginStepDef {

    @Steps
    ReqresApi reqresApi;

    @Given("Login user with valid json")
    public void loginUserWithValidJson() {
        File json = new File(Constants.REQ_BODY_DIR+"UserLogRegBody.json");
        reqresApi.loginUser(json);
    }

    @When("Send login user")
    public void sendLoginUser() {
        SerenityRest.when()
                .post(ReqresApi.LOGIN_USER);
    }

    @And("Validate login user JSON Schema")
    public void validateLoginUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"LoginUserJSONSchema.json");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

//    Invalid no password
    @Given("Login user with invalid json no password")
    public void loginUserWithInvalidJsonNoPassword() {
        File json = new File(Constants.REQ_BODY_DIR+"UserLogRegBodyNoPassword.json");
        reqresApi.loginUser(json);
    }

    @And("Validate error login user JSON Schema")
    public void validateErrorLoginUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"RegisterErrorJSONSchema.json");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

//    Invalid no email
    @Given("Login user with invalid json no email")
    public void loginUserWithInvalidJsonNoEmail() {
        File json = new File(Constants.REQ_BODY_DIR+"UserLogRegBodyNoEmail.json");
        reqresApi.registerUser(json);
    }
}
