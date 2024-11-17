package com.job.portal.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.portal.model.Quiz;
import com.job.portal.repo.QuizRepo;
import com.job.portal.services.QuizService;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuizRepo qRepo;

    @Override
    public String createQuiz(Quiz quiz) {
        this.qRepo.save(quiz);
        return quiz.getTitle() + " Quiz saved Successfully!!";
    }

    @Override
    public String deleteQuiz(Long id) {
        this.qRepo.deleteById(id);
        return "Deleted SUccessfully !!!";
    }

    @Override
    public List<Quiz> getQuizs() {
        return this.qRepo.findAll();
    }

    @Override
    public Quiz getQuiz(Long id) {
        return this.qRepo.findCustomQuery(id);
    }

    @Override
    public String updateQuiz(Quiz quiz, Long id) {
        Quiz q=this.qRepo.findById(id).get();
        // Quiz qz = new Quiz();
        q.setCategory(quiz.getCategory());
        q.setDescription(quiz.getDescription());
        q.setNo_Of_Que(quiz.getNo_Of_Que());
        q.setQuestions(quiz.getQuestions());
        q.setStatus(quiz.getStatus());
        q.setTitle(quiz.getTitle());
        q.setMarksPer(quiz.getMarksPer());
        this.qRepo.save(q);
        return q.getTitle() + " Updated Successfully!!";
    }

}
