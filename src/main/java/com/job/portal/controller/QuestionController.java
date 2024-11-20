package com.job.portal.controller;

import java.util.ArrayList;
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
    public List<Question> getCategories() {
        return this.qService.getQuestions();
    }

    @GetMapping("getQuestionsOnly/{id}")
    public List<Question> getQuestionsOnly(@PathVariable Long id) {
        List<Question> ls = this.qService.getQuestionsQuiz(id);
        List<Question> list = new ArrayList<>();
        for (Question que : ls) {
            Question q = new Question();
            q.setQuestion(que.getQuestion());
            q.setImage(que.getImage());
            q.setOption1(que.getOption1());
            q.setOption2(que.getOption2());
            q.setOption3(que.getOption3());
            q.setOption4(que.getOption4());
            q.setQuiz(que.getQuiz());
            q.setQ_id(que.getQ_id());
            q.setAnswer(que.getAnswer());
            list.add(q);
        }
        return list;
    }

    @GetMapping("quiz/{id}")
    public List<Question> getQuestionsQuiz(@PathVariable Long id) {
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
