package algorytmy2;

import java.util.Random;

public class bubbleSort {
    public static void main(String[] args) {
        Random random = new Random();
        int[] tab = new int[50];

        //wypelnianie tablicy
        for (int i = 0; i < tab.length; i++) {
            tab[i] = random.nextInt(100);
        }

        bubbleSort2(tab);

        //wyswietlanie tablicy
        for (int i = 0; i < tab.length; i++) {
            System.out.println(tab[i]);
        }

    }



    public static void bubbleSort(int[] table) //Sortowanie bąbelkowe
    {
        for (int i = table.length - 1; i > 0; i--)   // petla zewnetrzna (malejaca)
        {
            for (int j = 0; j < i; j++)        // petla wewnetrzna (rosnaca)
            {
                if (table[j] > table[j + 1])       // zla kolejnosc?
                {
                    int temp = table[j];
                    table[j] = table[j + 1];
                    table[j + 1] = temp;
                }
            }
        }
    }


    public static void bubbleSort2(int[] tab){
        for (int i = tab.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (tab[j] > tab[j + 1]){
                    int a = tab[j];
                    tab[j] = tab[j + 1];
                    tab[j + 1] = a;
                }
            }
        }
    }


}
