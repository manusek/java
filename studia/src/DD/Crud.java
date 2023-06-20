package DD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Crud {
    private int id;

    private String title;

    private String author;

    private static int nextId = 1;

    private List<Crud> bookList = new ArrayList<>();

    public Crud(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Crud(){};



    public void setTitle(String title) {
        this.title = title;
    }


    public void setAuthor(String author) {
        this.author = author;
    }

    public void createBook() {
        System.out.println("=== Create Book ===");
        System.out.print("Enter title: ");
        String title = InputS();
        System.out.print("Enter author: ");
        String author = InputS();

        Crud book = new Crud(nextId++, title, author);
        bookList.add(book);

        System.out.println("Book created successfully.");
    }

    public void readBook() {
        System.out.println("=== Read Book ===");
        System.out.print("Enter book ID: ");
        int bookId = Input();

        bookList.get(bookId);
            System.out.println("ID: " +id);
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);

    }
//    public void readBook() {
//        System.out.println("=== Read Book ===");
//        System.out.print("Enter book ID: ");
//        int bookId = Input();
//
//        Crud book = findBookById(bookId);
//        if (book != null) {
//            System.out.println("ID: " +id);
//            System.out.println("Title: " + title);
//            System.out.println("Author: " + author);
//        } else {
//            System.out.println("Book not found.");
//        }
//    }

    public void readAllBooks(){
        System.out.println("=== Read All Books ===");
        for(int i = 0;i<=bookList.toArray().length; i++){
            System.out.println("ID: " +id);
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
        }

    }

    public void updateBook() {

        System.out.println("=== Update Book ===");
        System.out.print("Enter book ID: ");
        int bookId = Input();

        Crud book = findBookById(bookId);
        if (book != null) {
            System.out.print("Enter new title: ");
            String newTitle = InputS();
            System.out.print("Enter new author: ");
            String newAuthor = InputS();

            setTitle(newTitle);
            setAuthor(newAuthor);

            System.out.println("Book updated successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void deleteBook() {

        System.out.println("=== Delete Book ===");
        System.out.print("Enter book ID: ");
        int bookId = Input();

        Crud book = findBookById(bookId);
        if (book != null) {
            bookList.remove(book);
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public Crud findBookById(int id) {
        for (Crud book : bookList) {
            if (book.id == id) {
                return book;
            }
        }
        return null;
    }

    public int Input(){
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public String InputS(){
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}



