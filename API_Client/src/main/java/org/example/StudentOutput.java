package org.example;

import java.io.IOException;
import java.util.List;

public class StudentOutput {

    public void show() throws IOException {
        List<StudentDTO> list = JsonParser.getAllStudents();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
