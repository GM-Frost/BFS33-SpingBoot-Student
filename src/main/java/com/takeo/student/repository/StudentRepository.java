package com.takeo.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.takeo.student.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

	

}
