package com.app.sorteios.api.controller;

import com.app.sorteios.api.dto.CoachDTO;
import com.app.sorteios.api.model.Club;
import com.app.sorteios.api.model.Coach;
import com.app.sorteios.api.repository.ClubRepository;
import com.app.sorteios.api.repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/coaches")
public class CoachController {
    private final CoachRepository coachRepository;
    private final ClubRepository clubRepository;

    @Autowired
    public CoachController(CoachRepository coachRepository, ClubRepository clubRepository) {
        this.coachRepository = coachRepository;
        this.clubRepository = clubRepository;
    }

    // Endpoint to get all coaches
    @GetMapping
    public List<Coach> getAllCoaches() {
        return coachRepository.findAll();
    }

    // Endpoint to get a coach by ID
    @GetMapping("/{id}")
    public Coach getCoachById(@PathVariable Long id) {
        return coachRepository.findById(id).orElse(null);
    }

    // Endpoint to create a new coach
    @PostMapping
    public Coach createCoach(@RequestBody CoachDTO coachDTO) {

        Coach coach = new Coach();
        // Update the coach data
        coach.setFirstName(coachDTO.getFirstName());
        coach.setLastName(coachDTO.getLastName());
        coach.setBirthdate(coachDTO.getBirthdate());
        coach.setGender(coachDTO.getGender());
        coach.setNationality(coachDTO.getNationality());
        coach.setLogin(coachDTO.getLogin());
        coach.setPassword(coachDTO.getPassword());
        coach.setEmail(coachDTO.getEmail());
        coach.setPhoto(coachDTO.getPhoto());
        coach.setTrainerDegree(coachDTO.getTrainerDegree());
        Club club = clubRepository.findById(coachDTO.getClubId()).orElse(null);
            if (club != null){
                coach.setClub(club);
            }
        return coachRepository.save(coach);

    }

    // Endpoint to update a coach
    @PutMapping("/{id}")
    public Coach updateCoach(@PathVariable Long id, @RequestBody CoachDTO coachDTO) {
        Coach coach = coachRepository.findById(id).orElse(null);
        if (coach != null) {
            // Update the coach data
            coach.setFirstName(coachDTO.getFirstName());
            coach.setLastName(coachDTO.getLastName());
            coach.setBirthdate(coachDTO.getBirthdate());
            coach.setGender(coachDTO.getGender());
            coach.setNationality(coachDTO.getNationality());
            coach.setLogin(coachDTO.getLogin());
            coach.setPassword(coachDTO.getPassword());
            coach.setEmail(coachDTO.getEmail());
            coach.setPhoto(coachDTO.getPhoto());
            coach.setTrainerDegree(coachDTO.getTrainerDegree());
            Club club = clubRepository.findById(coachDTO.getClubId()).orElse(null);
            if (club != null){
                coach.setClub(club);
            }
            return coachRepository.save(coach);
        }
        return null;
    }

    // Endpoint to delete a coach
    @DeleteMapping("/{id}")
    public void deleteCoach(@PathVariable Long id) {
        coachRepository.deleteById(id);
    }
}
