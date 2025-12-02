package com.example.Library.controller;

import com.example.Library.model.MagazineDetails;
import com.example.Library.repository.MagazineDetailsRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/magazines")
public class MagazineDetailsRestController {

    private final MagazineDetailsRepository magazineDetailsRepository;

    public MagazineDetailsRestController(MagazineDetailsRepository magazineDetailsRepository) {
        this.magazineDetailsRepository = magazineDetailsRepository;
    }

    // Obține toate revistele
    @GetMapping
    public List<MagazineDetails> getAllMagazines() {
        return magazineDetailsRepository.findAll();
    }

    // Obține o revistă după ID
    @GetMapping("/{id}")
    public ResponseEntity<MagazineDetails> getMagazineById(@PathVariable String id) {
        return magazineDetailsRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Creează o revistă nouă
    @PostMapping
    public MagazineDetails createMagazine(@Valid @RequestBody MagazineDetails magazineDetails) {
        return magazineDetailsRepository.save(magazineDetails);
    }

    // Actualizează o revistă (CORECTAT)
    @PutMapping("/{id}")
    public ResponseEntity<MagazineDetails> updateMagazine(@PathVariable String id,
                                                          @Valid @RequestBody MagazineDetails magazineDetailsDetails) {
        return magazineDetailsRepository.findById(id).map(magazine -> {
            // Actualizăm câmpurile care există pe model (Titlu și Publisher)
            magazine.setTitle(magazineDetailsDetails.getTitle());
            magazine.setPublisher(magazineDetailsDetails.getPublisher()); // Câmpul specific MagazineDetails

            // Asigurăm că ID-ul este setat corect (deși @PathVariable ar trebui să-l gestioneze)
            magazine.setId(id);

            return ResponseEntity.ok(magazineDetailsRepository.save(magazine));
        }).orElse(ResponseEntity.notFound().build());
    }

    // Șterge o revistă
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMagazine(@PathVariable String id) {
        return magazineDetailsRepository.findById(id).map(magazine -> {
            magazineDetailsRepository.delete(magazine);
            return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}