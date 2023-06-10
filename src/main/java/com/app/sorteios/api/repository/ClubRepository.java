package com.app.sorteios.api.repository;

import com.app.sorteios.api.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {
}
