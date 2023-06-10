package com.app.sorteios.api.repository;

import com.app.sorteios.api.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Integer> {
    // You can define custom queries or methods here if needed
}
