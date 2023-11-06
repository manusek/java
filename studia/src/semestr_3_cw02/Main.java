package semestr_3_cw02;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("KOLOKWIUM");
        frame.setTitle("Kolokwium");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("WIDOKI");
        menuBar.add(menu);

        JMenuItem circle =new JMenuItem("KOŁO");
        circle.addActionListener(new Menu());
        menu.add(circle);

        JMenuItem square = new JMenuItem("KWADRAT");
        square.addActionListener(new Menu());
        menu.add(square);

        frame.add(menuBar, BorderLayout.NORTH);
        frame.setSize(400,400);
        frame.setVisible(true);

        //launch(args);

    }

}