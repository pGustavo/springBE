package com.app.sorteios.api.model;
import javax.persistence.*;

@Entity
@Table(name = "ChampionshipParticipants")
public class ChampionshipParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "championshipId", nullable = true)
    private Championship championship;

    @ManyToOne
    @JoinColumn(name = "athleteEntryCode", nullable = true)
    private Athlete athlete;

    @ManyToOne
    @JoinColumn(name = "coachId", nullable = true)
    private Coach coach;

    @ManyToOne
    @JoinColumn(name = "refereeId", nullable = true)
    private Referee referee;

    public ChampionshipParticipant() {
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Championship getChampionship() {
        return championship;
    }

    public void setChampionship(Championship championship) {
        this.championship = championship;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Referee getReferee() {
        return referee;
    }

    public void setReferee(Referee referee) {
        this.referee = referee;
    }
}
