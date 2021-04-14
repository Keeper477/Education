package prac20.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import prac20.model.Departure;

public interface DepartureRepository extends JpaRepository<Departure, Integer> { }
