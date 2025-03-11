package org.ax.springboot.clinicalveterinarian.controllers;

import org.ax.springboot.clinicalveterinarian.entities.User;
import org.ax.springboot.clinicalveterinarian.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getUsers(){
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<?> addUser(@RequestBody User user){
        return ResponseEntity.ok(userService.save(user));
    }

}
