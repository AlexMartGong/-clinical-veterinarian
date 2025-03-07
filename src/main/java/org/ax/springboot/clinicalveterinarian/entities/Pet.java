package org.ax.springboot.clinicalveterinarian.entities;

import jakarta.persistence.*;
import org.ax.springboot.clinicalveterinarian.enums.Gender;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "species_id", nullable = false)
    private Species species;

    @ManyToOne
    @JoinColumn(name = "breed_id")
    private Breed breed;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Column(name = "color", length = 50)
    private String color;

    @Column(name = "weight_kg", precision = 5, scale = 2)
    private BigDecimal weightKg;

    @Column(name = "microchip", length = 50)
    private String microchip;

    @Column(name = "photo_url", length = 255)
    private String photoUrl;

    @OneToMany(mappedBy = "pet")
    private List<Consultation> consultations;

    @OneToMany(mappedBy = "pet")
    private List<Vaccination> vaccinations;

}
