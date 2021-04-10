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
    @SequenceGenerator(name = "departure_seq", sequenceName =
            "departure_sequence", allocationSize = 1)
    @GeneratedValue(generator = "departure_seq", strategy =
            GenerationType.SEQUENCE)
    private int id;
    @Column(name = "type")
    String type;
    @Column(name = "departureDate")
    String departureDate;
}
