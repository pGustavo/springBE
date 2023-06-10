package com.app.sorteios.api.repository;


import com.app.sorteios.api.model.Poomsea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoomseaRepository extends JpaRepository<Poomsea, Long> {
}

