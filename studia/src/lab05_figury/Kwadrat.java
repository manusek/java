package lab05_figury;

public class Kwadrat {
    private double a;
    public Kwadrat(double a){
        this.a = a;
    }

    private double obwod(){
        return 4*a;
    }
    private double pole(){
        return Math.pow(a,2);
    }
    public void wyswietl(){
        System.out.printf("Kwadrat o boku "+a+" ma pole= "+pole()+" i obwód= "+obwod());
    }

}
