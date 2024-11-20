package com.job.portal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.job.portal.model.Category;
import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Long>{
    @Query("select e from Category e where e.cat_id=:cat_id")
    Category findByCatid(Long cat_id);
    // List<Category> findByCat_id(Long cat_id);
}
