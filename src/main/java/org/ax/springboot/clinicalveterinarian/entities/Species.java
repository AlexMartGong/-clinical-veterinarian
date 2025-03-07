package org.ax.springboot.clinicalveterinarian.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "species")
public class Species {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "species_id")
    private Integer id;

    @Column(name = "name", nullable = false, length = 50, unique = true)
    private String name;

    @OneToMany(mappedBy = "species")
    private List<Breed> breeds;

    @OneToMany(mappedBy = "species")
    private List<Pet> pets;

    @OneToMany(mappedBy = "species")
    private List<VaccineCatalog> vaccineCatalog;

    public Species() {
    }

    public Species(List<Breed> breeds, String name, List<Pet> pets, List<VaccineCatalog> vaccineCatalog) {
        this.breeds = breeds;
        this.name = name;
        this.pets = pets;
        this.vaccineCatalog = vaccineCatalog;
    }

    public List<Breed> getBreeds() {
        return breeds;
    }

    public void setBreeds(List<Breed> breeds) {
        this.breeds = breeds;
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

    public List<VaccineCatalog> getVaccineCatalog() {
        return vaccineCatalog;
    }

    public void setVaccineCatalog(List<VaccineCatalog> vaccineCatalog) {
        this.vaccineCatalog = vaccineCatalog;
    }
}
