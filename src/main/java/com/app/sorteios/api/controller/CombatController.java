package com.app.sorteios.api.controller;

import com.app.sorteios.api.model.Combat;
import com.app.sorteios.api.repository.CombatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/combats")
public class CombatController {

    private final CombatRepository combatRepository;

    @Autowired
    public CombatController(CombatRepository combatRepository) {
        this.combatRepository = combatRepository;
    }

    @GetMapping
    public ResponseEntity<List<Combat>> getAllCombats() {
        List<Combat> combats = combatRepository.findAll();
        return new ResponseEntity<>(combats, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Combat> getCombatById(@PathVariable("id") int id) {
        Combat combat = combatRepository.findById(id).orElse(null);
        if (combat == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(combat, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Combat> createCombat(@RequestBody Combat combat) {
        Combat createdCombat = combatRepository.save(combat);
        return new ResponseEntity<>(createdCombat, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Combat> updateCombat(
            @PathVariable("id") int id, @RequestBody Combat combat) {
        Combat existingCombat = combatRepository.findById(id).orElse(null);
        if (existingCombat == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        combat.setCombateCode(existingCombat.getCombateCode());
        Combat updatedCombat = combatRepository.save(combat);
        return new ResponseEntity<>(updatedCombat, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCombat(@PathVariable("id") int id) {
        Combat combat = combatRepository.findById(id).orElse(null);
        if (combat == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        combatRepository.delete(combat);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
