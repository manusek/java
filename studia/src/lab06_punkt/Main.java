package lab06_punkt;

public class Main {
    public static void main(String[] args) {
        Punkt a = new Punkt();
        Punkt b = new Punkt();
        Punkt c = new Punkt();

        a.x=2.3;
        a.y=4.3;
        a.opis();
        a.zeruj();
        a.opis();
        a.przesun(10,10);
        a.opis();
    }
}
