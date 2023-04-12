package lab05_gatunek;

public class Gatunek {
    private String rodzaj;
    private String gatunek;
    private int ch;
    private int ch2;
    private String opis;

    public Gatunek(String rodzaj, String gatunek, int ch, int ch2, String opis) {
        this.rodzaj = rodzaj;
        this.gatunek = gatunek;
        this.ch = ch;
        this.ch2 = ch2;
        this.opis = opis;
    }

    public void wyswietl(){
        System.out.format("\n\nRodzaj: %s\nGatunek: %s\nLiczba chromosomow 2n: %d\n" +
                "Liczba chromosomow x: %d\nOpis: %s",rodzaj, gatunek, ch, ch2, opis);
    }
    public Gatunek klonuj(){
        return new Gatunek(rodzaj, gatunek, ch, ch2, opis);
    }

}
