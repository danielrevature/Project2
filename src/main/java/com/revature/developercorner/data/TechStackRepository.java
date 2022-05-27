package com.revature.developercorner.data;

import com.revature.developercorner.entity.TechStack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// TechStackRepository Interface Class
// This interface class will handle the data logic of the TechStack objects in the database for the application.
@Repository
public interface TechStackRepository extends JpaRepository<TechStack, Long>{

    public List<TechStack> findByUserId(Long userId);
}
