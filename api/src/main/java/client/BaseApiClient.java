package client;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseApiClient {

    protected RequestSpecification requestSpec;

    public BaseApiClient() {
        this.requestSpec = new RequestSpecBuilder()
                .setBaseUri("http://localhost:5030")
                .setContentType("application/json")
                .build();
    }

    /**
     * Запрос с авторизацией (Bearer token)
     */
    protected io.restassured.specification.RequestSpecification getRequestWithAuth(String token) {
        return given()
                .spec(requestSpec)
                .header("Authorization", "Bearer " + token);
    }
}