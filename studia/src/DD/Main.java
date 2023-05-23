package DD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Book> bookList = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== Book CRUD Application ===");
            System.out.println("1. Create book");
            System.out.println("2. Read book");
            System.out.println("3. Update book");
            System.out.println("4. Delete book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    createBook(scanner);
                    break;
                case 2:
                    readBook(scanner);
                    break;
                case 3:
                    updateBook(scanner);
                    break;
                case 4:
                    deleteBook(scanner);
                    break;
                case 5:
                    System.out.println("Exiting the application...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createBook(Scanner scanner) {
        System.out.println("=== Create Book ===");
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        Book book = new Book(nextId++, title, author);
        bookList.add(book);

        System.out.println("Book created successfully.");
    }

    private static void readBook(Scanner scanner) {
        System.out.println("=== Read Book ===");
        System.out.print("Enter book ID: ");
        int bookId = scanner.nextInt();

        Book book = findBookById(bookId);
        if (book != null) {
            System.out.println("ID: " + book.getId());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void updateBook(Scanner scanner) {
        System.out.println("=== Update Book ===");
        System.out.print("Enter book ID: ");
        int bookId = scanner.nextInt();

        Book book = findBookById(bookId);
        if (book != null) {
            System.out.print("Enter new title: ");
            String newTitle = scanner.nextLine();
            System.out.print("Enter new author: ");
            String newAuthor = scanner.nextLine();

            book.setTitle(newTitle);
            book.setAuthor(newAuthor);

            System.out.println("Book updated successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void deleteBook(Scanner scanner) {
        System.out.println("=== Delete Book ===");
        System.out.print("Enter book ID: ");
        int bookId = scanner.nextInt();

        Book book = findBookById(bookId);
        if (book != null) {
            bookList.remove(book);
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    private static Book findBookById(int id) {
        for (Book book : bookList) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
}

class Book {
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}