package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection connection;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection connection) {
        this.connection = connection;
    }

    private void init() {
        try (InputStream input = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase.properties")) {
            Properties config = new Properties();
            config.load(input);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO items(name, created) VALUES (?,?);",
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        Item oldItem = findById(id);
        if (oldItem != null) {
            try (PreparedStatement statement = connection.prepareStatement("UPDATE items SET name = ?, created = ? WHERE items.id = ?")) {
                statement.setString(1, item.getName());
                statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
                statement.setInt(3, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return oldItem != null;
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM items WHERE id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> findAll() {
        ArrayList<Item> all = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM items;", Statement.RETURN_GENERATED_KEYS)) {
            statement.execute();
            try (ResultSet selectFromItems = statement.executeQuery()) {
                while (selectFromItems.next()) {
                    all.add(new Item(selectFromItems.getInt(1),
                            selectFromItems.getString(2),
                            selectFromItems.getTimestamp(3).toLocalDateTime()));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return all;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> all = findAll();
        List<Item> list = new ArrayList<>();
        for (Item item : all) {
            if (key.equals(item.getName())) {
                list.add(item);
            }
        }
        return list;
    }

    @Override
    public Item findById(int id) {
        List<Item> all = findAll();
        for (Item item : all) {
            if (id == item.getId()) {
                return item;
            }
        }
        return null;
    }
}
