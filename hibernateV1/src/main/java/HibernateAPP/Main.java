package HibernateAPP;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        StudentDao studentDao = new StudentDao();

        InputStudent inputStudent = new InputStudent();

        OutputStudent outputStudent = new OutputStudent();

        try {
            Menu menu = new Menu(inputStudent, outputStudent, studentDao);
            menu.menu();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
