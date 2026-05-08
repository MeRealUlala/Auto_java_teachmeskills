package util;

import client.AuthClient;
import io.restassured.response.Response;

public class AuthHelper {

    private static final AuthClient authClient = new AuthClient();

    public static String getToken() {
        String username = "user_" + System.currentTimeMillis();
        String password = "test123";

        Response response = authClient.signUpRaw(username, password);

        if (response.getStatusCode() != 200) {
            throw new RuntimeException("Signup failed");
        }

        return response.jsonPath().getString("token");
    }
}