package com.JustiMali.JustiMali1.controllers;

import com.JustiMali.JustiMali1.models.Pv;
import com.JustiMali.JustiMali1.services.PvService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("pv")
@AllArgsConstructor
public class PvController {
    private PvService pvService;

    @GetMapping
    public List<Pv> getAllPvs(){
        return pvService.findAll();
    }

    @GetMapping("id")
    public Optional<Pv> findPvById(Long id){
        return pvService.findById(id);
    }

    @PostMapping
    public Pv createPv(@RequestBody Pv pv){
        return pvService.create(pv);
    }

    @PatchMapping("{id}")
    public Pv updatePv(@PathVariable Long id, @RequestBody Pv pv){
        return pvService.update(pv,id);
    }

    @DeleteMapping("{id}")
    public void deletePv(@PathVariable Long id){
        pvService.delete(id);
    }
}
