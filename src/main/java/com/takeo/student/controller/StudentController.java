package com.takeo.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.takeo.student.model.Student;
import com.takeo.student.repository.StudentRepository;
import com.takeo.student.repository.StudyNoteRepository;

@RestController 
@RequestMapping("/students") 
public class StudentController {

	private final StudentRepository studentRepository;
	
	
	@Autowired
	public StudentController(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;

	}
	
	@GetMapping("/allStudents")
	public List<Student> getAllStudents()
	{
		return studentRepository.findAll();
	}

	@PostMapping
	public Student createStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable Long id) {
		return studentRepository.findById(id).orElse(null);
	}
	
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable Long id, @RequestBody Student updateStudent) {
		Student existingStudent = studentRepository.findById(id).orElse(null);
		
		if(existingStudent!=null) {
			existingStudent.setName(updateStudent.getName());
			return studentRepository.save(existingStudent);
		}
		return null;
	}
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Long id) {
		studentRepository.deleteById(id);
	}
}
