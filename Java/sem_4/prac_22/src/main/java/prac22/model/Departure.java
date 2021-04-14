package prac22.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "departures")
@Getter
@Setter
public class Departure {
    @Id
    @SequenceGenerator(name = "departures_seq", sequenceName = "departures_sequence", allocationSize = 1)
    @GeneratedValue(generator = "departures_seq", strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "type")
    String type;
    @Column(name = "departuredate")
    String departureDate;
    @Column(name = "postoffice_id")
    private int postoffice_id;
    @ManyToOne
    @JoinColumn(name = "postoffice_id", insertable = false, updatable = false)
    @JsonIgnore
    private PostOffice postoffice;
}
