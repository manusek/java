package Projekt;

import java.util.Scanner;

public abstract class Menu {

    public void wyswietlMenu() {
        Scanner input = new Scanner(System.in);

        boolean stop = false;
        while (!stop) {
            System.out.println("=================");
            System.out.println("1. Dodaj ogłoszenie");
            System.out.println("2. Wyswietl ogłoszenia");
            System.out.println("3. Edytuj ogłoszenie");
            System.out.println("4. Usun ogłoszenie");
            System.out.println("5. Wyswietl wszystkie ogloszenia");
            System.out.println("6. Wyjdz");
            System.out.print("Wybierz operację: ");

            boolean isValid = false;
            int num = 0;
            String choice;

            while(isValid == false) {
                choice = input.nextLine();
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
                    addAdd();
                    break;
                case 2:
                    showAdd();
                    break;
                case 3:
                    editAdd();
                    break;
                case 4:
                    deleteAdd();
                    break;
                case 5:
                    showAllAds();
                    break;
                case 6:
                    exitTable();
                    stop = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public abstract void addAdd();

    public abstract void showAdd();

    public abstract void editAdd();

    public abstract void deleteAdd();

    public abstract void showAllAds();

    public abstract void exitTable();

    public int Input(){
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public String InputS(){
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
