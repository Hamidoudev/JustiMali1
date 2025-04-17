package com.JustiMali.JustiMali1.controllers;

import com.JustiMali.JustiMali1.models.Procureur;
import com.JustiMali.JustiMali1.services.ProcureurService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("procureur")
@AllArgsConstructor
public class ProcureurController {
    private ProcureurService procureurService;

    @GetMapping
    public List<Procureur> getAllProcureurs() {
        return procureurService.findAll();
    }

    @GetMapping("{id}")
    public Optional<Procureur> getProcureurById(@PathVariable Long id) {
        return procureurService.findById(id);
    }

    @PostMapping
    public Procureur createProcureur(@RequestBody Procureur procureur) {
    return procureurService.create(procureur);
    }

    @PatchMapping("{id}")
    public Procureur updateProcureur(@PathVariable Long id, @RequestBody Procureur procureur) {
        return procureurService.update(procureur, id);
    }

    @DeleteMapping("{id}")
    public void deleteProcureur(@PathVariable Long id) {
        procureurService.delete(id);
    }

}
