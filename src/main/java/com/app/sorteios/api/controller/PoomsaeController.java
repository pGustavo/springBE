package com.app.sorteios.api.controller;

import com.app.sorteios.api.model.Poomsae;
import com.app.sorteios.api.repository.PoomsaeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/poomsae")
public class PoomsaeController {

    private final PoomsaeRepository poomsaeRepository;

    @Autowired
    public PoomsaeController(PoomsaeRepository poomsaeRepository) {
        this.poomsaeRepository = poomsaeRepository;
    }

    @GetMapping
    public List<Poomsae> getAllPoomsae() {
        return poomsaeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Poomsae getPoomsaeById(@PathVariable("id") int id) {
        return poomsaeRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Poomsae createPoomsae(@RequestBody Poomsae poomsae) {
        return poomsaeRepository.save(poomsae);
    }

    @PutMapping("/{id}")
    public Poomsae updatePoomsae(@PathVariable("id") int id, @RequestBody Poomsae poomsaeData) {
        Poomsae poomsae = poomsaeRepository.findById(id).orElse(null);
        if (poomsae != null) {
            // Update the fields of the existing poomsae object
            // with the data from poomsaeData object
            // Example: poomsae.setName(poomsaeData.getName());
            // Continue updating other fields as needed

            return poomsaeRepository.save(poomsae);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletePoomsae(@PathVariable("id") int id) {
        poomsaeRepository.deleteById(id);
    }
}
