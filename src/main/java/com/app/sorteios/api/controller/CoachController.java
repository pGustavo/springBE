package com.app.sorteios.api.controller;

import com.app.sorteios.api.model.Coach;
import com.app.sorteios.api.repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/coaches")
public class CoachController {

    private final CoachRepository coachRepository;

    @Autowired
    public CoachController(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    @GetMapping
    public ResponseEntity<List<Coach>> getAllCoaches() {
        List<Coach> coaches = coachRepository.findAll();
        return new ResponseEntity<>(coaches, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coach> getCoachById(@PathVariable("id") int id) {
        Coach coach = coachRepository.findById(id).orElse(null);
        if (coach == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(coach, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Coach> createCoach(@RequestBody Coach coach) {
        Coach createdCoach = coachRepository.save(coach);
        return new ResponseEntity<>(createdCoach, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coach> updateCoach(
            @PathVariable("id") int id, @RequestBody Coach coach) {
        Coach existingCoach = coachRepository.findById(id).orElse(null);
        if (existingCoach == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        coach.setCoachCode(existingCoach.getCoachCode());
        Coach updatedCoach = coachRepository.save(coach);
        return new ResponseEntity<>(updatedCoach, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCoach(@PathVariable("id") int id) {
        Coach coach = coachRepository.findById(id).orElse(null);
        if (coach == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        coachRepository.delete(coach);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
