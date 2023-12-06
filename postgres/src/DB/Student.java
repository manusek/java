package DB;

import java.util.Date;

public class Student {

    private int id;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setScndName(String scndName) {
        this.scndName = scndName;
    }

    public void setAlbumNumber(long albumNumber) {
        this.albumNumber = albumNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", name='" + name + '\'' +
                ", scndName='" + scndName + '\'' +
                ", albumNumber=" + albumNumber +
                ", date=" + date;
    }
}
