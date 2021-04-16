package prac24.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import prac24.model.Departure;

public interface DepartureRepository extends JpaRepository<Departure, Integer> { }
