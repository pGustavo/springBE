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

    @GetMapping
    public List<Referee> getAllReferees() {
        return refereeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Referee getRefereeById(@PathVariable int id) {
        return refereeRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Referee createReferee(@RequestBody Referee referee) {
        return refereeRepository.save(referee);
    }

    @PutMapping("/{id}")
    public Referee updateReferee(@PathVariable int id, @RequestBody Referee refereeDetails) {
        Referee referee = refereeRepository.findById(id).orElse(null);
        if (referee != null) {
            // Update the referee properties with refereeDetails
            // referee.setName(refereeDetails.getName());
            // referee.setAge(refereeDetails.getAge());
            // ...
            return refereeRepository.save(referee);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteReferee(@PathVariable int id) {
        refereeRepository.deleteById(id);
    }
}
