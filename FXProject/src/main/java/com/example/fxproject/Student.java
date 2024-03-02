package com.example.fxproject;

import java.util.Date;

public class Student {
    private int id;
    private String name;
    private String scndName;
    private String city;
    private int albumNumber;
    private Date creationDate;


    public Student(int id, String name, String scndName, String city, int albumNumber, Date date){
        this.id = id;
        this.name = name;
        this.scndName = scndName;
        this.city = city;
        this.albumNumber = albumNumber;
        this.creationDate = date;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public String getScndName() {
        return scndName;
    }

    public int getAlbumNumber() {
        return albumNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScndName(String scndName) {
        this.scndName = scndName;
    }

    public void setAlbumNumber(int albumNumber) {
        this.albumNumber = albumNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
