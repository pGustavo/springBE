/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appteste;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author paulocamargo
 */
@Embeddable
public class ChampionshipPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "champ_code")
    private int champCode;
    @Basic(optional = false)
    @Column(name = "Person_person_code")
    private int personpersoncode;
    @Basic(optional = false)
    @Column(name = "Person_Club_club_code")
    private int personClubclubcode;
    @Basic(optional = false)
    @Column(name = "Person_Athlete_athlete_code")
    private int personAthleteathletecode;
    @Basic(optional = false)
    @Column(name = "Person_Referee_referee_code")
    private int personRefereerefereecode;
    @Basic(optional = false)
    @Column(name = "Person_Coach_coach_code")
    private int personCoachcoachcode;

    public ChampionshipPK() {
    }

    public ChampionshipPK(int champCode, int personpersoncode, int personClubclubcode, int personAthleteathletecode, int personRefereerefereecode, int personCoachcoachcode) {
        this.champCode = champCode;
        this.personpersoncode = personpersoncode;
        this.personClubclubcode = personClubclubcode;
        this.personAthleteathletecode = personAthleteathletecode;
        this.personRefereerefereecode = personRefereerefereecode;
        this.personCoachcoachcode = personCoachcoachcode;
    }

    public int getChampCode() {
        return champCode;
    }

    public void setChampCode(int champCode) {
        this.champCode = champCode;
    }

    public int getPersonpersoncode() {
        return personpersoncode;
    }

    public void setPersonpersoncode(int personpersoncode) {
        this.personpersoncode = personpersoncode;
    }

    public int getPersonClubclubcode() {
        return personClubclubcode;
    }

    public void setPersonClubclubcode(int personClubclubcode) {
        this.personClubclubcode = personClubclubcode;
    }

    public int getPersonAthleteathletecode() {
        return personAthleteathletecode;
    }

    public void setPersonAthleteathletecode(int personAthleteathletecode) {
        this.personAthleteathletecode = personAthleteathletecode;
    }

    public int getPersonRefereerefereecode() {
        return personRefereerefereecode;
    }

    public void setPersonRefereerefereecode(int personRefereerefereecode) {
        this.personRefereerefereecode = personRefereerefereecode;
    }

    public int getPersonCoachcoachcode() {
        return personCoachcoachcode;
    }

    public void setPersonCoachcoachcode(int personCoachcoachcode) {
        this.personCoachcoachcode = personCoachcoachcode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) champCode;
        hash += (int) personpersoncode;
        hash += (int) personClubclubcode;
        hash += (int) personAthleteathletecode;
        hash += (int) personRefereerefereecode;
        hash += (int) personCoachcoachcode;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChampionshipPK)) {
            return false;
        }
        ChampionshipPK other = (ChampionshipPK) object;
        if (this.champCode != other.champCode) {
            return false;
        }
        if (this.personpersoncode != other.personpersoncode) {
            return false;
        }
        if (this.personClubclubcode != other.personClubclubcode) {
            return false;
        }
        if (this.personAthleteathletecode != other.personAthleteathletecode) {
            return false;
        }
        if (this.personRefereerefereecode != other.personRefereerefereecode) {
            return false;
        }
        if (this.personCoachcoachcode != other.personCoachcoachcode) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.appteste.ChampionshipPK[ champCode=" + champCode + ", personpersoncode=" + personpersoncode + ", personClubclubcode=" + personClubclubcode + ", personAthleteathletecode=" + personAthleteathletecode + ", personRefereerefereecode=" + personRefereerefereecode + ", personCoachcoachcode=" + personCoachcoachcode + " ]";
    }
    
}
