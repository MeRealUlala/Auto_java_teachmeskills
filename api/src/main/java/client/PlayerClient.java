package client;

import io.restassured.response.Response;
import model.PlayerRequest;

public class PlayerClient extends BaseApiClient {

    public Response getAllPlayers(String token) {
        return getRequestWithAuth(token)
                .get("/players");
    }

    public Response getPlayerById(String token, int id) {
        return getRequestWithAuth(token)
                .get("/players/" + id);
    }

    public Response createPlayer(String token, PlayerRequest request) {
        return getRequestWithAuth(token)
                .body(request)
                .post("/players");
    }
}