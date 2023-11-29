package algorytmy;

public class kroliki_PD {
    public static void main(String[] args) {
        System.out.println(kroliki(5));
    }
    static int kroliki(int miesiac){
        int[] tab = new int[miesiac + 2];
        tab[1] = 1;
        tab[2] = 1;
        for (int i = 3; i < tab.length; i++){
            tab[i] = tab[i - 1] + tab[i - 2];
        }
        return tab[tab.length - 1];
    }
}
