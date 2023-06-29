package Populacja;

import java.util.Arrays;
import java.util.Random;

public class Main {
    private final static int wielkoscPopulacja = 10;
    private final static int epoka = 10;
    private final static double prawdopodobienstwoMutacja = 0.1;
    private final static double prawdopodobienstwoPopulacja = 0.3;

    public static void main(String[] args)
    {
        Random random = new Random();
        Populacja populacja = new Populacja(wielkoscPopulacja, random);
        Chromosom najlepszyChromosom = populacja.najlepszyChromosom().kopiuj();
        int maksymalnaZdolnosc = najlepszyChromosom.getZdolnosc();
        for (int i = 0; i < Main.epoka; i++)
        {
            populacja.krzyzowanie(prawdopodobienstwoPopulacja);
            populacja.mutowanie(prawdopodobienstwoMutacja);
            populacja = populacja.reprodukuj(wielkoscPopulacja);
            Chromosom populacjaNajlepszychChromosomow = populacja.najlepszyChromosom();

            int populacjaNajlepszaZdolnosc = populacjaNajlepszychChromosomow.getZdolnosc();

            if (populacjaNajlepszaZdolnosc > maksymalnaZdolnosc)
            {
                najlepszyChromosom = populacjaNajlepszychChromosomow.kopiuj();
                maksymalnaZdolnosc = populacjaNajlepszaZdolnosc;
            }
        }

        System.out.println("Rozwiązanie najlepsze: " + Arrays.toString(najlepszyChromosom.getWagi()));
        System.out.println("Wartość całkowita: " + maksymalnaZdolnosc);
    }

}
