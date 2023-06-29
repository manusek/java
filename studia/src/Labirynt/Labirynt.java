package Labirynt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Labirynt {
    private int[][] lab;
    private int wiersz;
    private int kolumna;
    private List<int[]> najlepszaSciezka;

    public Labirynt(int[][] labirynt) {
        this.lab = labirynt;
        this.wiersz = this.lab.length;
        this.kolumna = this.lab[0].length;
        this.najlepszaSciezka = new ArrayList<>();
    }

    public List<int[]> znajdzWyjscie(int wierszPoczatek, int kolumnaPoczatek, int wierszKoniec, int kolumnaKoniec) {
        List<int[]> trasa = new ArrayList<>();
        boolean[][] czyOdwiedzone = new boolean[wiersz][kolumna];

        dfs(wierszPoczatek, kolumnaPoczatek, wierszKoniec, kolumnaKoniec, trasa, czyOdwiedzone);

        if (najlepszaSciezka.isEmpty()) {
            return Collections.emptyList();
        } else {
            return najlepszaSciezka;
        }
    }

    private void dfs(int wiersz, int kolumna, int wierszKoniec, int kolumnaKoniec, List<int[]> trasa, boolean[][] czyOdwiedzone) {
        if (wiersz < 0 || wiersz >= this.wiersz || kolumna < 0 || kolumna >= this.kolumna || lab[wiersz][kolumna] == 1 || czyOdwiedzone[wiersz][kolumna]) {
            return;
        }

        czyOdwiedzone[wiersz][kolumna] = true;

        trasa.add(new int[]{wiersz, kolumna});

        if (wiersz == wierszKoniec && kolumna == kolumnaKoniec) {
            if (najlepszaSciezka.isEmpty() || trasa.size() < najlepszaSciezka.size()) {
                najlepszaSciezka = new ArrayList<>(trasa);
            }
        }

        dfs(wiersz - 1, kolumna, wierszKoniec, kolumnaKoniec, trasa, czyOdwiedzone); // Góra
        dfs(wiersz + 1, kolumna, wierszKoniec, kolumnaKoniec, trasa, czyOdwiedzone); // Dół
        dfs(wiersz, kolumna - 1, wierszKoniec, kolumnaKoniec, trasa, czyOdwiedzone); // Lewo
        dfs(wiersz, kolumna + 1, wierszKoniec, kolumnaKoniec, trasa, czyOdwiedzone); // Prawo

        trasa.remove(trasa.size() - 1);

        czyOdwiedzone[wiersz][kolumna] = false;
    }

}
