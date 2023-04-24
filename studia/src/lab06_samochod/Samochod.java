package lab06_samochod;

import java.util.Scanner;

public class Samochod {
    private String marka, model, nadwozie, kolor;

    private int rokProdukcji, przebieg;

    public Samochod(){
        System.out.print("Podaj marke samochodu: ");
        marka = InputString();
        System.out.print("Podaj model samochodu: ");
        model = InputString();
        System.out.print("Podaj rodzaj nadwozia: ");
        nadwozie = InputString();
        System.out.print("Podaj kolor nadwozia: ");
        nadwozie = InputString();
        System.out.print("Podaj rok produkcji: ");
        rokProdukcji = InputInt();
        while(true) {
            System.out.print("Podaj przebieg: ");
            przebieg = InputInt();
            if(przebieg<0) System.out.println("Przebieg nie moze byc ujemny!");
            else break;
        }
    }


    public Samochod(String marka, String model, String nadwozie, String kolor, int rokProdukcji, int przebieg) {
        this.marka = marka;
        this.model = model;
        this.nadwozie = nadwozie;
        this.kolor = kolor;
        this.rokProdukcji = rokProdukcji;
        this.przebieg = przebieg;
    }

    public String InputString(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public int InputInt(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


    public String wyswietl() {
        return "Informacje o samochodzie: " +
                "marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", nadwozie='" + nadwozie + '\'' +
                ", kolor='" + kolor + '\'' +
                ", rokProdukcji=" + rokProdukcji +
                ", przebieg=" + przebieg;
    }
}
