package algorytmy;

public class DYNAMICZNY_bakterie {
    public static void main(String[] args) {
        System.out.println(bakt(1));
    }

    static int bakt(int czas){
        int[] tab = new int[czas + 1];
        tab[1] = 1;
        tab[2] = 2;
            for (int i = 3; i < tab.length; i++)
            {
                tab[i] = tab[i - 2] + tab[i - 2];
            }
        return tab[tab.length - 1];
    }
}
