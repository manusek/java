package figury;

public class Kolo {
    private int r;


    //konstruktor domyślny
    public Kolo() {
        this.r = 0;
    }

    //konstruktor
    public Kolo(int r) {
        this.r = r;
    }

    public void setR(int r) {
        this.r = r;
    }

    private double pole(){
        return Math.pow(r,2)*Math.PI;
    }

    private double obwod(){
        return 2*Math.PI*r;

    }

    public void wyswietl(){
        System.out.println("Kolo \nObwód: "+obwod()+" Pole: "+pole());
    }

}
