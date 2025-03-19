package org.ax.springboot.clinicalveterinarian.repositories;

import org.ax.springboot.clinicalveterinarian.entities.Species;
import org.springframework.data.repository.CrudRepository;

public interface SpeciesRepository extends CrudRepository<Species, Integer> {
}
