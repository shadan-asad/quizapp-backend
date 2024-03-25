package com.asad.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.asad.quizapp.dao.QuestionDao;
import com.asad.quizapp.model.Question;

@Service
public class QuestionService {

	@Autowired
	QuestionDao questionDao;
	
	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
			return new ResponseEntity(questionDao.findAll(), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new ArrayList<>(), HttpStatus.BAD_REQUEST);
		}
		
	}

	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		try {
			return new ResponseEntity(questionDao.findByCategory(category), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new ArrayList<>(), HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<String> addQuestion(Question ques) {
		try {
			questionDao.save(ques);
			return new ResponseEntity("Data added successfully!", HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity("Invalid data!", HttpStatus.BAD_REQUEST);
		}

	}

	public ResponseEntity<String> deleteQuestion(String id) {
		try {
			questionDao.deleteById(Integer.parseInt(id));
			return new ResponseEntity("Data deleted successfully!", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity("Data not found!", HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity updateQuestion(Integer id, Question ques) {
		try {
			Question q = questionDao.findById(id).orElseThrow();
			ques.setId(q.getId());
			questionDao.save(ques);
			return new ResponseEntity(ques, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity("Data not found!", HttpStatus.BAD_REQUEST);
		}
	}

}
