package com.job.portal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.portal.model.Category;
@Repository
public interface CategoryRepo extends JpaRepository<Category,Long>{
    
}
