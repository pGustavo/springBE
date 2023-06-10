package com.app.sorteios.api.controller;

import com.app.sorteios.api.dto.CombatDTO;
import com.app.sorteios.api.model.Athlete;
import com.app.sorteios.api.model.Combat;
import com.app.sorteios.api.repository.AthleteRepository;
import com.app.sorteios.api.repository.CombatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/combats")
public class CombatController {
    private final CombatRepository combatRepository;
    private final AthleteRepository athleteRepository;


    @Autowired
    public CombatController(CombatRepository combatRepository, AthleteRepository athleteRepository) {
        this.combatRepository = combatRepository;
        this.athleteRepository = athleteRepository;

    }

    // Endpoint to get all combats
    @GetMapping
    public List<CombatDTO> getAllCombats() {
        List<Combat> combats= combatRepository.findAll();
        List<CombatDTO> listToReturn = new ArrayList<>();
      for (Combat combat: combats){
          listToReturn.add(combatToDTO(combat));
      }
        return listToReturn;
    }

    // Endpoint to get a combat by ID
    @GetMapping("/{id}")
    public CombatDTO getCombatById(@PathVariable Long id) {
        return combatToDTO(combatRepository.findById(id).orElse(null));
    }

    // Endpoint to create a new combat
    @PostMapping
    public CombatDTO createCombat(@RequestBody CombatDTO combatDTO) {
        Combat combat = new Combat();
        Athlete athlete = athleteRepository.findByEntryCode(combatDTO.getAthleteEntryCode());
        Athlete opponent = athleteRepository.findByEntryCode(combatDTO.getOpponentEntryCode());
        if (athlete != null && opponent != null  ){
            combat.setAthlete(athlete);
            combat.setOpponent(opponent);
        }
        combat.setRoundOf(combatDTO.getRoundOf());
        combat.setCombatDate(combatDTO.getCombatDate());
        combat.setWinner(combatDTO.getWinner());
        combat.setScore(combatDTO.getScore());
        return combatToDTO(combatRepository.save(combat));
    }


    // Endpoint to update a combat
    @PutMapping("/{id}")
    public CombatDTO updateCombat(@PathVariable Long id, @RequestBody CombatDTO combatDTO) {
        Combat combat = combatRepository.findById(id).orElse(null);
        if (combat != null) {
            Athlete athlete = athleteRepository.findByEntryCode(combatDTO.getAthleteEntryCode());
            Athlete opponent = athleteRepository.findByEntryCode(combatDTO.getOpponentEntryCode());
            if (athlete != null && opponent != null  ){
                combat.setAthlete(athlete);
                combat.setOpponent(opponent);
            }
            combat.setRoundOf(combatDTO.getRoundOf());
            combat.setCombatDate(combatDTO.getCombatDate());
            combat.setWinner(combatDTO.getWinner());
            combat.setScore(combatDTO.getScore());
            return combatToDTO(combatRepository.save(combat));
        }
        return null;
    }

    // Endpoint to delete a combat
    @DeleteMapping("/{id}")
    public void deleteCombat(@PathVariable Long id) {
        combatRepository.deleteById(id);
    }

    private CombatDTO combatToDTO(Combat combat){
        if (combat !=null) {
            CombatDTO combatDTO = new CombatDTO();
            combatDTO.setCombatDate(combat.getCombatDate());
            combatDTO.setAthleteEntryCode(combat.getAthlete().getEntryCode());
            combatDTO.setOpponentEntryCode(combat.getOpponent().getEntryCode());
            combatDTO.setScore(combat.getScore());
            combatDTO.setRoundOf(combat.getRoundOf());
            combatDTO.setWinner(combat.getWinner());
            return combatDTO;
        }
        return null;
    }
}
