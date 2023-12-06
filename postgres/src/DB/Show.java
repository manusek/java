package DB;

import java.util.ArrayList;

public class Show {
    private static Show show;

    public static Show getInstance() {
        if (show == null) {
            show = new Show();
        }
        return show;
    }

    public void showStudentsLOCAL(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("Nie znaleziono studentow");
        } else {
            for (int i = 0; i < students.size(); i++) {
                System.out.println(students.get(i));
            }
        }
    }


}
