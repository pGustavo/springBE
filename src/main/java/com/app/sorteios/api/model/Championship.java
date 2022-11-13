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
import javax.persistence.Lob;
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
    @NamedQuery(name = "Championship.findAll", query = "SELECT c FROM Championship c"),
    @NamedQuery(name = "Championship.findByChampCode", query = "SELECT c FROM Championship c WHERE c.champCode = :champCode"),
    @NamedQuery(name = "Championship.findByName", query = "SELECT c FROM Championship c WHERE c.name = :name"),
    @NamedQuery(name = "Championship.findByLocation", query = "SELECT c FROM Championship c WHERE c.location = :location"),
    @NamedQuery(name = "Championship.findByTime", query = "SELECT c FROM Championship c WHERE c.time = :time")})
public class Championship implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "champ_code")
    private Integer champCode;

    private String name;

    private String location;
    @Temporal(TemporalType.DATE)
    private Date time;
    @Lob
    private byte[] logo;
    @JoinTable(name = "Person_has_Championship", joinColumns = {
        @JoinColumn(name = "Championship_champ_code", referencedColumnName = "champ_code")}, inverseJoinColumns = {
        @JoinColumn(name = "Person_person_code", referencedColumnName = "person_code"),
        @JoinColumn(name = "Person_Club_club_code", referencedColumnName = "Club_club_code")})
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Person> personCollection;

    public Championship() {
    }

    public Championship(Integer champCode) {
        this.champCode = champCode;
    }

    public Integer getChampCode() {
        return champCode;
    }

    public void setChampCode(Integer champCode) {
        this.champCode = champCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
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
        hash += (champCode != null ? champCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Championship)) {
            return false;
        }
        Championship other = (Championship) object;
        if ((this.champCode == null && other.champCode != null) || (this.champCode != null && !this.champCode.equals(other.champCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.Championship[ champCode=" + champCode + " ]";
    }
    
}
