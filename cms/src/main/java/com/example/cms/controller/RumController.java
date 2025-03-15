package com.example.cms.controller;

import com.example.cms.controller.exceptions.RumNotFoundException;
import com.example.cms.model.entities.Rum;
import com.example.cms.model.entities.Tequila;
import com.example.cms.model.repositories.RumRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/alcohol/spirit/rum")
public class RumController {
    private final RumRepository repository;

    public RumController(RumRepository repository) {
        this.repository = repository;
    }

    // GET & POST & DELETE automatically built in Spring Repo. fns

    // Get | Read
    @GetMapping()
    List<Rum> retrieveAllRums() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Rum retrieveRum(@PathVariable("id") long alcoholId) {
        return repository.findById(alcoholId)
                .orElseThrow(() -> new RumNotFoundException(alcoholId));
    }

    // Post | Create
    @PostMapping()
    Rum createRum(@RequestBody Rum newRum) {
        return repository.save(newRum);
    }

    // Put | Update
    @PutMapping("/{id}")
    Rum updateRum(@RequestBody Rum newRum, @PathVariable("id") long alcoholId) {
        return repository.findById(alcoholId)
                .map(rum -> { // need to add partial update features later
                    rum.setFlavour(newRum.getFlavour());
                    return repository.save(rum);
                })
                .orElseGet(() -> {
                    return repository.save(newRum);
                });
    }

    // Delete | Delete
    @DeleteMapping("/{id}")
    void deleteRum(@PathVariable("id") long alcoholId) {
        repository.deleteById(alcoholId);
    }

     // Search for Rum by name
    @GetMapping("/search/{name}")
    public List<Rum> searchByName(@PathVariable String name) {
        return repository.searchByName(name);
    }

    // Retrieve Rum by flavour 
    @GetMapping("/flavour/{flavour}")
    public List<Rum> getByFlavour(@PathVariable String flavour) {
        return repository.findByFlavour(flavour);
    }
}