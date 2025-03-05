package com.example.cms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.cms.controller.exceptions.Non_AlcoholicNotFoundException;
import com.example.cms.model.entities.Non_Alcoholic;
import com.example.cms.model.repositories.Non_AlcoholicRepository;

@CrossOrigin
@RestController
@RequestMapping("/non-alcoholic")

public class Non_AlcoholicController {
    private final Non_AlcoholicRepository repository;

    @Autowired
    public Non_AlcoholicController(Non_AlcoholicRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Non_Alcoholic> retrieveAllNon_AlcoholicDrinks() {
        return repository.findAll();
    }

    @PostMapping
    public Non_Alcoholic createNon_AlcoholicDrink(@RequestBody Non_Alcoholic newDrink) {
        return repository.save(newDrink);
    }

    @GetMapping("/{id}")
    public Non_Alcoholic retrieveNon_AlcoholicDrink(@PathVariable("id") Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new Non_AlcoholicNotFoundException(id));
    }

    @GetMapping("/carbonated")
    public List<Non_Alcoholic> getCarbonatedDrinks() {
        return repository.findByIsCarbonatedTrue();
    }

    @GetMapping("/non-carbonated")
    public List<Non_Alcoholic> getNonCarbonatedDrinks() {
        return repository.findByIsCarbonatedFalse();
    }

    @GetMapping("/search")
    public List<Non_Alcoholic> searchAlcoholicEquivalent(@RequestParam String alcoholicEquivalent) {
        return repository.findByAlcoholicEquivalentContainingIgnoreCase(alcoholicEquivalent);
    }

    @PutMapping("/{id}")
    public Non_Alcoholic updateNon_AlcoholicDrink(@RequestBody Non_Alcoholic updatedDrink, @PathVariable("id") Long id) {
        return repository.findById(id)
                .map(drink -> {
                    drink.setName(updatedDrink.getName());
                    drink.setPrice(updatedDrink.getPrice());
                    drink.setAmount(updatedDrink.getAmount());
                    drink.setIsCarbonated(updatedDrink.getIsCarbonated());
                    return repository.save(drink);
                })
                .orElseGet(() -> {
                    updatedDrink.setId(id);
                    return repository.save(updatedDrink);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteNon_AlcoholicDrink(@PathVariable("id") Long id) {
        if (!repository.existsById(id)) {
            throw new Non_AlcoholicNotFoundException(id);
        }
        repository.deleteById(id);
    }
}
