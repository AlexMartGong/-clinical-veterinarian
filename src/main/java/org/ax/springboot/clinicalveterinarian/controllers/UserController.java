package org.ax.springboot.clinicalveterinarian.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.ax.springboot.clinicalveterinarian.entities.User;
import org.ax.springboot.clinicalveterinarian.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<?> addUser(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            return validation(result);
        }
        return ResponseEntity.ok(userService.save(user));
    }

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, Object> errors = new HashMap<>();
        result.getFieldErrors().forEach(err -> errors.put(err.getField(), err.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

}
