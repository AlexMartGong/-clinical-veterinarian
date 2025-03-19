package org.ax.springboot.clinicalveterinarian.services;

import org.ax.springboot.clinicalveterinarian.entities.Species;

import java.util.List;

public interface SpeciesService {
    List<Species> findAll();
}
