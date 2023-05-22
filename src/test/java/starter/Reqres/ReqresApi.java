package starter.Reqres;

import io.cucumber.java.hi.तथा;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

public class ReqresApi {
//    Panggil Constants
    public static String GET_LIST_USERS = Constants.BASE_URL+"/api/users?page={page}";
    public static String POST_CREATE_USER = Constants.BASE_URL+"/api/users";
    public static String PUT_UPDATE_USER = Constants.BASE_URL+"/api/users/{id}";
    public static String DELETE_USER = Constants.BASE_URL+"/api/users/{id}";
    public static String LOGIN_USER = Constants.BASE_URL+"/api/login";
    public static String REGISTER_USER = Constants.BASE_URL+"/api/register";
    public static String GET_SINGLE_USER = Constants.BASE_URL+"/api/users/{id}";
    public static String GET_LIST_RESOURCE = Constants.BASE_URL+"/api/unknown";
    public static String GET_SINGLE_RESOURCE = Constants.BASE_URL+"/api/unknown/{id}";
    public static String PATCH_UPDATE_USER = Constants.BASE_URL+"/api/users/{id}";

    @Step("Get list user with valid parameter page")
    public void getListUserValidParamPage(int page) {
        SerenityRest.given()
                .pathParam("page",page);
    }

    @Step("Get list user with invalid parameter page")
    public void getListUserInvalidParamPage(String page) {
        SerenityRest.given()
                .pathParam("page", page);
    }

    @Step("Post create new user")
    public void postCreateUser(File json) {
        SerenityRest.given()
//                ini buat kalo pake token
//                .headers("Authorization", "Bearer 1n1t0k3nc3r1t4ny4")
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update user")
    public void putUpdateUser(int id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete user")
    public  void deleteUser(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Login user")
    public void loginUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Register user")
    public void registerUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Get single user with valid id")
    public void getSingleUser(int id) {
        SerenityRest.given()
                .pathParam("id",id);
    }

    @Step("Get single user with invalid id")
    public void getSingleUserInvalid(String id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Get single user resource")
    public void getSingleUserResource(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Patch update user")
    public void patchUpdateUser(int id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }
}
