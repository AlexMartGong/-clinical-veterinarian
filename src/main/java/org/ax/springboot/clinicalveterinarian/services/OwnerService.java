package org.ax.springboot.clinicalveterinarian.services;

import org.ax.springboot.clinicalveterinarian.entities.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerService {

    List<Owner> findAll();

    Optional<Owner> findById(Integer id);

    Owner save(Owner owner);

    void deleteById(Integer id);

    long count();

}
