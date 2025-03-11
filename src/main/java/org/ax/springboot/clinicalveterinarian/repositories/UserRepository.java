package org.ax.springboot.clinicalveterinarian.repositories;

import org.ax.springboot.clinicalveterinarian.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
