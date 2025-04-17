package com.JustiMali.JustiMali1.services;

import com.JustiMali.JustiMali1.models.Citoyen;
import com.JustiMali.JustiMali1.repositories.CitoyenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CitoyenService {

    private CitoyenRepository citoyenRepository;

    public Citoyen  create(Citoyen citoyen){
        return citoyenRepository.save(citoyen);
    }

    public List<Citoyen> findAll(){
        return citoyenRepository.findAll();
    }

    public Optional<Citoyen> findById(long id){
        return citoyenRepository.findById(id);
    }

    public Citoyen update(Citoyen citoyen, long id){
        Optional<Citoyen> citoyenOptional = citoyenRepository.findById(id);
        if(citoyenOptional.isPresent()){
            Citoyen citoyenUpdate = citoyenOptional.get();
            citoyenUpdate.setId(id);
            citoyenUpdate.setNom(citoyen.getNom());
            citoyenUpdate.setPrenom(citoyen.getPrenom());
            citoyenUpdate.setEmail(citoyen.getEmail());
            citoyenUpdate.setNina(citoyen.getNina());
            citoyenUpdate.setRole(citoyen.getRole());
            citoyenUpdate.setPassword(citoyen.getPassword());
            citoyenUpdate.setPvs(citoyen.getPvs());

            return citoyenRepository.save(citoyenUpdate);

        }
        return null;
    }

    public void deleteById(long id){
        Optional<Citoyen> citoyenOptional = citoyenRepository.findById(id);
        citoyenOptional.ifPresent((citoyen -> citoyenRepository.delete(citoyen)));
    }
}
