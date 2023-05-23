package Projekt;

import java.util.Date;

public class Ogloszenie {
    private double cena;

    private String tytul;

    private String tresc;

    private Date data;

    private String autor;

    public void setCena(double cena) {
        this.cena = cena;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
