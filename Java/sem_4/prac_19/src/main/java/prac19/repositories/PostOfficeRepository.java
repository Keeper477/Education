package prac19.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import prac19.model.PostOffice;

public interface PostOfficeRepository extends JpaRepository<PostOffice, Integer> { }
