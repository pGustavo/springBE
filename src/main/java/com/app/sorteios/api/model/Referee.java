/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.sorteios.api.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author paulocamargo
 */
@Entity
@Table(name = "Referee", catalog = "sorteios_db", schema = "")
@NamedQueries({
    @NamedQuery(name = "Referee.findAll", query = "SELECT r FROM Referee r"),
    @NamedQuery(name = "Referee.findByRefereeCode", query = "SELECT r FROM Referee r WHERE r.refereePK.refereeCode = :refereeCode"),
    @NamedQuery(name = "Referee.findByLastRecycle", query = "SELECT r FROM Referee r WHERE r.lastRecycle = :lastRecycle"),
    @NamedQuery(name = "Referee.findByType", query = "SELECT r FROM Referee r WHERE r.type = :type"),
    @NamedQuery(name = "Referee.findByInternational", query = "SELECT r FROM Referee r WHERE r.international = :international"),
    @NamedQuery(name = "Referee.findByPoomsaepoomsaecode", query = "SELECT r FROM Referee r WHERE r.refereePK.poomsaepoomsaecode = :poomsaepoomsaecode"),
    @NamedQuery(name = "Referee.findByPoomsaePersonpersoncode", query = "SELECT r FROM Referee r WHERE r.refereePK.poomsaePersonpersoncode = :poomsaePersonpersoncode"),
    @NamedQuery(name = "Referee.findByPoomsaePersonClubclubcode", query = "SELECT r FROM Referee r WHERE r.refereePK.poomsaePersonClubclubcode = :poomsaePersonClubclubcode"),
    @NamedQuery(name = "Referee.findByPoomsaePersonAthleteathletecode", query = "SELECT r FROM Referee r WHERE r.refereePK.poomsaePersonAthleteathletecode = :poomsaePersonAthleteathletecode"),
    @NamedQuery(name = "Referee.findByPoomsaePersonRefereerefereecode", query = "SELECT r FROM Referee r WHERE r.refereePK.poomsaePersonRefereerefereecode = :poomsaePersonRefereerefereecode"),
    @NamedQuery(name = "Referee.findByPoomsaePersonCoachcoachcode", query = "SELECT r FROM Referee r WHERE r.refereePK.poomsaePersonCoachcoachcode = :poomsaePersonCoachcoachcode"),
    @NamedQuery(name = "Referee.findByPoomsaePersoncombatcombatecode", query = "SELECT r FROM Referee r WHERE r.refereePK.poomsaePersoncombatcombatecode = :poomsaePersoncombatcombatecode")})
public class Referee implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RefereePK refereePK;
    @Column(name = "last_recycle")
    private String lastRecycle;
    @Column(name = "type")
    private String type;
    @Column(name = "international")
    private Short international;
    @Lob
    @Column(name = "proof")
    private byte[] proof;
    @JoinColumns({
        @JoinColumn(name = "Poomsae_poomsae_code", referencedColumnName = "poomsae_code", insertable = false, updatable = false),
        @JoinColumn(name = "Poomsae_Person_person_code", referencedColumnName = "Person_person_code", insertable = false, updatable = false),
        @JoinColumn(name = "Poomsae_Person_Club_club_code", referencedColumnName = "Person_Club_club_code", insertable = false, updatable = false),
        @JoinColumn(name = "Poomsae_Person_Athlete_athlete_code", referencedColumnName = "Person_Athlete_athlete_code", insertable = false, updatable = false),
        @JoinColumn(name = "Poomsae_Person_Referee_referee_code", referencedColumnName = "Person_Referee_referee_code", insertable = false, updatable = false),
        @JoinColumn(name = "Poomsae_Person_Coach_coach_code", referencedColumnName = "Person_Coach_coach_code", insertable = false, updatable = false),
        @JoinColumn(name = "Poomsae_Person_combat_combate_code", referencedColumnName = "Person_combat_combate_code", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Poomsae poomsae;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "referee")
    private Collection<Person> personCollection;

    public Referee() {
    }

    public Referee(RefereePK refereePK) {
        this.refereePK = refereePK;
    }

    public Referee(int refereeCode, int poomsaepoomsaecode, int poomsaePersonpersoncode, int poomsaePersonClubclubcode, int poomsaePersonAthleteathletecode, int poomsaePersonRefereerefereecode, int poomsaePersonCoachcoachcode, int poomsaePersoncombatcombatecode) {
        this.refereePK = new RefereePK(refereeCode, poomsaepoomsaecode, poomsaePersonpersoncode, poomsaePersonClubclubcode, poomsaePersonAthleteathletecode, poomsaePersonRefereerefereecode, poomsaePersonCoachcoachcode, poomsaePersoncombatcombatecode);
    }

    public RefereePK getRefereePK() {
        return refereePK;
    }

    public void setRefereePK(RefereePK refereePK) {
        this.refereePK = refereePK;
    }

    public String getLastRecycle() {
        return lastRecycle;
    }

    public void setLastRecycle(String lastRecycle) {
        this.lastRecycle = lastRecycle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Short getInternational() {
        return international;
    }

    public void setInternational(Short international) {
        this.international = international;
    }

    public byte[] getProof() {
        return proof;
    }

    public void setProof(byte[] proof) {
        this.proof = proof;
    }

    public Poomsae getPoomsae() {
        return poomsae;
    }

    public void setPoomsae(Poomsae poomsae) {
        this.poomsae = poomsae;
    }

    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (refereePK != null ? refereePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Referee)) {
            return false;
        }
        Referee other = (Referee) object;
        if ((this.refereePK == null && other.refereePK != null) || (this.refereePK != null && !this.refereePK.equals(other.refereePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.appteste.Referee[ refereePK=" + refereePK + " ]";
    }
    
}
