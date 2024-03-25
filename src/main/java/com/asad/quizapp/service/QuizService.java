package com.asad.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.asad.quizapp.dao.QuestionDao;
import com.asad.quizapp.dao.QuizDao;
import com.asad.quizapp.model.Question;
import com.asad.quizapp.model.Quiz;

@Service
public class QuizService {

	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		try {
			List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ);
			
			Quiz quiz = new Quiz();
			quiz.setTitle(title);
			quiz.setQuestions(questions);
			
			quizDao.save(quiz);
			
			return new ResponseEntity("Successfully created quiz!", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity("Invalid request!", HttpStatus.BAD_REQUEST);
		}
	}
}
