package org.ax.springboot.clinicalveterinarian.services;

import org.ax.springboot.clinicalveterinarian.entities.Breed;

import java.util.List;

public interface BreedService {

    List<Breed> findAll();

}
