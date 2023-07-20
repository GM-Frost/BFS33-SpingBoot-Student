package com.takeo.student.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity 
public class Student {
	 @Id 
	 @GeneratedValue(strategy = GenerationType.IDENTITY) 
	 private Long id; 
	 private String name; 
	 
	 @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
	 private StudyNote studyNote;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StudyNote getStudyNote() {
		return studyNote;
	}

	public void setStudyNote(StudyNote studyNote) {
		this.studyNote = studyNote;
	} 
	 
	 
	   
}
