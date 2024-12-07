package com.example.demo.services;

import com.example.demo.entities.Medecin;
import com.example.demo.entities.Patient;
import com.example.demo.entities.RendezVous;
import com.example.demo.repostories.MedecinRepository;
import com.example.demo.repostories.PatientRepository;
import com.example.demo.repostories.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RendezVousService {

    @Autowired
    private MedecinRepository medecinRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private RendezVousRepository rendezVousRepository;

    // Ajouti un rendez-vous
    public RendezVous createRendezVous(RendezVous rendezVous) {
        // Use the injected repositories to find the Medecin and Patient
        Medecin medecin = medecinRepository.findById(rendezVous.getMedecin().getId())
                .orElseThrow(() -> new RuntimeException("Medecin not found"));
        Patient patient = patientRepository.findById(rendezVous.getPatient().getId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        // tzid l medecin wel patient  rendezvous
        rendezVous.setMedecin(medecin);
        rendezVous.setPatient(patient);
        return rendezVousRepository.save(rendezVous);
    }


    public List<RendezVous> getAllRendezVous() {
        return rendezVousRepository.findAll();
    }


    public Optional<RendezVous> getRendezVousById(Long id) {
        return rendezVousRepository.findById(id);
    }


    public RendezVous updateRendezVous(Long id, RendezVous updatedRendezVous) {
        Optional<RendezVous> existingRendezVous = rendezVousRepository.findById(id);
        if (existingRendezVous.isPresent()) {
            updatedRendezVous.setId(id);
            return rendezVousRepository.save(updatedRendezVous);
        }
        return null;
    }


    public void deleteRendezVous(Long id) {
        rendezVousRepository.deleteById(id);
    }
}
