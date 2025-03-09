package com.example.cms.controller;

import com.example.cms.controller.exceptions.VodkaNotFoundException;
import com.example.cms.model.entities.Vodka;
import com.example.cms.model.repositories.VodkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class VodkaController {

    @Autowired
    private final VodkaRepository repository;

    public VodkaController(VodkaRepository repository) {
        this.repository = repository;
    }

    // Retrieve all vodkas
    @GetMapping("/vodka")
    public List<Vodka> retrieveAllVodkas() {
        return repository.findAll();
    }

    // Create a new vodka entry
    @PostMapping ("/vodka")
    public Vodka createVodka(@RequestBody Vodka newVodka) {
        return repository.save(newVodka);
    }

    // Retrieve a specific vodka by ID
    @GetMapping("/vodka/{id}")
    public Vodka retrieveVodka(@PathVariable("id") Long vodkaId) {
        return repository.findById(vodkaId)
                .orElseThrow(() -> new VodkaNotFoundException(vodkaId));
    }

    // Update an existing vodka by ID
    @PutMapping("/vodka/{id}")
    public Vodka updateVodka(@RequestBody Vodka newVodka, @PathVariable("id") Long vodkaId) {
        return repository.findById(vodkaId)
                .map(vodka -> {
                    vodka.setFlavor(newVodka.getFlavor());
                    return repository.save(vodka);
                })
                .orElseGet(() -> {
                    return repository.save(newVodka);
                });
    }

    // Delete a vodka by ID
    @DeleteMapping("/vodka/{id}")
    public void deleteVodka(@PathVariable("id") Long vodkaId) {
        repository.deleteById(vodkaId);
    }

    // Search for vodka by name
    @GetMapping("/vodka/search/{name}")
    public List<Vodka> searchByName(@PathVariable String name) {
        return repository.searchByName(name);
    }

    // Retrieve vodkas by specific flavor
    @GetMapping("/vodka/flavor/{flavor}")
    public List<Vodka> getByFlavor(@PathVariable String flavor) {
        return repository.findByFlavor(flavor);
    }
}
