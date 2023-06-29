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
        String sql = "CREATE TABLE IF NOT EXISTS cars (id INTEGER PRIMARY KEY, name TEXT, description TEXT,price INTEGER, carMileage INTEGER, yearOfProduction INTEGER)";
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
    }

    private static void createAnimalsTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS animals (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, description TEXT, cena INTEGER, gatunek TEXT, wiek INTEGER)";
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
    }

    private static void createHouseTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS house (id INTEGER PRIMARY KEY, name TEXT, description TEXT, cena INTEGER, pietro INTEGER, wielkosc INTEGER)";
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
    }

    public static List<OgloszenieSamochod> readCarsTable() {
        List<OgloszenieSamochod> carList = new ArrayList<>();

        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(DB_URL);

            String sql = "SELECT * FROM cars";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                OgloszenieSamochod car = new OgloszenieSamochod();
                car.setId(resultSet.getInt("id"));
                car.setTitle(resultSet.getString("name"));
                car.setDescription(resultSet.getString("description"));
                car.setPrice(resultSet.getInt("price"));
                car.setCarMileage(resultSet.getInt("carMileage"));
                car.setYearOfProduction(resultSet.getInt("yearOfProduction"));

                carList.add(car);
            }

            resultSet.close();
            statement.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carList;
    }

    public static List<OgloszenieMieszkanie> readHouseTable() {
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
                int cena = resultSet.getInt("cena");
                int pietro = resultSet.getInt("pietro");
                int wielkosc = resultSet.getInt("wielkosc");

                OgloszenieMieszkanie dom = new OgloszenieMieszkanie();
                dom.setId(id);
                dom.setTitle(name);
                dom.setDescription(desc);
                dom.setPrice(cena);
                dom.setFloorNumber(pietro);
                dom.setSurface(wielkosc);

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

    public static List<OgloszenieZwierze> readAnimalsTable() {
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
                int cena = resultSet.getInt("cena");
                String gat = resultSet.getString("gatunek");
                int wiek = resultSet.getInt("wiek");

                OgloszenieZwierze ani = new OgloszenieZwierze();
                ani.setId(id);
                ani.setTitle(name);
                ani.setDescription(desc);
                ani.setPrice(cena);
                ani.setSpeciesOfAnimal(gat);
                ani.setAge(wiek);

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

    public static void saveCarsTable(List<OgloszenieSamochod> szamochodList) {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(DB_URL);

            String sql = "DELETE FROM cars";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();

            for(OgloszenieSamochod samochod : szamochodList){

                sql = "INSERT INTO cars (id, name, description, price, carMileage, yearOfProduction) VALUES (?, ?, ?, ?, ?, ?)";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, samochod.getId());
                preparedStatement.setString(2, samochod.getTitle());
                preparedStatement.setString(3, samochod.getDescription());
                preparedStatement.setInt(4, samochod.getPrice());
                preparedStatement.setInt(5, samochod.getCarMileage());
                preparedStatement.setInt(6, samochod.getYearOfProduction());
                preparedStatement.executeUpdate();
            }

            preparedStatement.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveHouseTable(List<OgloszenieMieszkanie> mieszkanieList) {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(DB_URL);

            String sql = "DELETE FROM house";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();

            for(OgloszenieMieszkanie mieszkanie : mieszkanieList){

                sql = "INSERT INTO house (id, name, description, cena, pietro, wielkosc) VALUES (?, ?, ?, ?, ?, ?)";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, mieszkanie.getId());
                preparedStatement.setString(2, mieszkanie.getTitle());
                preparedStatement.setString(3, mieszkanie.getDescription());
                preparedStatement.setInt(4, mieszkanie.getPrice());
                preparedStatement.setInt(5, mieszkanie.getFloorNumber());
                preparedStatement.setInt(6, mieszkanie.getSurface());
                preparedStatement.executeUpdate();
            }

            preparedStatement.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveAnimalsTable(List<OgloszenieZwierze> zwierzeList) {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(DB_URL);

            String sql = "DELETE FROM animals";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();

            for(OgloszenieZwierze zwierze : zwierzeList){

                sql = "INSERT INTO animals (id, name, description, cena, gatunek , wiek) VALUES (?, ?, ?, ?, ?, ?)";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, zwierze.getId());
                preparedStatement.setString(2, zwierze.getTitle());
                preparedStatement.setString(3, zwierze.getDescription());
                preparedStatement.setInt(4, zwierze.getPrice());
                preparedStatement.setString(5, zwierze.getSpeciesOfAnimal());
                preparedStatement.setInt(6, zwierze.getAge());
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
