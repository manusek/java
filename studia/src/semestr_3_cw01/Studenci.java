package semestr_3_cw01;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Exception;

public class Studenci {
    ArrayList<Student> list = new ArrayList<>();
    Student student = new Student();
    public void menu(){
        while(true){

            System.out.println(" ");
            System.out.println("Dodaj studenta (1)");
            System.out.println("Usuń studenta (2)");
            System.out.println("Wyswietl studentów (3)");
            System.out.println("Wyswietl studenta po albumie (4)");
            System.out.println("Wyswietl studenta po albumie wiekszym niz podany (5)");
            System.out.println("Zakończ (6)");
            System.out.print("Jakie działanie chcesz wykonać: ");

            int a = inputInt();

            switch (a){
                case 1 -> {
                    //throw new RuntimeException("test");
                    addStudent();
                    break;
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

                           if(!removeStudent(albumNumberToDelete)){
                               throw new DeleteStudentException("Nie znaleziono studenta o danym numerze albumu");
                           }
                        }
                    }catch (DeleteStudentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                case 3 -> {
                        showStudents();
                    break;
                }

                case 4 -> {
                        System.out.println(" ");
                        System.out.print("Podaj numer albumu:  ");

                        int number = inputInt();

                        showStudentsByAlbumNumber(number);

                        break;
                }

                case 5 -> {
                    System.out.println(" ");
                    System.out.print("Podaj numer albumu: ");

                    int number = inputInt();

                    showStudentsByAlbumNumber2(number);

                    break;
                }

                case 6 -> {
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

    public boolean removeStudent(String itemToRemove, String itemToRemove2){

        boolean removed = false;
        for(int j = 0; j < list.size(); j++){
            if(list.get(j).getName().equals(itemToRemove) && list.get(j).getScndName().equals(itemToRemove2)){
                list.remove(j);
                removed = true;
            }
        }

        System.out.println("Uczeń został usunięty");

        showStudents();

        return removed;
    }

    public boolean removeStudent(int itemToRemove){

        boolean removed = false;

        for(int j = 0; j < list.size(); j++){
            if(list.get(j).getAlbumNumber() == (itemToRemove)){
                list.remove(j);
                removed = true;
            }
        }

        System.out.println("Uczeń został usunięty");
        showStudents();

        return removed;
    }

    public void showStudentsByAlbumNumber(int itemToShow){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getAlbumNumber() == itemToShow)
                System.out.println("Imie: " + list.get(i).getName() +", " + "Nazwisko: " + list.get(i).getScndName());
        }
    }

    void showStudents(){
        System.out.println(" ");
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }

    public void showStudentsByAlbumNumber2(int itemToShow){
        ArrayList<Student> list2 = new ArrayList<>();

        for(int i = 0; i < list.size(); i++) {
            if (list.get(i).getAlbumNumber() > itemToShow) {
                list2.add(list.get(i));
            }
        }

            for(int j = 0; j < list2.size(); j++){
                System.out.println(list2.get(j));
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

