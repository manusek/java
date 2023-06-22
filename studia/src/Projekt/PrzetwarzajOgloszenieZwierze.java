package Projekt;

import java.util.List;
import java.util.Scanner;

public class PrzetwarzajOgloszenieZwierze {
    List<OgloszenieZwierze> zwierzeList = ZarzadzajBazaDanych.odczytajZwierzetaOgloszenia();

    //private static int nextId = 1;

    public void dodajOgloszenie() {
        System.out.println("=== Dodaj ogłoszenie ===");
        OgloszenieZwierze zwierze = new OgloszenieZwierze();
        System.out.print("Wpisz tytuł: ");
        zwierze.setTitle(InputS());

        System.out.print("Wpisz treść: ");
        zwierze.setTresc(InputS());

        System.out.print("Podaj cene: ");
        zwierze.setPrice(Input());

        System.out.print("Podaj gatunek: ");
        zwierze.setGatunek(InputS());

        System.out.print("Podaj rok wiek: ");
        zwierze.setWiek(Input());

        zwierze.setId(zwierzeList.size() + 1);

        zwierzeList.add(zwierze);

        System.out.println("Ogłoszenie zostało dodane.");
    }

    public void wyswietlOgloszenie() {
        System.out.println("=== Wyświetl ogłoszenie ===");
        System.out.print("Podaj ID ogłoszenia: ");
        int animalID = Input();

        OgloszenieZwierze animall = findZwierzeById(animalID);
        if (animall != null) {
            System.out.println("ID: " + animall.getId());
            System.out.println("Tytuł: " + animall.getTitle());
            System.out.println("Tresc: " + animall.getTresc());
            System.out.println("Cena: " + animall.getPrice());
            System.out.println("Gatunek: " + animall.getGatunek());
            System.out.println("Wiek: " + animall.getWiek());
        } else {
            System.out.println("Nie znaleziono ogłoszenia.");
        }
    }

    public void wyswietlWszystkieOgloszenia() {
        System.out.println("=== Wyświetl ogłoszenie ===");
        System.out.println("Lista ogłoszen ");
        System.out.println("-----------------------");

        for (OgloszenieZwierze animal : zwierzeList) {
            System.out.println("ID: " + animal.getId());
            System.out.println("Tytuł: " + animal.getTitle());
            System.out.println("Tresc: " + animal.getTresc());
            System.out.println("Cena: " + animal.getPrice());
            System.out.println("Gatunek: " + animal.getGatunek());
            System.out.println("Wiek: " + animal.getWiek());
            System.out.println("-----------------------");
        }
    }


    public void edytujOgloszenie() {
        System.out.println("=== Edytuj ogłoszenia ===");
        System.out.print("Podaj ID ogłoszenia: ");
        int zwierzeID = Input();

        OgloszenieZwierze animal = findZwierzeById(zwierzeID);
        if (animal != null) {
            System.out.print("Wpisz nowy tytuł: ");
            animal.setTitle(InputS());

            System.out.print("Wpisz nową treść: ");
            animal.setTresc(InputS());

            System.out.print("Podaj nową cene: ");
            animal.setPrice(Input());

            System.out.print("Podaj nowy gatunek: ");
            animal.setGatunek(InputS());

            System.out.print("Podaj nowy wiek: ");
            animal.setWiek(Input());

            System.out.println("Ogłoszenie zostało zaaktualizowane.");
        } else {
            System.out.println("Nie znaleziono ogłoszenia.");
        }
    }

    public void usunOgloszenie() {
        System.out.println("=== Usuń ogłoszenie ===");
        System.out.print("Podaj ID ogłoszenia: ");
        int zwierzeID = Input();

        OgloszenieZwierze animal = findZwierzeById(zwierzeID);
        if (animal != null) {
            zwierzeList.remove(animal);
            System.out.println("Ogłoszenie zostało usunięte.");
        } else {
            System.out.println("Nie znaleziono ogłoszenia.");
        }
    }

    public OgloszenieZwierze findZwierzeById(int id) {
        for (OgloszenieZwierze animal : zwierzeList) {
            if (animal.getId() == id) {
                return animal;
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
        ZarzadzajBazaDanych.zapiszZwierzetaOgloszenia(zwierzeList);
    }
}


