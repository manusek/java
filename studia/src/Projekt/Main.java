package Projekt;

import java.util.Scanner;

public class Main {

        public static void main(String[] args) {

             ZarzadzajBazaDanych.utworzBazeDanych();

             Scanner inputInt = new Scanner(System.in);

             while(true){
                 System.out.println("1 Samochod");
                 System.out.println("2 Mieszkanie");
                 System.out.println("3 Zwierzę");
                 System.out.println("4 Zakoncz");
                 System.out.print("Wybierz typ: ");
                 int choice = inputInt.nextInt();
                 switch (choice){
                     case 1:
                         MenuSamochod.wyswietlMenu();
                         break;
                     case 2:
                         MenuMieszkanie.wyswietlMenu();
                         break;
                     case 3:
                         MenuZwierze.wyswietlMenu();
                         break;
                     case 4:
                         System.exit(0);
                     default:
                         System.out.println("Wpisz poprawny wynik.");
                 }
             }
        }
    }

