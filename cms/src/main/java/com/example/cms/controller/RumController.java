package com.example.cms.controller;

import com.example.cms.controller.exceptions.RumNotFoundException;
import com.example.cms.controller.exceptions.StudentNotFoundException;
import com.example.cms.model.entities.Rum;
import com.example.cms.model.repositories.RumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class RumController {
    @Autowired
    private final RumRepository repository;

    public RumController(RumRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/rums")
    List<Rum> retrieveAllRums() {
        return repository.findAll();
    }

    @PostMapping("/rums")
    Rum createRum(@RequestBody Rum newRum) {
        return repository.save(newRum);
    }

    @GetMapping("/rums/{id}")
    Rum retrieveRum(@PathVariable("id") Long id) {
        return repository.findById(id)
        .orElseThrow(() -> new RumNotFoundException(id));
    }

    @PutMapping("/rums/{id}")
    Rum updateRum(@RequestBody Rum newRum, @PathVariable("id") Long id) {
        return repository.findById(id)
                .map(rum -> {
                    rum.setFlavour(newRum.getFlavour());
                    return repository.save(rum);
                })
                .orElseGet(() -> {
                    newRum.setId(id);
                    return repository.save(newRum);
                });
    }

    @DeleteMapping("/rums/{id}")
    void deleteStudent(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }

}

