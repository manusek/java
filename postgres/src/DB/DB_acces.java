package DB;

import java.sql.*;
import java.util.ArrayList;

public class DB_acces {

    private static DB_acces dbAcces;

    public DB_acces() {
    }

    public static DB_acces getInstance() {
        if (dbAcces == null) {
            dbAcces = new DB_acces();
        }
        return dbAcces;
    }

    static String jdbcUrl = "jdbc:postgresql://127.0.0.1:5432/javaTest";
    static String username = "postgres";
    static String password = "admin";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl, username, password);
    }

    ArrayList<Student> list = new ArrayList<>();
    Student student = new Student();

    //TODO przywrocic uzywanie studenta

    public void addStudentDB(Student std) throws SQLException {
        try (Connection connection = getConnection()) {
            String sqlQuery = "INSERT INTO students (name, secondname, album) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            {

                statement.setString(1, std.getName());
                statement.setString(2, std.getScndName());
                statement.setLong(3, std.getAlbumNumber());
                statement.executeUpdate();
                System.out.println("Record created successfully");

                statement.close();
                connection.close();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeStudentName(Student std) throws SQLException {

        try (Connection connection = getConnection()) {

            String sqlQuery = "DELETE FROM students WHERE name = ? AND secondname = ?";

            PreparedStatement statement = connection.prepareStatement(sqlQuery);

            statement.setString(1, std.getName());
            statement.setString(2, std.getScndName());

            //statement.executeUpdate();
            //TODO zapytac czemu program dziala bez statement.executeUpdate i czy to ma zwiazek ze jest on w ifie ponizej
            //TODO bo inaczej wali bledem nawet jak wprowadzone dane sa prawidlowe
            if (statement.executeUpdate() != 0){
                System.out.println("Student został usunięty");
            }else {
                throw new SQLException("Nie znaleziono studenta");
            }

            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean removeStudentID(Student std2) throws SQLException {
        boolean removed = false;

        try (Connection connection = getConnection()) {
            String sqlQuery = "DELETE FROM students WHERE album = ?";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);

            statement.setLong(1, std2.getAlbumNumber());
            statement.executeUpdate();

            System.out.println("DB.Student został usunięty");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return removed;
    }

    public boolean showStudentsByAlbumNumber(int itemToShow) {
        boolean show = false;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAlbumNumber() == itemToShow)
                System.out.println("Imie: " + list.get(i).getName() + ", " + "Nazwisko: " + list.get(i).getScndName());
        }
        return show;
    }

    void showStudents() throws SQLException {
//        System.out.println(" ");
//        for(int i = 0; i < list.size(); i++){
//            System.out.println(list.get(i));
//        }
        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
        Statement statement = connection.createStatement();
        String sqlQuery = "SELECT * FROM students";
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        while (resultSet.next()) {

            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String secondname = resultSet.getString("secondname");
            int album = resultSet.getInt("album");

            System.out.println("ID: " + id + ", Name: " + name + ", Second Name: " + secondname + ", Ablum number: " + album);
        }

        resultSet.close();
        statement.close();
        connection.close();
    }

    public boolean showStudentsByAlbumNumber2(int itemToShow) {

        boolean show2 = false;
        ArrayList<Student> list2 = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAlbumNumber() > itemToShow) {
                list2.add(list.get(i));
            }
        }

        for (int j = 0; j < list2.size(); j++) {
            System.out.println(list2.get(j));
        }
        return show2;
    }

    public void editStudent(Student std) throws SQLException {

        try (Connection connection = getConnection()) {

            String sqlQuery = "UPDATE students SET name = ?, secondname = ? WHERE album = ?";

            PreparedStatement statement = connection.prepareStatement(sqlQuery);

            statement.setString(1, std.getName());
            statement.setString(2, std.getScndName());
            statement.setLong(3, std.getAlbumNumber());

            if (statement.executeUpdate() != 0) {
                System.out.println("Student został edytowany");
            }else {
                throw new SQLException("Nie znaleziono studenta");
            }
            statement.close();
            connection.close();

            //edited = statement.executeUpdate() >0 ? true: false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


