package algorytmy;

import java.util.Random;

public class zgadywanie {

    static Random rand = new Random();
    static int randomNumber = rand.nextInt(1000);

    public static void main(String[] args) {
        System.out.println("WYLOSOWANA LICZBA: " + randomNumber);
        guess(0, 1000);
    }

    static void guess(int a, int b) {
        int c = (a + b) / 2; //ustalanie srodka przedzialu

        if (c == randomNumber) System.out.println("ZGADŁEŚ!!!!!: " + c);
         else if (c > randomNumber) {

            System.out.println("LICZBA JEST ZA DUŻA: " + c);

            guess(a, c); //przesuwanie zakresu w lewo
        } else {

            System.out.println("LICZBA JEST ZA MAŁA: " + c);

            guess(c, b); //przesuwanie zakresu w prawo
        }
    }
}
