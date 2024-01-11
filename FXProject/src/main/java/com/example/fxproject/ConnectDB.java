package com.example.fxproject;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ConnectDB {
    static String jdbcUrl = "jdbc:postgresql://localhost:5432/peoples";
    static String username = "postgres";
    static String password = "admin";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl, username, password);
    }

    public static ObservableList<Student> getDatausers(){

        ObservableList<Student> list = FXCollections.observableArrayList();

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM students");
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()){
                list.add(new Student(Integer.parseInt(rs.getString("id")), rs.getString("name"), rs.getString("scndname"), rs.getString("city"), Integer.parseInt(rs.getString("albumnumber")), rs.getDate("datenumber")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
