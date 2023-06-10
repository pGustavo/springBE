package com.app.sorteios.api.dto;

public class ChampionshipParticipantDTO {
    private Long championshipId;
    private String athleteEntryCode;
    private Long coachId;
    private Long refereeId;

    // Constructors, getters, and setters

    public ChampionshipParticipantDTO() {
    }

    public Long getChampionshipId() {
        return championshipId;
    }

    public void setChampionshipId(Long championshipId) {
        this.championshipId = championshipId;
    }

    public String getAthleteEntryCode() {
        return athleteEntryCode;
    }

    public void setAthleteEntryCode(String athleteEntryCode) {
        this.athleteEntryCode = athleteEntryCode;
    }

    public Long getCoachId() {
        return coachId;
    }

    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }

    public Long getRefereeId() {
        return refereeId;
    }

    public void setRefereeId(Long refereeId) {
        this.refereeId = refereeId;
    }
}
