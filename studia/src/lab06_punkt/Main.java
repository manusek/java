package lab06_punkt;

public class Main {
    public static void main(String[] args) {
        Punkt p = new Punkt(4.5, 6.5);
        p.opis();
        System.out.println(p.getX()+","+p.getY());

        Okrag okr = new Okrag(3,new Punkt(4.5,6.5));
        okr.wyswietl();
        System.out.println("Pole powierzchni okregu: "+okr.getPowierzchnia());
        System.out.println("Srednica okregu: "+okr.getSrednica());
        System.out.println("Promien okregu: "+okr.getPromien());
        okr.setPromien(4.0);
        System.out.println("Nowy promien okregu: "+okr.getPromien());
        okr.wSrodku(p);

    }

}
