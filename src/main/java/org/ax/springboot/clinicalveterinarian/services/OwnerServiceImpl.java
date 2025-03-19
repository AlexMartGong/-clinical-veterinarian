package org.ax.springboot.clinicalveterinarian.services;

import org.ax.springboot.clinicalveterinarian.entities.Owner;
import org.ax.springboot.clinicalveterinarian.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public List<Owner> findAll() {
        return (List<Owner>) ownerRepository.findAll();
    }

    @Override
    public Optional<Owner> findById(Integer id) {
        return ownerRepository.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void deleteById(Integer id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public long count() {
        return ownerRepository.count();
    }
}
