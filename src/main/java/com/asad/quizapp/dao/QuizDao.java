package com.asad.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asad.quizapp.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer>{

}
