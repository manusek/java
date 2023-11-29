package algorytmy;

public class DYNAMICZNY_lososierekiny {
    public static void main(String[] args) {
        final int czas =4 ;
        System.out.println(stan(czas));
    }

    static double stan(int minuty){
        double[] tab = new double[minuty + 1];
        int popul = 1000;
        tab[1] = popul;
        for (int i = 2; i < tab.length; i++) {

            double xd = Math.pow(Math.E, 0.003)* tab[i-1];
            xd -= xd * 0.004;

            tab[i] = xd;

        }
        return tab[tab.length - 1];
    }
}
