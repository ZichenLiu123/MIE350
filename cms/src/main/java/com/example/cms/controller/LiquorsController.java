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

import com.example.cms.controller.exceptions.LiquorsNotFoundException;
import com.example.cms.model.entities.Liquors;
import com.example.cms.model.repositories.AlcoholRepository;
import com.example.cms.model.repositories.LiquorsRepository;

@CrossOrigin
@RestController
@RequestMapping("/alcohol/liquors")

public class LiquorsController {
    private final LiquorsRepository repository;
    private AlcoholRepository alcoholRepository;

    @Autowired
    public LiquorsController(LiquorsRepository repository, AlcoholRepository alcoholRepository) {
        this.repository = repository;
        this.alcoholRepository = alcoholRepository;
    }

    @GetMapping()
    public List<Liquors> retrieveAllLiquors() {
        return repository.findAll();
    }

    @PostMapping
    public Liquors createLiquors(@RequestBody Liquors newLiquors) {
        return repository.save(newLiquors);
    }

    @GetMapping("/search")
    public List<Liquors> searchLiquorsByAroma(@RequestParam String aroma) {
        return repository.findByAromaContainingIgnoreCase(aroma);
    }

    @GetMapping("/{id}")
    public Liquors retrieveLiquors(@PathVariable("id") Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new LiquorsNotFoundException(id));
    }

    @PutMapping("/{id}")
    public Liquors updateLiquors(@RequestBody Liquors updatedLiquor, @PathVariable("id") Long id) {
        return repository.findById(id)
                .map(liquor -> {
                    liquor.setAroma(updatedLiquor.getAroma());
                    return repository.save(liquor);
                })
                .orElseGet(() -> {
                    return repository.save(updatedLiquor);
                });
    }


    @DeleteMapping("/{id}")
    public void deleteLiquors(@PathVariable("id") Long id) {
        if (!repository.existsById(id)) {
            throw new LiquorsNotFoundException(id);
        }
        repository.deleteById(id);
    }
}
