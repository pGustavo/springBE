package com.app.sorteios.api.repository;

import com.app.sorteios.api.model.Championship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionshipRepository extends JpaRepository<Championship, Integer> {
    // You can define custom queries or methods here if needed
}
