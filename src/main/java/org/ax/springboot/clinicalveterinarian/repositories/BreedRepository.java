package org.ax.springboot.clinicalveterinarian.repositories;

import org.ax.springboot.clinicalveterinarian.entities.Breed;
import org.springframework.data.repository.CrudRepository;

public interface BreedRepository extends CrudRepository<Breed, Integer> {
}
