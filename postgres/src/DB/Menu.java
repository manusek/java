package DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    ArrayList<Student> list = new ArrayList<>();
    Student student = new Student();

    DB_acces db = new DB_acces();

    //TODO przywrocic uzywanie studenta i ogarnac case
    public Menu() throws SQLException {
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
                    db.addStudent();
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

                            if (!db.removeStudent(nameToDelete, scndNameToDelete)) {
                                DeleteStudentException dse = new DeleteStudentException("Nie znaleziono studenta o danym imieniu i nazwisku");
                                throw dse;
                            }

                        } else {
                            System.out.println("Podaj numer albumu ucznia do usuniecia");
                            int albumNumberToDelete = inputInt();

                            if (!db.removeStudent(albumNumberToDelete)) {
                                throw new DeleteStudentException("Nie znaleziono studenta o danym numerze albumu");
                            }
                        }
                    } catch (DeleteStudentException e) {
                        System.out.println(e.getMessage());
                    }
                }

                case 3 -> {
                    db.showStudents();
                }

                case 4 -> {
                    try {
                        System.out.println(" ");
                        System.out.print("Podaj numer albumu:  ");

                        int number = inputInt();

                        if (!db.showStudentsByAlbumNumber(number)) ;
                        throw new NumberFormatException("Nie istnieje student o podanym numerze albumu");
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    }

                }

                case 5 -> {
                    try {
                        System.out.println(" ");
                        System.out.print("Podaj numer albumu: ");

                        int number = inputInt();

                        if (!db.showStudentsByAlbumNumber2(number))
                            throw new DeleteStudentException("Nie znaleziono studentow o podanym numerze albumu");
                    } catch (DeleteStudentException e) {
                        System.out.println(e.getMessage());
                    }
                }

                case 6 -> {
                    System.out.println(" ");
                    System.out.println("Podaj numer albumu studenta którego chcesz edytowac: ");
                    int itemToEdit = inputInt();
                    db.editStudent(itemToEdit);
                }

                case 7 -> {
                    close();
                }
            }
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