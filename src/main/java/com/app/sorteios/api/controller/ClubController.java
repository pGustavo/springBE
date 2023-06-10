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

    @GetMapping
    public ResponseEntity<List<Club>> getAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        return new ResponseEntity<>(clubs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Club> getClubById(@PathVariable("id") int id) {
        Club club = clubRepository.findById(id).orElse(null);
        if (club == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(club, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Club> createClub(@RequestBody Club club) {
        Club createdClub = clubRepository.save(club);
        return new ResponseEntity<>(createdClub, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Club> updateClub(
            @PathVariable("id") int id, @RequestBody Club club) {
        Club existingClub = clubRepository.findById(id).orElse(null);
        if (existingClub == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        club.setClubCode(existingClub.getClubCode());
        Club updatedClub = clubRepository.save(club);
        return new ResponseEntity<>(updatedClub, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteClub(@PathVariable("id") int id) {
        Club club = clubRepository.findById(id).orElse(null);
        if (club == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        clubRepository.delete(club);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
