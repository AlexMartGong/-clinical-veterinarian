package org.ax.springboot.clinicalveterinarian.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "breeds")
public class Breed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "breed_id")
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @ManyToOne
    @JoinColumn(name = "species_id", nullable = false)
    private Species species;

    @OneToMany(mappedBy = "breed")
    private List<Pet> pets;

    public Breed() {
    }

    public Breed(String name, List<Pet> pets, Species species) {
        this.name = name;
        this.pets = pets;
        this.species = species;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }
}
