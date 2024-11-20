package com.job.portal.services.implementations;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.portal.model.Question;
import com.job.portal.repo.QuestionRepo;
import com.job.portal.repo.QuizRepo;
import com.job.portal.services.QuestionService;

import jakarta.transaction.Transactional;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepo cRepo;
    @Autowired
    private QuizRepo qzRepo;

    @Override
    public List<Question> getQuestions() {
        return this.cRepo.findAll();
    }
    // private static java.util.Map<String, String> map = new java.util.HashMap<>();

    @Override
    public String createQuestion(Question cat) {
        this.cRepo.save(cat);
        return cat.getQuestion() + " Saved Successfully!!";
    }

    @Override
    public List<Question> getQuestionsQuiz(Long id) {
        return this.cRepo.findByQuiz(this.qzRepo.findCustomQuery(id));
    }

    @Override
    @Transactional
    public String removeQuiz(Long qid) {
        this.cRepo.removeQuiz(qid);
        return "Deleted Successfully!!";
    }


    @Override
    public String deleteQuestion(Long id) {
        Question cat = this.cRepo.findById(id).get();
        if (cat != null) {
            this.cRepo.deleteById(id);
            return cat.getQuestion() + " Deleted Successfully";
        }
        return "Unable to Delete Question";
    }

    @Override
    public String updateQuestion(Question cat, Long id) {
        Question ct = this.cRepo.findById(id).get();
        if (ct == null)
            return "Wrong Question !!";
        ct.setQuestion(cat.getQuestion());
        ct.setQuiz(cat.getQuiz());
        ct.setAnswer(cat.getAnswer());
        ct.setImage(cat.getImage());
        // ct.set(cat.get());
        ct.setOption1(cat.getOption1());
        ct.setOption2(cat.getOption2());
        ct.setOption3(cat.getOption3());
        ct.setOption4(cat.getOption4());
        // ct.set(cat.get());
        this.cRepo.save(ct);
        return ct.getQuestion() + " Updated Successfully !!!";
    }
}
