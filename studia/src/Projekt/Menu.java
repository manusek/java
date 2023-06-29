package Projekt;

import java.util.Scanner;

public abstract class Menu {

    public void wyswietlMenu() {
        Scanner input = new Scanner(System.in);

        boolean stop = false;
        while (!stop) {
            System.out.println("=== Book CRUD Application ===");
            System.out.println("1. Dodaj ogłoszenie");
            System.out.println("2. Wyswietl ogłoszenia");
            System.out.println("3. Edytuj ogłoszenie");
            System.out.println("4. Usun ogłoszenie");
            System.out.println("5. Wyswietl wszystkie ogloszenia");
            System.out.println("6. Wyjdz");
            System.out.print("Wybierz operację: ");
            int wybor = input.nextInt();

            switch (wybor) {
                case 1:
                    DodajOgloszenie();
                    break;
                case 2:
                    WyswietlOgloszenie();
                    break;
                case 3:
                    EdytujOgloszenie();
                    break;
                case 4:
                    UsunOgloszenie();
                    break;
                case 5:
                    WyswietlWszystkieOgloszenia();
                    break;
                case 6:
                    ZakonczOgloszenia();
                    stop = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public abstract void DodajOgloszenie();

    public abstract void WyswietlOgloszenie();

    public abstract void EdytujOgloszenie();

    public abstract void UsunOgloszenie();

    public abstract void WyswietlWszystkieOgloszenia();

    public abstract void ZakonczOgloszenia();

    public int Input(){
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public String InputS(){
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
