package algorytmy;

    public class Lody {


        final static int N = 6; // permutacje n-elementowe
        private static int[] l = new int[N];
        public static int[] tabs = new int[7]; // PRZEJSCIA SMAKOW

        public static int[][] tab = {
                {0, 7, 20, 21, 12, 23},
                {27, 0, 13, 16, 46 ,5},
                {53, 15 ,0, 25, 27, 6},
                {16, 2, 35, 0, 47, 10},
                {31, 29, 5, 18, 0, 4},
                {28, 24, 1, 17, 5, 0}
        };

        static int suma; // CZAS
        static int najlepszy = 1000000; // NAJLEPSZY CZAS

        public static void main(String[] args) {
            permutacje(0);
            System.out.println("najelpszy czas to: " + najlepszy);
        }

        static void permutacje(int i) {
            if (i == N) {

                for (int j = 0; j < N; j++) {   //PRZYPISYWANIE SMAKOW DO TABLICY

                    tabs[j] = l[j];
                    tabs[6] = l[0]; // UZUPELNIANIE TABLICY WRAZ Z POWROTEM NA POCZATKOWY SMAK
                    System.out.print(l[j] + " ");

                }
                for (int z = 0; z < N; z++) {

                    int x = tabs[z]; // TUTAJ PRZECHOWYWANA JEST LICZBA
                    int y = tabs[z + 1];
                    suma += tab[x - 1][y - 1]; // JAKO ZE INDEXUJEMY OD 0 TO ODEJMUJEMY 1 I MAMY MIEJSCE W TABLICY

                }

                if (suma < najlepszy){
                    najlepszy = suma; // SPRAWDZANIE NAJLEPSZEGO CZASU
                }

                System.out.print(l[0] + ", czas oczekiwania: " + suma);
                suma  = 0; // ABY DLA KAZDEJ MOZLIWOSCI DOBRZE ZLICZALO CZAS
                System.out.println();

            } else {
                for (int j = 1; j <= N; j++) {
                    int k;
                    for (k = 0; k < i; k++) {
                        if (l[k] == j) {
                            break;
                        }
                    }
                    if (k == i) {
                        l[k] = j;
                        permutacje(i + 1);
                    }
                }
            }
        }
    }

