/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.sorteios.api.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "combat", catalog = "sorteios_db", schema = "")
@NamedQueries({
    @NamedQuery(name = "Combat.findAll", query = "SELECT c FROM Combat c"),
    @NamedQuery(name = "Combat.findByCombateCode", query = "SELECT c FROM Combat c WHERE c.combateCode = :combateCode"),
    @NamedQuery(name = "Combat.findByRoundOf", query = "SELECT c FROM Combat c WHERE c.roundOf = :roundOf"),
    @NamedQuery(name = "Combat.findByCombatDate", query = "SELECT c FROM Combat c WHERE c.combatDate = :combatDate"),
    @NamedQuery(name = "Combat.findByWinner", query = "SELECT c FROM Combat c WHERE c.winner = :winner"),
    @NamedQuery(name = "Combat.findByScore", query = "SELECT c FROM Combat c WHERE c.score = :score")})
public class Combat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "combate_code")
    private Integer combateCode;
    @Column(name = "roundOf")
    private Integer roundOf;
    @Column(name = "combat_date")
    @Temporal(TemporalType.DATE)
    private Date combatDate;
    @Column(name = "winner")
    private String winner;
    @Column(name = "score")
    private String score;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "combat")
    private Collection<Person> personCollection;

    public Combat() {
    }

    public Combat(Integer combateCode) {
        this.combateCode = combateCode;
    }

    public Integer getCombateCode() {
        return combateCode;
    }

    public void setCombateCode(Integer combateCode) {
        this.combateCode = combateCode;
    }

    public Integer getRoundOf() {
        return roundOf;
    }

    public void setRoundOf(Integer roundOf) {
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

    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (combateCode != null ? combateCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Combat)) {
            return false;
        }
        Combat other = (Combat) object;
        if ((this.combateCode == null && other.combateCode != null) || (this.combateCode != null && !this.combateCode.equals(other.combateCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.appteste.Combat[ combateCode=" + combateCode + " ]";
    }
    
}
