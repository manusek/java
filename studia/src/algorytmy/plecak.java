package algorytmy;

import java.util.Arrays;

public class plecak {
    final static int N = 6;                // liczba przedmiotów
    final static int MAX_V = 10;           // objetość plecaka

    final static int[] V = {1, 2, 3, 2, 3, 1};  // objetości przedmiotów
    final static int[] W = {6, 4, 5, 7, 10, 2}; // wartości przedmiotów

    public static void main(String[] args)
    {

        int[] indeksyPrzedmiotow = new int[N];
        int[] stosunekWartosciDoObjetosci = new int[N];

        for (int i = 0; i < N; i++)
        {
            stosunekWartosciDoObjetosci[i] = W[i] / V[i];
        }

        for (int i = 0; i < N; i++)
        {
            indeksyPrzedmiotow[i] = i;  // Inicjalizacja indeksów przedmiotów
        }

        // Sortowanie indeksów przedmiotów według stosunku wartości do objętości (malejąco)
        for (int i = 0; i < N - 1; i++)
        {
            for (int j = 0; j < N - i - 1; j++)
            {
                if (stosunekWartosciDoObjetosci[j] < stosunekWartosciDoObjetosci[j + 1])
                {
                    // Zamiana miejscami indeksów i stosunków
                    int temp = stosunekWartosciDoObjetosci[j];
                    stosunekWartosciDoObjetosci[j] = stosunekWartosciDoObjetosci[j + 1];
                    stosunekWartosciDoObjetosci[j + 1] = temp;

                    temp = indeksyPrzedmiotow[j];
                    indeksyPrzedmiotow[j] = indeksyPrzedmiotow[j + 1];
                    indeksyPrzedmiotow[j + 1] = temp;
                }
            }
        }

        int objetoscPlecaka = 0;

        for (int i = 0; i < N; i++)
        {
            if (objetoscPlecaka + V[indeksyPrzedmiotow[i]] <= MAX_V)
            {
                objetoscPlecaka += V[indeksyPrzedmiotow[i]];
            } else {
                indeksyPrzedmiotow[i] = -1;  // Oznaczanie przedmiotów, które nie mieszczą się w plecaku
            }
        }

        System.out.println("Przedmioty do wzięcia (indeksy): ");
        for (int indeks : indeksyPrzedmiotow)
        {
            if (indeks >= 0)
            {
                System.out.print(indeks + " ");
            }
        }
        System.out.println();
    }
}