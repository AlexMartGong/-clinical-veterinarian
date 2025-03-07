package org.ax.springboot.clinicalveterinarian.entities;

import jakarta.persistence.*;
import org.ax.springboot.clinicalveterinarian.enums.Role;

import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "full_name", nullable = false, length = 150)
    private String fullName;

    @Column(name = "username", nullable = false, length = 50, unique = true)
    private String username;

    @Column(name = "phone", nullable = false, length = 10, unique = true)
    private String phone;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @OneToMany(mappedBy = "user")
    private List<Consultation> consultations;

    @OneToMany(mappedBy = "user")
    private List<Vaccination> vaccinations;

    public User() {
    }

    public User(List<Consultation> consultations, String fullName, Boolean isActive, String password, String phone, Role role, String username, List<Vaccination> vaccinations) {
        this.consultations = consultations;
        this.fullName = fullName;
        this.isActive = isActive;
        this.password = password;
        this.phone = phone;
        this.role = role;
        this.username = username;
        this.vaccinations = vaccinations;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Vaccination> getVaccinations() {
        return vaccinations;
    }

    public void setVaccinations(List<Vaccination> vaccinations) {
        this.vaccinations = vaccinations;
    }
}
