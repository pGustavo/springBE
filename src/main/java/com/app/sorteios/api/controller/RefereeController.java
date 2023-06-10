package com.app.sorteios.api.controller;

import com.app.sorteios.api.model.Referee;
import com.app.sorteios.api.repository.RefereeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/referees")
public class RefereeController {
    private final RefereeRepository refereeRepository;
    @Autowired
    public RefereeController(RefereeRepository refereeRepository) {
        this.refereeRepository = refereeRepository;
    }
    // Endpoint to get all referees
    @GetMapping
    public List<Referee> getAllReferees() {
        return refereeRepository.findAll();
    }

    // Endpoint to get a referee by ID
    @GetMapping("/{id}")
    public Referee getRefereeById(@PathVariable Long id) {
        return refereeRepository.findById(id).orElse(null);
    }

    // Endpoint to create a new referee
    @PostMapping
    public Referee createReferee(@RequestBody Referee referee) {
        return refereeRepository.save(referee);
    }

    // Endpoint to update a referee
    @PutMapping("/{id}")
    public Referee updateReferee(@PathVariable Long id, @RequestBody Referee refereeData) {
        Referee referee = refereeRepository.findById(id).orElse(null);
        if (referee != null) {
            referee.setFirstName(refereeData.getFirstName());
            referee.setLastName(refereeData.getLastName());
            referee.setBirthdate(refereeData.getBirthdate());
            referee.setGender(refereeData.getGender());
            referee.setNationality(refereeData.getNationality());
            referee.setLogin(refereeData.getLogin());
            referee.setPassword(refereeData.getPassword());
            referee.setEmail(refereeData.getEmail());
            referee.setPhoto(refereeData.getPhoto());
            referee.setLastRecycle(refereeData.getLastRecycle());
            referee.setRefereeType(refereeData.getRefereeType());
            referee.setInternational(refereeData.isInternational());
            referee.setProof(refereeData.getProof());
            return refereeRepository.save(referee);
        }
        return null;
    }

    // Endpoint to delete a referee
    @DeleteMapping("/{id}")
    public void deleteReferee(@PathVariable Long id) {
        refereeRepository.deleteById(id);
    }
}
