package com.example.prac.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "departure")
@Getter
@Setter
public class Departure {
    @Id
    private int id;
    @Column(name = "type")
    String type;
    @Column(name = "departuredate")
    String departureDate;
}
