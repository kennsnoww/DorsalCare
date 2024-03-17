package com.isge.DorsalCare.controller;


import com.isge.DorsalCare.model.Correction;
import com.isge.DorsalCare.repository.CorrectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/corrections")
public class CorrectionController {

    @Autowired
    private CorrectionRepository correctionRepository;

    @GetMapping("/")
    public List<Correction> getAllCorrections() {
        return correctionRepository.findAll();
    }

    @PostMapping("/")
    public Correction createCorrection(@RequestBody Correction correction) {
        return correctionRepository.save(correction);
    }

    @GetMapping("/{id}")
    public Correction getCorrectionById(@PathVariable Long id) {
        return correctionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Correction introuvable avec l'ID " + id));
    }

    @PutMapping("/{id}")
    public Correction updateCorrection(@PathVariable Long id, @RequestBody Correction correctionDetails) {
        Correction correction = correctionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Correction introuvable avec l'ID " + id));
        correction.setValue(correctionDetails.getValue());
        correction.setDate(correctionDetails.getDate());
        return correctionRepository.save(correction);
    }

    @DeleteMapping("/{id}")
    public void deleteCorrection(@PathVariable Long id) {
        correctionRepository.deleteById(id);
    }
}
