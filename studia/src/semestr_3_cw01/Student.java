package semestr_3_cw01;

import java.util.ArrayList;
import java.util.Date;

public class Student {
    private String name;
    private String scndName;
    private long albumNumber;
    private Date date= new Date();

    public Student(String name, String scndName, long albumNumber) {
        this.name = name;
        this.scndName = scndName;
        this.albumNumber = albumNumber;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", scndName='" + scndName + '\'' +
                ", albumNumber=" + albumNumber +
                ", date=" + date +
                '}';
    }
}
