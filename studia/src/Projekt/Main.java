package Projekt;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

        public static void main(String[] args) {

                ZarzadzajBazaDanych.utworzBazeDanych();

                MenuMieszkanie houseMenu = new MenuMieszkanie();
                MenuSamochod carMenu = new MenuSamochod();
                MenuZwierze animalMenu = new MenuZwierze();

                Scanner inputInt = new Scanner(System.in);

                while (true) {
                    System.out.println("1 Samochod");
                    System.out.println("2 Mieszkanie");
                    System.out.println("3 Zwierzę");
                    System.out.println("4 Zakoncz");
                    System.out.print("Wybierz typ: ");

                    boolean isValid = false;
                    int num = 0;
                    String choice;

                    while(isValid == false) {
                        choice = inputInt.nextLine();
                        try{
                            num = Integer.parseInt(choice);
                            isValid = true;
                        } catch(NumberFormatException e)
                            {
                                System.out.print("Podano niewłaściwy typ: ");
                            }
                    }

                    switch (num) {
                        case 1:
                            carMenu.wyswietlMenu();
                            break;
                        case 2:
                            houseMenu.wyswietlMenu();
                            break;
                        case 3:
                            animalMenu.wyswietlMenu();
                            break;
                        case 4:
                            System.exit(0);
                        default:
                            System.out.println("Wybierz poprawny wynik!");
                    }
                }
            }

        }


