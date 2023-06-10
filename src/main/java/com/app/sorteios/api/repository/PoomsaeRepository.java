package com.app.sorteios.api.repository;

import com.app.sorteios.api.model.Poomsae;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoomsaeRepository extends JpaRepository<Poomsae, Integer> {
    // You can add custom query methods here if needed
}
