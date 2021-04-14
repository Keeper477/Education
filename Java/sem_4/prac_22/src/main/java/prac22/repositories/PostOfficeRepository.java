package prac22.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import prac22.model.PostOffice;

public interface PostOfficeRepository extends JpaRepository<PostOffice, Integer> { }
