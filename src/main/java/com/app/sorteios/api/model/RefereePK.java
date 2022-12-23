/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.sorteios.api.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author paulocamargo
 */
@Embeddable
public class RefereePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "referee_code")
    private int refereeCode;
    @Basic(optional = false)
    @Column(name = "Poomsae_poomsae_code")
    private int poomsaepoomsaecode;
    @Basic(optional = false)
    @Column(name = "Poomsae_Person_person_code")
    private int poomsaePersonpersoncode;
    @Basic(optional = false)
    @Column(name = "Poomsae_Person_Club_club_code")
    private int poomsaePersonClubclubcode;
    @Basic(optional = false)
    @Column(name = "Poomsae_Person_Athlete_athlete_code")
    private int poomsaePersonAthleteathletecode;
    @Basic(optional = false)
    @Column(name = "Poomsae_Person_Referee_referee_code")
    private int poomsaePersonRefereerefereecode;
    @Basic(optional = false)
    @Column(name = "Poomsae_Person_Coach_coach_code")
    private int poomsaePersonCoachcoachcode;
    @Basic(optional = false)
    @Column(name = "Poomsae_Person_combat_combate_code")
    private int poomsaePersoncombatcombatecode;

    public RefereePK() {
    }

    public RefereePK(int refereeCode, int poomsaepoomsaecode, int poomsaePersonpersoncode, int poomsaePersonClubclubcode, int poomsaePersonAthleteathletecode, int poomsaePersonRefereerefereecode, int poomsaePersonCoachcoachcode, int poomsaePersoncombatcombatecode) {
        this.refereeCode = refereeCode;
        this.poomsaepoomsaecode = poomsaepoomsaecode;
        this.poomsaePersonpersoncode = poomsaePersonpersoncode;
        this.poomsaePersonClubclubcode = poomsaePersonClubclubcode;
        this.poomsaePersonAthleteathletecode = poomsaePersonAthleteathletecode;
        this.poomsaePersonRefereerefereecode = poomsaePersonRefereerefereecode;
        this.poomsaePersonCoachcoachcode = poomsaePersonCoachcoachcode;
        this.poomsaePersoncombatcombatecode = poomsaePersoncombatcombatecode;
    }

    public int getRefereeCode() {
        return refereeCode;
    }

    public void setRefereeCode(int refereeCode) {
        this.refereeCode = refereeCode;
    }

    public int getPoomsaepoomsaecode() {
        return poomsaepoomsaecode;
    }

    public void setPoomsaepoomsaecode(int poomsaepoomsaecode) {
        this.poomsaepoomsaecode = poomsaepoomsaecode;
    }

    public int getPoomsaePersonpersoncode() {
        return poomsaePersonpersoncode;
    }

    public void setPoomsaePersonpersoncode(int poomsaePersonpersoncode) {
        this.poomsaePersonpersoncode = poomsaePersonpersoncode;
    }

    public int getPoomsaePersonClubclubcode() {
        return poomsaePersonClubclubcode;
    }

    public void setPoomsaePersonClubclubcode(int poomsaePersonClubclubcode) {
        this.poomsaePersonClubclubcode = poomsaePersonClubclubcode;
    }

    public int getPoomsaePersonAthleteathletecode() {
        return poomsaePersonAthleteathletecode;
    }

    public void setPoomsaePersonAthleteathletecode(int poomsaePersonAthleteathletecode) {
        this.poomsaePersonAthleteathletecode = poomsaePersonAthleteathletecode;
    }

    public int getPoomsaePersonRefereerefereecode() {
        return poomsaePersonRefereerefereecode;
    }

    public void setPoomsaePersonRefereerefereecode(int poomsaePersonRefereerefereecode) {
        this.poomsaePersonRefereerefereecode = poomsaePersonRefereerefereecode;
    }

    public int getPoomsaePersonCoachcoachcode() {
        return poomsaePersonCoachcoachcode;
    }

    public void setPoomsaePersonCoachcoachcode(int poomsaePersonCoachcoachcode) {
        this.poomsaePersonCoachcoachcode = poomsaePersonCoachcoachcode;
    }

    public int getPoomsaePersoncombatcombatecode() {
        return poomsaePersoncombatcombatecode;
    }

    public void setPoomsaePersoncombatcombatecode(int poomsaePersoncombatcombatecode) {
        this.poomsaePersoncombatcombatecode = poomsaePersoncombatcombatecode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) refereeCode;
        hash += (int) poomsaepoomsaecode;
        hash += (int) poomsaePersonpersoncode;
        hash += (int) poomsaePersonClubclubcode;
        hash += (int) poomsaePersonAthleteathletecode;
        hash += (int) poomsaePersonRefereerefereecode;
        hash += (int) poomsaePersonCoachcoachcode;
        hash += (int) poomsaePersoncombatcombatecode;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RefereePK)) {
            return false;
        }
        RefereePK other = (RefereePK) object;
        if (this.refereeCode != other.refereeCode) {
            return false;
        }
        if (this.poomsaepoomsaecode != other.poomsaepoomsaecode) {
            return false;
        }
        if (this.poomsaePersonpersoncode != other.poomsaePersonpersoncode) {
            return false;
        }
        if (this.poomsaePersonClubclubcode != other.poomsaePersonClubclubcode) {
            return false;
        }
        if (this.poomsaePersonAthleteathletecode != other.poomsaePersonAthleteathletecode) {
            return false;
        }
        if (this.poomsaePersonRefereerefereecode != other.poomsaePersonRefereerefereecode) {
            return false;
        }
        if (this.poomsaePersonCoachcoachcode != other.poomsaePersonCoachcoachcode) {
            return false;
        }
        if (this.poomsaePersoncombatcombatecode != other.poomsaePersoncombatcombatecode) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.appteste.RefereePK[ refereeCode=" + refereeCode + ", poomsaepoomsaecode=" + poomsaepoomsaecode + ", poomsaePersonpersoncode=" + poomsaePersonpersoncode + ", poomsaePersonClubclubcode=" + poomsaePersonClubclubcode + ", poomsaePersonAthleteathletecode=" + poomsaePersonAthleteathletecode + ", poomsaePersonRefereerefereecode=" + poomsaePersonRefereerefereecode + ", poomsaePersonCoachcoachcode=" + poomsaePersonCoachcoachcode + ", poomsaePersoncombatcombatecode=" + poomsaePersoncombatcombatecode + " ]";
    }
    
}
