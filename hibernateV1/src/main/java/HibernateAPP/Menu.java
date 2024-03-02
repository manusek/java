package HibernateAPP;

import java.sql.SQLException;

public class Menu {
    InputStudent inputStudent;
    OutputStudent outputStudent;
    StudentDao studentDao;

    public Menu(InputStudent inputStudent, OutputStudent outputStudent, StudentDao studentDao) {
        this.inputStudent = inputStudent;
        this.outputStudent = outputStudent;
        this.studentDao = studentDao;
    }

    public void menu() throws SQLException {
        while (true) {

            System.out.println(" ");
            System.out.println("Dodaj studenta (1)");
            System.out.println("Usuń studenta (2)");
            System.out.println("Wyswietl studentów (3)");
            System.out.println("Wyswietl studenta po id (4)");
            System.out.println("Edytuj studenta (5)");
            System.out.println("Zakończ (6)");
            System.out.print("Jakie działanie chcesz wykonać: ");

            int choice = inputStudent.inputInt();

            switch (choice) {
                case 1 -> {
                    studentDao.addStudent(inputStudent.add());
                }
                case 2 -> {
                    studentDao.deleteStudent(inputStudent.delete());
                }
                case 3 -> {
                    outputStudent.show(studentDao.getAllStudents());
                }
                case 4 -> {
                    try {
                        outputStudent.showById(studentDao.getStudentById(inputStudent.showByID()));
                    } catch (Exception e) {
                        System.out.println("Nie istnieje student o podanym id");
                    }
                }
                case 5 -> {
                    studentDao.editRecord(inputStudent.showByID(), inputStudent.add());
                }
                case 6 -> {
                    System.out.println("Dziękujemy");
                    System.exit(0);
                }
            }
        }
    }
}

