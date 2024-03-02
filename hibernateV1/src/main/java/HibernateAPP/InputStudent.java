package HibernateAPP;

import java.util.Scanner;

public class InputStudent {
    private static InputStudent inputStudent;

    public static InputStudent getInstance(){
        if (inputStudent == null){
            inputStudent = new InputStudent();
        }
        return inputStudent;
    }

    public Student add(){
        Student student = new Student();

        System.out.println("Podaj imie studenta: ");
        String name = inputString();
        student.setName(name);

        System.out.println("Podaj nazwisko studenta: ");
        String secondName = inputString();
        student.setSecondName(secondName);

        System.out.println("Podaj numer albumu: ");
        int albumNmbr = inputInt();
        student.setAlbumNumber(albumNmbr);

        return student;
    }

    public int showByID(){
        System.out.println("Podaj id studenta: ");
        return inputInt();
    }

    public int delete(){
        System.out.println("Podaj id studenta ktorego chcesz usunac: ");
        return inputInt();
    }

    public String inputString(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int inputInt(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
