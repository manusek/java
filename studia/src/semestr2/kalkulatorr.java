package semestr2;

import java.util.Scanner;

public class kalkulatorr {
    public static void main(String[] args)
    {
        run();
    }
    public static void run(){
        while(true) {
            menu();
        }
    }
    public static void menu(){
        System.out.println("Dodawanie (1)");
        System.out.println("Odejmowanie (2)");
        System.out.println("Mnożenie (3)");
        System.out.println("Dzielenie (4)");
        System.out.println("Potęgowanie (5)");
        System.out.println("Pierwiastkowanie (6)");
        System.out.println("Trygonometria (7)");
        System.out.println("Wyjscie (8)");
        System.out.print("Jakie działanie chcesz wykonać: ");
        int liczba = InputInt();
        switch (liczba) {
            case 1 -> suma();
            case 2 -> roznica();
            case 3 -> iloczyn();
            case 4 -> iloraz();
            case 5 -> potega();
            case 6 -> pierwiastek();
            case 7 -> funTryg();
            case 8 -> close();
        }
        String test = " ";
        do{
        System.out.print("Czy chcesz koontynuowac ? (t/n)");
        test = InputString();
        if((test.equals("n")))close();
            else if((test.equals("t")))menu();
        }while(!(test.equals("n")) || !(test.equals("t")));


    }
    public static int InputInt(){
        Scanner wczytywanie = new Scanner(System.in);
        return wczytywanie.nextInt();

    }
    public static String InputString(){
        Scanner wczytywanie2 = new Scanner(System.in);
        String a = wczytywanie2.nextLine();
        return a;
    }
    public static void suma(){
        System.out.println("Dodawanie");
        System.out.print("Podaj 1 liczbe: ");
        int a = InputInt();
        System.out.print("Podaj 2 liczbe: ");
        int b = InputInt();
        System.out.println(a+" + "+b+" = "+(a+b));
    }
    public static void roznica(){
        System.out.println("Odejmowanie");
        System.out.print("Podaj 1 liczbe: ");
        int a = InputInt();
        System.out.print("Podaj 2 liczbe: ");
        int b = InputInt();
        System.out.println(a+" - "+b+" = "+(a-b));
    }
    public static void iloczyn(){
        System.out.println("Mnożenie");
        System.out.print("Podaj 1 liczbe: ");
        int a = InputInt();
        System.out.print("Podaj 2 liczbe: ");
        int b = InputInt();
        System.out.println(a+" * "+b+" = "+(a*b));
    }
    public static void iloraz() {
        int b=1;
        System.out.println("Dzielenie");
        System.out.print("Podaj 1 liczbe: ");
        int a = InputInt();
        do {
            System.out.print("Podaj 2 liczbe: ");
            b = InputInt();
            if(b==0) System.out.println("Nie dzieli sie przez 0 !!");
        }while(b==0);
        System.out.println(a + " / " + b + " = " + (a / b));
    }
    public static void potega(){
        System.out.println("Potęgowanie");
        System.out.print("Podaj podstawę potęgi: ");
        int a = InputInt();
        System.out.print("Podaj wykładni potęgi: ");
        int b = InputInt();
        System.out.println(a+" ^ "+b+" = "+Math.pow(a,b));
    }
    public static void pierwiastek(){
        System.out.println("Pierwiastkowanie");
        System.out.print("Podaj liczbe: ");
        int a = InputInt();
        System.out.println("Pierwiastek z "+a+" = "+Math.sqrt(a));
    }
    public static void funTryg(){
        int a = 0;
        System.out.println("Kąty");
        do {
        System.out.print("Podaj liczbe stopni: ");
            a = InputInt();
            if(a<0 || a>360)System.out.println("Podaj liczbe z przedziału <0.360>");
        }while(a<0 || a>360);
        System.out.println("Sin(" + a + ") = " + Math.sin(a) + "\nCos(" + a + ") = " + Math.cos(a) + "\nTg(" + a + ") = " + Math.tan(a));
        }
    public static void close(){
        System.out.println("Dziekujemy :)");
        System.exit(0);
    }
}
