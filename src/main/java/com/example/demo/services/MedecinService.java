package com.example.demo.services;

import com.example.demo.entities.Medecin;
import com.example.demo.repostories.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedecinService {

    @Autowired
    private MedecinRepository medecinRepository;

    // Ajouter un médecin
    public Medecin createMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    // Obtenir un médecin par ID
    public Optional<Medecin> getMedecinById(Long id) {
        return medecinRepository.findById(id);
    }

    // Obtenir tous les médecins
    public List<Medecin> getAllMedecins() {
        return medecinRepository.findAll();
    }

    // Mettre à jour un médecin
    public Medecin updateMedecin(Long id, Medecin updatedMedecin) {
        Optional<Medecin> existingMedecin = medecinRepository.findById(id);
        if (existingMedecin.isPresent()) {
            updatedMedecin.setId(id);
            return medecinRepository.save(updatedMedecin);
        }
        return null;
    }


    public void deleteMedecin(Long id) {
        medecinRepository.deleteById(id);
    }
}
