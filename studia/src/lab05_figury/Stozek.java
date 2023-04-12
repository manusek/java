package lab05_figury;

public class Stozek {
    private double h;
    private double r;
    private double l;

    public Stozek(double h, double r, double l) {
        this.h = h;
        this.r = r;
        this.l = l;
    }
    private double obj(){
        return (1/3)*(Math.PI)*(Math.pow(r,2))*h;
    }
    private double Pc(){
        return (Math.PI*Math.pow(r,2))+(Math.PI*r*l);
    }
    public void wyswietl(){
        System.out.printf("Stożek o promieniu "+r+" wysokości "+h+" i boku "+l+" ma objętość= "+obj()+" i pole całkowite= "+Pc());
    }
}
