package org.ax.springboot.clinicalveterinarian.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "vaccinations")
public class Vaccination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaccination_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "vaccine_catalog_id", nullable = false)
    private VaccineCatalog vaccineCatalog;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "application_date", nullable = false)
    private LocalDate applicationDate;

    @Column(name = "next_application_date")
    private LocalDate nextApplicationDate;

    public Vaccination() {
    }

    public Vaccination(LocalDate applicationDate, LocalDate nextApplicationDate, Pet pet, User user, VaccineCatalog vaccineCatalog) {
        this.applicationDate = applicationDate;
        this.nextApplicationDate = nextApplicationDate;
        this.pet = pet;
        this.user = user;
        this.vaccineCatalog = vaccineCatalog;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getNextApplicationDate() {
        return nextApplicationDate;
    }

    public void setNextApplicationDate(LocalDate nextApplicationDate) {
        this.nextApplicationDate = nextApplicationDate;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public VaccineCatalog getVaccineCatalog() {
        return vaccineCatalog;
    }

    public void setVaccineCatalog(VaccineCatalog vaccineCatalog) {
        this.vaccineCatalog = vaccineCatalog;
    }
}
