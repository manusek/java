package semestr_3_cw01;

import java.util.ArrayList;
import java.util.Scanner;

public class Studenci {
    ArrayList<Student> list = new ArrayList<>();
    Student student = new Student();
    public void menu(){
        while(true){
            System.out.println(" ");
            System.out.println("Dodaj studenta (1)");
            System.out.println("Usuń studenta (2)");
            System.out.println("Wyswietl studentów (3)");
            System.out.println("Zakończ (4)");
            System.out.print("Jakie działanie chcesz wykonać: ");
            int a = inputInt();

            switch (a){
                case 1 -> {
                    addStudent();
                    break;
                }
                case 2 -> {
                    removeStudent();
                    break;
                }
                case 3 -> {
                    showStudents();
                    break;
                }
                case 4 -> {
                    close();
                    break;
                }
            }

        }
    }

    public void addStudent(){
            System.out.println("=====>Dodawanie uczniów<====");

            System.out.println("Podaj imie: ");
            String name = inputString();

            System.out.print("Podaj nazwisko: ");
            String scndName = inputString();

            System.out.print("Podaj adres albumu: ");
            int albumNumber = inputInt();

            list.add(new Student(name, scndName, albumNumber));
    }

    public void removeStudent(){
        int i = list.size();
        System.out.println(" ");
        System.out.println("Ktorego studenta chcesz usunac(1-"+i+"):");


        //TODO zrobic usuwanie przez imie, nazwisko lub nr albumu (przeciezanie metod)
        //list.remove(number);
        System.out.println("Uczeń został usunięty");
        showStudents();
    }



    void showStudents(){
        System.out.println(" ");
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }

    public String inputString(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int inputInt(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void close(){
        System.out.println("Dziekujemy :)");
        System.exit(0);
    }

}

