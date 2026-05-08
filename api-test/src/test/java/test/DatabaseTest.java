package test;

import client.AuthClient;
import client.PlayerClient;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import query.PlayerRepository;
import util.AuthHelper;

import java.util.List;

public class DatabaseTest {

    private final AuthClient authClient = new AuthClient();
    private final PlayerClient playerClient = new PlayerClient();
    private final PlayerRepository playerRepository = new PlayerRepository();


    @Test
    public void apiAndDatabaseShouldReturnSamePlayerCountTest() {
        String token = AuthHelper.getToken();

        Response apiResponse = playerClient.getAllPlayers(token);

        System.out.println("API STATUS: " + apiResponse.getStatusCode());
        System.out.println("API BODY: " + apiResponse.getBody().asString());

        Assertions.assertEquals(200, apiResponse.getStatusCode());

        List<Object> apiPlayers = apiResponse.jsonPath().getList("$");
        List<String> dbPlayers = playerRepository.getAllPlayerFullNames();

        long apiPlayersCount = apiPlayers.stream().count();
        long dbPlayersCount = dbPlayers.stream().count();

        System.out.println("DB PLAYERS: " + dbPlayers);
        System.out.println("API COUNT: " + apiPlayersCount);
        System.out.println("DB COUNT: " + dbPlayersCount);

        Assertions.assertEquals(apiPlayersCount, dbPlayersCount);
    }
}