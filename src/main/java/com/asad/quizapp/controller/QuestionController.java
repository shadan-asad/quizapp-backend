package com.asad.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asad.quizapp.model.Question;
import com.asad.quizapp.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@GetMapping("allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions() {
		return questionService.getAllQuestions();
	}
	
	@GetMapping("category/{id}")
	public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable("id") String category) {
		return questionService.getQuestionsByCategory(category);
	}
	
	@PostMapping()
	public ResponseEntity<String> addQuestion(@RequestBody Question ques) {
		return questionService.addQuestion(ques);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteQuestion(@PathVariable String id) {
		return questionService.deleteQuestion(id);

	}
	
	@PutMapping("{id}")
	public ResponseEntity updateQuestion(@PathVariable Integer id, @RequestBody Question ques) {
		return questionService.updateQuestion(id, ques);
	}

}
