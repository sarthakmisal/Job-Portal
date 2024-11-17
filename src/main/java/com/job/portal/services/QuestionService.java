package com.job.portal.services;

import com.job.portal.model.Question;

public interface QuestionService {
    String createQuestion(Question que);

    String deleteQuestion(Long id);

    java.util.List<Question> getQuestions();

    java.util.List<Question> getQuestionsQuiz(Long id);

    String updateQuestion(Question que, Long id);

    String removeQuiz(Long q_id);

}
