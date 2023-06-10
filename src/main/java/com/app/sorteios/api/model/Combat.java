package com.app.sorteios.api.model;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Combats")
public class Combat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "athleteEntryCode")
    private Athlete athlete;

    @ManyToOne
    @JoinColumn(name = "opponentEntryCode")
    private Athlete opponent;

    private int roundOf;
    private Date combatDate;
    private String winner;
    private String score;

    public Combat() {
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    public Athlete getOpponent() {
        return opponent;
    }

    public void setOpponent(Athlete opponent) {
        this.opponent = opponent;
    }

    public int getRoundOf() {
        return roundOf;
    }

    public void setRoundOf(int roundOf) {
        this.roundOf = roundOf;
    }

    public Date getCombatDate() {
        return combatDate;
    }

    public void setCombatDate(Date combatDate) {
        this.combatDate = combatDate;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
