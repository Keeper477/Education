package prac20.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import prac20.model.PostOffice;

public interface PostOfficeRepository extends JpaRepository<PostOffice, Integer> { }
