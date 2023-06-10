package com.app.sorteios.api.repository;

import java.util.List;

import com.app.sorteios.api.model.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, String> {
    Athlete findByEntryCode(String entryCode);
    void deleteByEntryCode(String entryCode);

}

