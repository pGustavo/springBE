package com.app.sorteios.api.dto;

import java.util.Date;

public class ChampionshipDTO {
    private String name;
    private String location;
    private Date time;
    private byte[] logo;

    // Constructors, getters, and setters

    public ChampionshipDTO() {
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
}
