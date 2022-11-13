package com.app.sorteios.api.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author paulocamargo
 */
@Entity
@Table(catalog = "sorteios_db", schema = "")
@NamedQueries({
    @NamedQuery(name = "Combat.findAll", query = "SELECT c FROM Combat c"),
    @NamedQuery(name = "Combat.findByCombateCode", query = "SELECT c FROM Combat c WHERE c.combateCode = :combateCode"),
    @NamedQuery(name = "Combat.findByMath", query = "SELECT c FROM Combat c WHERE c.math = :math"),
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
    private Integer math;
    @Column(name = "combat_date")
    @Temporal(TemporalType.DATE)
    private Date combatDate;

    private String winner;
 
    private String score;
    @ManyToMany(mappedBy = "combatCollection", fetch = FetchType.EAGER)
    private Collection<Referee> refereeCollection;
    @ManyToMany(mappedBy = "combatCollection", fetch = FetchType.EAGER)
    private Collection<Athlete> athleteCollection;

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

    public Integer getMath() {
        return math;
    }

    public void setMath(Integer math) {
        this.math = math;
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

    public Collection<Referee> getRefereeCollection() {
        return refereeCollection;
    }

    public void setRefereeCollection(Collection<Referee> refereeCollection) {
        this.refereeCollection = refereeCollection;
    }

    public Collection<Athlete> getAthleteCollection() {
        return athleteCollection;
    }

    public void setAthleteCollection(Collection<Athlete> athleteCollection) {
        this.athleteCollection = athleteCollection;
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
        return "com.mycompany.mavenproject1.Combat[ combateCode=" + combateCode + " ]";
    }
    
}
