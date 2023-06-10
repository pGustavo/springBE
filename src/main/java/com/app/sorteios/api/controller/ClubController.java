package com.app.sorteios.api.controller;

import com.app.sorteios.api.model.Club;
import com.app.sorteios.api.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/clubs")
public class ClubController {
    private final ClubRepository clubRepository;

    @Autowired
    public ClubController(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    // Endpoint to get all clubs
    @GetMapping
    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }

    // Endpoint to get a club by ID
    @GetMapping("/{id}")
    public Club getClubById(@PathVariable Long id) {
        return clubRepository.findById(id).orElse(null);
    }

    // Endpoint to create a new club
    @PostMapping
    public Club createClub(@RequestBody Club club) {
        return clubRepository.save(club);
    }

    // Endpoint to update a club
    @PutMapping("/{id}")
    public Club updateClub(@PathVariable Long id, @RequestBody Club clubData) {
        Club club = clubRepository.findById(id).orElse(null);
        if (club != null) {
            // Update the club data
            club.setEmailAddress(clubData.getEmailAddress());
            club.setClubName(clubData.getClubName());
            club.setClubCountry(clubData.getClubCountry());
            club.setClubCountryCode(clubData.getClubCountryCode());
            return clubRepository.save(club);
        }
        return null;
    }

    // Endpoint to delete a club
    @DeleteMapping("/{id}")
    public void deleteClub(@PathVariable Long id) {
        clubRepository.deleteById(id);
    }
}