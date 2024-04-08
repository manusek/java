package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //wyswietlanie wszystkich studentow
//        StudentOutput studentOutput = new StudentOutput();
//        studentOutput.show();

        //dodawanie studenta
//        StudentInput studentInput = new StudentInput();
//        JsonParser.addStudent(studentInput.add());
//
        //usuwanie studenta
        StudentInput studentInput = new StudentInput();
        JsonParser.deleteStudent(studentInput.delete());
    }
}
