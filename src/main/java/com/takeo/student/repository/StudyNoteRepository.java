package com.takeo.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.takeo.student.model.StudyNote;

public interface StudyNoteRepository extends JpaRepository<StudyNote, Long>{

}
