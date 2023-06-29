package Populacja;

import java.util.Random;

public class Chromosom
{
    private final static int ilosc = 6;
    private final static int maxV = 10;
    private final static int[] v = {2,6,3,3,1,2};
    private final static int[] w = {4,6,5,10,2,7};

    private int[] wagi;
    private int zdolnosc;

    public Chromosom()
    {
        wagi = new int[ilosc];
        for (int w : wagi)
        {
            w = 0;
        }
        zdolnosc = 0;
    }

    public Chromosom(Random random)
    {
        wagi = new int[ilosc];
        wagi = random.ints(ilosc, 0, 2).toArray();
        zdolnosc();
    }

    public Chromosom kopiuj()
    {
        Chromosom nowyChromosom = new Chromosom();
        nowyChromosom.setWagi(this.wagi.clone());
        return nowyChromosom;
    }

    public void zdolnosc()
    {
        int calkowitaWartosc = 0;
        int calkowitaWaga = 0;
        for (int i = 0; i < ilosc; i++)
        {
            if (wagi[i] == 1)
            {
                calkowitaWartosc += w[i];
                calkowitaWaga += v[i];
            }
        }
        if (calkowitaWaga > maxV) zdolnosc = 0;

        else zdolnosc = calkowitaWartosc;
    }

    public void mutowanie(Random random)
    {
        int index = random.nextInt(ilosc);
        wagi[index] ^= 1;
        zdolnosc();
    }

    public void krzyzowanie(int[] inneWagi, int punktKrzyzowania)
    {
        System.arraycopy(inneWagi, 0, wagi, 0, punktKrzyzowania);
    }

    public int getZdolnosc()
    {
        return zdolnosc;
    }

    public int[] getWagi()
    {
        return wagi;
    }
    public void setWagi(int[] wagi)
    {
        this.wagi = wagi;
        zdolnosc();
    }
    public int getRozmiar()
    {
        return ilosc;
    }
}

