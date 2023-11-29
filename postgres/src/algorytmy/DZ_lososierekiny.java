package algorytmy;

public class DZ_lososierekiny {
    public static void main(String[] args) {

        final int czas = 4;
        System.out.println(stan(czas));
    }

    static double stan(int minuty){
        int popul = 1000;
        if (minuty == 1){
            return popul;
        }
        else {
            double xd = Math.pow(Math.E, 0.003)* stan(minuty- 1);
            xd -= xd * 0.004;
            if (xd < 100.0)
                return 0;
            else
                return xd;
        }
    }
}
