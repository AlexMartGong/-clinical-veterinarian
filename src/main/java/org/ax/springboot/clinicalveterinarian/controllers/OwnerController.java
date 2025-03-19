package org.ax.springboot.clinicalveterinarian.controllers;

import org.ax.springboot.clinicalveterinarian.entities.Owner;
import org.ax.springboot.clinicalveterinarian.services.OwnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PreAuthorize("permitAll()")
    @GetMapping
    public ResponseEntity<?> getOwners() {
        return ResponseEntity.ok(ownerService.findAll());
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/find/{id}")
    public ResponseEntity<?> getOwner(@PathVariable Integer id) {
        return ownerService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("permitAll()")
    @PostMapping("/save")
    public ResponseEntity<?> saveOwner(@RequestBody Owner owner) {
        return ResponseEntity.ok(ownerService.save(owner));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOwner(@PathVariable Integer id) {
        return ownerService.findById(id).map(o -> {
            ownerService.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/count")
    public ResponseEntity<?> countOwners() {
        return ResponseEntity.ok(ownerService.count());
    }

}
