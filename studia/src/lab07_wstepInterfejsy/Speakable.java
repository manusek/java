package lab07_wstepInterfejsy;

public interface Speakable {
    int QUIET = 0;
    int LOUD = 1;
    String getVoice(int voice);
}
