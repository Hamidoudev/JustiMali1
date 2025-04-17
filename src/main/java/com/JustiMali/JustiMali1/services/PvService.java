package com.JustiMali.JustiMali1.services;

import com.JustiMali.JustiMali1.models.Pv;
import com.JustiMali.JustiMali1.repositories.PvRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PvService {
    private PvRepository pvRepository;

    public List<Pv> findAll() {
        return pvRepository.findAll();
    }

    public Optional<Pv> findById(Long id) {
        return pvRepository.findById(id);
    }

    public Pv create(Pv pv) {
        return pvRepository.save(pv);
    }

    public Pv update(Pv pv, Long id) {
        Optional<Pv> optionalPv = pvRepository.findById(id);
        if (optionalPv.isPresent()) {
            Pv pvUpdate = optionalPv.get();
            pvUpdate.setId(id);
            pvUpdate.setLibelle(pv.getLibelle());
            pvUpdate.setSource(pv.getSource());
            pvUpdate.setPolicier(pv.getPolicier());
            pvUpdate.setProcureur(pv.getProcureur());
            return pvRepository.save(pvUpdate);
        }
        return null;
    }

    public  void delete(Long id) {
        Optional<Pv> optionalPv = pvRepository.findById(id);
        optionalPv.ifPresent(pv -> pvRepository.delete(pv));
    }
}
