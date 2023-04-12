package lab05_figury;

public class Kolo {
    private double r;

    public Kolo(double r) {
        this.r = r;
    }
    private double pole(){
        return Math.round(Math.PI*Math.pow(r,2));
    }
    private double obwod(){
        return Math.round(2*Math.PI*r);
    }
    public void wyswietl(){
        System.out.printf("Koło o promieniu "+r+" ma pole= "+pole()+" i obwód= "+obwod());
    }
}
