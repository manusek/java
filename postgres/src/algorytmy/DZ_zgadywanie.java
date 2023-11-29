package algorytmy;

import java.util.Random;

public class DZ_zgadywanie {

    static Random rand = new Random();
    static int LICZBA = rand.nextInt(1000);

    public static void main(String[] args) {
        System.out.println("WYLOSOWANA LICZBA: " + LICZBA);
        zgaduj(0, 1000);
    }

    static void zgaduj(int a, int b){
        int z = (a+b)/2; //SRODEK PRZEDZIALU

        if (z == LICZBA){
            System.out.println("TAK: " + z);
        }
        else if(z > LICZBA){
            System.out.println("ZA DUŻA: " + z);
            zgaduj(a, z); //ZAKRES PRZESUWAMY W LEWO
        }else {
            System.out.println("ZA MAŁA: " + z);
            zgaduj(z, b); //ZAKRES PRZESUWAMY W PRAWO
        }
    }

}
