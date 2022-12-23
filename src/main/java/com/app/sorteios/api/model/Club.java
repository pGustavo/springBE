/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appteste;

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
@Table(name = "Club", catalog = "sorteios_db", schema = "")
@NamedQueries({
    @NamedQuery(name = "Club.findAll", query = "SELECT c FROM Club c"),
    @NamedQuery(name = "Club.findByClubCode", query = "SELECT c FROM Club c WHERE c.clubCode = :clubCode"),
    @NamedQuery(name = "Club.findByEmailAddress", query = "SELECT c FROM Club c WHERE c.emailAddress = :emailAddress"),
    @NamedQuery(name = "Club.findByClubName", query = "SELECT c FROM Club c WHERE c.clubName = :clubName")})
public class Club implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "club_code")
    private Integer clubCode;
    @Column(name = "email_address")
    private String emailAddress;
    @Column(name = "club_name")
    private String clubName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "club")
    private Collection<Person> personCollection;

    public Club() {
    }

    public Club(Integer clubCode) {
        this.clubCode = clubCode;
    }

    public Integer getClubCode() {
        return clubCode;
    }

    public void setClubCode(Integer clubCode) {
        this.clubCode = clubCode;
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

    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clubCode != null ? clubCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Club)) {
            return false;
        }
        Club other = (Club) object;
        if ((this.clubCode == null && other.clubCode != null) || (this.clubCode != null && !this.clubCode.equals(other.clubCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.appteste.Club[ clubCode=" + clubCode + " ]";
    }
    
}
