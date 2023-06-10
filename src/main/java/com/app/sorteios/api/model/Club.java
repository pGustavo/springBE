package com.app.sorteios.api.model;

import javax.persistence.*;

import javax.persistence.*;

@Entity
@Table(name = "Clubs")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String emailAddress;
    private String clubName;
    private String clubCountry;
    private String clubCountryCode;

    public Club() {
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubCountry() {
        return clubCountry;
    }

    public void setClubCountry(String clubCountry) {
        this.clubCountry = clubCountry;
    }

    public String getClubCountryCode() {
        return clubCountryCode;
    }

    public void setClubCountryCode(String clubCountryCode) {
        this.clubCountryCode = clubCountryCode;
    }
}
