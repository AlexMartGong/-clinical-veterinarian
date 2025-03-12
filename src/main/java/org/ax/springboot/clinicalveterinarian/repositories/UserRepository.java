package org.ax.springboot.clinicalveterinarian.repositories;

import org.ax.springboot.clinicalveterinarian.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);
}
