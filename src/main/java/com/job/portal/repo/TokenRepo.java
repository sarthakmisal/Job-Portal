package com.job.portal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.job.portal.model.Token;
import com.job.portal.model.User;

@Repository
public interface TokenRepo extends JpaRepository<Token,Long> {
    // User findByUsername(String username);
    @Query("SELECT e FROM User e WHERE e.username = :username")
    List<User> findCustomQuery(@Param("username") String username);
}
