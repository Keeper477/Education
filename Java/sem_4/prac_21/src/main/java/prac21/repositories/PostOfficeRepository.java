package prac21.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import prac21.model.PostOffice;

public interface PostOfficeRepository extends JpaRepository<PostOffice, Integer> { }
