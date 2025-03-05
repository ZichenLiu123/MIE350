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

import com.example.cms.controller.exceptions.SpiritNotFoundException;
import com.example.cms.model.entities.Spirit;
import com.example.cms.model.repositories.SpiritRepository;

@CrossOrigin
@RestController
@RequestMapping("/spirits")
public class SpiritController {

    @Autowired
    private final SpiritRepository repository;

    public SpiritController(SpiritRepository repository) {
        this.repository = repository;
    }

    // Retrieve all spirits
    @GetMapping
    public List<Spirit> retrieveAllSpirits() {
        return repository.findAll();
    }

    // Create a new spirit entry
    @PostMapping
    public Spirit createSpirit(@RequestBody Spirit newSpirit) {
        return repository.save(newSpirit);
    }

    // Retrieve a specific spirit by ID
    @GetMapping("/{id}")
    public Spirit retrieveSpirit(@PathVariable("id") Long spiritId) {
        return repository.findById(spiritId)
                .orElseThrow(() -> new SpiritNotFoundException(spiritId));
    }

    // Update an existing spirit by ID
    @PutMapping("/{id}")
    public Spirit updateSpirit(@RequestBody Spirit newSpirit, @PathVariable("id") Long spiritId) {
        return repository.findById(spiritId)
                .map(spirit -> {
                    spirit.setName(newSpirit.getName());
                    return repository.save(spirit);
                })
                .orElseGet(() -> {
                    newSpirit.setId(spiritId);
                    return repository.save(newSpirit);
                });
    }

    // Delete a spirit by ID
    @DeleteMapping("/{id}")
    public void deleteSpirit(@PathVariable("id") Long spiritId) {
        repository.deleteById(spiritId);
    }

    // Search for spirits by name
    @GetMapping("/search/{name}")
    public List<Spirit> searchByName(@PathVariable String name) {
        return repository.searchByName(name);
    }

    // Retrieve spirits by type
    @GetMapping("/type/{type}")
    public List<Spirit> getByType(@PathVariable String type) {
        return repository.findBySpiritType(type);
    }
}
