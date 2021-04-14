package prac23.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import prac23.model.Departure;

public interface DepartureRepository extends JpaRepository<Departure, Integer> { }
