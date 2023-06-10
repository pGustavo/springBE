package com.app.sorteios.api.repository;

import com.app.sorteios.api.model.Combat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CombatRepository extends JpaRepository<Combat, Integer> {
    // You can define custom queries or methods here if needed
}
