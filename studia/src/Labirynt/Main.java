package Labirynt;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[][] plansza = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1},
                {1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1},
                {0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1},
                {1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1}
        };


        Labirynt lab = new Labirynt(plansza);
        int wierszPoczatek = 4; // współrzędne punktu startowego
        int kolumnaPoczatek = 7;
        int wierszKoniec = 9; //współrzędne punktu końcowego
        int kolumnaKoniec = 8;

        List<int[]> trasa = lab.znajdzWyjscie(wierszPoczatek, kolumnaPoczatek, wierszKoniec, kolumnaKoniec);

        if (trasa.isEmpty()) {
            System.out.println("Wyjście nie zostało znalezione.");
        } else {
            System.out.println("Optymalna trasa, wyznaczona przez współrzędne kolejnych punktów: ");
            for (int[] pozycja : trasa) {
                System.out.println("(" + pozycja[0] + ", " + pozycja[1] + ")");
            }
        }
    }
}

