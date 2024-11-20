package com.job.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.job.portal.model.Category;
import com.job.portal.model.Quiz;
import com.job.portal.services.QuizService;

@RestController
// @CrossOrigin("http://[::1]:4200/")
@CrossOrigin("*")
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    private QuizService qzService;

    @GetMapping("get")
    public java.util.List<Quiz> getCategories() {
        return this.qzService.getQuizs();
    }
    @GetMapping("get/{id}")
    // public java.util.List<Quiz> getQuizzesByCategory(@PathVariable Long id) {
    public List<Quiz> getQuizzesByCategory(@PathVariable long id) {
        return this.qzService.getQuizzesByCategory(id);
        // return id;
    }
    @GetMapping("getq/{id}") // GETQUIZBYID
    public Quiz getQuiz(@PathVariable int id) {
        return this.qzService.getQuiz((long)id);
        // return id+"";
    }

    @PostMapping("create")
    public String saveQuiz(@RequestBody Quiz quiz) {
        // return "saved "+quiz.getTitle();
        // String str = quiz.getTitle();
        // String str = quiz.getDescription();
        // String str = quiz.getCategory();
        // str += quiz.getNo_Of_Que();
        // str += quiz.getQz_id();
        return this.qzService.createQuiz(quiz);
        // return quiz.getNo_Of_Que();
    }

    @PutMapping("update/{id}")
    public String updateQuiz(@PathVariable Long id, @RequestBody Quiz quiz) {
        return this.qzService.updateQuiz(quiz, id);
        // return id+"";
    }

    @DeleteMapping("delete/{id}")
    public String deleteQuiz(@PathVariable Long id) {
        return this.qzService.deleteQuiz(id);
    }
}
