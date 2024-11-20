package com.job.portal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.job.portal.model.Question;
import com.job.portal.model.Quiz;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long> {
    List<Question> findByQuiz(Quiz quiz);

    @Modifying
    @Query("UPDATE Question q SET q.quiz = null WHERE q.q_id = :qid")
    void removeQuiz(Long qid);
}
