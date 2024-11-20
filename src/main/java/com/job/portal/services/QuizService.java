package com.job.portal.services;

import java.util.List;

import com.job.portal.model.Category;
import com.job.portal.model.Quiz;

/**
 * QuizService
 */
public interface QuizService {
    String createQuiz(Quiz quiz);

    String deleteQuiz(Long id);

    java.util.List<Quiz> getQuizs();

    java.util.List<Quiz> getQuizzesByCategory(long id);
    // Category getQuizzesByCategory(long id);

    Quiz getQuiz(Long id);

    String updateQuiz(Quiz quiz, Long id);


}