/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.sorteios.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.mapping.Set;

/**
 *
 * @author paulocamargo
 */
@Entity
@Table(name = "Championship", catalog = "sorteios_db", schema = "")
@NamedQueries({
    @NamedQuery(name = "Championship.findAll", query = "SELECT c FROM Championship c"),
    @NamedQuery(name = "Championship.findByChampCode", query = "SELECT c FROM Championship c WHERE c.championshipPK.champCode = :champCode"),
    @NamedQuery(name = "Championship.findByName", query = "SELECT c FROM Championship c WHERE c.name = :name"),
    @NamedQuery(name = "Championship.findByLocation", query = "SELECT c FROM Championship c WHERE c.location = :location"),
    @NamedQuery(name = "Championship.findByTime", query = "SELECT c FROM Championship c WHERE c.time = :time"),
    @NamedQuery(name = "Championship.findByPersonpersoncode", query = "SELECT c FROM Championship c WHERE c.championshipPK.personpersoncode = :personpersoncode"),
    @NamedQuery(name = "Championship.findByPersonClubclubcode", query = "SELECT c FROM Championship c WHERE c.championshipPK.personClubclubcode = :personClubclubcode"),
    @NamedQuery(name = "Championship.findByPersonAthleteathletecode", query = "SELECT c FROM Championship c WHERE c.championshipPK.personAthleteathletecode = :personAthleteathletecode"),
    @NamedQuery(name = "Championship.findByPersonRefereerefereecode", query = "SELECT c FROM Championship c WHERE c.championshipPK.personRefereerefereecode = :personRefereerefereecode"),
    @NamedQuery(name = "Championship.findByPersonCoachcoachcode", query = "SELECT c FROM Championship c WHERE c.championshipPK.personCoachcoachcode = :personCoachcoachcode")})
public class Championship implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChampionshipPK championshipPK;
    @Column(name = "name")
    private String name;
    @Column(name = "location")
    private String location;
    @Column(name = "time")
    @Temporal(TemporalType.DATE)
    private Date time;
    @Lob
    @Column(name = "logo")
    private byte[] logo;
   

    @JoinColumn(name = "Person_person_code", referencedColumnName = "person_code", insertable = false, updatable = false)
    private Set personCollection;
    
   

    public Championship() {
    }

    public Championship(ChampionshipPK championshipPK) {
        this.championshipPK = championshipPK;
    }

    public Championship(int champCode, int personpersoncode, int personClubclubcode, int personAthleteathletecode, int personRefereerefereecode, int personCoachcoachcode) {
        this.championshipPK = new ChampionshipPK(champCode, personpersoncode, personClubclubcode, personAthleteathletecode, personRefereerefereecode, personCoachcoachcode);
    }

    public ChampionshipPK getChampionshipPK() {
        return championshipPK;
    }

    public void setChampionshipPK(ChampionshipPK championshipPK) {
        this.championshipPK = championshipPK;
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




	@Override
    public int hashCode() {
        int hash = 0;
        hash += (championshipPK != null ? championshipPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Championship)) {
            return false;
        }
        Championship other = (Championship) object;
        if ((this.championshipPK == null && other.championshipPK != null) || (this.championshipPK != null && !this.championshipPK.equals(other.championshipPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.appteste.Championship[ championshipPK=" + championshipPK + " ]";
    }
    
}
