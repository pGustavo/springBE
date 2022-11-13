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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
    @NamedQuery(name = "Poomsae.findAll", query = "SELECT p FROM Poomsae p"),
    @NamedQuery(name = "Poomsae.findByPoomsaeCode", query = "SELECT p FROM Poomsae p WHERE p.poomsaeCode = :poomsaeCode"),
    @NamedQuery(name = "Poomsae.findByPoomsae", query = "SELECT p FROM Poomsae p WHERE p.poomsae = :poomsae"),
    @NamedQuery(name = "Poomsae.findByResult", query = "SELECT p FROM Poomsae p WHERE p.result = :result"),
    @NamedQuery(name = "Poomsae.findByOrder", query = "SELECT p FROM Poomsae p WHERE p.order = :order"),
    @NamedQuery(name = "Poomsae.findByPoomsaeDate", query = "SELECT p FROM Poomsae p WHERE p.poomsaeDate = :poomsaeDate"),
    @NamedQuery(name = "Poomsae.findByPoomsaeCategory", query = "SELECT p FROM Poomsae p WHERE p.poomsaeCategory = :poomsaeCategory"),
    @NamedQuery(name = "Poomsae.findByNote", query = "SELECT p FROM Poomsae p WHERE p.note = :note")})
public class Poomsae implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "poomsae_code")
    private Integer poomsaeCode;

    private String poomsae;
    private Integer result;
    private Integer order;
    @Column(name = "poomsae_date")
    @Temporal(TemporalType.DATE)
    private Date poomsaeDate;

    @Column(name = "poomsae_Category")
    private String poomsaeCategory;

    private String note;
    @ManyToMany(mappedBy = "poomsaeCollection", fetch = FetchType.EAGER)
    private Collection<Athlete> athleteCollection;
    @JoinTable(name = "Referee_has_Poomsae", joinColumns = {
        @JoinColumn(name = "Poonsae_poomsae_code", referencedColumnName = "poomsae_code")}, inverseJoinColumns = {
        @JoinColumn(name = "Referee_referee_code", referencedColumnName = "referee_code")})
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Referee> refereeCollection;

    public Poomsae() {
    }

    public Poomsae(Integer poomsaeCode) {
        this.poomsaeCode = poomsaeCode;
    }

    public Integer getPoomsaeCode() {
        return poomsaeCode;
    }

    public void setPoomsaeCode(Integer poomsaeCode) {
        this.poomsaeCode = poomsaeCode;
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

    public Collection<Athlete> getAthleteCollection() {
        return athleteCollection;
    }

    public void setAthleteCollection(Collection<Athlete> athleteCollection) {
        this.athleteCollection = athleteCollection;
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
        hash += (poomsaeCode != null ? poomsaeCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Poomsae)) {
            return false;
        }
        Poomsae other = (Poomsae) object;
        if ((this.poomsaeCode == null && other.poomsaeCode != null) || (this.poomsaeCode != null && !this.poomsaeCode.equals(other.poomsaeCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.Poomsae[ poomsaeCode=" + poomsaeCode + " ]";
    }
    
}
