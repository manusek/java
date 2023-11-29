package DB;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        try {
            Menu menu = new Menu();
            menu.menu();
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n");
            e.printStackTrace();
        }
    }
}
