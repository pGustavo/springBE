package com.app.sorteios.api.model;

import javax.persistence.*;
import java.util.Date;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Referees")
public class Referee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private Date birthdate;
    private String gender;
    private String nationality;
    private String login;
    private String password;
    private String email;

    @Lob
    private byte[] photo;

    private Date lastRecycle;
    private String refereeType;
    private boolean isInternational;

    @Lob
    private byte[] proof;

    public Referee() {
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
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

    public Date getLastRecycle() {
        return lastRecycle;
    }

    public void setLastRecycle(Date lastRecycle) {
        this.lastRecycle = lastRecycle;
    }

    public String getRefereeType() {
        return refereeType;
    }

    public void setRefereeType(String refereeType) {
        this.refereeType = refereeType;
    }

    public boolean isInternational() {
        return isInternational;
    }

    public void setInternational(boolean international) {
        isInternational = international;
    }

    public byte[] getProof() {
        return proof;
    }

    public void setProof(byte[] proof) {
        this.proof = proof;
    }
}

