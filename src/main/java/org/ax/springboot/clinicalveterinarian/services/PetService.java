package org.ax.springboot.clinicalveterinarian.services;

import org.ax.springboot.clinicalveterinarian.entities.Pet;

import java.util.List;
import java.util.Optional;

public interface PetService {

    List<Pet> findAll();

    Optional<Pet> findById(Integer id);

    Pet save(Pet pet);

    void deleteById(Integer id);

    long count();

}
