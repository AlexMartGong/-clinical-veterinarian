package org.ax.springboot.clinicalveterinarian.controllers;

import org.ax.springboot.clinicalveterinarian.entities.Pet;
import org.ax.springboot.clinicalveterinarian.services.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PreAuthorize("permitAll()")
    @GetMapping
    public ResponseEntity<?> getPets() {
        return ResponseEntity.ok(petService.findAll());
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/find/{id}")
    public ResponseEntity<?> getPet(@PathVariable Integer id) {
        return petService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("permitAll()")
    @PostMapping("/save")
    public ResponseEntity<?> savePet(@RequestBody Pet pet) {
        return ResponseEntity.ok(petService.save(pet));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePet(@PathVariable Integer id) {
        return petService.findById(id).map(p -> {
            petService.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/count")
    public ResponseEntity<?> countPets() {
        return ResponseEntity.ok(petService.count());
    }

}
