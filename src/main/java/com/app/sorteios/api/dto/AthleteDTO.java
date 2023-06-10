package com.app.sorteios.api.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Athlete DTO class
 */

public class AthleteDTO {
    private String entryCode;
    private String firstName;
    private String lastName;
    private Date birthdate;
    private String gender;
    private String nationality;
    private String login;
    private String password;
    private String email;
    private byte[] photo;
    private String treePosition;
    private String graduation;
    private String weightCategory;
    private String groupCategory;
    private String categoryType;
    private Long clubId;
    private Long coachId;

    // Constructors, getters, and setters

    public AthleteDTO() {
    }

    public AthleteDTO(String entryCode, String firstName, String lastName, Date birthdate, String gender,
                      String nationality, String login, String password, String email, byte[] photo,
                      String treePosition, String graduation, String weightCategory, String groupCategory,
                      String categoryType, Long clubId, Long coachId) {
        this.entryCode = entryCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.gender = gender;
        this.nationality = nationality;
        this.login = login;
        this.password = password;
        this.email = email;
        this.photo = photo;
        this.treePosition = treePosition;
        this.graduation = graduation;
        this.weightCategory = weightCategory;
        this.groupCategory = groupCategory;
        this.categoryType = categoryType;
        this.clubId = clubId;
        this.coachId = coachId;
    }

    public String getEntryCode() {
        return entryCode;
    }

    public void setEntryCode(String entryCode) {
        this.entryCode = entryCode;
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

    public String getTreePosition() {
        return treePosition;
    }

    public void setTreePosition(String treePosition) {
        this.treePosition = treePosition;
    }

    public String getGraduation() {
        return graduation;
    }

    public void setGraduation(String graduation) {
        this.graduation = graduation;
    }

    public String getWeightCategory() {
        return weightCategory;
    }

    public void setWeightCategory(String weightCategory) {
        this.weightCategory = weightCategory;
    }

    public String getGroupCategory() {
        return groupCategory;
    }

    public void setGroupCategory(String groupCategory) {
        this.groupCategory = groupCategory;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public Long getClubId() {
        return clubId;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }

    public Long getCoachId() {
        return coachId;
    }

    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }
	
	
}
