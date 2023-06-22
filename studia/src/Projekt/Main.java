package Projekt;

import java.util.Scanner;

public class Main {

        public static void main(String[] args) {

            try {
                ZarzadzajBazaDanych.utworzBazeDanych();
                MenuMieszkanie menuMieszkanie = new MenuMieszkanie();
                MenuSamochod menuSamochod = new MenuSamochod();
                MenuZwierze menuZwierze = new MenuZwierze();
                Scanner inputInt = new Scanner(System.in);

                while (true) {
                    System.out.println("1 Samochod");
                    System.out.println("2 Mieszkanie");
                    System.out.println("3 Zwierzę");
                    System.out.println("4 Zakoncz");
                    System.out.print("Wybierz typ: ");
                    int choice = inputInt.nextInt();
                    switch (choice) {
                        case 1:
                            menuSamochod.wyswietlMenu();
                            break;
                        case 2:
                            menuMieszkanie.wyswietlMenu();
                            break;
                        case 3:
                            menuZwierze.wyswietlMenu();
                            break;
                        case 4:
                            System.exit(0);
                        default:
                            throw new Exception("Wpisz poprawny wynik.");
                    }
                }
            }
            catch (Exception e) {
                System.out.println("Wystąpił wyjątek. Opis: "+e.getMessage());
                e.printStackTrace();
            }
        }
    }

