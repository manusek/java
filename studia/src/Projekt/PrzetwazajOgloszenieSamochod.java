package Projekt;

import java.util.List;
import java.util.Scanner;


public class PrzetwazajOgloszenieSamochod {

    List<OgloszenieSamochod> samochodList = ZarzadzajBazaDanych.odczytajSamochodOgloszenia();

    //private static int nextId = 1;

    public void dodajOgloszenie() {
        System.out.println("=== Dodaj ogłoszenie ===");
        OgloszenieSamochod samochod = new OgloszenieSamochod();
        System.out.print("Wpisz tytuł: ");
        samochod.setTitle(InputS());

        System.out.print("Wpisz treść: ");
        samochod.setTresc(InputS());

        System.out.print("Podaj cene: ");
        samochod.setPrice(Input());

        System.out.print("Podaj przebieg: ");
        samochod.setPrzebieg(Input());

        System.out.print("Podaj rok produkcji: ");
        samochod.setRokProdukcji(Input());

        samochod.setId(samochodList.size() + 1);

        samochodList.add(samochod);

        System.out.println("Ogłoszenie zostało dodane.");
    }

    public void wyswietlOgloszenie() {
        System.out.println("=== Wyświetl ogłoszenie ===");
        System.out.print("Podaj ID ogłoszenia: ");
        int carId = Input();

        OgloszenieSamochod auto = findCarById(carId);
        if (auto != null) {
            System.out.println("ID: " + auto.getId());
            System.out.println("Tytuł: " + auto.getTitle());
            System.out.println("Tresc: " + auto.getTresc());
            System.out.println("Cena: " + auto.getPrice());
            System.out.println("Przebieg: " + auto.getPrzebieg());
            System.out.println("Rok produkcji: " + auto.getRokProdukcji());
        } else {
            System.out.println("Nie znaleziono ogłoszenia.");
        }
    }

    public void wyswietlWszystkieOgloszenia() {
        System.out.println("=== Wyświetl ogłoszenie ===");
        System.out.println("Lista ogłoszen ");
        System.out.println("-----------------------");

        for (OgloszenieSamochod auto : samochodList) {
                System.out.println("ID: " + auto.getId());
                System.out.println("Tytuł: " + auto.getTitle());
                System.out.println("Tresc: " + auto.getTresc());
                System.out.println("Cena: " + auto.getPrice());
                System.out.println("Przebieg: " + auto.getPrzebieg());
                System.out.println("Rok produkcji : " + auto.getRokProdukcji());
                System.out.println("-----------------------");
        }
    }


    public void edytujOgloszenie() {
        System.out.println("=== Edytuj ogłoszenia ===");
        System.out.print("Podaj ID ogłoszenia: ");
        int samochodID = Input();

        OgloszenieSamochod samochod = findCarById(samochodID);
        if (samochod != null) {
            System.out.print("Wpisz nowy tytuł: ");
            samochod.setTitle(InputS());

            System.out.print("Wpisz nową treść: ");
            samochod.setTresc(InputS());

            System.out.print("Podaj nową cene: ");
            samochod.setPrice(Input());

            System.out.print("Podaj nowy przebieg: ");
            samochod.setPrzebieg(Input());

            System.out.print("Podaj nowy rok produkcji: ");
            samochod.setRokProdukcji(Input());

            System.out.println("Ogłoszenie zostało zaaktualizowane.");
        } else {
            System.out.println("Nie znaleziono ogłoszenia.");
        }
    }

    public void usunOgloszenie() {
        System.out.println("=== Usuń ogłoszenie ===");
        System.out.print("Podaj ID ogłoszenia: ");
        int bookId = Input();

        OgloszenieSamochod samochod = findCarById(bookId);
        if (samochod != null) {
            samochodList.remove(samochod);
            System.out.println("Ogłoszenie zostało usunięte.");
        } else {
            System.out.println("Nie znaleziono ogłoszenia.");
        }
    }

    public OgloszenieSamochod findCarById(int id) {
        for (OgloszenieSamochod samochod : samochodList) {
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
      ZarzadzajBazaDanych.zapiszSamochodOgloszenia(samochodList);
    }
}
