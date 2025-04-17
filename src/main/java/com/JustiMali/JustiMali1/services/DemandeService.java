package com.JustiMali.JustiMali1.services;

import com.JustiMali.JustiMali1.models.Demande;
import com.JustiMali.JustiMali1.repositories.DemandeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DemandeService {
    private DemandeRepository demandeRepository;

    public List<Demande> findAll() {
        return demandeRepository.findAll();
    }

    public Optional<Demande> findById(Long id) {
        return demandeRepository.findById(id);
    }

    public Demande create(Demande demande) {
        return demandeRepository.save(demande);
    }

    public Demande update(Demande demande,Long id) {
        Optional<Demande> optionalDemande = demandeRepository.findById(id);
        if (optionalDemande.isPresent()) {
            Demande updatedDemande = optionalDemande.get();
            updatedDemande.setId(id);
            updatedDemande.setTypeDemande(demande.getTypeDemande());
            updatedDemande.setEtat(demande.getEtat());
            updatedDemande.setCitoyen(demande.getCitoyen());
            updatedDemande.setMaire(demande.getMaire());
            updatedDemande.setProcureur(demande.getProcureur());
            return demandeRepository.save(updatedDemande);
        }
        return null;
    }

    public void delete(long id) {
        Optional<Demande> optionalDemande = demandeRepository.findById(id);
        optionalDemande.ifPresent(demande -> demandeRepository.delete(demande));
    }

}
