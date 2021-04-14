package prac21.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import prac21.model.Departure;

public interface DepartureRepository extends JpaRepository<Departure, Integer> { }
