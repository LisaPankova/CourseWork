package ru.fantasy.server;

import ru.fantasy.api.data.characters;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DatabaseTest {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost/fantasy";
        String login = "postgres";
        String password = "123";
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection conn = DriverManager.getConnection(url, login, password);
            Statement statement = conn.createStatement();
            //      String sql = "CREATE TABLE characters ( id varchar(60) NOT NULL, character_name varchar(30) NOT NULL, location varchar(20), description varchar(100), PRIMARY KEY (id));";
            //    String sql1 = "INSERT INTO characters(id, character_name, location, description) VALUES (\'" + UUID.randomUUID()+ "\', \'Вильям\', \'Энра\', \'Высокий\')";
            //     statement.execute(sql1);
            String sql2 = "SELECT id, character_name, location, description FROM characters WHERE location='Энра'";
            ResultSet resultSet = statement.executeQuery(sql2);
            List<characters> characters = new ArrayList<>();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("character_name");
                String location = resultSet.getString("location");
                String description = resultSet.getString("description");
                characters character = new characters();
                character.setId(id);
                character.setName(name);
                character.setLocation(location);
                character.setDescription(description);
                characters.add(character);
            }
            System.out.println(characters);
            String message = "";
            for (int i = 0; i < characters.size(); i++) {
                message = message + characters.get(i).getName() + " ";
            }
            System.out.println(message);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
