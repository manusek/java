package lab07_wstepInterfejsy;

public class Samochod implements Moveable {
    private String marka;
    Samochod(String marka){
        this.marka = marka;
    }

    @Override
    public void stop() {
        System.out.println("Samochod sie zatrzymal");
    }

    @Override
    public void start() {
        System.out.println("Samochod wystartowal");
    }
}
