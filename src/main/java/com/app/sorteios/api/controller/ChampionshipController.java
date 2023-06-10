package com.app.sorteios.api.controller;

import com.app.sorteios.api.dto.ChampionshipDTO;
import com.app.sorteios.api.dto.PoomseaDTO;
import com.app.sorteios.api.model.Championship;
import com.app.sorteios.api.model.Poomsea;
import com.app.sorteios.api.repository.ChampionshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    // Endpoint to get all championships
    @GetMapping
    public List<ChampionshipDTO> getAllChampionships() {
        List<Championship> championships= championshipRepository.findAll();
        List<ChampionshipDTO> listToReturn = new ArrayList<>();
        for (Championship championship: championships){
            listToReturn.add(championshipToDTO(championship));
        }
        return listToReturn;
    }

    // Endpoint to get a championship by ID
    @GetMapping("/{id}")
    public ChampionshipDTO getChampionshipById(@PathVariable Long id) {
        return championshipToDTO(championshipRepository.findById(id).orElse(null));
    }

    // Endpoint to create a new championship
    @PostMapping
    public ChampionshipDTO createChampionship(@RequestBody Championship championship) {
        return championshipToDTO(championshipRepository.save(championship));
    }

    // Endpoint to update a championship
    @PutMapping("/{id}")
    public ChampionshipDTO updateChampionship(@PathVariable Long id, @RequestBody ChampionshipDTO championshipDTO) {
        Championship championship = championshipRepository.findById(id).orElse(null);
        if (championship != null) {
            championship.setName(championshipDTO.getName());
            championship.setLocation(championshipDTO.getLocation());
            championship.setTime(championshipDTO.getTime());
            championship.setLogo(championshipDTO.getLogo());
            return championshipToDTO(championshipRepository.save(championship));
        }
        return null;
    }
    private ChampionshipDTO championshipToDTO(Championship championship){
        if (championship != null) {
            ChampionshipDTO championshipDTO = new ChampionshipDTO();
            championshipDTO.setName(championship.getName());
            championshipDTO.setLocation(championship.getLocation());
            championshipDTO.setTime(championship.getTime());
            championshipDTO.setLogo(championship.getLogo());
            return championshipDTO;
        }
        return null;
    }

    // Endpoint to delete a championship
    @DeleteMapping("/{id}")
    public void deleteChampionship(@PathVariable Long id) {
        championshipRepository.deleteById(id);
    }
}
