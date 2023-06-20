package Projekt;
import lab07_wstepInterfejsy.Samochod;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PrzetwazajOgloszenieSamochod {

    List<OgloszenieSamochod> szamochodList = ZarzadzajBazaDanych.odczytajSamochodOgloszenia();

    private static int nextId = 1;

    public void dodajOgloszenie() {
        System.out.println("=== Dodaj ogłoszenie ===");
        OgloszenieSamochod samochod = new OgloszenieSamochod();
        System.out.print("Wpisz tytuł: ");
        samochod.setTitle(InputS());

        System.out.print("Wpisz treść: ");
        samochod.setTresc(InputS());

        System.out.print("Podaj cene: ");
        samochod.setPrice(Input());

        samochod.setId(szamochodList.size() + 1);

        szamochodList.add(samochod);

        System.out.println("Book created successfully.");
    }

    public void wyswietlOgloszenie() {
        System.out.println("=== Wyświetl ogłoszenie ===");
        System.out.print("Podaj ID ogłoszenia: ");
        int bookId = Input();

        OgloszenieSamochod book = findBookById(bookId);
        if (book != null) {
            System.out.println("ID: " + book.getId());
            System.out.println("Tytuł: " + book.getTitle());
            System.out.println("Tresc: " + book.getTresc());
            System.out.println("Cena: " + book.getPrice());
        } else {
            System.out.println("Nie znaleziono ogłoszenia.");
        }
    }

    public void wyswietlWszystkieOgloszenia() {
        System.out.println("=== Wyświetl ogłoszenie ===");
        System.out.println("Lista ogłoszen ");
        System.out.println("-----------------------");

        for (OgloszenieSamochod book : szamochodList) {
                System.out.println("ID: " + book.getId());
                System.out.println("Tytuł: " + book.getTitle());
                System.out.println("Tresc: " + book.getTresc());
                System.out.println("Cena: " + book.getPrice());
                System.out.println("-----------------------");
        }
    }


    public void edytujOgloszenie() {
        System.out.println("=== Edytuj ogłoszenia ===");
        System.out.print("Podaj ID ogłoszenia: ");
        int bookId = Input();

        OgloszenieSamochod samochod = findBookById(bookId);
        if (samochod != null) {
            System.out.print("Wpisz nowy tytuł: ");
            samochod.setTitle(InputS());

            System.out.print("Wpisz nową treść: ");
            samochod.setTresc(InputS());

            System.out.print("Podaj nową cene: ");
            samochod.setPrice(Input());

            System.out.println("Ogłoszenie zostało zaaktualizowane.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void usunOgloszenie() {
        System.out.println("=== Usuń ogłoszenie ===");
        System.out.print("Podaj ID ogłoszenia: ");
        int bookId = Input();

        OgloszenieSamochod samochod = findBookById(bookId);
        if (samochod != null) {
            szamochodList.remove(samochod);
            System.out.println("Ogłoszenie zostało usunięte.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public OgloszenieSamochod findBookById(int id) {
        for (OgloszenieSamochod samochod : szamochodList) {
            if (samochod.getId() == id) {
                return samochod;
            }
        }
        return null;
    }

    public int Input(){
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public String InputS(){
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public void zamknij(){
      ZarzadzajBazaDanych.zapiszSamochodOgloszenia(szamochodList);
    }
}
