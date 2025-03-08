package com.example.cms.controller;

import com.example.cms.controller.exceptions.TequilaNotFoundException;
import com.example.cms.model.entities.Tequila;
import com.example.cms.model.repositories.TequilaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TequilaController {
    @Autowired
    private final TequilaRepository repository;

    public TequilaController(TequilaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/tequilas")
    List<Tequila> retrieveAllTequilas() {
        return repository.findAll();
    }

    @PostMapping("/tequilas")
    Tequila createTequila(@RequestBody Tequila newTequila) {
        return repository.save(newTequila);
    }

    @GetMapping("/tequilas/{id}")
    Tequila retrieveTequila(@PathVariable("id") Long id) {
        return repository.findById(id)
        .orElseThrow(() -> new TequilaNotFoundException(id));
    }

    @PutMapping("/tequilas/{id}")
    Tequila updateTequila(@RequestBody Tequila newTequila, @PathVariable("id") Long id) {
        return repository.findById(id)
                .map(tequila -> {
                    tequila.setType(newTequila.getType());
                    return repository.save(tequila);
                })
                .orElseGet(() -> {
                    newTequila.setId(id);
                    return repository.save(newTequila);
                });
    }

    @DeleteMapping("/tequilas/{id}")
    void deleteStudent(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }

}

