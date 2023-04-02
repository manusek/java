package semestr2;

import java.util.Scanner;

public class lab02_cw3i4 {
    public static void main(String[] args) {
        run();
    }
    public static void run(){
        while(true) {
            menu();
        }
    }
    public static void menu(){
        //InputTab();
        double[] tab2 = InputTab();
        System.out.println("Wyswietlanie tablicy (1)");
        System.out.println("Wyswietlanie w odwrotnej kolejnosc (2)");
        System.out.println("Wyswietlanie indeksów nieparzystych (3)");
        System.out.println("Wyswietlanie indeksów parzystych (4)");
        System.out.println("Suma elementów tablicy (5)");
        System.out.println("Iloczyn elementów tablicy (6)");
        System.out.println("Srednia wartość (7)");
        System.out.println("Min (8)");
        System.out.println("Max (9)");
        System.out.println("Wyjscie (10)");
        System.out.print("Jakie działanie chcesz wykonać: ");
        int liczba = InputInt();
        switch (liczba) {
              case 1 -> wyswietl(tab2);
              case 2 -> wyswietl2(tab2);
              case 3 -> wyswietl3(tab2);
              case 4 -> wyswietl4(tab2);
              case 5 -> wyswietl5(tab2);
              case 6 -> wyswietl6(tab2);
              case 7 -> wyswietl7(tab2);
              case 8 -> wyswietl8(tab2);
              case 9 -> wyswietl9(tab2);
              case 10 -> close();
        }
        String test = " ";
        do{
            System.out.print("Czy chcesz koontynuowac ? (t/n)");
            test = InputString();
            if((test.equals("n")))close();
            else if((test.equals("t")))menu();
        }while(!(test.equals("n")) || !(test.equals("t")));
    }
    public static double[] InputTab(){
        double[] tab = new double[10];
        for(int i=0; i<tab.length; i++){
            System.out.print("Podaj tab["+i+"]: ");
            tab[i] = InputDouble();
        }
            return tab;
    }
    public static double InputDouble(){
        Scanner wczytywanie = new Scanner(System.in);
        return wczytywanie.nextDouble();
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
    public static void close(){
        System.out.println("Dziekujemy :)");
        System.exit(0);
    }
    public static void wyswietl(double[] tab){
        for(int i = 0; i<tab.length; i++){
            System.out.print(tab[i]+", ");
        }
        System.out.println();
    }
    public static void wyswietl2(double[] tab){
        for(int i = tab.length - 1; i>=0; i--){
            System.out.print(tab[i]+", ");
        }
        System.out.println();
    }
    public static void wyswietl3(double[] tab){
        for(int i = 0; i<tab.length; i++){
            if(i%2 != 0)System.out.print(tab[i]+", ");
        }
        System.out.println();
    }
    public static void wyswietl4(double[] tab){
        for(int i = 0; i<tab.length; i++){
            if(i%2 == 0)System.out.print(tab[i]+", ");
        }
        System.out.println();
    }
    public static void wyswietl5(double[] tab){
        double suma = 0;
        for(int i = 0; i<tab.length; i++){
             suma += tab[i];
        }
        System.out.println("Suma = "+suma);
    }
    public static void wyswietl6(double[] tab){
        double iloczyn = 1;
        for(int i = 0; i<tab.length; i++){
            iloczyn = iloczyn * tab[i];
        }
        System.out.println("Iloczyn = "+iloczyn);
    }
    public static void wyswietl7(double[] tab){
        double suma = 0;
        for(int i = 0; i<tab.length; i++){
            suma += tab[i];
        }
        double wynik = suma/ tab.length;
        System.out.println("Średnia wartość = "+wynik);
    }
    public static void wyswietl8(double[] tab){
        double min = tab[0];
        for(int i = 1; i<tab.length; i++){
            if(tab[i]<min)min=tab[i];
        }
        System.out.println("Min = "+min);
    }
    public static void wyswietl9(double[] tab){
        double max = tab[0];
        for(int i = 1; i<tab.length; i++){
            if(tab[i]>max)max=tab[i];
        }
        System.out.println("Max = "+max);
    }
}
