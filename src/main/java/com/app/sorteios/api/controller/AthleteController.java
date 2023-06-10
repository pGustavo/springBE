package com.app.sorteios.api.controller;

import java.util.ArrayList;
import java.util.List;

import com.app.sorteios.api.dto.AthleteDTO;
import com.app.sorteios.api.model.Athlete;
import com.app.sorteios.api.model.Club;
import com.app.sorteios.api.model.Coach;
import com.app.sorteios.api.repository.ClubRepository;
import com.app.sorteios.api.repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.sorteios.api.repository.AthleteRepository;

import javax.transaction.Transactional;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/athletes")
@Transactional
public class AthleteController {
    private final AthleteRepository athleteRepository;
    private final ClubRepository clubRepository;
    private final CoachRepository coachRepository;

    @Autowired
    public AthleteController(AthleteRepository athleteRepository, ClubRepository clubRepository, CoachRepository coachRepository) {
        this.athleteRepository = athleteRepository;
        this.clubRepository = clubRepository;
        this.coachRepository = coachRepository;
    }

    // Endpoint to get all athletes
    @GetMapping
    public List<Athlete> getAllAthletes() {
        return athleteRepository.findAll();
    }

    // Endpoint to get an athlete by entryCode
    @GetMapping("/{entryCode}")
    public Athlete getAthleteByEntryCode(@PathVariable String entryCode) {
        return athleteRepository.findById(entryCode).orElse(null);
    }

    // Endpoint to create a new athlete
    @PostMapping
    public Athlete createAthlete(@RequestBody AthleteDTO athleteDTO) {

        Athlete athlete = new Athlete();
        athlete.setEntryCode(athleteDTO.getEntryCode());
        athlete.setFirstName(athleteDTO.getFirstName());
        athlete.setLastName(athleteDTO.getLastName());
        athlete.setBirthdate(athleteDTO.getBirthdate());
        athlete.setGender(athleteDTO.getGender());
        athlete.setNationality(athleteDTO.getNationality());
        athlete.setLogin(athleteDTO.getLogin());
        athlete.setPassword(athleteDTO.getPassword());
        athlete.setEmail(athleteDTO.getEmail());
        athlete.setPhoto(athleteDTO.getPhoto());
        athlete.setTreePositions(athleteDTO.getTreePosition());
        athlete.setGraduation(athleteDTO.getGraduation());
        athlete.setWeightCategory(athleteDTO.getWeightCategory());
        athlete.setGroupCategory(athleteDTO.getGroupCategory());
        athlete.setCategoryType(athleteDTO.getCategoryType());
        Club club = clubRepository.findById(athleteDTO.getClubId()).orElse(null);
        if (club != null) {
            athlete.setClub(club);
        }
        Coach coach = coachRepository.findById(athleteDTO.getCoachId()).orElse(null);
        if (coach != null) {
            athlete.setCoach(coach);
        }
        // Save the athlete using the repository
        athlete = athleteRepository.save(athlete);

        return athlete;
    }

    @PostMapping("/batch")
    public List<Athlete> createAthletes(@RequestBody List<AthleteDTO> athleteDTOList) {
        List<Athlete> athletes = new ArrayList<>();
        for (AthleteDTO athleteDTO : athleteDTOList) {
            Athlete athlete = new Athlete();
            athlete.setEntryCode(athleteDTO.getEntryCode());
            athlete.setFirstName(athleteDTO.getFirstName());
            athlete.setLastName(athleteDTO.getLastName());
            athlete.setBirthdate(athleteDTO.getBirthdate());
            athlete.setGender(athleteDTO.getGender());
            athlete.setNationality(athleteDTO.getNationality());
            athlete.setLogin(athleteDTO.getLogin());
            athlete.setPassword(athleteDTO.getPassword());
            athlete.setEmail(athleteDTO.getEmail());
            athlete.setPhoto(athleteDTO.getPhoto());
            athlete.setGraduation(athleteDTO.getGraduation());
            athlete.setWeightCategory(athleteDTO.getWeightCategory());
            athlete.setGroupCategory(athleteDTO.getGroupCategory());
            athlete.setCategoryType(athleteDTO.getCategoryType());

            Club club = clubRepository.findById(athleteDTO.getClubId()).orElse(null);
            if (club != null) {
                athlete.setClub(club);
            }

            Coach coach = coachRepository.findById(athleteDTO.getCoachId()).orElse(null);
            if (coach != null) {
                athlete.setCoach(coach);
            }

            athletes.add(athlete);
        }

        // Save the athletes using the repository
        return athleteRepository.saveAll(athletes);
    }


    // Endpoint to update an athlete
    @PutMapping("/{entryCode}")
    public Athlete updateAthlete(@PathVariable String entryCode, @RequestBody AthleteDTO athleteDTO) {
        Athlete athlete = athleteRepository.findById(entryCode).orElse(null);
        if (athlete != null) {
            // Update the athlete data
            athlete.setEntryCode(athleteDTO.getEntryCode());
            athlete.setFirstName(athleteDTO.getFirstName());
            athlete.setLastName(athleteDTO.getLastName());
            athlete.setBirthdate(athleteDTO.getBirthdate());
            athlete.setGender(athleteDTO.getGender());
            athlete.setNationality(athleteDTO.getNationality());
            athlete.setLogin(athleteDTO.getLogin());
            athlete.setPassword(athleteDTO.getPassword());
            athlete.setEmail(athleteDTO.getEmail());
            athlete.setPhoto(athleteDTO.getPhoto());
            athlete.setTreePositions(athleteDTO.getTreePosition());
            athlete.setGraduation(athleteDTO.getGraduation());
            athlete.setWeightCategory(athleteDTO.getWeightCategory());
            athlete.setGroupCategory(athleteDTO.getGroupCategory());
            athlete.setCategoryType(athleteDTO.getCategoryType());
            Club club = clubRepository.findById(athleteDTO.getClubId()).orElse(null);
            if (club != null) {
                athlete.setClub(club);
            }
            Coach coach = coachRepository.findById(athleteDTO.getCoachId()).orElse(null);
            if (coach != null) {
                athlete.setCoach(coach);
            }
            return athleteRepository.save(athlete);
        }
        return null;
    }

    // Endpoint to delete an athlete
    @DeleteMapping("/{entryCode}")
    public void deleteAthlete(@PathVariable String entryCode) {
        athleteRepository.deleteByEntryCode(entryCode);
    }
}
