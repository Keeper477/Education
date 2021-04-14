package prac18.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import prac18.model.Departure;

public interface DepartureRepository extends JpaRepository<Departure, Integer> { }
