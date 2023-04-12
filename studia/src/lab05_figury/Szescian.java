package lab05_figury;

public class Szescian {
    private double a;
    public Szescian(double a){
        this.a = a;
    }
    private double obj(){
        return Math.pow(a,3);
    }
    private double Pc(){
        return 6*(Math.pow(a,2));
    }
    public void wyswietl(){
        System.out.printf("Sześcian o boku "+a+" ma objętość= "+obj()+" i pole całkowite= "+Pc());
    }
}
