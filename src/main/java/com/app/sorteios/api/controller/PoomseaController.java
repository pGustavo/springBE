package com.app.sorteios.api.controller;

import com.app.sorteios.api.dto.CombatDTO;
import com.app.sorteios.api.dto.PoomseaDTO;
import com.app.sorteios.api.model.Athlete;
import com.app.sorteios.api.model.Combat;
import com.app.sorteios.api.model.Poomsea;
import com.app.sorteios.api.repository.AthleteRepository;
import com.app.sorteios.api.repository.PoomseaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/poomseas")
public class PoomseaController {
    private final PoomseaRepository poomseaRepository;
    private final AthleteRepository athleteRepository;

    @Autowired
    public PoomseaController(PoomseaRepository poomseaRepository, AthleteRepository athleteRepository) {
        this.poomseaRepository = poomseaRepository;
        this.athleteRepository = athleteRepository;
    }

    // Endpoint to get all poomseas
    @GetMapping
    public List<PoomseaDTO> getAllPoomseas() {
        List<Poomsea> poomseas= poomseaRepository.findAll();
        List<PoomseaDTO> listToReturn = new ArrayList<>();
        for (Poomsea poomsea: poomseas){
            listToReturn.add(poomseaToDTO(poomsea));
        }
        return listToReturn;
    }

    // Endpoint to get a poomsea by ID
    @GetMapping("/{id}")
    public PoomseaDTO getPoomseaById(@PathVariable Long id) {
        return poomseaToDTO(poomseaRepository.findById(id).orElse(null));
    }

    // Endpoint to create a new poomsea
    @PostMapping
    public PoomseaDTO createPoomsea(@RequestBody PoomseaDTO poomseaDTO) {
        Poomsea poomsea = new Poomsea();
        Athlete athlete = athleteRepository.findByEntryCode(poomseaDTO.getAthleteEntryCode());
        if (athlete != null){
            poomsea.setAthlete(athlete);
        }
        poomsea.setPoomseaName(poomseaDTO.getPoomseaName());
        poomsea.setResult(poomseaDTO.getResult());
        poomsea.setPoomseaOrder(poomseaDTO.getPoomseaOrder());
        poomsea.setPoomseaDate(poomseaDTO.getPoomseaDate());
        poomsea.setPoomseaCategory(poomseaDTO.getPoomseaCategory());
        poomsea.setNote(poomseaDTO.getNote());

        return poomseaToDTO(poomseaRepository.save(poomsea));
    }

    private PoomseaDTO poomseaToDTO(Poomsea poomsea){
        if (poomsea != null) {
            PoomseaDTO poomseaDTO = new PoomseaDTO();
            poomseaDTO.setId(poomsea.getId());
            poomseaDTO.setNote(poomsea.getNote());
            poomseaDTO.setPoomseaCategory(poomsea.getPoomseaCategory());
            poomseaDTO.setPoomseaName(poomsea.getPoomseaName());
            poomseaDTO.setPoomseaDate(poomsea.getPoomseaDate());
            poomseaDTO.setPoomseaOrder(poomsea.getPoomseaOrder());
            poomseaDTO.setPoomseaCategory(poomsea.getPoomseaCategory());
            poomseaDTO.setResult(poomsea.getResult());
            poomseaDTO.setAthleteEntryCode(poomsea.getAthlete().getEntryCode());
            return poomseaDTO;
        }
        return null;
    }
    // Endpoint to update a poomsea
    @PutMapping("/{id}")
    public PoomseaDTO updatePoomsea(@PathVariable Long id, @RequestBody PoomseaDTO poomseaDTO) {
        Poomsea poomsea = poomseaRepository.findById(id).orElse(null);
        if (poomsea != null) {
            Athlete athlete = athleteRepository.findByEntryCode(poomseaDTO.getAthleteEntryCode());
            if (athlete != null){
                poomsea.setAthlete(athlete);
            }
            poomsea.setPoomseaName(poomseaDTO.getPoomseaName());
            poomsea.setResult(poomseaDTO.getResult());
            poomsea.setPoomseaOrder(poomseaDTO.getPoomseaOrder());
            poomsea.setPoomseaDate(poomseaDTO.getPoomseaDate());
            poomsea.setPoomseaCategory(poomseaDTO.getPoomseaCategory());
            poomsea.setNote(poomseaDTO.getNote());
            return poomseaToDTO(poomseaRepository.save(poomsea));
        }
        return null;
    }

    // Endpoint to delete a poomsea
    @DeleteMapping("/{id}")
    public void deletePoomsea(@PathVariable Long id) {
        poomseaRepository.deleteById(id);
    }
}
