package lab05_gatunek;

public class Main {
    public static void main(String[] args) {
        Gatunek gat = new Gatunek("zaba", "ssak", 40, 34, "opis");
        gat.wyswietl();

        Gatunek gat2 = new Gatunek("pies", "owad", 3, 11, "opis2");
        gat2.wyswietl();

        Gatunek gat3 = new Gatunek("kunolis", "gad", 233, 0, "opis3");
        gat3.wyswietl();

        Gatunek gat4 = gat3.klonuj();
        gat4.wyswietl();

    }
}
