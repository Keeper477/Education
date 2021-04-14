package prac22.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import prac22.model.Departure;

public interface DepartureRepository extends JpaRepository<Departure, Integer> { }
