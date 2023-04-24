package lab06_samochod;

import java.util.Scanner;

public class SamochodOsobowy extends Samochod {
    //Waga (powinna być z przedziału 2 t –4,5 t), Pojemność silnika (powinna być z przedziału 0,8-3,0), Ilość osób
    private double waga, pojSilnika;
    private int ilOsob;

    public SamochodOsobowy(){
        while(true) {
            System.out.print("Podaj wage samochodu(2t - 4.5t): ");
            waga = InputDouble();
            if(waga>2 && waga<4.5)break;
        }
        while(true) {
            System.out.print("Podaj pojemnosc silnika(0.8 - 3.0): ");
            pojSilnika = InputDouble();
            if(pojSilnika>0.8 && pojSilnika<3)break;
        }
        System.out.print("Podaj ilosc osob: ");
        ilOsob = super.InputInt();
    }



    public double InputDouble(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    @Override
    public String wyswietl() {
        return super.wyswietl() + ", waga="+waga+", pojemnosc silnika="+pojSilnika+", ilosc miejsc="+ilOsob;
    }
}
