package algorytmy;

public class FIBO_ILOCZYN_POPRZEDNIHC {

    public static void main(String[] args) {
        final int N = 5; // n-ty wyraz ciagu
        System.out.println(fibo(N));
    }

    static int fibo(int n) {
        if (n == 1)
            return 2;
        if (n == 2)
            return 4;
        else {
            return (fibo(n - 1) * fibo(n - 2)) / 2;
        }
    }
}
