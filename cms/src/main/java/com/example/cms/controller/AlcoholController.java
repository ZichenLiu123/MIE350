package com.example.cms.controller;

import com.example.cms.controller.dto.AlcoholDto;
import com.example.cms.controller.exceptions.AlcoholNotFoundException;
import com.example.cms.model.entities.Alcohol;
import com.example.cms.model.entities.AlcoholCategory;
import com.example.cms.model.entities.Rum;
import com.example.cms.model.repositories.AlcoholRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class AlcoholController {
    @Autowired
    private final AlcoholRepository repository;

    public AlcoholController(AlcoholRepository repository) {
        this.repository = repository;
    }

    // GET & POST & DELETE automatically built in Spring Repo. fns

    // Get | Read
    @GetMapping("/alcohol")
    List<Alcohol> retrieveAllAlcohol() {
        return repository.findAll();
    }

    @GetMapping("/alcohol/{id}")
    Alcohol retrieveAlcohol(@PathVariable("id") long alcoholId) {
        return repository.findById(alcoholId)
                .orElseThrow(() -> new AlcoholNotFoundException(alcoholId));
    }

    // Post | Create
    @PostMapping("/alcohol")
    Alcohol createAlcohol(@RequestBody AlcoholDto alcoholDto) {
        Alcohol newAlcohol = new Alcohol();
        // Basic attributes
        newAlcohol.setId(alcoholDto.getId());
        newAlcohol.setName(alcoholDto.getName());
        newAlcohol.setAmount(alcoholDto.getAmount());
        newAlcohol.setPrice(alcoholDto.getPrice());
        newAlcohol.setAbv(alcoholDto.getAbv());
        newAlcohol.setTop1Flavor(alcoholDto.getTop1Flavor());
        newAlcohol.setTop2Flavor(alcoholDto.getTop2Flavor());
        newAlcohol.setTop3Flavor(alcoholDto.getTop3Flavor());

        // Find from category table with category string instead
        Long categoryId = repository.findCategory(alcoholDto.getCategory());
        if (categoryId != null) {
            AlcoholCategory category = new AlcoholCategory();
            category.setCategory_id(categoryId);
            newAlcohol.setCategory_id(category);
        }

        return repository.save(newAlcohol);
    }

    // POST (Pairings) -- Wine

    // 1. retrieve values for "Type"
    // 2. retrieve values for "FlavorTYpe"

    //




    // Put | Update
    @PutMapping("/alcohol/{id}")
    Alcohol updateAlcohol(@RequestBody AlcoholDto alcoholDto, @PathVariable("id") long alcoholId) {
        return repository.findById(alcoholId)
                .map(alcohol -> {
                    // Basic attributes
                    alcohol.setName(alcoholDto.getName());
                    alcohol.setAmount(alcoholDto.getAmount());
                    alcohol.setPrice(alcoholDto.getPrice());
                    alcohol.setAbv(alcoholDto.getAbv());
                    alcohol.setTop1Flavor(alcoholDto.getTop1Flavor());
                    alcohol.setTop2Flavor(alcoholDto.getTop2Flavor());
                    alcohol.setTop3Flavor(alcoholDto.getTop3Flavor());

                    // Find from category table with category string instead
                    Long categoryId = repository.findCategory(alcoholDto.getCategory());
                    if (categoryId != null) {
                        AlcoholCategory category = new AlcoholCategory();
                        category.setCategory_id(categoryId);
                        alcohol.setCategory_id(category);
                    }

                    // Save the existing alcohol object (not the newAlcohol)
                    return repository.save(alcohol);
                })
                .orElseGet(() -> {
                    // Create new alcohol if not found
                    Alcohol newAlcohol = new Alcohol();
                    newAlcohol.setId(alcoholId); // Use the provided ID
                    newAlcohol.setName(alcoholDto.getName());
                    newAlcohol.setAmount(alcoholDto.getAmount());
                    newAlcohol.setPrice(alcoholDto.getPrice());
                    newAlcohol.setAbv(alcoholDto.getAbv());
                    newAlcohol.setTop1Flavor(alcoholDto.getTop1Flavor());
                    newAlcohol.setTop2Flavor(alcoholDto.getTop2Flavor());
                    newAlcohol.setTop3Flavor(alcoholDto.getTop3Flavor());

                    // Find from category table with category string instead
                    Long categoryId = repository.findCategory(alcoholDto.getCategory());
                    if (categoryId != null) {
                        AlcoholCategory category = new AlcoholCategory();
                        category.setCategory_id(categoryId);
                        newAlcohol.setCategory_id(category);
                    }

                    return repository.save(newAlcohol);
                });
    }





    // Delete | Delete

    @DeleteMapping("/alcohol/{id}")
    void deleteAlcohol(@PathVariable("id") long alcoholId) {
        repository.deleteById(alcoholId);
    }

    // Search for alcohol by name
    @GetMapping("/alcohol/search/{name}")
    public List<Alcohol> searchByName(@PathVariable String name) {
        return repository.searchByName(name);
    }
}
