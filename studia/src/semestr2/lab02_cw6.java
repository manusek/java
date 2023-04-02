package semestr2;

import java.util.Scanner;

public class lab02_cw6 {
    public static void main(String[] args) {
      run();
    }
    public static void run(){
        while(true){
            System.out.print("Podaj liczbe: ");
            int a = InputInt();
            if(a<0)break;
        }
    }
    public static int InputInt(){
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        return num;
    }
}
