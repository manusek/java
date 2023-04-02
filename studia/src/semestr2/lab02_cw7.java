package semestr2;

import java.util.Scanner;




public class lab02_cw7 {
    public static void main(String[] args) {
        run();
    }
    public static void run(){
        System.out.println("Ile liczb do tablicy chcesz wprowadzic ?");
        int n = InputInt();
        int[] tab = InputTab(n);
        System.out.println("Liczby przed posortowaniem: ");wyswietl(tab);
        sort(tab);
        System.out.println("Liczby po posortowaniu: ");wyswietl(tab);

    }
    public static int InputInt(){
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        return num;
    }
    public static int[] InputTab(int a){
        int[] tab = new int[a];
        for(int i=0; i<a; i++){
            System.out.print("Podaj tab["+i+"]: ");
            tab[i] = InputInt();
        }
        return tab;
    }
    public static void wyswietl(int[] tab){
        for(int i = 0; i< tab.length; i++){
            System.out.print(tab[i]+", ");
        }
        System.out.println();
    }
    public static int[] sort(int[] tab) {

        for (int i = 0; i < tab.length; i++) {

            for (int j = i + 1; j < tab.length; j++) {

                int liczbaA = tab[i];
                int liczbaB = tab[j];

                if (liczbaA > liczbaB) {
                    tab[i] = liczbaB;
                    tab[j] = liczbaA;
                }
            }
        }
        return tab;
    }
}
