package org.ax.springboot.clinicalveterinarian.services;

import org.ax.springboot.clinicalveterinarian.entities.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User save(User user);

}
