package algorytmy;

public class DZ_newton {

    public static void main(String[] args)
    {
        final int N = 3;
        final int K = 4;
        System.out.println(newton(N, K));
    }

    static int newton(int n, int k)
    {
        if (k == 0 || k == n)
            return 1;
        else
            return newton(n - 1, k - 1) + newton(n - 1, k);
    }
}
