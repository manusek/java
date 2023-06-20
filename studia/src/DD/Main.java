package DD;

public class Main {

    public static void main(String[] args) {

        Crud book = new Crud();

        while (true) {
            System.out.println("=== Book CRUD Application ===");
            System.out.println("1. Create book");
            System.out.println("2. Read book");
            System.out.println("3. Read all books");
            System.out.println("4. Update book");
            System.out.println("5. Delete book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = book.Input();

            switch (choice) {
                case 1:
                    book.createBook();
                    break;
                case 2:
                    book.readBook();
                    break;
                case 3:
                    book.readAllBooks();
                    break;
                case 4:
                    book.updateBook();
                    break;
                case 5:
                    book.deleteBook();
                    break;
                case 6:
                    System.out.println("Exiting the application...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
