/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.sorteios.api.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findByPersonCode", query = "SELECT p FROM Person p WHERE p.personPK.personCode = :personCode"),
    @NamedQuery(name = "Person.findByFirstName", query = "SELECT p FROM Person p WHERE p.firstName = :firstName"),
    @NamedQuery(name = "Person.findByLastName", query = "SELECT p FROM Person p WHERE p.lastName = :lastName"),
    @NamedQuery(name = "Person.findByBirthDate", query = "SELECT p FROM Person p WHERE p.birthDate = :birthDate"),
    @NamedQuery(name = "Person.findByGender", query = "SELECT p FROM Person p WHERE p.gender = :gender"),
    @NamedQuery(name = "Person.findByNationality", query = "SELECT p FROM Person p WHERE p.nationality = :nationality"),
    @NamedQuery(name = "Person.findByLogin", query = "SELECT p FROM Person p WHERE p.login = :login"),
    @NamedQuery(name = "Person.findByPassword", query = "SELECT p FROM Person p WHERE p.password = :password"),
    @NamedQuery(name = "Person.findByEmail", query = "SELECT p FROM Person p WHERE p.email = :email"),
    @NamedQuery(name = "Person.findByClubclubcode", query = "SELECT p FROM Person p WHERE p.personPK.clubclubcode = :clubclubcode"),
    @NamedQuery(name = "Person.findByAthleteathletecode", query = "SELECT p FROM Person p WHERE p.personPK.athleteathletecode = :athleteathletecode"),
    @NamedQuery(name = "Person.findByRefereerefereecode", query = "SELECT p FROM Person p WHERE p.personPK.refereerefereecode = :refereerefereecode"),
    @NamedQuery(name = "Person.findByCoachcoachcode", query = "SELECT p FROM Person p WHERE p.personPK.coachcoachcode = :coachcoachcode")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonPK personPK;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    private String gender;

    private String nationality;

    private String login;

    private String password;
    
    private String email;
    @Lob
    private byte[] photo;
    @ManyToMany(mappedBy = "personCollection", fetch = FetchType.EAGER)
    private Collection<Championship> championshipCollection;
    @JoinColumn(name = "Athlete_athlete_code", referencedColumnName = "athlete_code", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Athlete athlete;
    @JoinColumn(name = "Club_club_code", referencedColumnName = "club_code", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Club club;
    @JoinColumn(name = "Coach_coach_code", referencedColumnName = "coach_code", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Coach coach;
    @JoinColumn(name = "Referee_referee_code", referencedColumnName = "referee_code", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Referee referee;

    public Person() {
    }

    public Person(PersonPK personPK) {
        this.personPK = personPK;
    }

    public Person(int personCode, int clubclubcode, int athleteathletecode, int refereerefereecode, int coachcoachcode) {
        this.personPK = new PersonPK(personCode, clubclubcode, athleteathletecode, refereerefereecode, coachcoachcode);
    }

    public PersonPK getPersonPK() {
        return personPK;
    }

    public void setPersonPK(PersonPK personPK) {
        this.personPK = personPK;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Collection<Championship> getChampionshipCollection() {
        return championshipCollection;
    }

    public void setChampionshipCollection(Collection<Championship> championshipCollection) {
        this.championshipCollection = championshipCollection;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Referee getReferee() {
        return referee;
    }

    public void setReferee(Referee referee) {
        this.referee = referee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personPK != null ? personPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.personPK == null && other.personPK != null) || (this.personPK != null && !this.personPK.equals(other.personPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() { 
        return "com.mycompany.mavenproject1.Person[ personPK=" + personPK + " ]";
    }
    
}
