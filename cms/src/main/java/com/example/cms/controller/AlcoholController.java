package com.example.cms.controller;

import com.example.cms.controller.exceptions.AlcoholNotFoundException;
import com.example.cms.model.entities.Alcohol;
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

    // Used alcoholId instead of beer id because we might want to index all alcohol later?
    // Need to confirm
    @GetMapping("/alcohol/{id}")
    Alcohol retrieveAlcohol(@PathVariable("id") long alcoholId) {
        return repository.findById(alcoholId)
                .orElseThrow(() -> new AlcoholNotFoundException(alcoholId));
    }

    // Post | Create
    @PostMapping("/alcohol")
    Alcohol createAlcohol(@RequestBody Alcohol newAlcohol) {
        return repository.save(newAlcohol);
    }
    // Put | Update
    @PutMapping("/alcohol/{id}")
    Alcohol updateAlcohol(@RequestBody Alcohol newAlcohol, @PathVariable("id") long alcoholId) {
        return repository.findById(alcoholId)
                .map(alcohol -> { // need to add partial update features later
                    alcohol.setCategory_id(newAlcohol.getCategory_id());
                    alcohol.setAmount(newAlcohol.getAmount());
                    alcohol.setName(newAlcohol.getName());
                    alcohol.setPrice(newAlcohol.getPrice());
                    alcohol.setAbv(newAlcohol.getAbv());
                    alcohol.setTop1Flavor(newAlcohol.getTop1Flavor());
                    alcohol.setTop2Flavor(newAlcohol.getTop2Flavor());
                    alcohol.setTop3Flavor(newAlcohol.getTop3Flavor());
                    return repository.save(newAlcohol);
                })
                .orElseGet(() -> {
                    return repository.save(newAlcohol);
                });
    }

    // Delete | Delete

    @DeleteMapping("/alcohol/{id}")
    void deleteAlcohol(@PathVariable("id") long alcoholId) {
        repository.deleteById(alcoholId);
    }
}
