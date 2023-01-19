package ru.fantasy.server;

import ru.fantasy.api.data.characters;
import ru.fantasy.api.data.countries;
import ru.fantasy.api.services.CharacterService;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CharacterServiceImpl  implements CharacterService {

    private String url = "jdbc:postgresql://localhost/fantasy";
    private String login = "postgres";
    private String password = "123";
    @Override
    public String addCharacter(characters character) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            String id = UUID.randomUUID().toString();
            character.setId(id);
            Connection conn = DriverManager.getConnection(url, login, password);
            Statement statement = conn.createStatement();
            String sql = "INSERT INTO characters(id, character_name, location, description, magic, race) VALUES (\'" + character.getId() + "\'," +
                    " \'" + character.getName() + "\', \'" + character.getLocation() + "\' , \'" + character.getDescription() + "\', \'" +
            character.getMagic() + "\', \'" + character.getRace() + "\')";
            statement.execute(sql);
            statement.close();
            conn.close();
            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void delCharacter(String id) {
              try {
            Connection conn = DriverManager.getConnection(url, login, password);
            Statement statement = conn.createStatement();
            String sql = "DELETE FROM characters WHERE id='" + id + "'";
            statement.execute(sql);
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public characters getCharacter(String id) {
        try {
            Connection conn = DriverManager.getConnection(url, login, password);
            Statement statement = conn.createStatement();
            String sql = "SELECT character_name,  location, description, magic, race FROM characters WHERE id='" + id + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            characters character = new characters();
            if (resultSet.next()) {
                character.setId(id);
                character.setName(resultSet.getString("character_name"));
                character.setLocation(resultSet.getString("location"));
                character.setDescription(resultSet.getString("description"));
                character.setMagic(resultSet.getString("magic"));
                character.setRace(resultSet.getString("race"));
            }
            statement.close();
            conn.close();
            return character;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<characters> lookCountry(String name) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection conn = DriverManager.getConnection(url, login, password);
            Statement statement = conn.createStatement();
            String sql = "SELECT id, character_name FROM characters WHERE location='" + name + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            List<characters> characters = new ArrayList<>();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String Name = resultSet.getString("character_name");
                characters character = new characters();
                character.setId(id);
                character.setName(Name);
                characters.add(character);
            }
            System.out.println(characters.size());
            statement.close();
            conn.close();
            return characters;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<characters> lookMagic(String name) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection conn = DriverManager.getConnection(url, login, password);
            Statement statement = conn.createStatement();
            String sql = "SELECT id, character_name FROM characters WHERE magic='" + name + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            List<characters> characters = new ArrayList<>();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String Name = resultSet.getString("character_name");
                characters character = new characters();
                character.setId(id);
                character.setName(Name);
                characters.add(character);
            }
            System.out.println(characters.size());
            statement.close();
            conn.close();
            return characters;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<characters> lookRace(String name) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection conn = DriverManager.getConnection(url, login, password);
            Statement statement = conn.createStatement();
            String sql = "SELECT id, character_name FROM characters WHERE race='" + name + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            List<characters> characters = new ArrayList<>();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String Name = resultSet.getString("character_name");
                characters character = new characters();
                character.setId(id);
                character.setName(Name);
                characters.add(character);
            }
            System.out.println(characters.size());
            statement.close();
            conn.close();
            return characters;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<characters> getCharacterList() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection conn = DriverManager.getConnection(url, login, password);
            Statement statement = conn.createStatement();
            String sql = "SELECT id, character_name, location, description, magic, race FROM characters";
            ResultSet resultSet = statement.executeQuery(sql);
            List<characters> characters = new ArrayList<>();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String Name = resultSet.getString("character_name");
                String location = resultSet.getString("location");
                String description = resultSet.getString("description");
                String magic = resultSet.getString("magic");
                String race = resultSet.getString("race");
                characters character = new characters();
                character.setId(id);
                character.setName(Name);
                character.setLocation(location);
                character.setDescription(description);
                character.setRace(race);
                character.setMagic(magic);
                characters.add(character);
            }
            System.out.println(characters.size());
            statement.close();
            conn.close();
            return characters;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
