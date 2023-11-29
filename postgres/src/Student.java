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

    @Override
    public String toString() {
        return  "imie='" + name + '\'' +
                ", nazwisko='" + scndName + '\'' +
                ", numer albumu=" + albumNumber +
                ", data utworzenia=" + date +
                '}';
    }

}
