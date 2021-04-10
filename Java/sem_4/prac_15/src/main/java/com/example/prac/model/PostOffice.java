package com.example.prac.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Entity;


@Entity
@Table(name = "postoffice")
@Getter
@Setter
public class PostOffice {
    @Id
    private int id;
    @Column(name = "name")
    String name;
    @Column(name = "cityname")
    String cityName;
}
