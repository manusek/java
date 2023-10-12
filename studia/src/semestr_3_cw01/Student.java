package semestr_3_cw01;

import java.util.Date;

public class Student {
    private final int id = 0;
    private String name;
    private String scndName;
    private long albumNumber;
    private Date date= new Date();


    public Student(String name, String scndName, long albumNumber) {
        this.name = name;
        this.scndName = scndName;
        this.albumNumber = albumNumber;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public String getScndName() {
        return scndName;
    }

    public long getAlbumNumber() {
        return albumNumber;
    }

    @Override
    public String toString() {
        return  "imie='" + name + '\'' +
                ", nazwisko='" + scndName + '\'' +
                ", numer albumu=" + albumNumber +
                ", data utworzenia=" + date +
                '}';
    }

}
