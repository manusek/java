package Projekt;

import java.util.Scanner;

public class MenuZwierze {
    static PrzetwarzajOgloszenieZwierze ogloszenie = new PrzetwarzajOgloszenieZwierze();

    public static void wyswietlMenu() {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("=== Book CRUD Application ===");
            System.out.println("1. Dodaj ogłoszenie");
            System.out.println("2. Wyswietl ogłoszenia");
            System.out.println("3. Edytuj ogłoszenie");
            System.out.println("4. Usun ogłoszenie");
            System.out.println("5. Wyjdz");
            System.out.println("6. Wyswietl wszystkie ogloszenia");
            System.out.print("Wybierz operację: ");
            int wybor = input.nextInt();

            switch (wybor) {
                case 1:
                    ogloszenie.dodajOgloszenie();
                    break;
                case 2:
                    ogloszenie.wyswietlOgloszenie();
                    break;
                case 3:
                    ogloszenie.edytujOgloszenie();
                    break;
                case 4:
                    ogloszenie.usunOgloszenie();
                    break;
                case 5:
                    System.out.println("Exiting the application...");
                    ogloszenie.zamknij();
                    System.exit(0);
                case 6:
                    ogloszenie.wyswietlWszystkieOgloszenia();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

}
