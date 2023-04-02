package semestr2;

public class lab02_cw5 {
    public static void main(String[] args) {
        run();
    }
    public static void run(){
        for(int i = 0; i<=20; i++){
            if(i==2 || i==6 || i==9 || i==15 || i==19)continue;
            System.out.print(i+", ");
        }
    }
}
