import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Studenci {

    String jdbcUrl = "jdbc:postgresql://localhost:5432/javaTest";
    String username = "postgres";
    String password = "admin";


    ArrayList<Student> list = new ArrayList<>();
    Student student = new Student();

    public Studenci() throws SQLException {
    }


    public void menu() throws SQLException {
        while (true) {

            System.out.println(" ");
            System.out.println("Dodaj studenta (1)");
            System.out.println("Usuń studenta (2)");
            System.out.println("Wyswietl studentów (3)");
            System.out.println("Wyswietl studenta po albumie (4)");
            System.out.println("Wyswietl studenta po albumie wiekszym niz podany (5)");
            System.out.println("Edytuj studenta (6)");
            System.out.println("Zakończ (7)");
            System.out.print("Jakie działanie chcesz wykonać: ");

            switch (checkInput()) {
                case 1 -> {
                    addStudent();
                }

                case 2 -> {

                    System.out.println(" ");
                    System.out.println("Usuwanie po imieniu i nazwisku (1)\nUsuwanie po numerze albumu (2): ");

                    int choice = inputInt();

                    try {
                        if (choice == 1) {

                            System.out.print("Podaj imie ucznia do usuniecia: ");
                            String nameToDelete = inputString();

                            System.out.print("Podaj nazwisko ucznia do usuniecia: ");
                            String scndNameToDelete = inputString();

                            if (!removeStudent(nameToDelete, scndNameToDelete)) {
                                DeleteStudentException dse = new DeleteStudentException("Nie znaleziono studenta o danym imieniu i nazwisku");
                                throw dse;
                            }

                        } else {
                            System.out.println("Podaj numer albumu ucznia do usuniecia");
                            int albumNumberToDelete = inputInt();

                            if (!removeStudent(albumNumberToDelete)) {
                                throw new DeleteStudentException("Nie znaleziono studenta o danym numerze albumu");
                            }
                        }
                    } catch (DeleteStudentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                case 3 -> {
                    showStudents();
                    break;
                }

                case 4 -> {
                    try {
                        System.out.println(" ");
                        System.out.print("Podaj numer albumu:  ");

                        int number = inputInt();

                        if (!showStudentsByAlbumNumber(number)) ;
                        throw new NumberFormatException("Nie istnieje student o podanym numerze albumu");
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                }

                case 5 -> {
                    try {
                        System.out.println(" ");
                        System.out.print("Podaj numer albumu: ");

                        int number = inputInt();

                        if (!showStudentsByAlbumNumber2(number))
                            throw new DeleteStudentException("Nie znaleziono studentow o podanym numerze albumu");
                    } catch (DeleteStudentException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                }

                case 6 -> {
                    try {
                        System.out.println(" ");
                        System.out.println("Podaj numer albumu studenta którego chcesz edytowac: ");
                        int itemToEdit = inputInt();
                        if (!editStudent(itemToEdit)) ;
                        throw new DeleteStudentException("Nie znaleziono studenta");
                    } catch (DeleteStudentException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                }

                case 7 -> {
                    close();

                    break;
                }
            }

        }
    }

    public void addStudent() throws SQLException {
        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
        Statement statement = connection.createStatement();

        System.out.println("=====>Dodawanie uczniów<====");

        System.out.println("Podaj imie: ");
        String name = inputString();

        System.out.print("Podaj nazwisko: ");
        String scndName = inputString();

        System.out.print("Podaj adres albumu: ");
        int albumNumber = inputInt();

        list.add(new Student(name, scndName, albumNumber));

        String sqlQuery = "INSERT INTO students(name, secondname, album) VALUES(?, ?, ?)";


        ResultSet resultSet = statement.executeQuery(sqlQuery);

        statement.close();
        resultSet.close();
        connection.close();
    }

    public boolean removeStudent(String itemToRemove, String itemToRemove2) throws SQLException {

        boolean removed = false;

        for (int j = 0; j < list.size(); j++) {
            if (list.get(j).getName().equals(itemToRemove) && list.get(j).getScndName().equals(itemToRemove2)) {
                list.remove(j);
                removed = true;
            }
        }

        System.out.println("Uczeń został usunięty");

        showStudents();

        return removed;
    }

    public boolean removeStudent(int itemToRemove) throws SQLException {

        boolean removed = false;

        for (int j = 0; j < list.size(); j++) {
            if (list.get(j).getAlbumNumber() == (itemToRemove)) {
                list.remove(j);
                removed = true;
            }
        }

        System.out.println("Uczeń został usunięty");
        showStudents();

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

    public boolean editStudent(int itemToEdit) {
        boolean edited = false;

        System.out.println("Sdfsd");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAlbumNumber() == (itemToEdit)) {
                System.out.print("Podaj nowe imie: ");
                list.get(i).setName(inputString());

                System.out.print("Podaj nowe nazwisko: ");
                list.get(i).setScndName(inputString());

                edited = true;
            }
        }
        return edited;
    }

    public String inputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int inputInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void close() {
        System.out.println("Dziekujemy :)");
        System.exit(0);
    }

    public int checkInput() {
        boolean checkInput = false;
        int number = 0;
        String choice2;

        while (checkInput == false) {
            choice2 = inputString();
            try {
                number = Integer.parseInt(choice2);
                checkInput = true;
            } catch (NumberFormatException e) {
                System.out.print("Podano niewłaściwy typ! ");
            }
        }
        return number;
    }

}

