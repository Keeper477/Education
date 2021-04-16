package prac24.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import prac24.model.PostOffice;

public interface PostOfficeRepository extends JpaRepository<PostOffice, Integer> { }
