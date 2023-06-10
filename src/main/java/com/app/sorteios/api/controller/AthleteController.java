package com.app.sorteios.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.sorteios.api.exeption.ResourceNotFoundException;
import com.app.sorteios.api.model.Athlete;
import com.app.sorteios.api.repository.AthleteRepository;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/athletes")
public class AthleteController {
	

	@Autowired
	private AthleteRepository athleteRepository;

	@GetMapping
	public List<Athlete> getAllAthletes() {
		return athleteRepository.findAll();
	}

	@PostMapping
	public Athlete createAthletes(@RequestBody Athlete athlete) {
		return athleteRepository.save(athlete);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Athlete> getAthletesById(@PathVariable Integer id) {
		Athlete athlete = athleteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Athlete not exist with id :" + id));
		
		return ResponseEntity.ok(athlete);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Athlete> updateAthlete(@PathVariable Integer id, @RequestBody Athlete athleteDetails) {
		Athlete athlete = athleteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Athlete not exist with id :" + id));

		athlete.setGroupCategory(athleteDetails.getGroupCategory());

		Athlete updatedAthlete = athleteRepository.save(athlete);
		return ResponseEntity.ok(updatedAthlete);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteAthlete(@PathVariable Integer id) {
		Athlete athlete = athleteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Athlete not exist with id :" + id));

		athleteRepository.delete(athlete);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
