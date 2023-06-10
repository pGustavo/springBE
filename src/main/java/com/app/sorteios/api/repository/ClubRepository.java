package com.app.sorteios.api.repository;

import com.app.sorteios.api.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends JpaRepository<Club, Integer> {
    // You can define custom queries or methods here if needed
}
