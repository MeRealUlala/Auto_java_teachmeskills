package test;

import client.AuthClient;
import client.PlayerClient;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.AuthHelper;


public class AuthApiTest {

    private final AuthClient authClient = new AuthClient();
    private final PlayerClient playerClient = new PlayerClient();


    @Test
    public void getPlayersShouldReturnListTest() {
        String token = AuthHelper.getToken();

        Response response = playerClient.getAllPlayers(token);

        System.out.println("STATUS: " + response.getStatusCode());
        System.out.println("BODY: " + response.getBody().asString());

        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertTrue(response.getBody().asString().startsWith("["));
    }

    @Test
    public void getPlayerByIdShouldReturn200Or404Test() {
        String token = AuthHelper.getToken();

        Response response = playerClient.getPlayerById(token, 1);

        System.out.println("STATUS: " + response.getStatusCode());
        System.out.println("BODY: " + response.getBody().asString());

        Assertions.assertTrue(
                response.getStatusCode() == 200 || response.getStatusCode() == 404
        );
    }
}