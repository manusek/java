package Populacja;

import java.util.Random;

public class Populacja
{
    private final Chromosom[] populacja;
    private final int wielkosc;
    private int calkowitaWartosc;
    Random rand;

    public Populacja(Chromosom[] POPULACJA, Random random)
    {
        this.populacja = POPULACJA;
        this.wielkosc = POPULACJA.length;
        this.rand = random;
        calkowitaZdolnosc();
    }

    public Populacja(int WIELKOSC, Random random)
    {
        this.wielkosc = WIELKOSC;
        populacja = new Chromosom[WIELKOSC];
        this.rand = random;
        for (int i = 0; i < WIELKOSC; i++)
        {
            populacja[i] = new Chromosom(random);
        }
        calkowitaZdolnosc();
    }

    public Chromosom najlepszyChromosom()
    {
        int maksymalnaWartosc = 0;
        Chromosom najlepszy = null;
        for (Chromosom chromosom : populacja)
        {
            int wartosc = chromosom.getZdolnosc();
            if (wartosc > maksymalnaWartosc)
            {
                maksymalnaWartosc = wartosc;
                najlepszy = chromosom;
            }
        }
        return najlepszy;
    }

    private void calkowitaZdolnosc()
    {
        int suma = 0;
        for (Chromosom chromosom : populacja)
        {
            suma += chromosom.getZdolnosc();
        }
        calkowitaWartosc = suma;
    }

    public Populacja reprodukuj(int nowaWielkoscPop)
    {
        Chromosom[] nowaPopulacja = new Chromosom[nowaWielkoscPop];
        for (int i = 0; i < nowaWielkoscPop; i++)
        {
            nowaPopulacja[i] = reprodukujChromosom();
        }
        return new Populacja(nowaPopulacja, rand);
    }

    private Chromosom reprodukujChromosom()
    {
        int prog = (int)((double) rand.nextInt(100)/100 * calkowitaWartosc);
        double shortSumZdolnosc = 0.0;
        for (int i = 0; i < wielkosc; i++)
        {
            Chromosom chromosom = populacja[i];
            shortSumZdolnosc = shortSumZdolnosc + chromosom.getZdolnosc();

            if (shortSumZdolnosc > prog) return chromosom.kopiuj();
        }
        throw new IllegalStateException("Błąd w obliczeniach");
    }

    public void mutowanie(double prawdopodobienstwo)
    {
        for (Chromosom chromosom : populacja)
        {
            if (rand.nextDouble() > prawdopodobienstwo) chromosom.mutowanie(rand);
        }
        calkowitaZdolnosc();
    }

    public void krzyzowanie(double prawdopodobienstwo)
    {
        for (Chromosom chrom : populacja)
        {
            if (rand.nextDouble() > prawdopodobienstwo)
            {
                Chromosom chromosom2;
                do
                {
                    chromosom2 = populacja[rand.nextInt(wielkosc)];
                } while (chromosom2 == chrom);

                krzyzowanie(chrom, chromosom2);
            }
        }
        calkowitaZdolnosc();
    }

    private void krzyzowanie(Chromosom chromosom1, Chromosom chromosom2)
    {
        int punktKrzyzowania = rand.nextInt(chromosom1.getRozmiar());
        int[] wagi1 = chromosom1.getWagi().clone();
        int[] wagi2 = chromosom2.getWagi().clone();

        chromosom1.krzyzowanie(wagi2, punktKrzyzowania);
        chromosom2.krzyzowanie(wagi1, punktKrzyzowania);
    }
}
