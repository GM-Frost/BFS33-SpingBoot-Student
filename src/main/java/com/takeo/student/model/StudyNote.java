package com.takeo.student.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity 
public class StudyNote {
	  @Id 
	  @GeneratedValue(strategy = GenerationType.IDENTITY) 
	  private Long id; 
	  private String content; 
	    
	  @OneToOne 
	  @JoinColumn(name = "student_id") 
	  private Student student;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	} 
	  
	  
}
