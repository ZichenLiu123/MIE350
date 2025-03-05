package com.example.cms.controller;

import com.example.cms.controller.exceptions.WineNotFoundException;
import com.example.cms.model.entities.Wine;
import com.example.cms.model.repositories.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/wine")
public class WineController {

    @Autowired
    private final WineRepository repository;

    public WineController(WineRepository repository) {
        this.repository = repository;
    }

    // Retrieve all wines
    @GetMapping
    public List<Wine> retrieveAllWines() {
        return repository.findAll();
    }

    // Create a new wine entry
    @PostMapping
    public Wine createWine(@RequestBody Wine newWine) {
        return repository.save(newWine);
    }

    // Retrieve a specific wine by ID
    @GetMapping("/{id}")
    public Wine retrieveWine(@PathVariable("id") Long wineId) {
        return repository.findById(wineId)
                .orElseThrow(() -> new WineNotFoundException(wineId));
    }

    // Update an existing wine by ID
    @PutMapping("/{id}")
    public Wine updateWine(@RequestBody Wine newWine, @PathVariable("id") Long wineId) {
        return repository.findById(wineId)
                .map(wine -> {
                    wine.setType(newWine.getType());
                    wine.setAge(newWine.getAge());
                    return repository.save(wine);
                })
                .orElseGet(() -> {
                    newWine.setId(wineId);
                    return repository.save(newWine);
                });
    }

    // Delete a wine by ID
    @DeleteMapping("/{id}")
    public void deleteWine(@PathVariable("id") Long wineId) {
        repository.deleteById(wineId);
    }

    // Search for wine by name
    @GetMapping("/search/{name}")
    public List<Wine> searchByName(@PathVariable String name) {
        return repository.searchByName(name);
    }

    // Retrieve wines by type (e.g., Red, White, Rosé)
    @GetMapping("/type/{type}")
    public List<Wine> getByType(@PathVariable String type) {
        return repository.findByType(type);
    }

    // Retrieve aged wines (e.g., wines aged over X years)
    @GetMapping("/aged/{minAge}")
    public List<Wine> getAgedWines(@PathVariable int minAge) {
        return repository.findAgedWines(minAge);
    }
}
