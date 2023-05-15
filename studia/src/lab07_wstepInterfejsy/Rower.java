package lab07_wstepInterfejsy;

public class Rower implements Moveable{
    @Override
    public void start() {
        System.out.println("Rower wystartowal");
    }

    @Override
    public void stop() {
        System.out.println("Rower sie zatrzymal");
    }
}
