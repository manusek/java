package DB;

import java.util.Scanner;

public class Adding {

    private static Adding adding;

    public static Adding getInstance() {
        if (adding == null) {
            adding = new Adding();
        }
        return adding;
    }

    public Adding() {
    }

//    Student std = new Student();


    public Student addStudentLOCAL() {
        Student std = new Student();

        System.out.println("=====>Dodawanie uczniów<====");

        System.out.println("Podaj imie: ");
        std.setName(inputString());

        System.out.print("Podaj nazwisko: ");
        std.setScndName(inputString());

        System.out.print("Podaj adres albumu: ");
        std.setAlbumNumber(inputInt());

        return std;
    }

    public Student removeStudentNameLOCAL() {
        Student std = new Student();

        System.out.println("Podaj imie: ");
        std.setName(inputString());

        System.out.print("Podaj nazwisko: ");
        std.setScndName(inputString());

        return std;
    }

    public Student removeStudentIDLOCAL() {
        Student std = new Student();

        System.out.print("Podaj adres albumu: ");
        std.setAlbumNumber(inputInt());

        return std;
    }

    public Student editStudentLOCAL() {
        Student std = new Student();

        System.out.println("Podaj nr albumu studenta do edycji");
        std.setAlbumNumber(inputInt());

        System.out.print("Podaj nowe imie: ");
        std.setName(inputString());

        System.out.print("Podaj nowe nazwisko: ");
        std.setScndName(inputString());

        return std;
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
