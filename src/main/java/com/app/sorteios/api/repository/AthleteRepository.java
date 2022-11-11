package com.app.sorteios.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.sorteios.api.model.Athlete;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Long>{
	
	List<Athlete> findAthleteByGroupCategoryIgnoreCaseContaining(String groupCategory);

}
