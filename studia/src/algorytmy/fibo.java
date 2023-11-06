package algorytmy;

public class fibo {
    public static void main(String[] args) {
        System.out.println(newton(5,3));
    }
    static int newton(int n, int k){
        if(k == 0 || k == n)
            return 1;
        else
            return newton(n - 1, k - 1) + newton(n - 1, k);
    }
}
