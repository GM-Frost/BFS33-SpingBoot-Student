package com.takeo.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.takeo.student.model.Student;
import com.takeo.student.model.StudyNote;
import com.takeo.student.repository.StudyNoteRepository;

@RestController
@RequestMapping("/studynotes")
public class StudyNoteController {
private final StudyNoteRepository studyNoteRepository;
	
	
	@Autowired
	public StudyNoteController(StudyNoteRepository studyNoteRepository) {
		this.studyNoteRepository = studyNoteRepository;
		
	}
	
	@GetMapping("/allNotes")
	public List<StudyNote> getAllNotes()
	{
		return studyNoteRepository.findAll();
	}
	
	@PostMapping
	public StudyNote createNote(@RequestBody StudyNote studynote) {
		return studyNoteRepository.save(studynote);
	}
	
	@GetMapping("/{id}")
	public StudyNote getNoteById(@PathVariable Long id) {
		return studyNoteRepository.findById(id).orElse(null);
	}
	
	@PutMapping("/{id}")
	public StudyNote updateNote(@PathVariable Long id, @RequestBody StudyNote updateNote) {
		
		StudyNote exisitingNote = studyNoteRepository.findById(id).orElse(null);
		
		if(exisitingNote!=null) {
			exisitingNote.setContent(updateNote.getContent());
			return studyNoteRepository.save(exisitingNote);
		}
		
		return null;
	}
}
