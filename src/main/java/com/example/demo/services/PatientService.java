package com.example.demo.services;

import com.example.demo.entities.Patient;
import com.example.demo.repostories.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // Ajouter un patient
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    // Obtenir un patient par ID
    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    // Obtenir tous les patients
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Mettre à jour un patient
    public Patient updatePatient(Long id, Patient updatedPatient) {
        Optional<Patient> existingPatient = patientRepository.findById(id);
        if (existingPatient.isPresent()) {
            updatedPatient.setId(id);
            return patientRepository.save(updatedPatient);
        }
        return null;
    }


    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
