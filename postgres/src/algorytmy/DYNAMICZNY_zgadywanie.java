package algorytmy;

import java.util.Random;

public class DYNAMICZNY_zgadywanie {

    static Random rand = new Random();
    static int liczba = rand.nextInt(1000);

    public static void main(String[] args) {
        System.out.println("LICZBA: " + liczba);
        los(0, 1000);
    }

    static int los(int a, int b) {
        int c = (a + b) / 2;
        int[] tab = new int[1000];
        for (int i = 0; i < tab.length; i++) {
            if (c == liczba) {
                System.out.println("BRAWO: " + c);
                tab[i] = c;
                break;
            } else if (c > liczba) {
                System.out.println("ZA DUZA: " + c);
                tab[i] = c;
                los(a, c);
            } else {
                System.out.println("ZA MALA: " + c);
                tab[i] = c;
                los(c, b);
            }
        }
        return tab[tab.length];
    }
}
