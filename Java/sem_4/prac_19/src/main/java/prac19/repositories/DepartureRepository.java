package prac19.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import prac19.model.Departure;

public interface DepartureRepository extends JpaRepository<Departure, Integer> { }
