package kolos;

public class Main {
    public static void main(String[] args) {
        //dzielniki(16);
        //sumaNiep(1,10);
       doskonala(7);
    }
    public static void dzielniki(int a){
        for(int i = 1;i<=a;i++){
            if(a%i==0) System.out.println(i+", ");
        }
    }
    public static void sumaNiep(int pocz, int kon) {
        int suma = 0;
        for (int i = pocz; i <= kon; i++) {
            if (i % 2 != 0) {
                suma += i;
                System.out.println(i);
            }
        }
        System.out.println("suma: " + suma);
    }

        public static void doskonala(int b){
            int suma2 = 0;
            for (int i = 1; i < b; i++) {
                if (b % i == 0) suma2 += i;
            }
            if (suma2 == b) System.out.println(b + " to liczba doskonala");
            else System.out.println(b + " to nie liczba doskonala"+suma2);
        }


}
