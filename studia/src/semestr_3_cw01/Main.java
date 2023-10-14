package semestr_3_cw01;

public class Main {
    public static void main(String[] args) {

        try {
            Studenci student = new Studenci();
            student.menu();
        }
        catch(Exception e) {
            System.out.println(e.getMessage()+"\n");
            e.printStackTrace();
        };
    }
}
