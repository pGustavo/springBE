package com.app.sorteios.api.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 *
 * @author paulocamargo
 */
@Entity
@Table(catalog = "sorteios_db", schema = "")
@NamedQueries({
    @NamedQuery(name = "Coach.findAll", query = "SELECT c FROM Coach c"),
    @NamedQuery(name = "Coach.findByCoachCode", query = "SELECT c FROM Coach c WHERE c.coachCode = :coachCode"),
    @NamedQuery(name = "Coach.findByTrainnerDegree", query = "SELECT c FROM Coach c WHERE c.trainnerDegree = :trainnerDegree")})
public class Coach implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "coach_code")
    private Integer coachCode;

    private String trainnerDegree;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coach", fetch = FetchType.EAGER)
    private Collection<Person> personCollection;

    public Coach() {
    }

    public Coach(Integer coachCode) {
        this.coachCode = coachCode;
    }

    public Integer getCoachCode() {
        return coachCode;
    }

    public void setCoachCode(Integer coachCode) {
        this.coachCode = coachCode;
    }

    public String getTrainnerDegree() {
        return trainnerDegree;
    }

    public void setTrainnerDegree(String trainnerDegree) {
        this.trainnerDegree = trainnerDegree;
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
        hash += (coachCode != null ? coachCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coach)) {
            return false;
        }
        Coach other = (Coach) object;
        if ((this.coachCode == null && other.coachCode != null) || (this.coachCode != null && !this.coachCode.equals(other.coachCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.Coach[ coachCode=" + coachCode + " ]";
    }
    
}
