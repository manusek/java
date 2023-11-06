package semestr_3_cw02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        String choice = e.getActionCommand();
        if (choice.equals("Nowy")){
            System.out.println("Tworze nowy plik");
        } else if (choice.equals("Otwórz")) {
            System.out.println("Otwieram plik");
        } else if (choice.equals("Zapisz")) {
            System.out.println("Zapisuje plik");
        }else System.exit(0);

    }
}