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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cms.controller.dto.Non_alcoholicDto;
import com.example.cms.controller.exceptions.Non_AlcoholicNotFoundException;
import com.example.cms.model.entities.Non_Alcoholic;
import com.example.cms.model.repositories.Non_AlcoholicRepository;

@CrossOrigin
@RestController

public class Non_AlcoholicController {
    private final Non_AlcoholicRepository repository;

    @Autowired
    public Non_AlcoholicController(Non_AlcoholicRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/alcohol/non-alcoholic/")
    public List<Non_Alcoholic> retrieveAllNon_AlcoholicDrinks() {
        return repository.findAll();
    }

    // For recommending Non-alco
    @PostMapping("/alcohol/non-alcoholic/")
    public List<Non_Alcoholic> non_Alcoholics_rec(@RequestBody Non_alcoholicDto non_alcoholicDto) {
        return repository.non_alcoholicRec(non_alcoholicDto.getPrice(), non_alcoholicDto.getFlavor(),
                non_alcoholicDto.getIsCarbonated(), non_alcoholicDto.getAlcoholicEquivalent());
    }

    @GetMapping("/alcohol/non-alcoholic/{id}")
    public Non_Alcoholic retrieveNon_AlcoholicDrink(@PathVariable("id") Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new Non_AlcoholicNotFoundException(id));
    }

    @GetMapping("/alcohol/non-alcoholic/carbonated")
    public List<Non_Alcoholic> getCarbonatedDrinks() {
        return repository.findByIsCarbonatedTrue();
    }

    @GetMapping("/alcohol/non-alcoholic/non-carbonated")
    public List<Non_Alcoholic> getNonCarbonatedDrinks() {
        return repository.findByIsCarbonatedFalse();
    }

    @GetMapping("/alcohol/non-alcoholic/search")
    public List<Non_Alcoholic> searchAlcoholicEquivalent(@RequestParam String alcoholicEquivalent) {
        return repository.findByAlcoholicEquivalentContainingIgnoreCase(alcoholicEquivalent);
    }

    @PutMapping("/alcohol/non-alcoholic/{id}")
    public Non_Alcoholic updateNon_AlcoholicDrink(@RequestBody Non_Alcoholic updatedDrink,
            @PathVariable("id") Long id) {
        return repository.findById(id)
                .map(drink -> {
                    drink.setIsCarbonated(updatedDrink.getIsCarbonated());
                    drink.setAlcoholicEquivalent(updatedDrink.getAlcoholicEquivalent());
                    return repository.save(drink);
                })
                .orElseGet(() -> {
                    updatedDrink.setId(id);
                    return repository.save(updatedDrink);
                });
    }

    @DeleteMapping("/alcohol/non-alcoholic/{id}")
    public void deleteNon_AlcoholicDrink(@PathVariable("id") Long id) {
        if (!repository.existsById(id)) {
            throw new Non_AlcoholicNotFoundException(id);
        }
        repository.deleteById(id);
    }
}
