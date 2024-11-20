package com.job.portal.services;

import java.util.List;
import com.job.portal.model.Question;

public interface QuestionService {
    String createQuestion(Question que);

    String deleteQuestion(Long id);

    List<Question> getQuestions();

    List<Question> getQuestionsQuiz(Long id);

    String updateQuestion(Question que, Long id);

    String removeQuiz(Long q_id);


}
