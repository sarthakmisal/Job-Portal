package com.job.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.portal.model.Question;
import com.job.portal.services.QuestionService;

@RestController
@RequestMapping("question")
// @CrossOrigin("http://[::1]:4200")
@CrossOrigin("*")
public class QuestionController {
    @Autowired
    private QuestionService qService;

    @GetMapping("get")
    public java.util.List<Question> getCategories() {
        return this.qService.getQuestions();
    }
    @GetMapping("quiz/{id}")
    public java.util.List<Question> getQuestionsQuiz(@PathVariable Long id) {
        return this.qService.getQuestionsQuiz(id);
    }
    
    @PutMapping("removeQuestion/{id}")
    public String removeQuiz(@PathVariable Long id, @RequestBody Question que) {
        return this.qService.removeQuiz(que.getQ_id());
    }
    @PostMapping("create")
    public String saveQuestion(@RequestBody Question Question) {
        return this.qService.createQuestion(Question);
    }

    @PutMapping("update/{id}")
    public String updateQuestion(@PathVariable Long id, @RequestBody Question que) {
        return this.qService.updateQuestion(que, id);
    }

    @DeleteMapping("delete/{id}")
    public String deleteQuestion(@PathVariable Long id) {
        return this.qService.deleteQuestion(id);
    }
}
