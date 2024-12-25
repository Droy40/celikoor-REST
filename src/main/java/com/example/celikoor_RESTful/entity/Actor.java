package com.example.celikoor_RESTful.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "actors")
@Table(name = "actors")
public class Actor {
    public enum Gender{
        FEMALE,
        MALE;
    }
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "Birth_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date birthDate;

    private String nationality;

    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    public Actor() {
    }
    public Actor(Long id, String name, Date birthDate, String nationality, Gender gender) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.nationality = nationality;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getNationality() {
        return nationality;
    }

    public Gender getGender() {
        return gender;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
