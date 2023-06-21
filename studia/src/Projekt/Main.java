package Projekt;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


        public static void main(String[] args) {

             ZarzadzajBazaDanych.utworzBazeDanych();

             Scanner input = new Scanner(System.in);

             while(true){
                 System.out.println("Wybierz typ: ");
                 System.out.println("1 Samochod");
                 System.out.println("2 Mieszkanie");
                 System.out.println("3 Zakoncz");
                 int wybor2 = input.nextInt();
                 switch (wybor2){
                     case 1:
                         MenuSamochod.wyswietlMenu();
                         break;
                     case 2:
                         MenuMieszkanie.wyswietlMenu();
                         break;
                     case 3:
                         //ogloszenie.edytujOgloszenie();
                         break;
                     case 4:
                         System.exit(0);
                     default:
                         System.out.println("Invalid choice. Please try again.");
                 }
             }
        }
    }

