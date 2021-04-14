package prac18.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import prac18.model.PostOffice;

public interface PostOfficeRepository extends JpaRepository<PostOffice, Integer> { }
