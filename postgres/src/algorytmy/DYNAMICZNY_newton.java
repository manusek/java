package algorytmy;

public class DYNAMICZNY_newton {

    final static int N = 15;
    final static int K = 3;

    public static void main(String[] args) {
        int[][] tab = new int[K + 1][N + 1];

        for (int n = 0; n <= N; n++) //Wypelnianie pierwszego wiersza - K=0
            tab[0][n] = 1;

        for (int k = 0; k <= K; k++) //Wypelnianie przekatnej - K==N
            for (int n = 0; n <= N; n++)
                if (k == n)
                    tab[k][n] = 1;

        for (int k = 1; k <= K; k++) //Wypelnianie pozostalych komorek
            for (int n = 2; n <= N; n++) {
                if (n < k)
                    continue;
                tab[k][n] = tab[k - 1][n - 1] + tab[k][n - 1];
            }

        for (int i = 0; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                int val = tab[i][j];
                if (val < 1000)
                    System.out.print(" ");
                if (val < 100)
                    System.out.print(" ");
                if (val < 10)
                    System.out.print(" ");
                System.out.print(val + "  ");
            }
            System.out.println();
        }
    }
}