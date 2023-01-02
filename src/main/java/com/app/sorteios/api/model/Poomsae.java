/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.sorteios.api.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author paulocamargo
 */
@Entity
@Table(name = "Poomsae", catalog = "sorteios_db", schema = "")
@NamedQueries({
    @NamedQuery(name = "Poomsae.findAll", query = "SELECT p FROM Poomsae p"),
    @NamedQuery(name = "Poomsae.findByPoomsaeCode", query = "SELECT p FROM Poomsae p WHERE p.poomsaePK.poomsaeCode = :poomsaeCode"),
    @NamedQuery(name = "Poomsae.findByPoomsae", query = "SELECT p FROM Poomsae p WHERE p.poomsae = :poomsae"),
    @NamedQuery(name = "Poomsae.findByResult", query = "SELECT p FROM Poomsae p WHERE p.result = :result"),
    @NamedQuery(name = "Poomsae.findByOrder", query = "SELECT p FROM Poomsae p WHERE p.order = :order"),
    @NamedQuery(name = "Poomsae.findByPoomsaeDate", query = "SELECT p FROM Poomsae p WHERE p.poomsaeDate = :poomsaeDate"),
    @NamedQuery(name = "Poomsae.findByPoomsaeCategory", query = "SELECT p FROM Poomsae p WHERE p.poomsaeCategory = :poomsaeCategory"),
    @NamedQuery(name = "Poomsae.findByNote", query = "SELECT p FROM Poomsae p WHERE p.note = :note"),
    @NamedQuery(name = "Poomsae.findByPersonpersoncode", query = "SELECT p FROM Poomsae p WHERE p.poomsaePK.personpersoncode = :personpersoncode"),
    @NamedQuery(name = "Poomsae.findByPersonClubclubcode", query = "SELECT p FROM Poomsae p WHERE p.poomsaePK.personClubclubcode = :personClubclubcode"),
    @NamedQuery(name = "Poomsae.findByPersonAthleteathletecode", query = "SELECT p FROM Poomsae p WHERE p.poomsaePK.personAthleteathletecode = :personAthleteathletecode"),
    @NamedQuery(name = "Poomsae.findByPersonRefereerefereecode", query = "SELECT p FROM Poomsae p WHERE p.poomsaePK.personRefereerefereecode = :personRefereerefereecode"),
    @NamedQuery(name = "Poomsae.findByPersonCoachcoachcode", query = "SELECT p FROM Poomsae p WHERE p.poomsaePK.personCoachcoachcode = :personCoachcoachcode"),
    @NamedQuery(name = "Poomsae.findByPersoncombatcombatecode", query = "SELECT p FROM Poomsae p WHERE p.poomsaePK.personcombatcombatecode = :personcombatcombatecode")})
public class Poomsae implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PoomsaePK poomsaePK;
    @Column(name = "poomsae")
    private String poomsae;
    @Column(name = "result")
    private Integer result;
    @Column(name = "order")
    private Integer order;
    @Column(name = "poomsae_date")
    @Temporal(TemporalType.DATE)
    private Date poomsaeDate;
    @Column(name = "poomsae_Category")
    private String poomsaeCategory;
    @Column(name = "note")
    private String note;
    @JoinColumns({
        @JoinColumn(name = "Person_person_code", referencedColumnName = "person_code", insertable = false, updatable = false),
        @JoinColumn(name = "Person_Club_club_code", referencedColumnName = "Club_club_code", insertable = false, updatable = false),
        @JoinColumn(name = "Person_Athlete_athlete_code", referencedColumnName = "Athlete_athlete_code", insertable = false, updatable = false),
        @JoinColumn(name = "Person_Referee_referee_code", referencedColumnName = "Referee_referee_code", insertable = false, updatable = false),
        @JoinColumn(name = "Person_Coach_coach_code", referencedColumnName = "Coach_coach_code", insertable = false, updatable = false),
        @JoinColumn(name = "Person_combat_combate_code", referencedColumnName = "combat_combate_code", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Person person;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "poomsae")
    private Collection<Referee> refereeCollection;

    public Poomsae() {
    }

    public Poomsae(PoomsaePK poomsaePK) {
        this.poomsaePK = poomsaePK;
    }

    public Poomsae(int poomsaeCode, int personpersoncode, int personClubclubcode, int personAthleteathletecode, int personRefereerefereecode, int personCoachcoachcode, int personcombatcombatecode) {
        this.poomsaePK = new PoomsaePK(poomsaeCode, personpersoncode, personClubclubcode, personAthleteathletecode, personRefereerefereecode, personCoachcoachcode, personcombatcombatecode);
    }

    public PoomsaePK getPoomsaePK() {
        return poomsaePK;
    }

    public void setPoomsaePK(PoomsaePK poomsaePK) {
        this.poomsaePK = poomsaePK;
    }

    public String getPoomsae() {
        return poomsae;
    }

    public void setPoomsae(String poomsae) {
        this.poomsae = poomsae;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Date getPoomsaeDate() {
        return poomsaeDate;
    }

    public void setPoomsaeDate(Date poomsaeDate) {
        this.poomsaeDate = poomsaeDate;
    }

    public String getPoomsaeCategory() {
        return poomsaeCategory;
    }

    public void setPoomsaeCategory(String poomsaeCategory) {
        this.poomsaeCategory = poomsaeCategory;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Collection<Referee> getRefereeCollection() {
        return refereeCollection;
    }

    public void setRefereeCollection(Collection<Referee> refereeCollection) {
        this.refereeCollection = refereeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (poomsaePK != null ? poomsaePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Poomsae)) {
            return false;
        }
        Poomsae other = (Poomsae) object;
        if ((this.poomsaePK == null && other.poomsaePK != null) || (this.poomsaePK != null && !this.poomsaePK.equals(other.poomsaePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.appteste.Poomsae[ poomsaePK=" + poomsaePK + " ]";
    }
    
}
