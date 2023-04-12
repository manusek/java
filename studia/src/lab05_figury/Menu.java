package lab05_figury;

import java.util.Scanner;

public class Menu {
        public void wybor () {
            while (true) {
                System.out.println("Koło (1)");
                System.out.println("Kwadrat (2)");
                System.out.println("Prostokąt (3)");
                System.out.println("Sześcian (4)");
                System.out.println("Prostopadłościan (5)");
                System.out.println("Kula (6)");
                System.out.println("Stożek (7)");
                System.out.println("Wyjscie (8)");
                System.out.print("Wybierz figurę: ");
                int i = InputInt();
                switch (i) {
                    case 1:
                        k1();
                        break;
                    case 2:
                        k2();
                        break;
                    case 3:
                        k3();
                        break;
                    case 4:
                        k4();
                        break;
                    case 5:
                        k5();
                        break;
                    case 6:
                        k6();
                        break;
                    case 7:
                        k7();
                        break;
                    case 8:
                        close();
                        break;
                }
                String test = " ";
                do{
                    System.out.print("\nCzy chcesz koontynuowac ? (t/n)");
                    test = InputString();
                    if((test.equals("n")))close();
                    else if((test.equals("t")))wybor();
                }while(!(test.equals("n")) || !(test.equals("t")));
            }
        }
        private int InputInt () {
        Scanner wczytywanie = new Scanner(System.in);
        return wczytywanie.nextInt();
    }
        private double InputDouble () {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }
        public static String InputString(){
            Scanner wczytywanie2 = new Scanner(System.in);
            String a = wczytywanie2.nextLine();
            return a;
        }
        private void k1 () {
        System.out.print("Podaj promień: ");
        double r = InputDouble();
        Kolo k = new Kolo(r);
        k.wyswietl();
    }
        private void k2 () {
        System.out.print("Podaj bok: ");
        double a = InputDouble();
        Kwadrat kw = new Kwadrat(a);
        kw.wyswietl();
    }
        private void k3 () {
        System.out.print("Podaj pierwszy bok: ");
        double a = InputDouble();
        System.out.print("Podaj drugi bok: ");
        double b = InputDouble();
        Prostakat pr = new Prostakat(a, b);
        pr.wyswietl();
    }
        private void k4 () {
        System.out.print("Podaj bok: ");
        double a = InputDouble();
        Szescian sz = new Szescian(a);
        sz.wyswietl();
    }
        private void k5 () {
        System.out.print("Podaj pierwszy bok: ");
        double a = InputDouble();
        System.out.print("Podaj drugi bok: ");
        double b = InputDouble();
        System.out.print("Podaj trzeci bok: ");
        double c = InputDouble();
        Prostopadloscian pro = new Prostopadloscian(a, b, c);
        pro.wyswietl();
    }
        private void k6 () {
        System.out.print("Podaj promień: ");
        double r = InputDouble();
        Kula ku = new Kula(r);
        ku.wyswietl();
    }
        private void k7 () {
        System.out.print("Podaj wysokość: ");
        double h = InputDouble();
        System.out.print("Podaj promień: ");
        double r = InputDouble();
        System.out.print("Podaj bok: ");
        double l = InputDouble();
        Stozek st = new Stozek(h, r, l);
        st.wyswietl();
    }
        private void close(){
            System.out.println("Dziekujemy :)");
            System.exit(0);
        }

}
