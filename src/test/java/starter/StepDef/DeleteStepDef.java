package starter.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresApi;

public class DeleteStepDef {

    @Steps
    ReqresApi reqresApi;

    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidId(int id) {
        reqresApi.deleteUser(id);
    }

    @When("Send delete user")
    public void sendDeleteUser() {
        SerenityRest.when().delete(ReqresApi.DELETE_USER);
    }
}
