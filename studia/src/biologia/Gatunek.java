package biologia;

public class Gatunek {
    private String rodzaj;
    private String gatunek;
    private int liczbach2n;
    private int liczbachx;

    public Gatunek(String rodzaj, String gatunek, int liczbach2n, int liczbachx) {
        this.rodzaj = rodzaj;
        this.gatunek = gatunek;
        this.liczbach2n = liczbach2n;
        this.liczbachx = liczbachx;
    }
    public void fullName(){
        System.out.printf("Rodzaj: "+rodzaj+" Gatunek: "+gatunek);

    }

    public Gatunek klonuj(){
        return new Gatunek(rodzaj, gatunek, liczbach2n, liczbachx);
    }

    public boolean Equals (Gatunek g) {
        if ((this.rodzaj == g.rodzaj) && (this.gatunek == g.gatunek) && (this.liczbach2n == g.liczbach2n) && (this.liczbachx == g.liczbachx)){
            return true;
        }
        return false;
    }

    public void Aktualizuj (Gatunek g) {
        this.rodzaj = g.rodzaj;

    }
}
