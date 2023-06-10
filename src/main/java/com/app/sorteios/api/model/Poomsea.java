package com.app.sorteios.api.model;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Poomseas")
public class Poomsea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "athleteEntryCode")
    private Athlete athlete;

    private String poomseaName;
    private int result;
    private int poomseaOrder;
    private Date poomseaDate;
    private String poomseaCategory;
    private String note;

    public Poomsea() {
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    public String getPoomseaName() {
        return poomseaName;
    }

    public void setPoomseaName(String poomseaName) {
        this.poomseaName = poomseaName;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getPoomseaOrder() {
        return poomseaOrder;
    }

    public void setPoomseaOrder(int poomseaOrder) {
        this.poomseaOrder = poomseaOrder;
    }

    public Date getPoomseaDate() {
        return poomseaDate;
    }

    public void setPoomseaDate(Date poomseaDate) {
        this.poomseaDate = poomseaDate;
    }

    public String getPoomseaCategory() {
        return poomseaCategory;
    }

    public void setPoomseaCategory(String poomseaCategory) {
        this.poomseaCategory = poomseaCategory;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
