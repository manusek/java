import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Wyświetl studentów");
            System.out.println("2. Wybór 2");
            System.out.println("3. Wybór 3");
            System.out.println("4. Wybór 4");
            System.out.println("0. Wyjście");
            System.out.print("Wybierz opcję: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Wybrano opcję 1.");
                    // Tutaj możesz dodać kod dla opcji 1
                    break;
                case 2:
                    System.out.println("Wybrano opcję 2.");
                    // Tutaj możesz dodać kod dla opcji 2
                    break;
                case 3:
                    System.out.println("Wybrano opcję 3.");
                    // Tutaj możesz dodać kod dla opcji 3
                    break;
                case 4:
                    System.out.println("Wybrano opcję 4.");
                    // Tutaj możesz dodać kod dla opcji 4
                    break;
                case 0:
                    System.out.println("Koniec programu.");
                    break;
                default:
                    System.out.println("Nieprawidłowa opcja. Wybierz ponownie.");
                    break;
            }

        } while (choice != 0);

        scanner.close();
    }
}
