package DB;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        DB_acces dbAccess= DB_acces.getInstance();

        Adding adding = Adding.getInstance();

        Show show = Show.getInstance();

        try {
            Menu menu = new Menu(dbAccess, adding, show);
            menu.menu();
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n");
            e.printStackTrace();
        }
    }
}
