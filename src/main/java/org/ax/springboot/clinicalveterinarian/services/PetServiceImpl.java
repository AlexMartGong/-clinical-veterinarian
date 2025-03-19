package org.ax.springboot.clinicalveterinarian.services;

import org.ax.springboot.clinicalveterinarian.entities.Pet;
import org.ax.springboot.clinicalveterinarian.repositories.PetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;

    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pet> findAll() {
        return (List<Pet>) petRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Pet> findById(Integer id) {
        return petRepository.findById(id);
    }

    @Override
    @Transactional
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        petRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return petRepository.count();
    }
}
