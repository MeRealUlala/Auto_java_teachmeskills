package client;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthClient extends BaseApiClient {

    private static final String AUTH_TOKEN = "/auth/token";
    private static final String AUTH_SIGNUP = "/auth/sign-up";

    /**
     * Регистрация пользователя (возвращает Response)
     */
    public Response signUpRaw(String username, String password) {
        return given()
                .spec(requestSpec)
                .body("{\"username\":\"" + username + "\", \"password\":\"" + password + "\"}")
                .when()
                .post(AUTH_SIGNUP)
                .then()
                .extract()
                .response();
    }

    /**
     * Логин (возвращает JWT токен)
     */
    public String login(String username, String password) {
        Response response = given()
                .spec(requestSpec)
                .body("{\"username\":\"" + username + "\", \"password\":\"" + password + "\"}")
                .when()
                .post(AUTH_TOKEN)
                .then()
                .extract()
                .response();

        System.out.println("LOGIN STATUS: " + response.getStatusCode());
        System.out.println("LOGIN BODY: " + response.getBody().asString());

        if (response.getStatusCode() != 200) {
            return null;
        }

        return response.jsonPath().getString("token");
    }

    /**
     * Регистрация + сразу получение токена (удобный метод)
     */
    public String signUpAndGetToken(String username, String password) {
        Response response = signUpRaw(username, password);

        System.out.println("SIGNUP STATUS: " + response.getStatusCode());
        System.out.println("SIGNUP BODY: " + response.getBody().asString());

        if (response.getStatusCode() != 200) {
            return null;
        }

        return response.jsonPath().getString("token");
    }
}