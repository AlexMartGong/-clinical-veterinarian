package org.ax.springboot.clinicalveterinarian.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "vaccine_catalog")
public class VaccineCatalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaccine_catalog_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "species_id", nullable = false)
    private Species species;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "interval_months")
    private Integer intervalMonths;

    @OneToMany(mappedBy = "vaccineCatalog")
    private List<Vaccination> vaccinations;

    public VaccineCatalog() {
    }

    public VaccineCatalog(String description, Integer intervalMonths, String name, Species species, List<Vaccination> vaccinations) {
        this.description = description;
        this.intervalMonths = intervalMonths;
        this.name = name;
        this.species = species;
        this.vaccinations = vaccinations;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIntervalMonths() {
        return intervalMonths;
    }

    public void setIntervalMonths(Integer intervalMonths) {
        this.intervalMonths = intervalMonths;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public List<Vaccination> getVaccinations() {
        return vaccinations;
    }

    public void setVaccinations(List<Vaccination> vaccinations) {
        this.vaccinations = vaccinations;
    }
}
