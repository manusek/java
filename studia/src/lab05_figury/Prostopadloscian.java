package lab05_figury;

public class Prostopadloscian {
    private double a;
    private double b;
    private double c;

    public Prostopadloscian(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    private double obj(){
        return a*b*c;
    }
    private double Pc(){
        return (2*a*b)+(2*a*c)+(2*b*c);
    }
    public void wyswietl(){
        System.out.printf("Prostopadłościan o boku "+a+" ,boku "+b+" i boku "+c+" ma objętość= "+obj()+" i pole całkowite= "+Pc());
    }
}
