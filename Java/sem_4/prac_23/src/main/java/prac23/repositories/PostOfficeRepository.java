package prac23.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import prac23.model.PostOffice;

public interface PostOfficeRepository extends JpaRepository<PostOffice, Integer> { }
