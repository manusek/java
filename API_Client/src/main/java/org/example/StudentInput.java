package org.example;

import javax.xml.namespace.QName;
import java.util.Scanner;

public class StudentInput {

    public StudentDTO add(){
        System.out.print("Podaj imie studenta: ");
        String name = inputString();

        System.out.print("Podaj wiek studenta: ");
        int age = inputInt();

        System.out.print("Podaj miasto urodzenia studenta: ");
        String city = inputString();

        return new StudentDTO(name, age, city);
    }

    public String delete(){
        System.out.print("Podaj Id studenta którego chcesz usunąć: ");
        return inputString();
    }

    private int inputInt(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private String inputString(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
