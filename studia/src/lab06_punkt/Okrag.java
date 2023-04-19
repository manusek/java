package lab06_punkt;

public class Okrag {
    private double promien;
    private Punkt srodek;

    public Okrag() {
        this.promien = 0.0;
        this.srodek = new Punkt(0.0,0.0);
    }

    public Okrag(double promien, Punkt srodek) {
        this.promien = promien;
        this.srodek = srodek;
    }

    public double getPowierzchnia(){
        return Math.PI*Math.pow(promien,2);
    }
    public double getSrednica(){
        return 2*promien;
    }
    public void setPromien(double p){
        promien = p;
    }
    public double getPromien(){
        return this.promien;
    }
    public void wSrodku(Punkt a){
        if(Math.pow((a.x-srodek.x),2)+Math.pow((a.y-srodek.y),2)<=Math.pow(promien,2)){
            System.out.println("Ten punkt lezy w okregu");}
            else
            System.out.println("Ten punkt nie lezy w okregu");
    }
    public void wyswietl(){
        System.out.println("Wspolrzedne srodka okregu: "+srodek.x+" , "+srodek.y);
    }
}
