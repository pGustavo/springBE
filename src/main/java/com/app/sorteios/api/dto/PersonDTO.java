package com.app.sorteios.api.dto;

import java.util.Date;

public class PersonDTO {
    //person
    private String firstName;
    //person
    private String lastName;
    //person
    private Date birthDate;
    //person
    private String gender;

    //person
    private String nationality;
    //person
    private String login;
    //person
    private String password;
    //person
    private String email;
    //person
    private byte[] photo;


    //athlete
    private String groupCategory;

    //athlete categoryType
    private String categoryType;

    //athlete
    private String graduation;

    // poomsea1
    private String poomseaName1;
    private int result1;
    private int order1;
    private Date poomseaDate1;

    private String poomsaeCategory1;
    private String note1;

    // poomsea2
    private String poomseaName2;
    private int result2;
    private int order2;
    private Date poomseaDate2;

    private String poomsaeCategory2;
    private String note2;

    // poomsea3
    private String poomseaName3;
    private int result3;
    private int order3;
    private Date poomseaDate3;

    private String poomsaeCategory3;
    private String note3;


    //  todo ; PAULO ADD TreePosition {the type is arrayOf String} TO COMBAT IN DB AND ENTITY and methods ..
    //  todo ; PAULO ADD PoomEntry {int} TO person IN DB AND ENTITY and methods ..




}
