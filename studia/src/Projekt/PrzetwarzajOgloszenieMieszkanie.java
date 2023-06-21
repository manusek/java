package Projekt;

import java.util.List;
import java.util.Scanner;

public class PrzetwarzajOgloszenieMieszkanie {


        List<OgloszenieMieszkanie> mieszkanieList = ZarzadzajBazaDanych.odczytajMieszkanieOgloszenia();

        //private static int nextId = 1;

        public void dodajOgloszenie() {
            System.out.println("=== Dodaj ogłoszenie ===");
            OgloszenieMieszkanie mieszkanie = new OgloszenieMieszkanie();
            System.out.print("Wpisz tytuł: ");
            mieszkanie.setTitle(InputS());

            System.out.print("Wpisz treść: ");
            mieszkanie.setTresc(InputS());

            System.out.print("Podaj cene: ");
            mieszkanie.setPrice(Input());

            System.out.print("Podaj wielkosc: ");
            mieszkanie.setWielkosc(Input());

            System.out.print("Podaj pietro: ");
            mieszkanie.setPietro(Input());

            mieszkanie.setId(mieszkanieList.size() + 1);

            mieszkanieList.add(mieszkanie);

            System.out.println("Ogłoszenie zostało dodane.");
        }

        public void wyswietlOgloszenie() {
            System.out.println("=== Wyświetl ogłoszenie ===");
            System.out.print("Podaj ID ogłoszenia: ");
            int mieszkanieID = Input();

            OgloszenieMieszkanie mieszkanie = findMieszkanieById(mieszkanieID);
            if (mieszkanie != null) {
                System.out.println("ID: " + mieszkanie.getId());
                System.out.println("Tytuł: " + mieszkanie.getTitle());
                System.out.println("Tresc: " + mieszkanie.getTresc());
                System.out.println("Cena: " + mieszkanie.getPrice());
                System.out.println("Pietro: " + mieszkanie.getPietro());
                System.out.println("Wielkosc[m^2]: " + mieszkanie.getWielkosc());
            } else {
                System.out.println("Nie znaleziono ogłoszenia.");
            }
        }

        public void wyswietlWszystkieOgloszenia() {
            System.out.println("=== Wyświetl ogłoszenie ===");
            System.out.println("Lista ogłoszen ");
            System.out.println("-----------------------");

            for (OgloszenieMieszkanie mieszkanie : mieszkanieList) {
                System.out.println("ID: " + mieszkanie.getId());
                System.out.println("Tytuł: " + mieszkanie.getTitle());
                System.out.println("Tresc: " + mieszkanie.getTresc());
                System.out.println("Cena: " + mieszkanie.getPrice());
                System.out.println("Pietro: " + mieszkanie.getPietro());
                System.out.println("Wielkosc[m^2] : " + mieszkanie.getWielkosc());
                System.out.println("-----------------------");
            }
        }


        public void edytujOgloszenie() {
            System.out.println("=== Edytuj ogłoszenia ===");
            System.out.print("Podaj ID ogłoszenia: ");
            int mieszkanieID = Input();

            OgloszenieMieszkanie mieszkanie = findMieszkanieById(mieszkanieID);
            if (mieszkanie != null) {
                System.out.print("Wpisz nowy tytuł: ");
                mieszkanie.setTitle(InputS());

                System.out.print("Wpisz nową treść: ");
                mieszkanie.setTresc(InputS());

                System.out.print("Podaj nową cene: ");
                mieszkanie.setPrice(Input());

                System.out.print("Podaj nowe pietro: ");
                mieszkanie.setPietro(Input());

                System.out.print("Podaj nową wielkosc: ");
                mieszkanie.setWielkosc(Input());

                System.out.println("Ogłoszenie zostało zaaktualizowane.");
            } else {
                System.out.println("Nie znaleziono ogłoszenia.");
            }
        }

        public void usunOgloszenie() {
            System.out.println("=== Usuń ogłoszenie ===");
            System.out.print("Podaj ID ogłoszenia: ");
            int mieszkanieID = Input();

            OgloszenieMieszkanie mieszkanie = findMieszkanieById(mieszkanieID);
            if (mieszkanie != null) {
                mieszkanieList.remove(mieszkanie);
                System.out.println("Ogłoszenie zostało usunięte.");
            } else {
                System.out.println("Nie znaleziono ogłoszenia.");
            }
        }

        public OgloszenieMieszkanie findMieszkanieById(int id) {
            for (OgloszenieMieszkanie mieszkanie : mieszkanieList) {
                if (mieszkanie.getId() == id) {
                    return mieszkanie;
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
            ZarzadzajBazaDanych.zapiszMieszkanieOgloszenia(mieszkanieList);
        }
    }

