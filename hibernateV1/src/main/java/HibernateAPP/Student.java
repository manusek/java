package HibernateAPP;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //autoinkrementacja ID
    private int id;
    private String name;
    private String secondName;
    private int albumNumber;

    public Student() {
        super();
    }

    public Student(int id, String name, String secondName, int albumNumber) {
        super();
        this.id = id;
        this.name = name;
        this.secondName = secondName;
        this.albumNumber = albumNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAlbumNumber() {
        return albumNumber;
    }

    public void setAlbumNumber(int albumNumber) {
        this.albumNumber = albumNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", albumNumber=" + albumNumber +
                '}';
    }
}
