package com.rowingApp.domain;


import javax.persistence.*;

@Entity
public class UserScore implements Comparable<UserScore>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId", nullable = false, updatable = false)
    private Long userId;
    private Long number;
    private String division;
    private String name;
    private Integer wats;
    @Lob
    private byte[] picture;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWats() {
        return wats;
    }

    public void setWats(Integer wats) {
        this.wats = wats;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Override
    public int compareTo(UserScore o) {
        return this.getWats().compareTo(o.getWats());
    }
}
