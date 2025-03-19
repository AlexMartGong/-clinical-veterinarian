package org.ax.springboot.clinicalveterinarian.controllers;

import org.ax.springboot.clinicalveterinarian.services.BreedService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/breeds")
public class BreedController {

    private final BreedService breedService;

    public BreedController(BreedService breedService) {
        this.breedService = breedService;
    }

    @PreAuthorize("permitAll()")
    @GetMapping
    public ResponseEntity<?> getBreeds() {
        return ResponseEntity.ok(breedService.findAll());
    }

}
