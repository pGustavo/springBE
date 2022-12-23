/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.sorteios.api.model;

import java.io.Serializable;
import java.util.Collection;
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

/**
 *
 * @author paulocamargo
 */
@Entity
@Table(name = "Athlete", catalog = "sorteios_db", schema = "")
@NamedQueries({
    @NamedQuery(name = "Athlete.findAll", query = "SELECT a FROM Athlete a"),
    @NamedQuery(name = "Athlete.findByAthleteCode", query = "SELECT a FROM Athlete a WHERE a.athleteCode = :athleteCode"),
    @NamedQuery(name = "Athlete.findByGroupCategory", query = "SELECT a FROM Athlete a WHERE a.groupCategory = :groupCategory"),
    @NamedQuery(name = "Athlete.findByGraduation", query = "SELECT a FROM Athlete a WHERE a.graduation = :graduation"),
    @NamedQuery(name = "Athlete.findByWeigthCategory", query = "SELECT a FROM Athlete a WHERE a.weigthCategory = :weigthCategory"),
    @NamedQuery(name = "Athlete.findByCategoryType", query = "SELECT a FROM Athlete a WHERE a.categoryType = :categoryType")})
public class Athlete implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "athlete_code")
    private Integer athleteCode;
    @Column(name = "group_category")
    private String groupCategory;
    @Column(name = "graduation")
    private String graduation;
    @Column(name = "weigth_category")
    private String weigthCategory;
    @Column(name = "category_type")
    private String categoryType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "athlete")
    private Collection<Person> personCollection;

    public Athlete() {
    }

    public Athlete(Integer athleteCode) {
        this.athleteCode = athleteCode;
    }

    public Integer getAthleteCode() {
        return athleteCode;
    }

    public void setAthleteCode(Integer athleteCode) {
        this.athleteCode = athleteCode;
    }

    public String getGroupCategory() {
        return groupCategory;
    }

    public void setGroupCategory(String groupCategory) {
        this.groupCategory = groupCategory;
    }

    public String getGraduation() {
        return graduation;
    }

    public void setGraduation(String graduation) {
        this.graduation = graduation;
    }

    public String getWeigthCategory() {
        return weigthCategory;
    }

    public void setWeigthCategory(String weigthCategory) {
        this.weigthCategory = weigthCategory;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
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
        hash += (athleteCode != null ? athleteCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Athlete)) {
            return false;
        }
        Athlete other = (Athlete) object;
        if ((this.athleteCode == null && other.athleteCode != null) || (this.athleteCode != null && !this.athleteCode.equals(other.athleteCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.appteste.Athlete[ athleteCode=" + athleteCode + " ]";
    }
    
}
