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
    @SequenceGenerator(name = "postoffice_seq", sequenceName =
            "postoffice_sequence", allocationSize = 1)
    @GeneratedValue(generator = "postoffice_seq", strategy =
            GenerationType.SEQUENCE)
    private int id;
    @Column(name = "name")
    String name;
    @Column(name = "cityName")
    String cityName;
}
