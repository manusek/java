package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication implements CommandLineRunner {

	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Student student = getStudent();
		studentRepository.save(student);

	}

	@GetMapping(value = "/users")
	public Student getUsers() {
		Student student = studentRepository.findAll().getFirst();
		return student;
	}

	@PostMapping(path = "/users",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public int createUser(@RequestBody Student std) {
		studentRepository.save(std);
        return std.getId();
    }

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable("id") String id) {
		studentRepository.deleteById(Long.valueOf(id));
	}

	public Student getStudent(){
		return new Student("Kacper", 21, "Rzeszow");
	}
}
