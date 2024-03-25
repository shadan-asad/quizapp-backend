package com.asad.quizapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asad.quizapp.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
	public List<Question> findByCategory(String category);

	@Query(value = "SELECT * FROM question q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
	public List<Question> findRandomQuestionsByCategory(String category, int numQ);
}
