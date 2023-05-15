package lab07_wstepInterfejsy;

public class Pies extends Zwierze implements Speakable,Moveable{
    @Override
    public void start() {
        System.out.println("pies biegnie");
    }

    @Override
    public void stop() {
        System.out.println("pies stoi");
    }

    @Override
    public String getVoice(int voice) {
        return null;
    }
    public String getTyp(){
        return "Pies";
    }
}
