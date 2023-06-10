package com.app.sorteios.api.dto;

import java.util.Date;

public class CombatDTO {
    private String athleteEntryCode;
    private String opponentEntryCode;
    private int roundOf;
    private Date combatDate;
    private String winner;
    private String score;

    // Constructors, getters, and setters

    public CombatDTO() {
    }

    public String getAthleteEntryCode() {
        return athleteEntryCode;
    }

    public void setAthleteEntryCode(String athleteEntryCode) {
        this.athleteEntryCode = athleteEntryCode;
    }

    public String getOpponentEntryCode() {
        return opponentEntryCode;
    }

    public void setOpponentEntryCode(String opponentEntryCode) {
        this.opponentEntryCode = opponentEntryCode;
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
