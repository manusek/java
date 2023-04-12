package lab05_budynek;

import java.security.PublicKey;
import java.time.LocalDate;

public class Budynek {
    private String nazwa;
    private int rokBudowy;
    private int pietra;
    private int lata = LocalDate.now().getYear();

    public Budynek(String nazwa, int rokBudowy, int pietra){
        this.nazwa = nazwa;
        this.rokBudowy = rokBudowy;
        this.pietra = pietra;
    }

    public void wyswietl(){
        System.out.println("\nNazwa budynku: "+nazwa+"\nRok budowy: "+rokBudowy+"\nLiczba pięter: "
        +pietra+"\nLiczba lat: "+(lata-rokBudowy));
    }

}
