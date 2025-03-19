package org.ax.springboot.clinicalveterinarian.controllers;

import org.ax.springboot.clinicalveterinarian.services.SpeciesService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/species")
public class SpeciesController {

    private final SpeciesService speciesService;

    public SpeciesController(SpeciesService speciesService) {
        this.speciesService = speciesService;
    }

    @PreAuthorize("permitAll()")
    @GetMapping
    public ResponseEntity<?> getSpecies() {
        return ResponseEntity.ok(speciesService.findAll());
    }

}
