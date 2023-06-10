package com.app.sorteios.api.dto;

import java.util.Date;
public class PoomseaDTO {
    private Long id;
    private String athleteEntryCode;
    private String poomseaName;
    private int result;
    private int poomseaOrder;
    private Date poomseaDate;
    private String poomseaCategory;
    private String note;

    // Constructors

    public PoomseaDTO() {
    }

    public PoomseaDTO(Long id, String athleteEntryCode, String poomseaName, int result, int poomseaOrder, Date poomseaDate, String poomseaCategory, String note) {
        this.id = id;
        this.athleteEntryCode = athleteEntryCode;
        this.poomseaName = poomseaName;
        this.result = result;
        this.poomseaOrder = poomseaOrder;
        this.poomseaDate = poomseaDate;
        this.poomseaCategory = poomseaCategory;
        this.note = note;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAthleteEntryCode() {
        return athleteEntryCode;
    }

    public void setAthleteEntryCode(String athleteEntryCode) {
        this.athleteEntryCode = athleteEntryCode;
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
