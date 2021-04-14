package prac23.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prac23.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> { }
