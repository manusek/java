package lab05_figury;

public class Kula {
    private double r;
    public Kula(double r){
        this.r = r;
    }
    private double obj(){
        return (4/3)*Math.PI*Math.pow(r,3);
    }
    private double Pc(){
        return 4*Math.PI*Math.pow(r,2);
    }
    public void wyswietl(){
        System.out.printf("Kula o promieniu "+r+" ma objętość= "+obj()+" i pole całkowite= "+Pc());
    }
}
