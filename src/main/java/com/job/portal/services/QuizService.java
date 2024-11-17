package com.job.portal.services;

import com.job.portal.model.Quiz;

/**
 * QuizService
 */
public interface QuizService {
    String createQuiz(Quiz quiz);

    String deleteQuiz(Long id);

    java.util.List<Quiz> getQuizs();

    Quiz getQuiz(Long id);

    String updateQuiz(Quiz quiz, Long id);

}