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

public class ReqresStepDef {

    @Steps
    ReqresApi reqresApi;

//    200 OK
    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

//    204 No Content
    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }

//    400 Bad Request
    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int badReq) {
        SerenityRest.then().statusCode(badReq);
    }

//    201 Created
    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

//    404 Not Found
    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

//    Error message
    @And("Response body should be error {string}")
    public void responseBodyShouldBeError(String error) {
        SerenityRest.and()
                .body(ReqresResponses.ERROR,equalTo(error));
    }
}
