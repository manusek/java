package Projekt;

    public class Main {


        public static void main(String[] args) {
            Ogloszenie ogloszenie = new Ogloszenie();

            while (true) {
                System.out.println("=== Book CRUD Application ===");
                System.out.println("1. Dodaj ogłoszenie");
                System.out.println("2. Wyswietl ogłoszenia");
                System.out.println("3. Edytuj ogłoszenie");
                System.out.println("4. Usun ogłoszenie");
                System.out.println("5. Wyjdz");
                System.out.print("Wybierz operację: ");
                int wybor = ogloszenie.Input();

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
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

