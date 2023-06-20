package Projekt;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ZarzadzajBazaDanych {

    private static String dbName = "myDb.db";
    private static final String DB_URL = "jdbc:sqlite:myDb.db";

    public static void utworzBazeDanych() {
        File f = new File(dbName);
        if (!f.exists()) {
            Connection connection = null;
            try {
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection(DB_URL);

                System.out.println("Connected to the database");

                // Create a table if it doesn't exist
                createCarsTable(connection);
                createAnimalsTable(connection);
                createHouseTable(connection);

                connection.close();
                System.out.println("Disconnected from the database");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    private static void createCarsTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS cars (id INTEGER PRIMARY KEY, name TEXT, description TEXT)";
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
    }

    private static void createAnimalsTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS cars (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, position TEXT)";
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
    }

    private static void createHouseTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS cars (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, position TEXT)";
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
    }

    public static List<OgloszenieSamochod> odczytajSamochodOgloszenia() {
        List<OgloszenieSamochod> szamochodList = new ArrayList<>();

        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(DB_URL);

            String sql = "SELECT * FROM cars";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String desc = resultSet.getString("description");

                OgloszenieSamochod sam = new OgloszenieSamochod();
                sam.setId(id);
                sam.setTitle(name);
                sam.setTresc(desc);

                szamochodList.add(sam);
            }

            resultSet.close();
            statement.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return szamochodList;
    }

    public static List<OgloszenieSamochod> odczytajMieszkanieOgloszenia() {
        return null;
    }

    public static List<OgloszenieSamochod> odczytajZwierzetaOgloszenia() {
        return null;
    }

    public static void zapiszSamochodOgloszenia(List<OgloszenieSamochod> szamochodList) {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(DB_URL);

            String sql = "DELETE FROM cars";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();

            for(OgloszenieSamochod samochod : szamochodList){

                sql = "INSERT INTO cars (id, name, description) VALUES (?, ?, ?)";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, samochod.getId());
                preparedStatement.setString(2, samochod.getTitle());
                preparedStatement.setString(3, samochod.getTresc());
                preparedStatement.executeUpdate();
            }

            preparedStatement.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
