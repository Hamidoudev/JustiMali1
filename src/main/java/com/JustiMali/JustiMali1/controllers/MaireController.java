package com.JustiMali.JustiMali1.controllers;

import com.JustiMali.JustiMali1.models.Maire;
import com.JustiMali.JustiMali1.services.MaireService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("maire")
@AllArgsConstructor
public class MaireController {
    private MaireService maireService;

    @GetMapping
    public List<Maire> getAllMaires() {
        return maireService.findAll();
    }

    @GetMapping("{id}")
    public Optional<Maire> getMaireById(@PathVariable Long id) {
        return maireService.findById(id);
    }

    @PostMapping
    public Maire createMaire(@RequestBody Maire maire) {
        return maireService.create(maire);
    }

    @PatchMapping("{id}")
    public Maire updateMaire(@RequestBody Maire maire, @PathVariable Long id) {
        return maireService.update(maire, id);
    }

    @DeleteMapping("{id}")
    public void deleteMaire(@PathVariable Long id) {
        maireService.delete(id);
    }
}
