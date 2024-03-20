package com.example.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "students")
@Getter
@Setter
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;
    private String city;

    public Student() {
    }

    public Student(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }
}
