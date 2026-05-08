package query;

import connection.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlayerRepository {

    private final DatabaseConnection databaseConnection = new DatabaseConnection();

    public List<String> getAllPlayerFullNames() {
        List<String> players = new ArrayList<>();

        String query = "SELECT first_name, last_name FROM players";

        try (Connection connection = databaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String fullName = resultSet.getString("first_name") + " "
                        + resultSet.getString("last_name");
                players.add(fullName);
            }

        } catch (Exception e) {
            throw new RuntimeException("Error while reading players from database", e);
        }
        return players.stream()
                .distinct()        // убрать дубликаты
                .sorted()          // отсортировать
                .toList();         // вернуть как List
    }
}