package prac23.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "postoffices")
@Getter
@Setter
public class PostOffice {
    @Id
    @SequenceGenerator(name = "postoffice_seq", sequenceName = "postoffice_sequence", allocationSize = 1)
    @GeneratedValue(generator = "postoffice_seq", strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "name")
    String name;
    @Column(name = "cityname")
    String cityName;
    @OneToMany(mappedBy = "postoffice", fetch = FetchType.LAZY)
    private List<Departure> departures;
}
