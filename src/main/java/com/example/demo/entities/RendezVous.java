package com.example.demo.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "rendezvous")
public class RendezVous {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "medecin_id")
    private Medecin medecin;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    @JsonBackReference
    private Patient patient;

    @Column(name = "date_rendezvous")
    private LocalDateTime dateRendezVous;

    // Default constructor
    public RendezVous() {}

    // Constructor with parameters
    public RendezVous(Long id, Medecin medecin, Patient patient, LocalDateTime dateRendezVous) {
        this.id = id;
        this.medecin = medecin;
        this.patient = patient;
        this.dateRendezVous = dateRendezVous;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDateTime getDateRendezVous() {
        return dateRendezVous;
    }

    public void setDateRendezVous(LocalDateTime dateRendezVous) {
        this.dateRendezVous = dateRendezVous;
    }
}
