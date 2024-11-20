package com.job.portal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.job.portal.model.Quiz;
import java.util.List;
import com.job.portal.model.Category;


@Repository
public interface QuizRepo extends JpaRepository<Quiz, Long> {
    // public Quiz findByQz_id(long qz_id);
    @Query("SELECT e FROM Quiz e WHERE e.qz_id = :qz_id")
    Quiz findCustomQuery(@Param("qz_id") Long qz_id);
    // java.util.List<Quiz> findByCate(Long id)
    List<Quiz> findByCategory(Category category);
}
