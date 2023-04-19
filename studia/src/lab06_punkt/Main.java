package lab06_punkt;

public class Main {
    public static void main(String[] args) {
        Punkt p = new Punkt(1.0, 1.0);
        Punkt p2 = new Punkt(0.0, 9.9);
        Punkt p3 = new Punkt(11.0, 11.0);
        p.opis();
        System.out.println(p.getX()+","+p.getY());

        Okrag okr = new Okrag(10,new Punkt(0.0,0.0));
        okr.wyswietl();
        System.out.println("Pole powierzchni okregu: "+okr.getPowierzchnia());
        System.out.println("Srednica okregu: "+okr.getSrednica());
        System.out.println("Promien okregu: "+okr.getPromien());
        //okr.setPromien(4.0);
        //System.out.println("Nowy promien okregu: "+okr.getPromien());
        okr.wSrodku(p);
        okr.wSrodku(p2);
        okr.wSrodku(p3);

    }

}
