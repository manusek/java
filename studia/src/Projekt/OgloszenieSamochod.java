package Projekt;

public class OgloszenieSamochod extends Ogloszenie{
    private int rokProdukcji;

    private int przebieg;

    public OgloszenieSamochod(){};

    public int getRokProdukcji() {
        return rokProdukcji;
    }

    public void setRokProdukcji(int rokProdukcji) {
        this.rokProdukcji = rokProdukcji;
    }

    public int getPrzebieg() {
        return przebieg;
    }

    public void setPrzebieg(int przebieg) {
        this.przebieg = przebieg;
    }
}
