package org.ax.springboot.clinicalveterinarian.services;

import org.ax.springboot.clinicalveterinarian.entities.Breed;
import org.ax.springboot.clinicalveterinarian.repositories.BreedRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BreedServiceImpl implements BreedService {

    private final BreedRepository breedRepository;

    public BreedServiceImpl(BreedRepository breedRepository) {
        this.breedRepository = breedRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Breed> findAll() {
        return (List<Breed>) breedRepository.findAll();
    }
}
