package DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DB_acces {

    public DB_acces() {
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

    public void addStudent() throws SQLException {
        System.out.println("=====>Dodawanie uczniów<====");

        System.out.println("Podaj imie: ");
        String name = inputString();

//        String name = student.setName(inputString());

        //TODO zapytac czy tu mozna zrobic set name i potem dopiero wyslac zapytanie do bazy tak jak powyzej i jak uzyc tu listy z obiekatmi i czy jest sens
        System.out.print("Podaj nazwisko: ");
        String scndName = inputString();

        System.out.print("Podaj adres albumu: ");
        int albumNumber = inputInt();

        try (Connection connection = getConnection()) {
            String sqlQuery = "INSERT INTO students (name, secondname, album) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            {

                statement.setString(1, name);
                statement.setString(2, scndName);
                statement.setInt(3, albumNumber);
                statement.executeUpdate();
                System.out.println("Record created successfully");

                statement.close();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean removeStudent(String itemToRemove, String itemToRemove2) throws SQLException {

        boolean removed = false;


        try (Connection connection = getConnection()) {
            String sqlQuery = "DELETE FROM students WHERE name = ? AND secondname = ?";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);

            statement.setString(1, itemToRemove);
            statement.setString(2, itemToRemove2);
            statement.executeUpdate();

            System.out.println("DB.Student został usunięty");

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return removed;
    }

    public boolean removeStudent(int itemToRemove) throws SQLException {

        boolean removed = false;
        try (Connection connection = getConnection()) {
            String sqlQuery = "DELETE FROM students WHERE album = ?";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);

            statement.setInt(1, itemToRemove);
            statement.executeUpdate();

            System.out.println("DB.Student został usunięty");

        } catch (SQLException e) {
            e.printStackTrace();
        }
//        for(int j = 0; j < list.size(); j++){
//            if(list.get(j).getAlbumNumber() == (itemToRemove)){
//                list.remove(j);
//                removed = true;
//            }
//        }
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

    public void editStudent(int itemToEdit) throws SQLException {
//        System.out.println("Sdfsd");
//        for(int i = 0; i < list.size(); i++) {
//            if(list.get(i).getAlbumNumber() == (itemToEdit)){
//                System.out.print("Podaj nowe imie: ");
//                list.get(i).setName(inputString());
//
//                System.out.print("Podaj nowe nazwisko: ");
//                list.get(i).setScndName(inputString());
//
//                edited = true;
//            }
//        }
        boolean edited = false;
        try (Connection connection = getConnection()) {
            String sqlQuery = "UPDATE students SET name = ?, secondname = ? WHERE album = ?";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);

            System.out.print("Podaj nowe imie: ");
            String name = inputString();
            statement.setString(1, name);

            System.out.print("Podaj nowe nazwisko: ");
            String scndName = inputString();
            statement.setString(2, scndName);

            statement.setInt(3, itemToEdit);

            if (statement.executeUpdate() == 0) {
                throw new SQLException("Nie znaleziono studenta");
            }

            //edited = statement.executeUpdate() >0 ? true: false;

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String inputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int inputInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
