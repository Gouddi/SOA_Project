package com.example.demo.services;

import com.example.demo.entities.Prescription;
import com.example.demo.repostories.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    public Prescription createPrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    public Optional<Prescription> getPrescriptionById(Long id) {
        return prescriptionRepository.findById(id);
    }

    public Prescription updatePrescription(Long id, Prescription updatedPrescription) {
        if (prescriptionRepository.existsById(id)) {
            updatedPrescription.setId(id);
            return prescriptionRepository.save(updatedPrescription);
        }
        return null;
    }

    public void deletePrescription(Long id) {
        prescriptionRepository.deleteById(id);
    }
}
