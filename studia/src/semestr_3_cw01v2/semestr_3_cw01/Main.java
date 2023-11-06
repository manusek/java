package semestr_3_cw01v2.semestr_3_cw01;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
//        String jdbcUrl = "jdbc:postgresql://localhost:5432/test";
//        String username = "postgres";
//        String password = "admin";
//
//        try {
//            // Establish a connection to the PostgreSQL database
//            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
//
//            // Create a statement for executing SQL queries
//            Statement statement = connection.createStatement();
//
//            // Execute a simple query
//            String sqlQuery = "SELECT * FROM your_table_name";
//            ResultSet resultSet = statement.executeQuery(sqlQuery);
//
//            // Process the query result
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                // You can retrieve other columns in a similar way
//                System.out.println("ID: " + id + ", Name: " + name);
//            }
//
//            // Close the resources
//            resultSet.close();
//            statement.close();
//            connection.close();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }





        try {
            Studenci student = new Studenci();
            student.menu();
        }
        catch(Exception e) {
            System.out.println(e.getMessage()+"\n");
            e.printStackTrace();
        };
    }
}
