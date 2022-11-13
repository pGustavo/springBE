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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
    @NamedQuery(name = "Referee.findAll", query = "SELECT r FROM Referee r"),
    @NamedQuery(name = "Referee.findByRefereeCode", query = "SELECT r FROM Referee r WHERE r.refereeCode = :refereeCode"),
    @NamedQuery(name = "Referee.findByLastRecycle", query = "SELECT r FROM Referee r WHERE r.lastRecycle = :lastRecycle"),
    @NamedQuery(name = "Referee.findByType", query = "SELECT r FROM Referee r WHERE r.type = :type"),
    @NamedQuery(name = "Referee.findByInternational", query = "SELECT r FROM Referee r WHERE r.international = :international")})
public class Referee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "referee_code")
    private Integer refereeCode;

    @Column(name = "last_recycle")
    private String lastRecycle;

    private String type;
    private Short international;
    @Lob
    private byte[] proof;
    @JoinTable(name = "Referee_has_combat", joinColumns = {
        @JoinColumn(name = "Referee_referee_code", referencedColumnName = "referee_code")}, inverseJoinColumns = {
        @JoinColumn(name = "combat_combate_code", referencedColumnName = "combate_code")})
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Combat> combatCollection;
    @ManyToMany(mappedBy = "refereeCollection", fetch = FetchType.EAGER)
    private Collection<Poomsae> poomsaeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "referee", fetch = FetchType.EAGER)
    private Collection<Person> personCollection;

    public Referee() {
    }

    public Referee(Integer refereeCode) {
        this.refereeCode = refereeCode;
    }

    public Integer getRefereeCode() {
        return refereeCode;
    }

    public void setRefereeCode(Integer refereeCode) {
        this.refereeCode = refereeCode;
    }

    public String getLastRecycle() {
        return lastRecycle;
    }

    public void setLastRecycle(String lastRecycle) {
        this.lastRecycle = lastRecycle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Short getInternational() {
        return international;
    }

    public void setInternational(Short international) {
        this.international = international;
    }

    public byte[] getProof() {
        return proof;
    }

    public void setProof(byte[] proof) {
        this.proof = proof;
    }

    public Collection<Combat> getCombatCollection() {
        return combatCollection;
    }

    public void setCombatCollection(Collection<Combat> combatCollection) {
        this.combatCollection = combatCollection;
    }

    public Collection<Poomsae> getPoomsaeCollection() {
        return poomsaeCollection;
    }

    public void setPoomsaeCollection(Collection<Poomsae> poomsaeCollection) {
        this.poomsaeCollection = poomsaeCollection;
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
        hash += (refereeCode != null ? refereeCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Referee)) {
            return false;
        }
        Referee other = (Referee) object;
        if ((this.refereeCode == null && other.refereeCode != null) || (this.refereeCode != null && !this.refereeCode.equals(other.refereeCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.Referee[ refereeCode=" + refereeCode + " ]";
    }
    
}
