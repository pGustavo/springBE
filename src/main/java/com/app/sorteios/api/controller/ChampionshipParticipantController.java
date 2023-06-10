package com.app.sorteios.api.controller;

import com.app.sorteios.api.dto.ChampionshipDTO;
import com.app.sorteios.api.dto.ChampionshipParticipantDTO;
import com.app.sorteios.api.model.*;
import com.app.sorteios.api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/championship-participants")
public class ChampionshipParticipantController {
    private final ChampionshipParticipantRepository championshipParticipantRepository;
    private final AthleteRepository athleteRepository;
    private final ChampionshipRepository championshipRepository;
    private final CoachRepository coachRepository;
    private final RefereeRepository refereeRepository;


    @Autowired
    public ChampionshipParticipantController(ChampionshipParticipantRepository championshipParticipantRepository, AthleteRepository athleteRepository, ChampionshipRepository championshipRepository, CoachRepository coachRepository, RefereeRepository refereeRepository) {
        this.championshipParticipantRepository = championshipParticipantRepository;
        this.athleteRepository = athleteRepository;
        this.championshipRepository = championshipRepository;
        this.coachRepository = coachRepository;
        this.refereeRepository = refereeRepository;
    }

    // Endpoint to get all championship participants
    @GetMapping
    public List<ChampionshipParticipantDTO> getAllChampionshipParticipants() {
        List<ChampionshipParticipant> championshipParticipants= championshipParticipantRepository.findAll();
        List<ChampionshipParticipantDTO> listToReturn = new ArrayList<>();
        for (ChampionshipParticipant championshipParticipant: championshipParticipants){
            listToReturn.add(championshipParticipantToDTO(championshipParticipant));
        }
        return listToReturn;


    }

    // Endpoint to get a championship participant by ID
    @GetMapping("/{id}")
    public ChampionshipParticipantDTO getChampionshipParticipantById(@PathVariable Long id) {
        return championshipParticipantToDTO(championshipParticipantRepository.findById(id).orElse(null));
    }

    // Endpoint to create a new championship participant
    @PostMapping
    public ChampionshipParticipantDTO createChampionshipParticipant(@RequestBody ChampionshipParticipantDTO championshipParticipantDTO) {
        ChampionshipParticipant participant = new ChampionshipParticipant();
            if (championshipParticipantDTO.getAthleteEntryCode() != null){
                Athlete athlete = athleteRepository.findByEntryCode(championshipParticipantDTO.getAthleteEntryCode());
                participant.setAthlete(athlete);
            }
            if (championshipParticipantDTO.getChampionshipId() != null){
                Championship championship = championshipRepository.findById(championshipParticipantDTO.getChampionshipId()).orElse(null);
                participant.setChampionship(championship);
            }
            if (championshipParticipantDTO.getRefereeId() != null){
                Referee referee = refereeRepository.findById(championshipParticipantDTO.getRefereeId()).orElse(null);
                participant.setReferee(referee);
            }
            if (championshipParticipantDTO.getCoachId() != null){
                Coach coach = coachRepository.findById(championshipParticipantDTO.getCoachId()).orElse(null);
                participant.setCoach(coach);
            }
            return championshipParticipantToDTO(championshipParticipantRepository.save(participant));
    }


    // Endpoint to update a championship participant
    @PutMapping("/{id}")
    public ChampionshipParticipantDTO updateChampionshipParticipant(@PathVariable Long id, @RequestBody ChampionshipParticipantDTO championshipParticipantDTO) {
        ChampionshipParticipant participant = championshipParticipantRepository.findById(id).orElse(null);
        if (participant != null) {
            if (championshipParticipantDTO.getAthleteEntryCode() != null){
                Athlete athlete = athleteRepository.findByEntryCode(championshipParticipantDTO.getAthleteEntryCode());
                participant.setAthlete(athlete);
            }
            if (championshipParticipantDTO.getChampionshipId() != null){
                Championship championship = championshipRepository.findById(championshipParticipantDTO.getChampionshipId()).orElse(null);
                participant.setChampionship(championship);
            }
            if (championshipParticipantDTO.getRefereeId() != null){
                Referee referee = refereeRepository.findById(championshipParticipantDTO.getRefereeId()).orElse(null);
                participant.setReferee(referee);
            }
            if (championshipParticipantDTO.getCoachId() != null){
                Coach coach = coachRepository.findById(championshipParticipantDTO.getCoachId()).orElse(null);
                participant.setCoach(coach);
            }
            return championshipParticipantToDTO(championshipParticipantRepository.save(participant));
        }
        return null;
    }

    private ChampionshipParticipantDTO championshipParticipantToDTO(ChampionshipParticipant championship){
        if (championship != null){
            ChampionshipParticipantDTO championshipParticipantDTO = new ChampionshipParticipantDTO();
            if(championship.getChampionship() !=null)
                championshipParticipantDTO.setChampionshipId(championship.getChampionship().getId());
            if(championship.getAthlete() !=null)
                championshipParticipantDTO.setAthleteEntryCode(championship.getAthlete().getEntryCode());
            if(championship.getCoach() !=null)
                championshipParticipantDTO.setCoachId(championship.getCoach().getId());
            if(championship.getReferee() !=null)
                championshipParticipantDTO.setRefereeId(championship.getReferee().getId());
            return championshipParticipantDTO;
        }
        return null;
    }

    // Endpoint to delete a championship participant
    @DeleteMapping("/{id}")
    public void deleteChampionshipParticipant(@PathVariable Long id) {
        championshipParticipantRepository.deleteById(id);
    }
}
