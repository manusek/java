package lab05_budynek;

public class Main {
    public static void main(String[] args) {
        Budynek a = new Budynek("kościół", 1978, 1);
        a.wyswietl();
        Budynek b = new Budynek("blok", 2001, 15);
        b.wyswietl();
        Budynek c = new Budynek("drapacz", 2018, 1000);
        c.wyswietl();
        Budynek d = new Budynek("zamek", 1760, 4);
        d.wyswietl();

    }
}
