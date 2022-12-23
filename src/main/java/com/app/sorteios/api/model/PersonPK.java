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
public class PersonPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "person_code")
    private int personCode;
    @Basic(optional = false)
    @Column(name = "Club_club_code")
    private int clubclubcode;
    @Basic(optional = false)
    @Column(name = "Athlete_athlete_code")
    private int athleteathletecode;
    @Basic(optional = false)
    @Column(name = "Referee_referee_code")
    private int refereerefereecode;
    @Basic(optional = false)
    @Column(name = "Coach_coach_code")
    private int coachcoachcode;
    @Basic(optional = false)
    @Column(name = "combat_combate_code")
    private int combatCombateCode;

    public PersonPK() {
    }

    public PersonPK(int personCode, int clubclubcode, int athleteathletecode, int refereerefereecode, int coachcoachcode, int combatCombateCode) {
        this.personCode = personCode;
        this.clubclubcode = clubclubcode;
        this.athleteathletecode = athleteathletecode;
        this.refereerefereecode = refereerefereecode;
        this.coachcoachcode = coachcoachcode;
        this.combatCombateCode = combatCombateCode;
    }

    public int getPersonCode() {
        return personCode;
    }

    public void setPersonCode(int personCode) {
        this.personCode = personCode;
    }

    public int getClubclubcode() {
        return clubclubcode;
    }

    public void setClubclubcode(int clubclubcode) {
        this.clubclubcode = clubclubcode;
    }

    public int getAthleteathletecode() {
        return athleteathletecode;
    }

    public void setAthleteathletecode(int athleteathletecode) {
        this.athleteathletecode = athleteathletecode;
    }

    public int getRefereerefereecode() {
        return refereerefereecode;
    }

    public void setRefereerefereecode(int refereerefereecode) {
        this.refereerefereecode = refereerefereecode;
    }

    public int getCoachcoachcode() {
        return coachcoachcode;
    }

    public void setCoachcoachcode(int coachcoachcode) {
        this.coachcoachcode = coachcoachcode;
    }

    public int getCombatCombateCode() {
        return combatCombateCode;
    }

    public void setCombatCombateCode(int combatCombateCode) {
        this.combatCombateCode = combatCombateCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) personCode;
        hash += (int) clubclubcode;
        hash += (int) athleteathletecode;
        hash += (int) refereerefereecode;
        hash += (int) coachcoachcode;
        hash += (int) combatCombateCode;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonPK)) {
            return false;
        }
        PersonPK other = (PersonPK) object;
        if (this.personCode != other.personCode) {
            return false;
        }
        if (this.clubclubcode != other.clubclubcode) {
            return false;
        }
        if (this.athleteathletecode != other.athleteathletecode) {
            return false;
        }
        if (this.refereerefereecode != other.refereerefereecode) {
            return false;
        }
        if (this.coachcoachcode != other.coachcoachcode) {
            return false;
        }
        if (this.combatCombateCode != other.combatCombateCode) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.appteste.PersonPK[ personCode=" + personCode + ", clubclubcode=" + clubclubcode + ", athleteathletecode=" + athleteathletecode + ", refereerefereecode=" + refereerefereecode + ", coachcoachcode=" + coachcoachcode + ", combatCombateCode=" + combatCombateCode + " ]";
    }
    
}
