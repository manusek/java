package biologia;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Gatunek g = new Gatunek("kot", "ssak", 2, 4);
        g.fullName();
        Gatunek a = g.klonuj();
        a.fullName();
        if(g.Equals(a)){
            System.out.printf("\nObiekty sa takie same");
        }
    }
}
