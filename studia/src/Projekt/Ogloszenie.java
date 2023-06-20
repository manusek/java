package Projekt;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ogloszenie {
    private int id;

    private int price;

    private String title;

    private String tresc;

    public Ogloszenie(int id, String title, String tresc, int price) {
        this.id = id;
        this.title = title;
        this.tresc = tresc;
        this.price = price;
    }

    public Ogloszenie(){};

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTresc() {
        return tresc;
    }
    public int getPrice() {
        return price;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    private static List<Ogloszenie> bookList = new ArrayList<>();
    private static int nextId = 1;

    public void dodajOgloszenie() {
        System.out.println("=== Dodaj ogłoszenie ===");

        System.out.print("Wpisz tytuł: ");
        String title = InputS();

        System.out.print("Wpisz treść: ");
        String tresc = InputS();

        System.out.print("Podaj cene: ");
        int price = Input();

        Ogloszenie book = new Ogloszenie(nextId++, title, tresc, price);
        bookList.add(book);

        System.out.println("Book created successfully.");
    }

    public void wyswietlOgloszenie() {
        System.out.println("=== Wyświetl ogłoszenie ===");
        System.out.print("Podaj ID ogłoszenia: ");
        int bookId = Input();

        Ogloszenie book = findBookById(bookId);
        if (book != null) {
            System.out.println("ID: " + book.getId());
            System.out.println("Tytuł: " + book.getTitle());
            System.out.println("Tresc: " + book.getTresc());
            System.out.println("Cena: " + book.getPrice());
        } else {
            System.out.println("Nie znaleziono ogłoszenia.");
        }
    }


    public void edytujOgloszenie() {
        System.out.println("=== Edytuj ogłoszenia ===");
        System.out.print("Podaj ID ogłoszenia: ");
        int bookId = Input();

        Ogloszenie book = findBookById(bookId);
        if (book != null) {
            System.out.print("Wpisz nowy tytuł: ");
            String newTitle = InputS();

            System.out.print("Wpisz nową treść: ");
            String newTresc = InputS();

            System.out.print("Podaj nową cene: ");
            int newPrice = Input();

            book.setTitle(newTitle);
            book.setTresc(newTresc);
            book.setPrice(newPrice);

            System.out.println("Ogłoszenie zostało zaaktualizowane.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void usunOgloszenie() {
        System.out.println("=== Usuń ogłoszenie ===");
        System.out.print("Podaj ID ogłoszenia: ");
        int bookId = Input();

        Ogloszenie book = findBookById(bookId);
        if (book != null) {
            bookList.remove(book);
            System.out.println("Ogłoszenie zostało usunięte.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public Ogloszenie findBookById(int id) {
        for (Ogloszenie book : bookList) {
            if (book.getId() == id) {
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
