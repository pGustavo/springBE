package com.app.sorteios.api.controller;

import com.app.sorteios.api.model.Championship;
import com.app.sorteios.api.repository.ChampionshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/championships")
public class ChampionshipController {

    private final ChampionshipRepository championshipRepository;

    @Autowired
    public ChampionshipController(ChampionshipRepository championshipRepository) {
        this.championshipRepository = championshipRepository;
    }

    @GetMapping
    public ResponseEntity<List<Championship>> getAllChampionships() {
        List<Championship> championships = championshipRepository.findAll();
        return new ResponseEntity<>(championships, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Championship> getChampionshipById(@PathVariable("id") int id) {
        Championship championship = championshipRepository.findById(id).orElse(null);
        if (championship == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(championship, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Championship> createChampionship(@RequestBody Championship championship) {
        Championship createdChampionship = championshipRepository.save(championship);
        return new ResponseEntity<>(createdChampionship, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Championship> updateChampionship(
            @PathVariable("id") int id, @RequestBody Championship championship) {
        Championship existingChampionship = championshipRepository.findById(id).orElse(null);
        if (existingChampionship == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        championship.setChampionshipPK(existingChampionship.getChampionshipPK());
        Championship updatedChampionship = championshipRepository.save(championship);
        return new ResponseEntity<>(updatedChampionship, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteChampionship(@PathVariable("id") int id) {
        Championship championship = championshipRepository.findById(id).orElse(null);
        if (championship == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        championshipRepository.delete(championship);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
