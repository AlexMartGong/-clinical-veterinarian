package org.ax.springboot.clinicalveterinarian.repositories;

import org.ax.springboot.clinicalveterinarian.entities.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Integer> {
}
