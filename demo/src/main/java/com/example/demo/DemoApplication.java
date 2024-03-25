package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

//	@GetMapping(value = "/users")
//	public List<Student> getAllStudents() {
//		return studentRepository.findAll();
//	}

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
	@PutMapping("/users/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Long studentId, @RequestBody Student studentDetails) throws ResourceNotFoundException {
		Student student = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + studentId));

		student.setName(studentDetails.getName());
		student.setAge(studentDetails.getAge());
		student.setCity(studentDetails.getCity());
		final Student updatedEmployee = studentRepository.save(student);
		return ResponseEntity.ok(updatedEmployee);
	}



	public Student getStudent(){
		return new Student("Kacper", 21, "Rzeszow");
	}
}
