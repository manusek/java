package DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    ArrayList<Student> list = new ArrayList<>();
    Student student = new Student();

    DB_acces db;
    Adding adding;
    Show show;

    public Menu(DB_acces db, Adding add, Show show) throws SQLException {
        this.db = db;
        this.adding = add;
        this.show = show;
    }

    public void menu() throws SQLException {
        while (true) {

            System.out.println(" ");
            System.out.println("Dodaj studenta (1)");
            System.out.println("Usuń studenta (2)");
            System.out.println("Wyswietl studentów (3)");
            System.out.println("Wyswietl studenta po albumie (4)");
            System.out.println("Edytuj studenta (5)");
            System.out.println("Zakończ (6)");
            System.out.print("Jakie działanie chcesz wykonać: ");

            switch (checkInput()) {
                case 1 -> {
                    db.addStudentDB(adding.addStudentLOCAL());
                }

                case 2 -> {
                    System.out.println("Usuwanie po imieniu i nazwisku (1)\nUsuwanie po numerze albumu (2): ");

                    int choice = inputInt();

                    if (choice == 1) {
                        db.removeStudentName(adding.removeStudentNameLOCAL());
                    } else {
                        db.removeStudentID(adding.removeStudentIDLOCAL());
                    }
                }

                case 3 -> {
                    show.showStudentsLOCAL(db.showStudents());
                }

//                case 4 -> {
//                    try {
//                        System.out.println(" ");
//                        System.out.print("Podaj numer albumu:  ");
//
//                        int number = inputInt();
//
//                        if (!db.showStudentsByAlbumNumber(number)) ;
//                        throw new NumberFormatException("Nie istnieje student o podanym numerze albumu");
//                    } catch (NumberFormatException e) {
//                        System.out.println(e.getMessage());
//                    }
//
//                }

                case 5 -> {
                    db.editStudent(adding.editStudentLOCAL());
                }

                case 6 -> {
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