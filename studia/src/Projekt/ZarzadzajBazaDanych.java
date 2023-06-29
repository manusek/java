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
        String sql = "CREATE TABLE IF NOT EXISTS cars (id INTEGER PRIMARY KEY, name TEXT, description TEXT,cena INTEGER, przebieg INTEGER, rokProdukcji INTEGER)";
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
    }

    private static void createAnimalsTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS animals (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, description TEXT, gatunek TEXT, wiek INTEGER)";
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
    }

    private static void createHouseTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS house (id INTEGER PRIMARY KEY, name TEXT, description TEXT, pietro INTEGER, wielkosc INTEGER)";
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
    }

    public static List<OgloszenieSamochod> odczytajSamochodOgloszenia() {
        List<OgloszenieSamochod> samochodList = new ArrayList<>();

        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(DB_URL);

            String sql = "SELECT * FROM cars";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                OgloszenieSamochod sam = new OgloszenieSamochod();
                sam.setId(resultSet.getInt("id"));
                sam.setTitle(resultSet.getString("name"));
                sam.setTresc(resultSet.getString("description"));
                sam.setPrice(resultSet.getInt("cena"));
                sam.setPrzebieg(resultSet.getInt("przebieg"));
                sam.setRokProdukcji(resultSet.getInt("rokProdukcji"));

                samochodList.add(sam);
            }

            resultSet.close();
            statement.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return samochodList;
    }

    public static List<OgloszenieMieszkanie> odczytajMieszkanieOgloszenia() {
        List<OgloszenieMieszkanie> mieszkanieList = new ArrayList<>();

        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(DB_URL);

            String sql = "SELECT * FROM house";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String desc = resultSet.getString("description");
                int pietro = resultSet.getInt("pietro");
                int wielkosc = resultSet.getInt("wielkosc");

                OgloszenieMieszkanie dom = new OgloszenieMieszkanie();
                dom.setId(id);
                dom.setTitle(name);
                dom.setTresc(desc);
                dom.setPietro(pietro);
                dom.setWielkosc(wielkosc);

                mieszkanieList.add(dom);
            }

            resultSet.close();
            statement.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mieszkanieList;
    }

    public static List<OgloszenieZwierze> odczytajZwierzetaOgloszenia() {
        List<OgloszenieZwierze> zwierzeList = new ArrayList<>();

        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(DB_URL);

            String sql = "SELECT * FROM animals";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String desc = resultSet.getString("description");
                String gat = resultSet.getString("gatunek");
                int wiek = resultSet.getInt("wiek");

                OgloszenieZwierze ani = new OgloszenieZwierze();
                ani.setId(id);
                ani.setTitle(name);
                ani.setTresc(desc);
                ani.setGatunek(gat);
                ani.setWiek(wiek);

                zwierzeList.add(ani);
            }

            resultSet.close();
            statement.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return zwierzeList;
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

                sql = "INSERT INTO cars (id, name, description, cena, przebieg, rokProdukcji) VALUES (?, ?, ?, ?, ?, ?)";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, samochod.getId());
                preparedStatement.setString(2, samochod.getTitle());
                preparedStatement.setString(3, samochod.getTresc());
                preparedStatement.setInt(4, samochod.getPrice());
                preparedStatement.setInt(5, samochod.getPrzebieg());
                preparedStatement.setInt(6, samochod.getRokProdukcji());
                preparedStatement.executeUpdate();
            }

            preparedStatement.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void zapiszMieszkanieOgloszenia(List<OgloszenieMieszkanie> mieszkanieList) {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(DB_URL);

            String sql = "DELETE FROM house";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();

            for(OgloszenieMieszkanie mieszkanie : mieszkanieList){

                sql = "INSERT INTO house (id, name, description, pietro, wielkosc) VALUES (?, ?, ?, ?, ?)";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, mieszkanie.getId());
                preparedStatement.setString(2, mieszkanie.getTitle());
                preparedStatement.setString(3, mieszkanie.getTresc());
                preparedStatement.setInt(4, mieszkanie.getPietro());
                preparedStatement.setInt(5, mieszkanie.getWielkosc());
                preparedStatement.executeUpdate();
            }

            preparedStatement.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void zapiszZwierzetaOgloszenia(List<OgloszenieZwierze> zwierzeList) {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(DB_URL);

            String sql = "DELETE FROM animals";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();

            for(OgloszenieZwierze zwierze : zwierzeList){

                sql = "INSERT INTO animals (id, name, description, gatunek , wiek) VALUES (?, ?, ?, ?, ?)";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, zwierze.getId());
                preparedStatement.setString(2, zwierze.getTitle());
                preparedStatement.setString(3, zwierze.getTresc());
                preparedStatement.setString(4, zwierze.getGatunek());
                preparedStatement.setInt(5, zwierze.getWiek());
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
