package HibernateAPP;

import java.util.List;

public class OutputStudent {

    private static OutputStudent outputStudent;

    public static OutputStudent getInstance(){
        if (outputStudent == null){
            outputStudent = new OutputStudent();
        }
        return outputStudent;
    }
    public void show(List<Student> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public void showById(Student student){
        System.out.println(student.toString());
    }
}
