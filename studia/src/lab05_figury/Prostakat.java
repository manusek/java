package lab05_figury;

public class Prostakat {
    private double a;
    private double b;

    public Prostakat(double a, double b) {
        this.a = a;
        this.b = b;
    }
    private double pole(){
        return a*b;
    }
    private double obwod(){
        return (2*a)+(2*b);
    }
    public void wyswietl(){
        System.out.printf("Prostokąt o boku "+a+" i boku "+b+" ma pole= "+pole()+" i obwód= "+obwod());
    }
}
