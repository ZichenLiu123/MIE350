package com.example.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cms.controller.exceptions.BrandyNotFoundException;
import com.example.cms.model.entities.Brandy;
import com.example.cms.model.repositories.BrandyRepository;

@CrossOrigin
@RestController
public class BrandyController {

    @Autowired
    private final BrandyRepository repository;

    public BrandyController(BrandyRepository repository) {
        this.repository = repository;
    }

    // Retrieve all brandies
    @GetMapping(("/brandy"))
    public List<Brandy> retrieveAllBrandies() {
        return repository.findAll();
    }

    // Create a new brandy entry
    @PostMapping("/brandy")
    public Brandy createBrandy(@RequestBody Brandy newBrandy) {
        return repository.save(newBrandy);
    }

    // Retrieve a specific brandy by ID
    @GetMapping("/brandy/{id}")
    public Brandy retrieveBrandy(@PathVariable("id") Long brandyId) {
        return repository.findById(brandyId)
                .orElseThrow(() -> new BrandyNotFoundException(brandyId));
    }

    // Update an existing brandy by ID
    @PutMapping("/brandy/{id}")
    public Brandy updateBrandy(@RequestBody Brandy newBrandy, @PathVariable("id") Long brandyId) {
        return repository.findById(brandyId)
                .map(brandy -> {
                    brandy.setAge(newBrandy.getAge());
                    brandy.setBarrelType(newBrandy.getBarrelType());
                    return repository.save(brandy);
                })
                .orElseGet(() -> {
                    newBrandy.setId(brandyId);
                    return repository.save(newBrandy);
                });
    }

    // Delete a brandy by ID
    @DeleteMapping("/brandy/{id}")
    public void deleteBrandy(@PathVariable("id") Long brandyId) {
        repository.deleteById(brandyId);
    }

    // Search for brandy by name
    @GetMapping("/brandy/search/{name}")
    public List<Brandy> searchByName(@PathVariable String name) {
        return repository.searchByName(name);
    }

    // Retrieve brandies by age
    @GetMapping("/brandy/age/{minAge}")
    public List<Brandy> getByMinimumAge(@PathVariable Integer minAge) {
        return repository.findByMinimumAge(minAge);
    }

    // Retrieve brandies by barrel type
    @GetMapping("/brandy/barrel/{barrelType}")
    public List<Brandy> getByBarrelType(@PathVariable String barrelType) {
        return repository.findByBarrelType(barrelType);
    }
}
