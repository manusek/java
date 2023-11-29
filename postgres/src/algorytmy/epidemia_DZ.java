package algorytmy;

public class epidemia_DZ {
    public static void main(String[] args) {
        System.out.println(epidemia(9));
    }

    static int epidemia(int dni) {
        if (dni == 1) return 10;
        else if (dni > 1 && dni < 7) {
            return 3 * epidemia(dni - 1);
        } else if (dni == 7) {
            return 3 * epidemia(dni - 1) - epidemia(dni - 6);
        } else {
            return 3 * epidemia(dni - 1) - epidemia(dni - 7) * 2;
        }

    }
}
